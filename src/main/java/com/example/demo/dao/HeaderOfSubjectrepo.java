package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Id;
import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;

import java.util.List;

public interface HeaderOfSubjectrepo extends JpaRepository<HeaderOfSubject, Long> {

	HeaderOfSubject findById(long id);
	List<HeaderOfSubject>findAll();
	
}
