package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.dto.EventDTO;
import com.mmadinastia.api.dto.FightDTO;
import com.mmadinastia.domain.entities.Event;
import com.mmadinastia.domain.entities.Fight;
import com.mmadinastia.domain.repositories.EventRepository;
import com.mmadinastia.domain.repositories.FightRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private FightRepository fightRepository;

	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable) {

		Page<Event> page = eventRepository.findAll(pageable);

		return page.map(e -> new EventDTO(e));
	}

	@Transactional(readOnly = true)
	public EventDTO findById(Long id) {

		Event event = findOrFail(id);

		return new EventDTO(event);
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {

		Event entity = new Event();
		copyDtoToEntity(dto, entity);

		entity = eventRepository.save(entity);
		
		return new EventDTO(entity);
	}

	@Transactional
	public EventDTO update(Long id, EventDTO dto) {

		Event entity = findOrFail(id);
		copyDtoToEntity(dto, entity);

		entity = eventRepository.save(entity);
		
		return new EventDTO(entity);
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

	private void copyDtoToEntity(EventDTO dto, Event entity) {

		entity.setEventName(dto.getEventName());
		entity.setArena(dto.getArena());
		entity.setAttendance(dto.getAttendance());
		entity.setCreationDate(dto.getCreationDate());
		entity.setEventDate(dto.getEventDate());

		entity.getFights().clear();
		for (FightDTO fightDto : dto.getFights()) {
			Fight fights = fightRepository.getReferenceById(fightDto.getId());
			entity.getFights().add(fights);
		}
	}

}
