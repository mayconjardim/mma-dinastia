package com.mmadinastia.domain.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.assembler.OrganizationDtoAssembler;
import com.mmadinastia.api.assembler.OrganizationDtoDisassembler;
import com.mmadinastia.api.dto.OrganizationDTO;
import com.mmadinastia.domain.entities.Organization;
import com.mmadinastia.domain.repositories.OrganizationRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
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
	
	@Transactional
	public OrganizationDTO update(Long id, OrganizationDTO dto) {
		try {
		
			Organization entity = findOrFail(id);
			dto.setId(entity.getId());
			dto.setRegisterDate(entity.getRegisterDate());
			
			disassembler.copyToDomainObject(dto, entity);

			return assembler.toDTO(organizationRepository.save(entity));
		}

		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}

	}

	public void delete(Long id) {
		try {
			organizationRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade!");
		}
	}

	public Organization findOrFail(Long id) {
		return organizationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Organização não encontrada: ", id)));
	}

}
