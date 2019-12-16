package com.myservs.demo.controler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myservs.demo.Dto.ExceptionDTO;
import com.myservs.demo.ExcepHandlers.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizeExcepHandelingControler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request){
	
		ExceptionDTO exception=new ExceptionDTO(new Date(),ex.getMessage(),request.getDescription(false));
		System.out.println("Error 01");
		return new ResponseEntity(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException ex,WebRequest request){
	
		ExceptionDTO exception=new ExceptionDTO(new Date(),ex.getMessage(),request.getDescription(false));
		System.out.println("Error 0");
		return new ResponseEntity(exception,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException args,HttpHeaders headers,HttpStatus httpStatus,WebRequest request){
	
		ExceptionDTO exception=new ExceptionDTO(new Date(),args.getMessage(),args.getBindingResult().toString());
		System.out.println("Error 2");
		return new ResponseEntity(exception,HttpStatus.BAD_REQUEST);
	}
	
	
}
