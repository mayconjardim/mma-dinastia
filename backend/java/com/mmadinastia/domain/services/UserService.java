package com.mmadinastia.domain.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.UserDtoAssembler;
import com.mmadinastia.api.assembler.UserDtoDisassembler;
import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.api.dto.UserInsertDTO;
import com.mmadinastia.api.dto.UserUpdateDTO;
import com.mmadinastia.domain.entities.Role;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.RoleRepository;
import com.mmadinastia.domain.repositories.UserRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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

		entity.setPassword(passwordEncoder.encode(dto.getPassword()));

		entity.getRoles().clear();
		Role role = roleRepository.getReferenceById(2L);
		entity.getRoles().add(role);

		entity = userRepository.save(entity);

		return assembler.toDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = findOrFail(id);
			entity.getRoles().clear();

			if (!dto.getPassword().equals(entity.getPassword())) {
				dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			}

			disassembler.copyToDomainObjectUpdate(dto, entity);

			return assembler.toDTO(userRepository.save(entity));
		}

		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}

	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade!");
		}
	}

	public User findOrFail(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Usuário não encontrado: ", id)));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}

		return user;
	}

}
