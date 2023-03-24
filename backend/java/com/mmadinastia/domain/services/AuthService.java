package com.mmadinastia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.repositories.UserRepository;
import com.mmadinastia.domain.services.exceptions.ForbiddenException;
import com.mmadinastia.domain.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User authenticated() {
		
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByUsername(username);

		} catch (Exception e) {
			throw new UnauthorizedException("Usuário Inválido");
		}
	}

	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if (user.getId() != userId && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Acesso negado!");
		}
	}

}
