package com.jsp.ecommerce1.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler	 {
	@ExceptionHandler(NoResourceFoundException.class)
	public String handler() {
		return "404.html";
	}

}
