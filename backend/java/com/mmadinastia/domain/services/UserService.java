package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.UserDtoAssembler;
import com.mmadinastia.api.assembler.UserDtoDisassembler;
import com.mmadinastia.api.dto.RoleDTO;
import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.api.dto.UserInsertDTO;
import com.mmadinastia.domain.entities.Role;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.RoleRepository;
import com.mmadinastia.domain.repositories.UserRepository;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserDtoAssembler assembler;

	@Autowired
	private UserDtoDisassembler disassembler;

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

		User entity = new User();
		disassembler.copyToDomainObject(dto, entity);

		entity.getRoles().clear();
		for (RoleDTO roleDTO: dto.getRoles()) {
			Role role = roleRepository.getReferenceById(roleDTO.getId());
			entity.getRoles().add(role);
		}
		
		entity = userRepository.save(entity);

		return assembler.toDTO(entity);

	}

	public User findOrFail(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Usuário não encontrado: ", id)));
	}

}
