package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String eventName;
	private String arena;
	private Integer attendance;

	private List<FightDTO> fights = new ArrayList<>();

}
