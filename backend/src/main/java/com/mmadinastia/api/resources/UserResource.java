package com.mmadinastia.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.domain.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAllPageable(Pageable pageable) {
	
		Page<UserDTO> page = userService.findAllPaged(pageable);

		return ResponseEntity.ok().body(page);
	}

	
	
	
}
