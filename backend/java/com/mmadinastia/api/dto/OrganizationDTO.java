package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

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

	public OrganizationDTO(Organization entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.initials = entity.getInitials();
		this.registerDate = entity.getRegisterDate();
	}

}
