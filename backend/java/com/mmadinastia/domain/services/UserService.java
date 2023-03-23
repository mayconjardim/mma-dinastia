package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.UserDtoAssembler;
import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.api.dto.UserInsertDTO;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.UserRepository;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDtoAssembler assembler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {

		return assembler.toCollectionDTO(userRepository.findAll(pageable));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {

		User user = findOrFail(id);

		return assembler.toDTO(user);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		
		 try {
	            User iser = disassembler.copyEntityToDTO(restauranteInput);
	            return assembler.copyDtoToEntity(cadastroRestaurante.save(restaurante));
	        } catch (CozinhaNaoEncontradaException e) {
	            throw new NegocioException(e.getMessage());
	        }
		
	}
	
	public User findOrFail(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Usuário não encontrado: ", id)));
	}
	

}
