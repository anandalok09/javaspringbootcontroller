package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.utility.UtilityInterface;

@RestControllerAdvice
public class GlobalExceptionHandeling {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseBodyException> resourceNotFoundExceptionHandeling() {
		ResponseBodyException rs=new ResponseBodyException();
		rs.setMessage("Resource Not found exception");
		Date date=new Date();
		int day=date.getDay();
		int month=date.getMonth();
		int years=date.getYear();
		String dateformat=day+"/"+month+"/"+years;
		rs.setDate(dateformat);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
	}
	@ExceptionHandler(CustmizationException.class)
	public ResponseEntity<Object> customException(Exception e) {
		ResponseBodyException rs=new ResponseBodyException();
		rs.setMessage(e.getMessage());
		
		rs.setDate(UtilityInterface.getCurrentDate());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
	}
	
	@ExceptionHandler(NotUpdated.class)
	public ResponseEntity<Object> NotUpdateException(Exception e) {
		ResponseBodyException rs=new ResponseBodyException();
		rs.setMessage(e.getMessage());
		
		rs.setDate(UtilityInterface.getCurrentDate());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rs);
	}
	
	
	
	
	
}
