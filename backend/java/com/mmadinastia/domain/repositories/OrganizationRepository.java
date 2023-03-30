package com.mmadinastia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
