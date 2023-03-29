package com.mmadinastia.api.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mmadinastia.api.dto.FightDTO;
import com.mmadinastia.domain.services.FightService;

@RestController
@RequestMapping(value = "/fights")
public class FightResource {

	@Autowired
	private FightService fightService;

	@GetMapping("/{id}")
	public ResponseEntity<FightDTO> findById(@PathVariable Long id) throws Exception {
		FightDTO dto = fightService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	@Secured(value = { "ROLE_MANAGER", "ROLE_ADMIN" })
	public ResponseEntity<FightDTO> insert(@RequestBody FightDTO dto) {
		dto = fightService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
