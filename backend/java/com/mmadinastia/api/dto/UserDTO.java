package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String email;
	private String campName;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
}
