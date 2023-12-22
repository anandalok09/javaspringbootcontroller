package com.example.demo.pojo;

import java.util.List;

import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;

public class ListOfHeader {
	private List<HeaderOfSubject> headerOfSubject;
	public List<HeaderOfSubject> getHeaderOfSubject() {
		return headerOfSubject;
	}
	public void setHeaderOfSubject(List<HeaderOfSubject> headerOfSubject) {
		this.headerOfSubject = headerOfSubject;
	}
	public List<SideOfContent> getSideOfContent() {
		return sideOfContent;
	}
	public void setSideOfContent(List<SideOfContent> sideOfContent) {
		this.sideOfContent = sideOfContent;
	}
	private List<SideOfContent> sideOfContent;
	

}
