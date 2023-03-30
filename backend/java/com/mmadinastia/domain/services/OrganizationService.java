package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.OrganizationDtoAssembler;
import com.mmadinastia.api.assembler.OrganizationDtoDisassembler;
import com.mmadinastia.api.dto.OrganizationDTO;
import com.mmadinastia.domain.entities.Organization;
import com.mmadinastia.domain.repositories.OrganizationRepository;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private OrganizationDtoAssembler assembler;

	@Autowired
	private OrganizationDtoDisassembler disassembler;

	@Transactional(readOnly = true)
	public Page<OrganizationDTO> findAllPaged(Pageable pageable) {

		return assembler.toCollectionDTO(organizationRepository.findAll(pageable));
	}

	@Transactional(readOnly = true)
	public OrganizationDTO findById(Long id) {

		Organization entity = findOrFail(id);

		return assembler.toDTO(entity);
	}

	@Transactional
	public OrganizationDTO insert(OrganizationDTO dto) {

		Organization entity = new Organization();

		disassembler.copyToDomainObject(dto, entity);

		entity = organizationRepository.save(entity);

		return assembler.toDTO(entity);
	}

	public Organization findOrFail(Long id) {
		return organizationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Organização não encontrada: ", id)));
	}

}
