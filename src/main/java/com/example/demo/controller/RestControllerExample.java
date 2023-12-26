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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;
import com.example.demo.exception.CustmizationException;
import com.example.demo.pojo.ListOfHeader;
import com.example.demo.pojo.ListOfsideHeader;
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
//	     if(header.size()>0) {
//	    	 return  ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(header);
//	     }
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	
	@GetMapping("/getallsideheaders/{id}")
	public ResponseEntity<Object>  getAllsideHeaders(@PathParam("id") long id){
		List<SideOfContent> header=headerOfSubjectAndSideOfSubject.findSideheaderByheaderid(id); 
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	@GetMapping("/findbyidheaders/{id}")
	public ResponseEntity<Object>  findByIdHeaders(@PathVariable("id") long id){
		HeaderOfSubject header=headerOfSubjectAndSideOfSubject.findByIdHeaders(id);
	     if(header!=null) {
	    	 return  ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(header);
	     }
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	@GetMapping("/findbyidheadersandsubhedid/{subidid}/{headerid}")
	public ResponseEntity<Object>  findByIdHeadersandsubid(@PathVariable("subidid") long subidid, @PathVariable("headerid") long headerid){
		List<SideOfContent> header=headerOfSubjectAndSideOfSubject.findBysubidandheaderid(subidid,headerid);
	     if(header.size()==0) {
	    	 
	    	 throw new CustmizationException("Record not found given subidid=="+subidid +"headerid="+headerid);
	     }
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);	
	}
	@PostMapping(value = "/createheader",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HeaderOfSubject>>  createHeader(@RequestBody ListOfHeader listOfHeader) {
		List<HeaderOfSubject> header=headerOfSubjectAndSideOfSubject.createHeader(listOfHeader);
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);   
	}
	@PostMapping(value = "/createsideheader",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SideOfContent>>  createsideHeader(@RequestBody ListOfsideHeader listOfsideHeader) {
	List<SideOfContent> header=headerOfSubjectAndSideOfSubject.createSideHeader(listOfsideHeader);
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);   
	}
	
	@PutMapping(value = "/updateinheader/{subjectheaderName}/{id}")
	public ResponseEntity<String>  
	updateHeader(@PathVariable("subjectheaderName")String subjectheaderName,@PathParam("id") Long id) {
	String header=headerOfSubjectAndSideOfSubject.updateHeader(subjectheaderName, id);
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);   
	}
	
	@PutMapping(value = "/updateinsideheader/{id}")
	public ResponseEntity<String>  
	updateSideHeaderorcontent(@RequestBody SideOfContent sc,@PathParam("id") Long id) {
	String header=headerOfSubjectAndSideOfSubject.updateSideHeaderorcontent(sc, id);
		return  ResponseEntity.status(HttpStatus.SC_OK).body(header);   
	}
	
}
