package com.mmadinastia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.Fight;

public interface FightRepository extends JpaRepository<Fight, Long> {
}
