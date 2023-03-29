package com.mmadinastia.api.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
public class FighterStratsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	// Geral
	private Integer stratPunching;
	private Integer stratKicking;
	private Integer stratClinching;
	private Integer stratTakedowns;

	// Clinch
	private Integer stratDirtyBoxing;
	private Integer stratThaiClinch;
	private Integer stratClinchTakedowns;
	private Integer stratAvoidClinch;

	// Chão
	private Integer stratGNP;
	private Integer stratSub;
	private Integer stratPositioning;
	private Integer stratLNP;
	private Integer stratStandUp;

	// Estilos
	private Integer fancyPunches;
	private Integer fightingStyle;
	private Integer tacticalStyle;
	private Integer fancyKicks;
	private Integer fancySubmissions;
	private Integer dirtyFighting;

}
