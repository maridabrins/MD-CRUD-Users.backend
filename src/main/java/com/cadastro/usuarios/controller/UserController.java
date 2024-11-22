package com.cadastro.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.usuarios.model.Users;
import com.cadastro.usuarios.service.UserService;

@RequestMapping
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/cadastro/users")
	public List<Users> getUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/cadastro/user/{id}")
	public Users getUser(@PathVariable Long id) {
		return service.getUser(id);
	}
	
	@PostMapping("/cadastro/create-user")
	public Users saveUser (@RequestBody Users user) {
		return service.saveUser(user);
	}
	@PutMapping("/cadastro/update-user/{id}")
	public Users updateUser (@PathVariable Long id, @RequestBody Users user) {
		return service.updateUser(user, id);
	}
	
	@DeleteMapping("/cadastro/delete-user/{id}")
	public void deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
	}
	

}
