package com.demo.handle;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Result;
import com.demo.exception.GirlException;
import com.demo.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof GirlException) {
			GirlException girlException=(GirlException)e;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		}else {
			logger.error("【系统异常】 {}",e);
			return ResultUtil.error(-1,"未知错误");
		}
	}
}
