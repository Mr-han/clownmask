package cn.clownmask.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一错误跳转页面，如403，404，500
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String notFund(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "error/404";
    }

    @RequestMapping("/500")
    public String sysError(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "error/500";
    }
}
