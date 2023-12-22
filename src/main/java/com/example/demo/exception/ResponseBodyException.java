package com.example.demo.exception;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class ResponseBodyException {
private String message;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

private String  date;
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
	
}
