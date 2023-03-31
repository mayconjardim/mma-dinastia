package com.mmadinastia.domain.services;

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

import com.mmadinastia.api.dto.RoleDTO;
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

	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {

		Page<User> page = userRepository.findAll(pageable);

		return page.map(u -> new UserDTO(u));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {

		User user = findOrFail(id);

		return new UserDTO(user);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
	
		copyDtoToEntity(dto, entity);
		
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
	
		entity = userRepository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {

		User entity = findOrFail(id);

		if (!dto.getPassword().equals(entity.getPassword())) {
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		}
		copyDtoToEntity(dto, entity);

		entity = userRepository.save(entity);
		return new UserDTO(entity);

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

	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setCampName(dto.getCampName());
		entity.setRegisterDate(dto.getRegisterDate());

		entity.getRoles().clear();
		for (RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getReferenceById(roleDTO.getId());
			entity.getRoles().add(role);
		}

	}

	private void copyDtoToEntity(UserUpdateDTO dto, User entity) {

		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setCampName(dto.getCampName());
		
		entity.getRoles().clear();
		for (RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getReferenceById(roleDTO.getId());
			entity.getRoles().add(role);
		}

	}

}
