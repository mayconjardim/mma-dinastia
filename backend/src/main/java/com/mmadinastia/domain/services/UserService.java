package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable){
		Page<User>  list = userRepository.findAll(pageable);
		
		return list.map(x-> new UserDTO(x));
		
	}
	
}
