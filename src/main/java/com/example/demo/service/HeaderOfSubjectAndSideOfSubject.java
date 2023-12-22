package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HeaderOfSubjectrepo;
import com.example.demo.dao.SideOfContentrepo;
import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;
import com.example.demo.pojo.ListOfHeader;
@Service
public class HeaderOfSubjectAndSideOfSubject {

	@Autowired
	HeaderOfSubjectrepo headerOfSubjectrepo;
	@Autowired
	SideOfContentrepo sideOfContentrepo;
	
	public List<HeaderOfSubject>finallHeader(){
		return headerOfSubjectrepo.findAll();
	}
	
	public List<HeaderOfSubject>findByIdHeaders(long id){
		return headerOfSubjectrepo.findById(id);
	}
	public List<SideOfContent> findBysubidandheaderid(long subidid,long headerid){
		return sideOfContentrepo.findByIdAndHeaderOfSubjectid(subidid, headerid);
	}
	public List<HeaderOfSubject> createHeader(ListOfHeader listOfHeader){
		return headerOfSubjectrepo.saveAll(listOfHeader.getHeaderOfSubject());
	}
}
