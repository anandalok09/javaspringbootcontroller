package com.example.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class SideOfContent {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
	private long id;
	@ManyToOne(fetch =FetchType.LAZY)
	  @JoinColumn(name = "header_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	private HeaderOfSubject headerOfSubject;
	private String sidemainheader;
	private String sidesubheader;
	@Lob 
	private String subjectcontent;
	@Override
	public String toString() {
		return "SideOfContent [id=" + id + ", headerOfSubject=" + headerOfSubject + ", sidemainheader=" + sidemainheader
				+ ", sidesubheader=" + sidesubheader + ", subjectcontent=" + subjectcontent + ", imagesro=" + imagesro
				+ "]";
	}


	public SideOfContent() {
	
	}
	
	
	public SideOfContent(long id, HeaderOfSubject headerOfSubject, String sidemainheader, String sidesubheader,
			String subjectcontent, String imagesro) {
		this.id = id;
		this.headerOfSubject = headerOfSubject;
		this.sidemainheader = sidemainheader;
		this.sidesubheader = sidesubheader;
		this.subjectcontent = subjectcontent;
		this.imagesro = imagesro;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public HeaderOfSubject getHeaderOfSubject() {
		return headerOfSubject;
	}
	public void setHeaderOfSubject(HeaderOfSubject headerOfSubject) {
		this.headerOfSubject = headerOfSubject;
	}
	public String getSidemainheader() {
		return sidemainheader;
	}
	public void setSidemainheader(String sidemainheader) {
		this.sidemainheader = sidemainheader;
	}
	public String getSidesubheader() {
		return sidesubheader;
	}
	public void setSidesubheader(String sidesubheader) {
		this.sidesubheader = sidesubheader;
	}
	public String getSubjectcontent() {
		return subjectcontent;
	}
	public void setSubjectcontent(String subjectcontent) {
		this.subjectcontent = subjectcontent;
	}
	public String getImagesro() {
		return imagesro;
	}
	public void setImagesro(String imagesro) {
		this.imagesro = imagesro;
	}
	private String imagesro;
	

}
