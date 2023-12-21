package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SideOfContent;

import jakarta.persistence.Id;

public interface SideOfContentrepo extends JpaRepository<SideOfContent, Id> {

	List<SideOfContent> findById(long id);
}
