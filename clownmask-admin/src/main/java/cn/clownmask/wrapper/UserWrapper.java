package cn.clownmask.wrapper;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import cn.clownmask.common.validator.group.AddGroup;
import cn.clownmask.common.validator.group.UpdateGroup;
import cn.clownmask.modules.sys.entity.SysUserEntity;
import lombok.Data;

@Data
public class UserWrapper {
	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private String username;

	/**
	 * 邮箱
	 */
	@NotBlank(message = "邮箱不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Email(message = "邮箱格式不正确", groups = { AddGroup.class, UpdateGroup.class })
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态 0：禁用 1：正常
	 */
	private Integer status;

	/**
	 * 角色ID列表
	 */
	private List<Long> roleIdList;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 部门ID
	 */
	@NotNull(message = "部门不能为空", groups = { AddGroup.class, UpdateGroup.class })
	private Integer deptId;

	/**
	 * 部门名称
	 */
	@TableField(exist = false)
	private String deptName;

	private String avatar;

	private String companyName;
	private String contactName;
	private String address;

	public static UserWrapper wrapper(SysUserEntity user) {
		UserWrapper wrapper = new UserWrapper();
		BeanUtils.copyProperties(user, wrapper);
		return wrapper;
	}

	public static void unWrapper(UserWrapper wrapper,SysUserEntity user) {
		BeanUtils.copyProperties(wrapper, user);
	}

}
