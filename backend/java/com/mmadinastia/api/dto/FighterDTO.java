package com.mmadinastia.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mmadinastia.domain.enums.WeightClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

	private List<RecordDTO> records = new ArrayList<>();

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
