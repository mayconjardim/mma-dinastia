package com.mmadinastia.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmadinastia.domain.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
