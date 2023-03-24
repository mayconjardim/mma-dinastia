package com.mmadinastia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);
	

}
