package com.mmadinastia.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.mmadinastia.domain.services.validation.UserInsertValid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@UserInsertValid
public class UserInsertDTO extends UserDTO {
	private static final long serialVersionUID = 1L;

	@Size(min = 5, max = 20, message = "Deve ter entre 5 e 20 caracteres")
	@NotBlank(message = "Campo obrigatorio")
	private String password;
	
	public UserInsertDTO() {
		super();
	}
	
}
