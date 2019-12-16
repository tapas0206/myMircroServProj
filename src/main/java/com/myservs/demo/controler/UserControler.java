package com.myservs.demo.controler;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myservs.demo.Dto.UserDTO;
import com.myservs.demo.ExcepHandlers.UserNotFoundException;
import com.myservs.demo.Services.UserServices;

@RestController
public class UserControler {
	
	@Autowired
	private UserServices UserService;
	
	@GetMapping("/ListUsers")
	public List<UserDTO> retriveAllUsers(){
		return UserService.findAll();
	}
	
	@GetMapping("/ListUsers/{id}")
	public UserDTO retriveUser(@PathVariable int id) throws Exception {
		UserDTO savedUser=UserService.findUser(id);
		
		if(savedUser==null) 
			throw new UserNotFoundException("id - "+id);
		
//		EntityModel<UserDTO> resource=new EntityModel<UserDTO>(savedUser);
//		ControllerLinkBuilder link= linkTo(methodOn(this.getClass()).retriveAllUsers());
//		resource.add(link.withRel("all-User"));
		return savedUser;
	}
	
	@PostMapping("/AddUser")
	public ResponseEntity<Object> createUser(@Valid@RequestBody UserDTO user) {
		UserDTO savedUser=UserService.saveUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/RemoveUser/{id}")
	public ResponseEntity<Object>  removeUser(@PathVariable int id) throws Exception{
		System.out.println(id);
		UserDTO updateList=UserService.removeUser(id);
		
		if(updateList==null) 
			throw new UserNotFoundException("Unavailable id - "+id);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateList.getId()).toUri();
//		return updateList;
		return ResponseEntity.ok(uri);
	}
	
	

}
