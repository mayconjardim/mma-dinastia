package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.mmadinastia.domain.entities.Record;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RecordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String result;
	private String opponentName;
	private String eventName;
	private Long eventId;
	private LocalDateTime date;
	private String description;

	public RecordDTO(Record entity) {
		super();
		this.id = entity.getId();
		this.result = entity.getResult();
		this.opponentName = entity.getOpponentName();
		this.eventName = entity.getEventName();
		this.eventId = entity.getEventId();
		this.date = entity.getDate();
		this.description = entity.getDescription();
	}

}
