package com.user.app.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.app.dto.CreateUserDto;
import com.user.app.model.RoleModel;
import com.user.app.model.UserModel;
import com.user.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<UserModel> listAllClientes() {
		return repository.findAll();
	}

	@Transactional
	public void createProduto(CreateUserDto dto) {
		UserModel model = new UserModel();
		model.setEmail(dto.getEmail());
		model.setNome(dto.getNome());
		model.setPassword(dto.getPassword());
		
		RoleModel roleModel = new RoleModel();
		roleModel.setRoleName(dto.getRolename());
		
		model.getRoles().add(roleModel);
		
		repository.save(model);
		
	}

	public UserModel findUserByEmail(String email) {		
		return repository.findByEmail(email);
	}

}
