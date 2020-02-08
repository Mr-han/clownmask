package cn.clownmask.modules.cms.controller.from;

import javax.validation.constraints.NotBlank;

import cn.clownmask.common.exception.RRException;
import lombok.Data;

@Data
public class RegisterFrom {
	@NotBlank(message = "用户名不能为空")
	private String username;
	@NotBlank(message = "密码不能为空")
	private String password;
	@NotBlank(message = "确认密码不能为空")
	private String confirmPassword;
	@NotBlank(message = "验证码不能为空")
	private String captcha;
	@NotBlank(message = "公司名不能为空")
	private String companyName;
	@NotBlank(message = "联系人不能为空")
	private String contactName;
	@NotBlank(message = "邮箱不能为空")
	private String email;
	
	public void valid() {
		if (!password.equals(confirmPassword)) {
			throw new RRException("密码不一致");
		}
	}
}
