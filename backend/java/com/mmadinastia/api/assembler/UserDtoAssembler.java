package com.mmadinastia.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.domain.entities.User;

@Component
public class UserDtoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public UserDTO toDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public List<UserDTO> toCollectionDTO(List<User> users) {
		return users.stream().map(user -> toDTO(user)).collect(Collectors.toList());

	}

	public Page<UserDTO> toCollectionDTO(Page<User> users) {
		return users.map(user -> toDTO(user));

	}

}
