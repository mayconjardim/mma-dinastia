package com.mmadinastia.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.UserDtoAssembler;
import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.UserRepository;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDtoAssembler assembler;

	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		return assembler.toCollectionDTO(userRepository.findAll(pageable));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
	
		Optional<User> obj = userRepository.findById(id);
		
		User entity = obj.orElseThrow(()-> new Exception("Entity not found"));
		
		return new UserDTO(entity);
	}
	
	
    public User findOrFail(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Usuário não encontrado: ", id)));
    }

}
