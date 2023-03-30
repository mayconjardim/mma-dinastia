package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mmadinastia.domain.entities.Event;
import com.mmadinastia.domain.entities.Fight;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String eventName;
	private String arena;
	private Integer attendance;
	private OffsetDateTime creationDate;
	private OffsetDateTime eventDate;

	private List<FightDTO> fights = new ArrayList<>();

	public EventDTO(Event entity) {
		this.id = entity.getId();
		this.eventName = entity.getEventName();
		this.arena = entity.getArena();
		this.attendance = entity.getAttendance();
		this.creationDate = entity.getCreationDate();
		this.eventDate = entity.getEventDate();
	}

	public EventDTO(Event entity, List<Fight> fights) {
		this(entity);
		fights.forEach(fight -> this.fights.add(new FightDTO(fight)));
	}

}
