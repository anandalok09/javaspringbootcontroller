package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HeaderOfSubjectrepo;
import com.example.demo.dao.SideOfContentrepo;
import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;
import com.example.demo.exception.NotUpdated;
import com.example.demo.pojo.ListOfHeader;
import com.example.demo.pojo.ListOfsideHeader;
import com.example.demo.utility.UtilityInterface;
@Service
public class HeaderOfSubjectAndSideOfSubject {

	@Autowired
	HeaderOfSubjectrepo headerOfSubjectrepo;
	@Autowired
	SideOfContentrepo sideOfContentrepo;
	
	public List<HeaderOfSubject>finallHeader(){
		return headerOfSubjectrepo.findAll();
	}
	
	public HeaderOfSubject findByIdHeaders(long id){
		return headerOfSubjectrepo.findById(id);
	}
	public List<SideOfContent> findBysubidandheaderid(long subidid,long headerid){
		return sideOfContentrepo.findByIdAndHeaderOfSubjectid(subidid, headerid);
	}
	public List<HeaderOfSubject> createHeader(ListOfHeader listOfHeader){
		return headerOfSubjectrepo.saveAll(listOfHeader.getHeaderOfSubject());
	}

	public List<SideOfContent> createSideHeader(ListOfsideHeader listOfsideHeader) {
		// TODO Auto-generated method stub
		List<SideOfContent > l1=listOfsideHeader.getSideOfContent().stream()
				.map(m->{
					m.setHeaderOfSubject(listOfsideHeader.getHeaderOfSubject());
					return m;}
					)
				.collect(Collectors.toList());
		return sideOfContentrepo.saveAll(l1);
		
	}

	public String updateHeader(String subjectheaderName, Long id) {
		// TODO Auto-generated method stub
		HeaderOfSubject headerOfSubject=(headerOfSubjectrepo.findById(id));
		headerOfSubject.setSubjectheaderName(subjectheaderName);
		
		if(headerOfSubjectrepo.save(headerOfSubject)!=null) {
			return "Success Full";	
		}
		throw new NotUpdated("geating error during updating  Header where id ="+id);
		
	}

	public String updateSideHeaderorcontent(SideOfContent sc, Long id) {
		// TODO Auto-generated method stub
		SideOfContent s=sideOfContentrepo.findById(id);
		
		System.out.println("this is value of data ===="+s.getImagesro());
		
		
		             s.setImagesro(sc.getImagesro());
		             s.setSidemainheader(sc.getSidemainheader());
		             s.setSidesubheader(sc.getSidesubheader());
		             sc.setSubjectcontent(sc.getSubjectcontent());
		             System.out.println("this is db object===="+s);
		             System.out.println("this is filter object===="+sc);
		        if( sideOfContentrepo.save(s)!=null) {
		        	return UtilityInterface.updateMessage;
		        }
		        throw new NotUpdated(UtilityInterface.notUpdatedByID+""+id);     
	}
}
