package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.mmadinastia.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Size(min = 5, max = 20, message = "Deve ter entre 5 e 20 caracteres")
	@NotBlank(message = "Campo obrigatorio")
	private String username;
	
	@Email(message = "Digite um email valido!")
	private String email;
	
	@NotBlank(message = "Campo obrigatorio")
	private String campName;
	
	private OffsetDateTime registerDate;

	private Set<RoleDTO> roles = new HashSet<>();

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.email = entity.getEmail();
		this.campName = entity.getCampName();
		this.registerDate = entity.getRegisterDate();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

}
