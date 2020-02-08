package cn.clownmask.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.sys.entity.SysRoleEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	

}
