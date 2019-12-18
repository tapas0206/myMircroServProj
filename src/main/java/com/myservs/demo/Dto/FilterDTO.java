package com.myservs.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("jsonFilter")
public class FilterDTO {
	private String filed1;
	private String filed2;
	private String filed3;
	
	public FilterDTO(String filed1, String filed2, String filed3) {
		super();
		this.filed1 = filed1;
		this.filed2 = filed2;
		this.filed3 = filed3;
	}
	public String getFiled1() {
		return filed1;
	}
	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	public String getFiled3() {
		return filed3;
	}
	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}
	
	
}
