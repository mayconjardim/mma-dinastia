package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.mmadinastia.domain.services.validation.UserInsertValid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@UserInsertValid
public class UserInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 20, message = "Deve ter entre 5 e 20 caracteres")
	@NotBlank(message = "Campo obrigatorio")
	private String username;
	
	@Email(message = "Digite um email valido!")
	private String email;
	
	@NotBlank(message = "Campo obrigatorio")
	private String campName;
	
	@Size(min = 5, max = 20, message = "Deve ter entre 5 e 20 caracteres")
	@NotBlank(message = "Campo obrigatorio")
	private String password;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
}
