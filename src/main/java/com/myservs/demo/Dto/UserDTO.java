package com.myservs.demo.Dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"id","birthDate"})
public class UserDTO {
	
	private int id;
//	@JsonIgnore
	@Size(min =2,message="Minimum size is 2 Character")
	private String name;
	
	@Past(message="Birthdate should not be future date")
	private Date birthDate;
	
	protected UserDTO() {
		
	}
	
	public UserDTO(int id,String name,Date birthDate) {
		super();
		this.id=id;
		this.name=name;
		this.birthDate=birthDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
