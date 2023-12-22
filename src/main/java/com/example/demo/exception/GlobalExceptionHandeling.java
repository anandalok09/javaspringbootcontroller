package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeling {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseBodyException> resourceNotFoundExceptionHandeling() {
		ResponseBodyException rs=new ResponseBodyException();
		rs.setMessage("Resource Not found exception");
		Date date=new Date();
		int day=date.getDay();
		int month=date.getMonth();
		int years=date.getYear();
		String dateformat=day+"/"+month+"/"+years;
		rs.setDate(dateformat);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&77");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
		
		
	}
}
