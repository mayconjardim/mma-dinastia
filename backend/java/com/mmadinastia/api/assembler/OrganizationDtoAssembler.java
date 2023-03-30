package com.mmadinastia.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.OrganizationDTO;
import com.mmadinastia.domain.entities.Organization;

@Component
public class OrganizationDtoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public OrganizationDTO toDTO(Organization organization) {
		return modelMapper.map(organization, OrganizationDTO.class);
	}

	public List<OrganizationDTO> toCollectionDTO(List<Organization> organizations) {
		return organizations.stream().map(organization -> toDTO(organization)).collect(Collectors.toList());

	}

	public Page<OrganizationDTO> toCollectionDTO(Page<Organization> organizations) {
		return organizations.map(organization -> toDTO(organization));

	}

}
