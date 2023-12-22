package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;
import com.example.demo.pojo.ListOfHeader;
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
	
	@GetMapping("/getallheaders")
	public ResponseEntity<Object>  getAllHeaders(){
		List<HeaderOfSubject> header=headerOfSubjectAndSideOfSubject.finallHeader();
	     if(header.size()>0) {
	    	 return  ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(header);
	     }
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	@GetMapping("/findbyidheaders/{id}")
	public ResponseEntity<Object>  findByIdHeaders(@PathVariable("id") long id){
		List<HeaderOfSubject> header=headerOfSubjectAndSideOfSubject.findByIdHeaders(id);
	     if(header.size()>0) {
	    	 return  ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(header);
	     }
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	
	@GetMapping("/findbyidheadersandsubhedid/{subidid}/{headerid}")
	public ResponseEntity<Object>  findByIdHeadersandsubid(@PathVariable("subidid") long subidid, @PathVariable("headerid") long headerid){
		List<SideOfContent> header=headerOfSubjectAndSideOfSubject.findBysubidandheaderid(subidid,headerid);
	     if(header.size()>0) {
	    	 return  ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(header);
	     }
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	
	@GetMapping(value = "/createheader",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HeaderOfSubject>>  createHeader(@RequestBody ListOfHeader listOfHeader) {
		List<HeaderOfSubject> header=headerOfSubjectAndSideOfSubject.createHeader(listOfHeader);
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);
	}
}
