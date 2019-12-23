package com.myservs.demo.Dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//@JsonIgnoreProperties(value= {"id","birthDate"})
@Entity
public class UserDTO {
	
	@Id
	@GeneratedValue
	private int id;
//	@JsonIgnore
	@Size(min =2,message="Minimum size is 2 Character")
	private String name;
	
	@Past(message="Birthdate should not be future date")
	private Date birthDate;
	
	@OneToMany(mappedBy="userDTO")
	private List<PostDTO> postDTO;
	
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
	public List<PostDTO> getPostDTO() {
		return postDTO;
	}
	public void setPostDTO(List<PostDTO> postDTO) {
		this.postDTO = postDTO;
	}

}
