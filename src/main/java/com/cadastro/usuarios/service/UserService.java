package com.cadastro.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.usuarios.model.Users;
import com.cadastro.usuarios.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	

	public Users saveUser(Users users) {
		return repo.save(users);
	}
	
	public List<Users> getUsers() {
		return repo.findAll();
	}
	
	public Users getUser(Long id) {
		return repo.findById(id).get();
	}
	
	public Users updateUser(Users user, Long id) {
		Users updateUser = repo.findById(id).get();
		updateUser.setNome(user.getNome());
		updateUser.setCpf(user.getCpf());
		updateUser.setNumero(user.getNumero());
		updateUser.setEmail(user.getEmail());
		return repo.save(user);
	}
	
	
	public void deleteUser(Long id) {
		 repo.deleteById(id);
	}

}
