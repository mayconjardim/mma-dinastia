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

	@Transactional
	public FighterDTO insert(FighterDTO dto) {

		Fighter entity = new Fighter();

		copyDtoToEntity(dto, entity);

		entity = fighterRepository.save(entity);

		return assembler.toDTO(entity);
	}

	public Fighter findOrFail(Long id) {
		return fighterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Usuário não encontrado: ", id)));
	}

	public void copyDtoToEntity(FighterDTO fighterDto, Fighter entity) {
		entity.setFirstName(fighterDto.getFirstName());
		entity.setLastName(fighterDto.getLastName());
		entity.setNickname(fighterDto.getLastName());
		entity.setAge(fighterDto.getAge());
		entity.setWeightClass(fighterDto.getWeightClass());
		entity.setPunching(fighterDto.getPunching());
		entity.setKicking(fighterDto.getKicking());
		entity.setClinchStriking(fighterDto.getClinchStriking());
		entity.setClinchGrappling(fighterDto.getClinchGrappling());
		entity.setTakedowns(fighterDto.getTakedowns());
		entity.setGnp(fighterDto.getGnp());
		entity.setSubmission(fighterDto.getSubmission());
		entity.setGroundGame(fighterDto.getGroundGame());
		entity.setDodging(fighterDto.getDodging());
		entity.setSubDefense(fighterDto.getSubDefense());
		entity.setTakedownsDef(fighterDto.getTakedownsDef());
		entity.setAggressiveness(fighterDto.getAggressiveness());
		entity.setControl(fighterDto.getControl());
		entity.setMotivation(fighterDto.getMotivation());
		entity.setStrength(fighterDto.getStrength());
		entity.setAgility(fighterDto.getAgility());
		entity.setConditioning(fighterDto.getConditioning());
		entity.setKoResistance(fighterDto.getKoResistance());
		entity.setToughness(fighterDto.getToughness());
	}

}
