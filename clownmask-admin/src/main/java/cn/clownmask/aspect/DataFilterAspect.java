package cn.clownmask.aspect;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.clownmask.common.annotation.DataFilter;
import cn.clownmask.common.exception.RRException;
import cn.clownmask.common.utils.Constant;
import cn.clownmask.modules.sys.entity.SysUserEntity;
import cn.clownmask.modules.sys.service.SysDeptService;
import cn.clownmask.modules.sys.service.SysRoleDeptService;
import cn.clownmask.modules.sys.service.SysUserRoleService;
import cn.clownmask.modules.sys.shiro.ShiroUtils;

/**
 * 数据过滤，切面处理类
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Aspect
@Component
public class DataFilterAspect {
	@Autowired
	private SysDeptService sysDeptService;

	@Pointcut("@annotation(cn.clownmask.common.annotation.DataFilter)")
	public void dataFilterCut() {

	}

	@Before("dataFilterCut()")
	public void dataFilter(JoinPoint point) throws Throwable {
		Object[] params = point.getArgs();
		for (Object param : params) {
			if (param != null && param instanceof Map) {
				SysUserEntity user = ShiroUtils.getUserEntity();
				// 如果不是超级管理员，则进行数据过滤
				if (user.getUserId() != Constant.SUPER_ADMIN) {
					Map map = (Map) param;
					map.put(Constant.SQL_FILTER, getSQLFilter(user, point));
				}

				return;
			}
		}

		throw new RRException("数据权限接口，只能是Map类型参数，且不能为NULL");
	}

	/**
	 * 获取数据过滤的SQL
	 */
	private String getSQLFilter(SysUserEntity user, JoinPoint point) {
		MethodSignature signature = (MethodSignature) point.getSignature();
		DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);
		// 获取表的别名
		String tableAlias = dataFilter.tableAlias();
		if (StringUtils.isNotBlank(tableAlias)) {
			tableAlias += ".";
		}

		// 部门ID列表
		Set<Long> deptIdList = new HashSet<>();

		// 用户角色对应的部门ID列表[这里注释掉，原因是：部门筛选应该在用户表中为准]
		/*
		 * List<Long> roleIdList = sysUserRoleService.queryRoleIdList(user.getUserId());
		 * if(roleIdList.size() > 0){ List<Long> userDeptIdList =
		 * sysRoleDeptService.queryDeptIdList(roleIdList.toArray(new
		 * Long[roleIdList.size()])); deptIdList.addAll(userDeptIdList); }
		 */
		// 以用户对应的部门为准。+++++很重要。
		deptIdList.add(new Long(user.getDeptId()));
		// 用户子部门ID列表
		if (dataFilter.subDept()) {
			List<Long> subDeptIdList = sysDeptService.getSubDeptIdList(new Long(user.getDeptId()));
			deptIdList.addAll(subDeptIdList);
		}

		StringBuilder sqlFilter = new StringBuilder();
		sqlFilter.append(" (");

		if (deptIdList.size() > 0) {
			sqlFilter.append(tableAlias).append(dataFilter.deptId()).append(" in(")
					.append(StringUtils.join(deptIdList, ",")).append(")");
		}

		// 没有本部门数据权限，也能查询本人数据
		if (dataFilter.user()) {
			if (deptIdList.size() > 0) {
				sqlFilter.append(" or ");
			}
			sqlFilter.append(tableAlias).append(dataFilter.userId()).append("=").append(user.getUserId());
		}

		sqlFilter.append(")");

		if (sqlFilter.toString().trim().equals("()")) {
			return null;
		}

		return sqlFilter.toString();
	}
}
