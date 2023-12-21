package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HeaderOfSubject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
	private long id;
	public long getId() {
		return id;
	}
	public HeaderOfSubject(long id, String subjectheaderName) {
		super();
		this.id = id;
		this.subjectheaderName = subjectheaderName;
	}
	@Override
	public String toString() {
		return "HeaderOfSubject [id=" + id + ", subjectheaderName=" + subjectheaderName + "]";
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubjectheaderName() {
		return subjectheaderName;
	}
	public void setSubjectheaderName(String subjectheaderName) {
		this.subjectheaderName = subjectheaderName;
	}
	private String subjectheaderName;
}
