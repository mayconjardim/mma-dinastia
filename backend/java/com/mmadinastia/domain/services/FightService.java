package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.dto.FightDTO;
import com.mmadinastia.domain.entities.Fight;
import com.mmadinastia.domain.entities.Fighter;
import com.mmadinastia.domain.repositories.FightRepository;
import com.mmadinastia.domain.repositories.FighterRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class FightService {

	@Autowired
	private FightRepository fightRepository;

	@Autowired
	private FighterRepository fighterRepository;

	@Transactional(readOnly = true)
	public Page<FightDTO> findAllPaged(Pageable pageable) {

		Page<Fight> page = fightRepository.findAll(pageable);

		return page.map(f -> new FightDTO(f));
	}

	@Transactional(readOnly = true)
	public FightDTO findById(Long id) {

		Fight fight = findOrFail(id);

		return new FightDTO(fight);
	}

	@Transactional
	public FightDTO insert(FightDTO dto) {

		Fight entity = new Fight();

		copyDtoToEntity(dto, entity);

		entity = fightRepository.save(entity);

		return new FightDTO(entity);
	}
	
	@Transactional
	public void simuleFight(Long id) {
		Fight fight = findOrFail(id);
		fight.simulate();

		if (fight.getGeneratePBP()) {
			simuleFight(fight);
		}

		resetFighterModifiers(fight.getFighter1());
		resetFighterModifiers(fight.getFighter2());
		fightRepository.save(fight);

	}

	public void delete(Long id) {
		try {
			fightRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade!");
		}
	}

	
	public Fight findOrFail(Long id) {
		return fightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Luta não encontrada: ", id)));
	}

	private void copyDtoToEntity(FightDTO dto, Fight entity) {

		Fighter fighter1 = fighterRepository.getReferenceById(dto.getFighter1().getId());
		Fighter fighter2 = fighterRepository.getReferenceById(dto.getFighter2().getId());

		entity.setEventName(dto.getEventName());
		entity.setWeightClass(dto.getWeightClass());
		entity.setNumberRounds(dto.getNumberRounds());
		entity.setTitleBout(dto.getTitleBout());
		entity.setGeneratePBP(dto.getGeneratePBP());
		entity.setHappened(dto.getHappened());
		entity.setFighter1(fighter1);
		entity.setFighter2(fighter2);
		
	}

	private void simuleFight(Fight obj) {
		obj.setGeneratePBP(false);
		obj.prepareFight();
		obj.fightController();
	}

	private void resetFighterModifiers(Fighter fighter) {
		fighter.setPunchingMod(0.0);
		fighter.setKickingMod(0.0);
		fighter.setClinchGrapplingMod(0.0);
		fighter.setClinchStrikingMod(0.0);
		fighter.setTakedownsMod(0.0);
		fighter.setGnpMod(0.0);
		fighter.setSubmissionMod(0.0);
		fighter.setGroundGameMod(0.0);
		fighter.setDodgingMod(0.0);
		fighter.setSubDefenseMod(0.0);
		fighter.setTakedownsDefMod(0.0);
		fighter.setAggressivenessMod(0.0);
		fighter.setControlMod(0.0);
		fighter.setMotivationMod(0.0);
		fighter.setStrengthMod(0.0);
		fighter.setAgilityMod(0.0);
		fighter.setConditioningMod(0.0);
		fighter.setKoResistanceMod(0.0);
		fighter.setToughnessMod(0.0);
	}

}
