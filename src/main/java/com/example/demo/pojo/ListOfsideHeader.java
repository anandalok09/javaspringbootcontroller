package com.example.demo.pojo;
import java.util.List;

import com.example.demo.entity.HeaderOfSubject;
import com.example.demo.entity.SideOfContent;
public class ListOfsideHeader {
	private HeaderOfSubject headerOfSubject;
	public HeaderOfSubject getHeaderOfSubject() {
		return headerOfSubject;
	}

	public void setHeaderOfSubject(HeaderOfSubject headerOfSubject) {
		this.headerOfSubject = headerOfSubject;
	}

	private List<SideOfContent> sideOfContent;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long id;

	public List<SideOfContent> getSideOfContent() {
		return sideOfContent;
	}

	public void setSideOfContent(List<SideOfContent> sideOfContent) {
		this.sideOfContent = sideOfContent;
	}
	

}