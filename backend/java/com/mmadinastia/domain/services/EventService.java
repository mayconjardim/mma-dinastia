package com.mmadinastia.domain.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.EventDtoAssembler;
import com.mmadinastia.api.assembler.EventDtoDisassembler;
import com.mmadinastia.api.dto.EventDTO;
import com.mmadinastia.domain.entities.Event;
import com.mmadinastia.domain.repositories.EventRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventDtoAssembler assembler;

	@Autowired
	private EventDtoDisassembler disassembler;

	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable) {

		return assembler.toCollectionDTO(eventRepository.findAll(pageable));
	}

	@Transactional(readOnly = true)
	public EventDTO findById(Long id) {

		Event entity = findOrFail(id);

		return assembler.toDTO(entity);
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {

		Event entity = new Event();
	
		
		disassembler.copyToDomainObject(dto, entity);

		entity = eventRepository.save(entity);

		return assembler.toDTO(entity);
	}
	
	@Transactional
	public EventDTO update(Long id, EventDTO dto) {
		try {
		
			Event entity = findOrFail(id);
			dto.setId(entity.getId());
			dto.setRegisterDate(entity.getRegisterDate());
			
			disassembler.copyToDomainObject(dto, entity);

			return assembler.toDTO(eventRepository.save(entity));
		}

		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}

	}

	public void delete(Long id) {
		try {
			eventRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade!");
		}
	}

	public Event findOrFail(Long id) {
		return eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Evento não encontrada: ", id)));
	}

}
