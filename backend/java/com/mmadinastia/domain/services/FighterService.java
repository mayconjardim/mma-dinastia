package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.FighterDtoAssembler;
import com.mmadinastia.api.dto.FighterDTO;
import com.mmadinastia.api.dto.FighterStratsDTO;
import com.mmadinastia.domain.entities.Fighter;
import com.mmadinastia.domain.repositories.FighterRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
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

	@Transactional(readOnly = true)
	public FighterStratsDTO findByStratsById(Long id) {

		Fighter fighter = findOrFail(id);

		return assembler.toStratsDTO(fighter);
	}

	@Transactional
	public FighterDTO insert(FighterDTO dto) {

		Fighter entity = new Fighter();

		copyDtoToEntity(dto, entity);

		entity = fighterRepository.save(entity);

		return assembler.toDTO(entity);
	}

	@Transactional
	public FighterDTO update(Long id, FighterStratsDTO dto) {

		Fighter entity = findOrFail(id);

		copyStrats(dto, entity);

		entity = fighterRepository.save(entity);

		return new FighterDTO(entity);
	}

	public void delete(Long id) {
		try {
			fighterRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade!");
		}
	}

	public Fighter findOrFail(Long id) {
		return fighterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Lutador não encontrado: ", id)));
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

		entity.setStratPunching(25);
		entity.setStratKicking(25);
		entity.setStratClinching(22);
		entity.setStratTakedowns(25);

		entity.setStratDirtyBoxing(25);
		entity.setStratThaiClinch(25);
		entity.setStratClinchTakedowns(25);
		entity.setStratAvoidClinch(25);

		entity.setStratGNP(20);
		entity.setStratSub(20);
		entity.setStratPositioning(20);
		entity.setStratLNP(20);
		entity.setStratStandUp(20);

		entity.setFancyPunches(0);
		entity.setFancyKicks(0);
		entity.setFancySubmissions(0);
		entity.setTacticalStyle(1);
		entity.setDirtyFighting(0);
		entity.setFightingStyle(0);
	}

	private void copyStrats(FighterStratsDTO dto, Fighter entity) {

		entity.setStratPunching(dto.getStratPunching());
		entity.setStratKicking(dto.getStratKicking());
		entity.setStratClinching(dto.getStratClinching());
		entity.setStratTakedowns(dto.getStratTakedowns());

		entity.setStratDirtyBoxing(dto.getStratDirtyBoxing());
		entity.setStratThaiClinch(dto.getStratThaiClinch());
		entity.setStratClinchTakedowns(dto.getStratClinchTakedowns());
		entity.setStratAvoidClinch(dto.getStratAvoidClinch());

		entity.setStratGNP(dto.getStratGNP());
		entity.setStratSub(dto.getStratSub());
		entity.setStratPositioning(dto.getStratPositioning());
		entity.setStratLNP(dto.getStratLNP());
		entity.setStratStandUp(dto.getStratStandUp());

		entity.setFancyPunches(dto.getFancyPunches());
		entity.setFancyKicks(dto.getFancyKicks());
		entity.setFancySubmissions(dto.getFancySubmissions());
		entity.setTacticalStyle(dto.getTacticalStyle());
		entity.setDirtyFighting(dto.getDirtyFighting());
		entity.setFightingStyle(dto.getFightingStyle());

	}

}
