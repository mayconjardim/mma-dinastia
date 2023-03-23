package com.mmadinastia.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.UserInsertDTO;
import com.mmadinastia.domain.entities.User;

@Component
public class UserDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;

    public User toDomainObject(UserInsertDTO userInsertDto) {
        return modelMapper.map(userInsertDto, User.class);
    }

    public void copyToDomainObject(UserInsertDTO userInsertDto, User user) {
    	
    	modelMapper.map(userInsertDto, user);
        
    }

}
