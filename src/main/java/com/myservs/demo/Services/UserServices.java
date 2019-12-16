package com.myservs.demo.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myservs.demo.Dto.UserDTO;

@Component
public class UserServices {

	private static List<UserDTO> user=new ArrayList<>();
	
	private static int userCount=4;
	
	static {
		user.add(new UserDTO(1, "User0", new Date()));
		user.add(new UserDTO(2, "User1", new Date()));
		user.add(new UserDTO(3, "User2", new Date()));
		user.add(new UserDTO(4, "User3", new Date()));
	}
	
	public List<UserDTO> findAll(){
		return user;
	}
	
	public UserDTO saveUser(UserDTO userDto) {
		if(userDto.getId()==0) {
			userDto.setId(++userCount);
		}
		user.add(userDto);
		return userDto;
	}
	
	public UserDTO findUser(int id) {
		for(UserDTO users:user) {
			if(users.getId()==id) {
				return users;
			}
		}
		return null;
	}
	
	public UserDTO removeUser(int id) {
		Iterator<UserDTO> iterator=user.iterator();
		while(iterator.hasNext()) {
			UserDTO dto=iterator.next();
			if(dto.getId()==id) {
				iterator.remove();
				return dto;
			}
		}
		return null;
	}
	
}
