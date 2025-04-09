package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.SideOfContent;

import jakarta.persistence.Id;

public interface SideOfContentrepo extends JpaRepository<SideOfContent, Long> {

              SideOfContent findById(long id);
	@Query(value ="select * from side_of_content where id=:subidid and header_id=:headerid",nativeQuery = true)
	List<SideOfContent> findByIdAndHeaderOfSubjectid(@Param("subidid") long subidid,@Param("headerid") long headerid);
	
	@Query(value ="select * from side_of_content where header_id=:headerid",nativeQuery = true)
	List<SideOfContent> findsideheaderByHeaderid(@Param("headerid") long headerid);
}
