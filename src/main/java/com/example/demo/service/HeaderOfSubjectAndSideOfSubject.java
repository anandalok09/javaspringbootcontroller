package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.HeaderOfSubjectrepo;
import com.example.demo.entity.HeaderOfSubject;

public class HeaderOfSubjectAndSideOfSubject {

	@Autowired
	HeaderOfSubjectrepo headerOfSubjectrepo;
	
	public List<HeaderOfSubject>finallHeader(){
		
		return headerOfSubjectrepo.findAll();
	}
}
