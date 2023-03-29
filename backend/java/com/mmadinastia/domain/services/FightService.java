package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.FightDtoAssembler;
import com.mmadinastia.api.dto.FightDTO;
import com.mmadinastia.domain.entities.Fight;
import com.mmadinastia.domain.repositories.FightRepository;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class FightService {

	@Autowired
	private FightRepository fightRepository;

	@Autowired
	private FightDtoAssembler assembler;

	@Transactional(readOnly = true)
	public Page<FightDTO> findAllPaged(Pageable pageable) {

		return assembler.toCollectionDTO(fightRepository.findAll(pageable));
	}

	@Transactional(readOnly = true)
	public FightDTO findById(Long id) {

		Fight fight = findOrFail(id);

		return assembler.toDTO(fight);
	}
	
	public Fight findOrFail(Long id) {
		return fightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Luta não encontrada: ", id)));
	}
	
}
