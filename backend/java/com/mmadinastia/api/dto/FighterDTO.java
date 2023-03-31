package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mmadinastia.domain.entities.Fighter;
import com.mmadinastia.domain.entities.User;
import com.mmadinastia.domain.enums.WeightClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FighterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String nickname;
	private Integer age;
	private Integer win;
	private Integer loss;
	private Integer draw;
	private WeightClass weightClass;

	private Double punching;
	private Double kicking;
	private Double clinchStriking;
	private Double clinchGrappling;
	private Double takedowns;

	private Double gnp;
	private Double submission;
	private Double groundGame;

	private Double dodging;
	private Double subDefense;
	private Double takedownsDef;

	private Double aggressiveness;
	private Double control;
	private Double motivation;

	private Double strength;
	private Double agility;
	private Double conditioning;
	private Double koResistance;
	private Double toughness;

	private Long userId;
	private String username;
	
	private List<RecordDTO> records = new ArrayList<>();

	public FighterDTO(Fighter entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.nickname = entity.getNickname();
		this.age = entity.getAge();
		this.win = entity.getWin();
		this.loss = entity.getLoss();
		this.draw = entity.getDraw();
		this.weightClass = entity.getWeightClass();
		this.punching = entity.getPunching();
		this.kicking = entity.getKicking();
		this.clinchStriking = entity.getClinchStriking();
		this.clinchGrappling = entity.getClinchGrappling();
		this.takedowns = entity.getTakedowns();
		this.gnp = entity.getGnp();
		this.submission = entity.getSubmission();
		this.groundGame = entity.getGroundGame();
		this.dodging = entity.getDodging();
		this.subDefense = entity.getSubDefense();
		this.takedownsDef = entity.getTakedownsDef();
		this.aggressiveness = entity.getAggressiveness();
		this.control = entity.getControl();
		this.motivation = entity.getMotivation();
		this.strength = entity.getStrength();
		this.agility = entity.getAgility();
		this.conditioning = entity.getConditioning();
		this.koResistance = entity.getKoResistance();
		this.toughness = entity.getToughness();
		this.userId = entity.getUser().getId();
		this.username = entity.getUser().getUsername();
	}

	public FighterDTO(Fighter entity, List<User> users, List<Record> records) {
		entity.getRecords().forEach(record -> this.records.add(new RecordDTO(record)));
	}

	public Double getOverall() {
		return punching + kicking + clinchStriking + clinchGrappling + takedowns +

				(gnp + submission + groundGame +

						dodging + subDefense + takedownsDef +

						aggressiveness + control + motivation +

						strength + agility + conditioning + koResistance + toughness) / 19;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

}
