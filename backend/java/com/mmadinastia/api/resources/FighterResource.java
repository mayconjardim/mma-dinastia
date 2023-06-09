package com.mmadinastia.api.resources;

import java.net.URI;

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

import com.mmadinastia.api.dto.FighterDTO;
import com.mmadinastia.api.dto.FighterStratsDTO;
import com.mmadinastia.domain.services.FighterService;

@RestController
@RequestMapping(value = "/fighters")
public class FighterResource {

	@Autowired
	private FighterService fighterService;

	@GetMapping
	@Secured({})
	public ResponseEntity<Page<FighterDTO>> findAllPageable(Pageable pageable) {

		Page<FighterDTO> page = fighterService.findAllPaged(pageable);

		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	@Secured({})
	public ResponseEntity<FighterDTO> findById(@PathVariable Long id) {

		FighterDTO dto = fighterService.findById(id);

		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/strats/{id}")
	public ResponseEntity<FighterStratsDTO> findByStratsById(@PathVariable Long id) {
		FighterStratsDTO dto = fighterService.findByStratsById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	@Secured(value = { "ROLE_MANAGER", "ROLE_ADMIN" })
	public ResponseEntity<FighterDTO> insert(@RequestBody FighterDTO dto) {
		dto = fighterService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	@Secured(value = { "ROLE_MANAGER", "ROLE_ADMIN" })
	public ResponseEntity<FighterDTO> update(@PathVariable Long id, @RequestBody FighterStratsDTO dto) {

		FighterDTO newDto = fighterService.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	@Secured(value = "ROLE_ADMIN")
	public ResponseEntity<FighterDTO> delete(@PathVariable Long id) {
		fighterService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
