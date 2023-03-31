package com.mmadinastia.api.dto;

import java.io.Serializable;

import com.mmadinastia.domain.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String authority;

	public RoleDTO(Role role) {
		super();
		id = role.getId();
		authority = role.getAuthority();
	}
	
}
