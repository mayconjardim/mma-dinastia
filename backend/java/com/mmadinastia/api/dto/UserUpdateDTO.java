package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String email;
	private String campName;
	private String password;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
}
