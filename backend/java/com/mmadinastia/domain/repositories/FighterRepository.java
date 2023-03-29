package com.mmadinastia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
