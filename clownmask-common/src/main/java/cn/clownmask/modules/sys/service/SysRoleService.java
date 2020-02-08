package cn.clownmask.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;

import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.modules.sys.entity.SysRoleEntity;

import java.util.Map;


/**
 * 角色
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveRole(SysRoleEntity role);

	void update(SysRoleEntity role);
	
	void deleteBatch(Long[] roleIds);

}
