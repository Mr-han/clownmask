package cn.clownmask.modules.sys.controller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.clownmask.common.annotation.SysLog;
import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.common.utils.R;
import cn.clownmask.common.validator.Assert;
import cn.clownmask.common.validator.ValidatorUtils;
import cn.clownmask.common.validator.group.AddGroup;
import cn.clownmask.common.validator.group.UpdateGroup;
import cn.clownmask.modules.sys.entity.SysUserEntity;
import cn.clownmask.modules.sys.service.SysUserRoleService;
import cn.clownmask.modules.sys.service.SysUserService;
import cn.clownmask.modules.sys.shiro.ShiroUtils;
import cn.clownmask.wrapper.UserWrapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysUserService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info() {
		return R.ok().put("user", UserWrapper.wrapper(sysUserService.getById(getUserId())));
	}

	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public R password(String password, String newPassword) {
		Assert.isBlank(newPassword, "新密码不为能空");

		// 原密码
		password = ShiroUtils.sha256(password, getUser().getSalt());
		// 新密码
		newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());

		// 更新密码
		boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
		if (!flag) {
			return R.error("原密码不正确");
		}

		return R.ok();
	}

	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId) {
		SysUserEntity user = sysUserService.getById(userId);

		// 获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);

		return R.ok().put("user", UserWrapper.wrapper(user));
	}

	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user) {
		ValidatorUtils.validateEntity(user, AddGroup.class);
		if (user.getUserId() != null) {
			return R.error("update error!!!");
		}
		sysUserService.saveUser(user);

		return R.ok();
	}

	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions({"sys:user:update"})
	public R update(@RequestBody UserWrapper wrapper) {
		SysUserEntity user = sysUserService.getById(wrapper.getUserId());
		UserWrapper.unWrapper(wrapper, user);
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		sysUserService.update(user);

		return R.ok();
	}
	
	/**
	 * 个人修改用户
	 * 默认所有都可以修改自己的信息，所以去掉权限控制
	 */
	@SysLog("修改用户")
	@RequestMapping("/profile")
	public R profile(@RequestBody UserWrapper wrapper) {
		if(!ShiroUtils.getUserId().equals(wrapper.getUserId())) {
			return R.error("没有权限.");
		}
		SysUserEntity user = sysUserService.getById(wrapper.getUserId());
		UserWrapper.unWrapper(wrapper, user);
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		
		//需要更新一下角色列表，方式外部修改
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(user.getUserId());
		user.setRoleIdList(roleIdList);
		sysUserService.update(user);
		return R.ok();
	}

	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds) {
		if (ArrayUtils.contains(userIds, 1L)) {
			return R.error("系统管理员不能删除");
		}

		if (ArrayUtils.contains(userIds, getUserId())) {
			return R.error("当前用户不能删除");
		}

		sysUserService.removeByIds(Arrays.asList(userIds));

		return R.ok();
	}
}
