package com.mmadinastia.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


	
}
