package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.FighterDtoAssembler;
import com.mmadinastia.api.dto.FighterDTO;
import com.mmadinastia.domain.entities.Fighter;
import com.mmadinastia.domain.repositories.FighterRepository;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class FighterService {

	@Autowired
	private FighterRepository fighterRepository;

	@Autowired
	private FighterDtoAssembler assembler;

	@Transactional(readOnly = true)
	public Page<FighterDTO> findAllPaged(Pageable pageable) {

		return assembler.toCollectionDTO(fighterRepository.findAll(pageable));
	}

	@Transactional(readOnly = true)
	public FighterDTO findById(Long id) {

		Fighter fighter = findOrFail(id);

		return assembler.toDTO(fighter);
	}

	public Fighter findOrFail(Long id) {
		return fighterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Usuário não encontrado: ", id)));
	}
	
}
