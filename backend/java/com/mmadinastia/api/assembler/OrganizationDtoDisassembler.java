package com.mmadinastia.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.OrganizationDTO;
import com.mmadinastia.domain.entities.Organization;

@Component
public class OrganizationDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Organization toDomainObject(OrganizationDTO organizationDto) {
		return modelMapper.map(organizationDto, Organization.class);
	}

	public void copyToDomainObject(OrganizationDTO organizationDto, Organization organization) {
		modelMapper.map(organizationDto, organization);
	}

}
