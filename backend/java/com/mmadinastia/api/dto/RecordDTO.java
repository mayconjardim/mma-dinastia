package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

}
