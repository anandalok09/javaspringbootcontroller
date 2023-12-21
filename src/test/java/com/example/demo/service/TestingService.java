package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingService {

	@Autowired
	BookService bookService;
	int i=0;
	@Test //this anotation  indicate we need run test case
	public void testbookservice() {
		Book b=new Book();
	    b.setId(501);
	    b.setName("book501");
	    b.setPrince(501);
	    
	    Book b1=new Book();
	    b1.setId(502);
	    b1.setName("book502");
	    b1.setPrince(502);
	    
	    Book b2=new Book();
	    b2.setId(503);
	    b2.setName("book503");
	    b2.setPrince(503);
	    
	    Book b3=new Book();
	    b3.setId(504);
	    b3.setName("book504");
	    b3.setPrince(504);
	    ArrayList<Book> l=new ArrayList<Book>();
	    l.add(b);
	    l.add(b1);
	    l.add(b2);
	    l.add(b3);
		
		assertThat(bookService.getAllBooks().size()).isEqualTo(l.size());
		i=i+1;
		System.out.println("first testclass==="+i);
	}
	@AfterEach //this anotation  indicate we need run this class after all  test case
	public void afterRunallcass() {
		i=i+1;
		System.out.println("This is the all after class===="+i);
	}
	@BeforeEach //this anotation  indicate we need run this class before all  test case
	public void beforeRunallcass() {
		i=i+1;
		System.out.println("This is the all Before class====="+i);
	}
}
