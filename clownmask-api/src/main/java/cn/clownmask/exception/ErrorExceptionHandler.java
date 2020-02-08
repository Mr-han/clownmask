package cn.clownmask.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.exceptions.TemplateInputException;

import cn.clownmask.common.exception.RRException;
import cn.clownmask.common.utils.R;

@ControllerAdvice
public class ErrorExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler({ CMSNotFoundException.class, TemplateInputException.class })
	public String handleRRException() {
		return "error/404";
	}

	/**
	 * 处理自定义异常
	 */
	@ResponseBody
	@ExceptionHandler(RRException.class)
	public R handleRRException(RRException e) {
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ResponseBody
	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e) {
		logger.error(e.getMessage(), e);
		return R.error("数据库中已存在该记录");
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public R handleException(Exception e) {
		logger.error(e.getMessage(), e);
		return R.error();
	}

}
