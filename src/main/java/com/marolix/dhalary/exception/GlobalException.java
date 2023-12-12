package com.marolix.dhalary.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<AppException> handlerExecption(UserException e)
	{
		String exmsg=e.getMessage();
		
		AppException appExecpetion=new AppException();
		
		appExecpetion.setCode("MT1108");
		appExecpetion.setMsg(exmsg);
		appExecpetion.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<AppException>(appExecpetion,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = EmptyDataException.class)
	public ResponseEntity<AppException> handlerNullexception(EmptyDataException e)
	{
		String exmsg= e.getMessage();
		
		AppException appException=new AppException();
		appException.setMsg(exmsg);
		appException.setCode("MT1109");
		appException.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<AppException>(appException,HttpStatus.NO_CONTENT);
	}
}
