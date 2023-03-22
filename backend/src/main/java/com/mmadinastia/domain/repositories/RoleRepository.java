package com.mmadinastia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
