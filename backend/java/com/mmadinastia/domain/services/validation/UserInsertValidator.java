package com.mmadinastia.domain.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mmadinastia.api.dto.UserInsertDTO;
import com.mmadinastia.api.resources.exceptions.FieldMessage;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.UserRepository;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		User username = userRepository.findByUsername(dto.getUsername());
		
		User email = userRepository.findByEmail(dto.getEmail());
		
		if (username != null) {
			list.add(new FieldMessage("username", "Username já exite"));
		}
		
		if (email != null) {
			list.add(new FieldMessage("email", "Email já exite"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}