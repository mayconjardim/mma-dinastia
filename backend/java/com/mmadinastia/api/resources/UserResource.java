package com.mmadinastia.api.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mmadinastia.api.dto.UserDTO;
import com.mmadinastia.api.dto.UserInsertDTO;
import com.mmadinastia.api.dto.UserUpdateDTO;
import com.mmadinastia.domain.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	@Secured({})
	public ResponseEntity<Page<UserDTO>> findAllPageable(Pageable pageable) {

		Page<UserDTO> page = userService.findAllPaged(pageable);

		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	@Secured({})
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {

		UserDTO dto = userService.findById(id);

		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	@Secured({})
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
		UserDTO newDTO = userService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDTO.getId()).toUri();

		return ResponseEntity.created(uri).body(newDTO);
	}

	@PutMapping(value = "/{id}")
	@Secured(value = { "ROLE_MANAGER", "ROLE_ADMIN" })
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) {

		UserDTO newDto = userService.update(id, dto);

		return ResponseEntity.ok().body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	@Secured(value = "ROLE_ADMIN")
	public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
