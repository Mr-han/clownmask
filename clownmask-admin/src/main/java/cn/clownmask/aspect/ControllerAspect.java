package cn.clownmask.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.clownmask.common.vo.DateGroup;
import cn.clownmask.common.vo.DeptGroup;
import cn.clownmask.modules.sys.shiro.ShiroUtils;

/**
 * 控制器切面，用于多站点分离
 * 
 * @author Daivd
 *
 */
@Aspect
@Component
public class ControllerAspect {


	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void handle(JoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for (Object object : args) {
        	if(object == null)continue;
			if(DeptGroup.class.isAssignableFrom(object.getClass())) {
				DeptGroup dept = (DeptGroup)object;
				dept.setDeptId(ShiroUtils.getUserEntity().getDeptId());
			}
			if(DateGroup.class.isAssignableFrom(object.getClass())) {
				DateGroup date = (DateGroup)object;
				date.setUpdateTime(new Date());
			}
		}
	}

}
