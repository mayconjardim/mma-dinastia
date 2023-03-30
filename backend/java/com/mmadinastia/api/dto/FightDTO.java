package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mmadinastia.domain.entities.Fight;
import com.mmadinastia.domain.enums.WeightClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FightDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String eventName;
	private WeightClass weightClass;
	private Integer numberRounds;
	private Boolean titleBout;
	private Boolean generatePBP;
	private Boolean happened;
	private FighterDTO fighter1;
	private FighterDTO fighter2;

	// Comments
	private String finishedType;
	private String finishedDescription;
	private Integer fighterWinner;
	private String side;
	private String location;
	private String injuryComment;

	private EventDTO event;

	private List<String> pbp = new ArrayList<>();

	public FightDTO(Fight entity) {
		id = entity.getId();
		eventName = entity.getEventName();
		weightClass = entity.getWeightClass();
		numberRounds = entity.getNumberRounds();
		titleBout = entity.getTitleBout();
		generatePBP = entity.getGeneratePBP();
		happened = entity.getHappened();
		fighter1 = new FighterDTO(entity.getFighter1());
		fighter2 = new FighterDTO(entity.getFighter2());

		entity.getPbp().forEach(pbp -> this.pbp.add(pbp));

		// Commnets
		finishedType = entity.getFinishedType();
		finishedDescription = entity.getFinishedDescription();
		fighterWinner = entity.getFighterWinner();
		side = entity.getSide();
		location = entity.getLocation();
		injuryComment = entity.getInjuryComment();
	}
}
