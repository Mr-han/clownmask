package cn.clownmask.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Controller
public class SysPageController {

	@RequestMapping("modules/{module}/{url}.html")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url) {
		return "modules/" + module + "/" + url;
	}

	@RequestMapping(value = { "/", "index.html" })
	public String index() {
		return "index";
	}

	@RequestMapping("index1.html")
	public String index1() {
		return "index1";
	}

	@RequestMapping("login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("register.html")
	public String register() {
		return "register";
	}

	@RequestMapping("lockscreen.html")
	public String lockscreen() {
		return "lockscreen";
	}

	@RequestMapping("profile.html")
	public String profile() {
		return "profile";
	}

	@RequestMapping("main.html")
	public String main() {
		return "main";
	}

	@RequestMapping("404.html")
	public String notFound() {
		return "error/404";
	}

	@RequestMapping("500.html")
	public String error() {
		return "error/500";
	}

}
