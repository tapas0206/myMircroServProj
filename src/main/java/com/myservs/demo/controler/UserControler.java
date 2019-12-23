package com.myservs.demo.controler;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.myservs.demo.Dto.PostDTO;
import com.myservs.demo.Dto.UserDTO;
import com.myservs.demo.ExcepHandlers.UserNotFoundException;
import com.myservs.demo.Repository.PostRepository;
import com.myservs.demo.Repository.UserRepository;
import com.myservs.demo.Services.UserServices;

@RestController
public class UserControler {
	
	@Autowired
	private UserServices UserService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/ListUsers")
	public List<UserDTO> retriveAllUsers(){
		return UserService.findAll();
	}
	
	@GetMapping("/JPA/ListUsers")
	public List<UserDTO> jpaRetriveAllUsers(){
		return userRepository.findAll();
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
	
	@GetMapping("/JPA/ListUsers/{id}")
	public Optional<UserDTO> JpaRetriveUser(@PathVariable int id) throws Exception {
		Optional<UserDTO> savedUser=userRepository.findById(id);
		
		if(!savedUser.isPresent()) 
			throw new UserNotFoundException("id - "+id);
		
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
	
	@DeleteMapping("/JPA/RemoveUser/{id}")
	public void JPAremoveUser(@PathVariable int id) throws Exception{
		System.out.println(id);
		userRepository.deleteById(id);
		
	}
	
	@GetMapping("/JPA/ListUsers/{id}/posts")
	public List<PostDTO> JpaRetriveUserPost(@PathVariable int id) throws Exception {
		Optional<UserDTO> savedUser=userRepository.findById(id);
		
		if(!savedUser.isPresent()) 
			throw new UserNotFoundException("id - "+id);
		
		return savedUser.get().getPostDTO();
	}

	@PostMapping("/JPA/User/{id}/posts")
	public ResponseEntity<Object> CreateUserPost(@PathVariable int id,@RequestBody PostDTO postDto) {
		
		Optional<UserDTO> savedUser=userRepository.findById(id);
		if(!savedUser.isPresent()) 
			throw new UserNotFoundException("id - "+id);
		
		UserDTO user =savedUser.get();
		postDto.setUserDTO(user);
		
		postRepository.save(postDto);
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postDto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

}
