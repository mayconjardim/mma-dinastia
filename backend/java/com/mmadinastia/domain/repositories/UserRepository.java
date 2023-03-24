package com.mmadinastia.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);
	
	Optional<User> findByResetToken(String resetToken);

}
