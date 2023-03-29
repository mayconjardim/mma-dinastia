package com.mmadinastia.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String result;
	private String opponentName;
	private String eventName;
	private Long eventId;
	private LocalDateTime date;
	private String description;
	
	public Record(String result, String opponentName, String eventName, Long eventId, LocalDateTime date,
			String description) {
		super();
		this.result = result;
		this.opponentName = opponentName;
		this.eventName = eventName;
		this.eventId = eventId;
		this.date = date;
		this.description = description;
	}

	
}
