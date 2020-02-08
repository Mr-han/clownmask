package cn.clownmask.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.sys.entity.SysUserEntity;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

}
