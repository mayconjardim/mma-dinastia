package com.mmadinastia.domain.services;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.api.dto.OrganizationDTO;
import com.mmadinastia.domain.entities.Organization;
import com.mmadinastia.domain.repositories.OrganizationRepository;
import com.mmadinastia.domain.services.exceptions.DatabaseException;
import com.mmadinastia.domain.services.exceptions.ResourceNotFoundException;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Transactional(readOnly = true)
	public Page<OrganizationDTO> findAllPaged(Pageable pageable) {

		Page<Organization> page = organizationRepository.findAll(pageable);

		return page.map(o -> new OrganizationDTO(o));
	}

	@Transactional(readOnly = true)
	public OrganizationDTO findById(Long id) {

		Organization org = findOrFail(id);

		return new OrganizationDTO(org);
	}

	@Transactional
	public OrganizationDTO insert(OrganizationDTO dto) {

		Organization entity = new Organization();

		copyDtoToEntity(dto, entity);

		entity = organizationRepository.save(entity);

		return new OrganizationDTO(entity);
	}

	@Transactional
	public OrganizationDTO update(Long id, OrganizationDTO dto) {
	
		Organization entity = findOrFail(id);
		copyDtoToEntity(dto, entity);

		entity = organizationRepository.save(entity);
		
		return new OrganizationDTO(entity);
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

	private void copyDtoToEntity(OrganizationDTO dto, Organization entity) {

		entity.setInitials(dto.getInitials());
		entity.setName(dto.getName());
		OffsetDateTime currentRegisterDate = entity.getRegisterDate();
		entity.setRegisterDate(currentRegisterDate);
	}

}
