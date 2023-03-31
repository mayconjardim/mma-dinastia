package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mmadinastia.domain.entities.Event;
import com.mmadinastia.domain.entities.Organization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String initials;
	private OffsetDateTime registerDate;

	private List<EventDTO> events = new ArrayList<>();
	
	public OrganizationDTO(Organization entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.initials = entity.getInitials();
		this.registerDate = entity.getRegisterDate(); 
	}

	public OrganizationDTO(Organization entity, List<Event> events) {
		this(entity);
		events.forEach(event -> this.events.add(new EventDTO(event)));
	}
}
