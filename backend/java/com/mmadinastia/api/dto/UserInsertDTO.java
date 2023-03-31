package com.mmadinastia.api.dto;

import com.mmadinastia.domain.services.validation.UserInsertValid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@UserInsertValid
public class UserInsertDTO extends UserDTO {
	private static final long serialVersionUID = 1L;

	private String password;
	
	public UserInsertDTO() {
		super();
	}
	
}
