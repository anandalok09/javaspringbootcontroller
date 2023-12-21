package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Id;
import com.example.demo.entity.HeaderOfSubject;
import java.util.List;

public interface HeaderOfSubjectrepo extends JpaRepository<HeaderOfSubject, Id> {

	List<HeaderOfSubject> findById(long id);
	List<HeaderOfSubject>findAll();
	
}
