package com.mmadinastia.api.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mmadinastia.api.dto.OrganizationDTO;
import com.mmadinastia.domain.services.OrganizationService;

@RestController
@RequestMapping(value = "/organizations")
public class OrganizationResource {

	@Autowired
	private OrganizationService organizationService;

	@GetMapping
	@Secured({})
	public ResponseEntity<Page<OrganizationDTO>> findAllPageable(Pageable pageable) {

		Page<OrganizationDTO> page = organizationService.findAllPaged(pageable);

		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrganizationDTO> findById(@PathVariable Long id) {
		OrganizationDTO dto = organizationService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	@Secured(value = { "ROLE_MANAGER", "ROLE_ADMIN" })
	public ResponseEntity<OrganizationDTO> insert(@RequestBody OrganizationDTO dto) {
		dto = organizationService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
