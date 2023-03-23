package com.mmadinastia.domain.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.mmadinastia.api.dto.UserUpdateDTO;
import com.mmadinastia.api.resources.exceptions.FieldMessage;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.UserRepository;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserUpdateValid ann) {
	}

	@Override
	public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		var uriVars = (Map <String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long userId = Long.parseLong(uriVars.get("id"));
		List<FieldMessage> list = new ArrayList<>();
		
		User username = repository.findByUsername(dto.getUsername());
		
		User user = repository.findByEmail(dto.getEmail());
		
		if (user != null && userId != user.getId()) {
			list.add(new FieldMessage("email", "Email já exite!"));
		}
		
		if (username != null && userId != user.getId()) {
			list.add(new FieldMessage("username", "Username já exite!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}