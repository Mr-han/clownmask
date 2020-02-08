package cn.clownmask.modules.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.clownmask.modules.sys.entity.SysUserEntity;

/**
 * Controller公共组件
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getDeptId() {
		return new Long(getUser().getDeptId());
	}
}
