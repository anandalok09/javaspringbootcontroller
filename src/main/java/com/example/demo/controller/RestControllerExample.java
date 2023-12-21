package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.service.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.HeaderOfSubjectAndSideOfSubject;

import jakarta.websocket.server.PathParam;

@RestController
public class RestControllerExample {

	@Autowired
	BookService bookService;
	
	
	@Autowired
	HeaderOfSubjectAndSideOfSubject headerOfSubjectAndSideOfSubject;
	
	public ResponseEntity<List<HeaderOfSubject>>  getAllHeaders(){
		List<HeaderOfSubject> header=headerOfSubjectAndSideOfSubject.finallHeader().;
		
//		return new ResponseEntity<>(header,HttpStatus.SC_OK);
		return new ResponseEntity<>(null,HttpStatus.SC_OK);
		
	}
	
	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	public ArrayList sayHello() {
	    return bookService.getAllBooks();
	}
	@RequestMapping(value = "/getdata1", method = RequestMethod.GET)
	public List<Book> findByid(@RequestParam("itemid") String itemid ) {
	    
		return bookService.getAllBooks().stream().filter(s->s.getId()==Integer.parseInt(itemid)).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/getdataparam", method = RequestMethod.GET)
	public List<Book> findByid(@RequestParam("itemid") String itemid,@RequestParam("empid") String empid ) {
		return bookService.getAllBooks().stream().filter(s->s.getId()==Integer.parseInt(itemid)).collect(Collectors.toList());
	}
	
	

	@RequestMapping(value = "/adddata3", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> setAllBooks(@RequestBody Book b) {
	    System.out.println("this is value of data=="+b);
		return bookService.setAllBooks(b);
	}
}
