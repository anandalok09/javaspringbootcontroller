package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	public ArrayList<Book> getAllBooks(){
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
	    return l;
	}
	public ArrayList<Book> setAllBooks(Book b7){
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
	    l.add(b7);
	    return l;
	}
	public String getAuthToken(User user){
		Map<String,String> m=new HashMap<String,String>();
		m.put("Alok","852126");
		m.put("Anand", "852126");
		m.put("guddu","852126");
		if(m.get(user.username)!=null) {
			return "abcdefgh"; 	
		}else {
			return "notfound";
		}
		
	
		
	}
	
}
