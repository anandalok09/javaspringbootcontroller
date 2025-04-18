package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.HeaderOfSubjectrepo;
import com.example.demo.dao.SideOfContentrepo;
import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;
import com.example.demo.exception.CustmizationException;
import com.example.demo.exception.NotUpdated;
import com.example.demo.pojo.ListOfHeader;
import com.example.demo.pojo.ListOfsideHeader;
import com.example.demo.utility.UtilityInterface;
@Service
@Transactional /* this is class level tranjection
if we do class level tranjection , tranjection will applay all public methode 

*/ 
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
		HeaderOfSubject headerOfSubject=(headerOfSubjectrepo.findById(id)).orElseThrow(()->new NoSuchElementException("No data avilable here"));
		headerOfSubject.setSubjectheaderName(subjectheaderName);
		
		if(headerOfSubjectrepo.save(headerOfSubject)!=null) {
			return "Success Full";	
		}
		throw new NotUpdated("geating error during updating  Header where id ="+id);
		
	}
	/*here is method level tranjection 
	 * if we need o applay tranjection on particular method then we can applay anotation on that method 
	 * if we need tranjection on private method then we have to use on that method but tranjection not applay on private method
	 * */
  @Transactional
	public String updateSideHeaderorcontent(SideOfContent sc, Long id) {
		// TODO Auto-generated method stub
		SideOfContent s = sideOfContentrepo.findById(id)
			    .orElseThrow(() -> new NoSuchElementException("Note available data"));

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

	public List<SideOfContent> findSideheaderByheaderid(long id) {
		// TODO Auto-generated method stub
		List<SideOfContent> sideOfContent=sideOfContentrepo.findsideheaderByHeaderid(id);
		if(sideOfContent.size()==0)
			throw new CustmizationException(UtilityInterface.notfoundbyid+id);
		return sideOfContent;
	}
}
