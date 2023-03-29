package com.mmadinastia.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mmadinastia.domain.enums.WeightClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Fighter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String firstName;
	private String lastName;
	private String nickname;
	private Integer age;
	private Integer win;
	private Integer loss;
	private Integer draw;
	private WeightClass weightClass;

	// Habilidaddes
	// Luta em pé
	private Double punching;
	private Double kicking;
	private Double clinchStriking;
	private Double clinchGrappling;
	private Double takedowns;

	// Luta no Chão
	private Double gnp;
	private Double submission;
	private Double groundGame;

	// Defesa
	private Double dodging;
	private Double subDefense;
	private Double takedownsDef;

	// Mental
	private Double aggressiveness;
	private Double control;
	private Double motivation;

	// Fisicas
	private Double strength;
	private Double agility;
	private Double conditioning;
	private Double koResistance;
	private Double toughness;

	// Record

	@OneToMany(cascade = CascadeType.ALL)
	private List<Record> records = new ArrayList<>();

	// Strategia

	// General
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
	private Integer stalling = 0;

	private boolean easySubs = true;
	private boolean techSubs = false;
	private boolean useKneesGround = false;
	private boolean useStomps = false;
	private boolean useSoccerKicks = false;
	private boolean pullsGuard = false;
	private Integer clinchType = 1;

	// Criacao
	private boolean dirtyBoxing = true;
	private boolean thaiClinch = false;
	private boolean judoTD = false;
	private boolean wrestlingTD = true;

	// Atributos do lutadores na luta
	private Double strengthMod = 0.0;
	private Double agilityMod = 0.0;
	private Double conditioningMod = 0.0;
	private Double koResistanceMod = 0.0;
	private Double toughnessMod = 0.0;
	private Double punchingMod = 0.0;
	private Double kickingMod = 0.0;
	private Double clinchStrikingMod = 0.0;
	private Double clinchGrapplingMod = 0.0;
	private Double takedownsMod = 0.0;
	private Double gnpMod = 0.0;
	private Double submissionMod = 0.0;
	private Double groundGameMod = 0.0;
	private Double aggressivenessMod = 0.0;
	private Double controlMod = 0.0;
	private Double motivationMod = 0.0;
	private Double dodgingMod = 0.0;
	private Double subDefenseMod = 0.0;
	private Double takedownsDefMod = 0.0;
	private Double damageMod = 0.0;
	private Double initMod = 0.0;

	private Integer painAndTiredness = 0;
	private Integer fearManagement = 0;
	private Integer fightSpirit = 0;
	private Integer fightPerformance = 0;
	private Integer latestResults = 0;

	private Double faceInjury = 0.0;
	private Double leftArmInjury = 0.0;
	private Double rightArmInjury = 0.0;
	private Double backInjury = 0.0;
	private Double rightLegInjury = 0.0;
	private Double leftLegInjury = 0.0;
	private Double torsoInjury = 0.0;

	private Double aggPower = 0.0;
	private Double defense = 0.0;
	private Integer careerStatus = 2;
	private Double currentHP = 0.0;
	private Double currentStamina = 0.0;
	private Double staminaLoss = 0.0;
	private Double accuracy = 0.0;
	private boolean onTheGround = false;
	private boolean dazed = false;
	private boolean useElbows = false;
	private Long dirtyMoveMalus = 0L;
	private Integer rush = 0;
	private Integer actionsInGround = 0;
	private Integer actionsInClinch = 0;
	private Integer actionsInStandUp = 0;
	private Double tempDamageGround = 0.0;
	private Double tempDamageClinch = 0.0;
	private Integer roundsInTheGround = 0;
	private Double trainingStatus = 0.0;
	private Integer injuryResistance = 0;
	private Integer cutResistance = 0;
	private Integer cuts = 0;
	private Double moral = 0.0;

	// Pontuacao
	private int[] roundStandUpPoints = new int[10];
	private int[] roundGroundPoints = new int[10];
	private int[] roundAggPoints = new int[10];
	private int[] roundTechPoints = new int[10];
	private int[] pointsPenalization = new int[10];

	public Fighter(Long id, String firstName, String lastName, String nickname, Integer age, WeightClass weightClass,
			Double punching, Double kicking, Double clinchStriking, Double clinchGrappling, Double takedowns,
			Double gnp, Double submission, Double groundGame, Double dodging, Double subDefense, Double takedownsDef,
			Double aggressiveness, Double control, Double motivation, Double strength, Double agility,
			Double conditioning, Double koResistance, Double toughness) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.age = age;
		this.weightClass = weightClass;
		this.punching = punching;
		this.kicking = kicking;
		this.clinchStriking = clinchStriking;
		this.clinchGrappling = clinchGrappling;
		this.takedowns = takedowns;
		this.gnp = gnp;
		this.submission = submission;
		this.groundGame = groundGame;
		this.dodging = dodging;
		this.subDefense = subDefense;
		this.takedownsDef = takedownsDef;
		this.aggressiveness = aggressiveness;
		this.control = control;
		this.motivation = motivation;
		this.strength = strength;
		this.agility = agility;
		this.conditioning = conditioning;
		this.koResistance = koResistance;
		this.toughness = toughness;
		// Strats Geral
		stratPunching = 50;
		stratKicking = 30;
		stratClinching = 20;
		stratTakedowns = 0;
		// Strats Clinch
		stratDirtyBoxing = 25;
		stratThaiClinch = 25;
		stratClinchTakedowns = 25;
		stratAvoidClinch = 25;
		// Strats Chão
		stratGNP = 20;
		stratSub = 20;
		stratPositioning = 20;
		stratLNP = 20;
		stratStandUp = 20;
		// Estilos
		fancyPunches = 0;
		fightingStyle = 2;
		tacticalStyle = 2;
		fancyKicks = 0;
		fancySubmissions = 0;
		dirtyFighting = 0;
	}

	// Metodos de luta

	public String getName() {
		return firstName + " " + lastName;
	}

	public void maxHPandStamina() {
		this.setCurrentHP((toughness * 5 * 100) / 100);
		this.setCurrentStamina((conditioning * 5 * 100) / 100);
	}

	public void recoverHP(double HPRecovered) {
		currentHP += HPRecovered;
		if (currentHP > toughness * 5) {
			currentHP = toughness * 5;
		}
	}

	public double getKORes() {
		return koResistance + koResistanceMod;
	}

	public double getRanking() {
		double statsRanking = punching + kicking + clinchStriking + takedowns + clinchGrappling + aggressiveness
				+ control + motivation + dodging + takedownsDef + subDefense + strength + toughness + agility
				+ koResistance + conditioning + groundGame + submission + gnp;
		return statsRanking;
	}

	public boolean checkDirtyMove() {
		final int MAX_RANDOM = 120;
		int modifiers = 0;

		if (getCurrentHP() < 50) {
			modifiers += 1;
		} else if (getCurrentHP() < 20) {
			modifiers += 2;
		}

		if (getCurrentStamina() < 50) {
			modifiers += 1;
		} else if (getCurrentStamina() < 20) {
			modifiers += 2;
		}

		modifiers += Math.round(getAggressiveness() / 7);

		modifiers *= getDirtyFighting();

		return (Math.random() * MAX_RANDOM <= modifiers);
	}

	public double getAttackBonus() {
		double bonus = accuracy + (agility / 4) + (aggressiveness / 5) - dirtyMoveMalus;
		bonus *= getTrainingStatus() / 100.0;
		return bonus;
	}

	public double getDefenseBonus() {
		final double DAZED_MALUS = 7;
		double bonus = defense + (getAgility() / 4) + (getControl() / 5) - (getAggressiveness() / 6) - dirtyMoveMalus;
		bonus *= getTrainingStatus() / 100.0;
		if (dazed) {
			bonus -= DAZED_MALUS;
		}
		return bonus;
	}

	private void calculateTrainingStatus() {
		int minTraining = 0;
		int increment = 0;
		switch (careerStatus) {
		case 0: // Rookie
			minTraining = 50;
			increment = 5;
			break;
		case 1: // Prospect
			minTraining = 60;
			increment = 5;
			break;
		case 2: // Prime
			minTraining = 65;
			increment = 5;
			break;
		case 3: // Aging
			minTraining = 60;
			increment = 5;
			break;
		case 4: // Washed
			minTraining = 50;
			increment = 5;
			break;
		}
		double result = minTraining;
		for (int i = 0; i <= Math.round(motivation + control / 2); i++) {
			result += Math.random() * increment;
		}
		if (result > 100) {
			result = 100;
		}
		trainingStatus = result;
	}

	public double getTrainingStatus() {
		if (trainingStatus == 0) {
			calculateTrainingStatus();
		}
		return trainingStatus;
	}

	public double getDamageBonus() {
		double result = (getStrength() / 2) + getDamageMod() + Math.round(getAggressiveness() / 8) - getDirtyMoveMalus()
				+ getAggPower();
		result *= getTrainingStatus() / 100;

		if (result < 1) {
			result = 1;
		} else if (result > 100) {
			result = 100;
		}

		return result;
	}

	public double getInitiativeBonus() {
		double result = (getAgility() / 4) + (getAggressiveness() / 6) + getRush();
		result = result * 100 / 100;
		return result;
	}

	public double getMean() {
		double result = (getDefenseMean() + getFitnessMean() + getGroundMean() + getMentalMean() + getStrikingMean())
				/ 5;
		return result;
	}

	public double getClinchMean() {
		return (getClinchStriking() + getClinchGrappling()) / 2;
	}

	public double getGroundMean() {
		double result = (getGroundGame() + getSubmission() + getGnp()) * 100 / 60;
		return result;
	}

	public double getMentalMean() {
		double result = (getAggressiveness() + getControl() + getMotivation()) * 100 / 60;
		return result;
	}

	public double getStrikingMean() {
		double result = (getPunching() + getKicking() + getClinchStriking() + getClinchGrappling() + getTakedowns())
				* 100 / 100;
		return result;
	}

	public double getFitnessMean() {
		double result = getStrength() + getToughness() + getAgility() + getKoResistance() + getConditioning();
		return result;
	}

	public double getDefenseMean() {
		double result = (getDodging() + getTakedownsDef() + getSubDefense()) * 100 / 60;
		return result;
	}

	public void recoverStamina(double staminaRecovered) {

		currentStamina += staminaRecovered;
	}

	public int getRoundPoints(int nRound) {
		int result = 0;
		if (nRound > 0 && nRound <= 10) {
			result += roundAggPoints[nRound - 1];
			result += roundTechPoints[nRound - 1];
			result += roundStandUpPoints[nRound - 1];
			result += roundGroundPoints[nRound - 1];
		}
		return result;
	}

	public int increasePoints(int NRound, int Points, boolean standing) {
		int result = 0;
		if (NRound <= 10) {
			if (standing) {
				roundStandUpPoints[NRound - 1] += Points;
				result = roundStandUpPoints[NRound - 1];
			} else {
				roundGroundPoints[NRound - 1] += Points;
				result = roundGroundPoints[NRound - 1];
			}
		}
		return result;
	}

	public int increasePoints2(int NRound, double Points, boolean standing) {
		int result = 0;
		if (NRound <= 10) {
			if (standing) {
				roundStandUpPoints[NRound - 1] += Math.round(Points);
				result = roundStandUpPoints[NRound - 1];
			} else {
				roundGroundPoints[NRound - 1] += Math.round(Points);
				result = roundGroundPoints[NRound - 1];
			}
		}
		return result;
	}

	public int getTotalAggPoints() {
		int result = 0;
		for (int index = 0; index < 10; index++) {
			result += roundAggPoints[index];
		}
		return result;
	}

	public int getTotalGroundPoints() {
		int result = 0;
		for (int index = 0; index < 10; index++) {
			result += roundGroundPoints[index];
		}
		return result;
	}

	public int getTotalPoints() {
		int result = 0;
		for (int index = 0; index < 10; index++) {
			result += roundAggPoints[index];
			result += roundTechPoints[index];
			result += roundGroundPoints[index];
			result += roundStandUpPoints[index];
		}
		// result += statistics.getPerfomanceBonus();
		return result;
	}

	public int getTotalStandUpPoints() {
		int result = 0;
		for (int index = 0; index < 10; index++) {
			result += roundStandUpPoints[index];
		}
		return result;
	}

	public int getTotalTechPoints() {
		int result = 0;
		for (int index = 0; index < 10; index++) {
			result += roundTechPoints[index];
		}
		return result;
	}

	public int increaseAggPoints(int NRound, int Points) {
		int result = 0;
		if (NRound <= 10) {
			roundAggPoints[NRound - 1] += Points;
			result = roundAggPoints[NRound - 1];
		}
		return result;
	}

	public int increaseTechPoints(int NRound, int Points) {
		int result = 0;
		if (NRound <= 10) {
			roundTechPoints[NRound - 1] += Points;
			result = roundTechPoints[NRound - 1];
		}
		return result;
	}

	public void clearAllRoundPoints() {
		for (int i = 1; i <= 5; i++) {
			clearRoundPoints(i);
		}
	}

	public void clearRoundPoints(int nRound) {
		roundStandUpPoints[nRound] = 0;
		roundGroundPoints[nRound] = 0;
		roundAggPoints[nRound] = 0;
		roundTechPoints[nRound] = 0;
	}

	public Double getOverall() {
		return punching + kicking + clinchStriking + clinchGrappling + takedowns +

				(gnp + submission + groundGame +

						dodging + subDefense + takedownsDef +

						aggressiveness + control + motivation +

						strength + agility + conditioning + koResistance + toughness) / 19;
	}

	public void resetFighter() {
		conditioningMod = 0.0;
		koResistanceMod = 0.0;
		toughnessMod = 0.0;
		punchingMod = 0.0;
		kickingMod = 0.0;
		clinchStrikingMod = 0.0;
		clinchGrapplingMod = 0.0;
		takedownsMod = 0.0;
		gnpMod = 0.0;
		submissionMod = 0.0;
		groundGameMod = 0.0;
		aggressivenessMod = 0.0;
		controlMod = 0.0;
		motivationMod = 0.0;
		dodgingMod = 0.0;
		subDefenseMod = 0.0;
		takedownsDefMod = 0.0;
		damageMod = 0.0;
		initMod = 0.0;

		painAndTiredness = 0;
		fearManagement = 0;
		fightSpirit = 0;
		fightPerformance = 0;
		latestResults = 0;

		faceInjury = 0.0;
		leftArmInjury = 0.0;
		rightArmInjury = 0.0;
		backInjury = 0.0;
		rightLegInjury = 0.0;
		leftLegInjury = 0.0;
		torsoInjury = 0.0;

		aggPower = 0.0;
		defense = 0.0;
		careerStatus = 2;
		currentHP = 0.0;
		currentStamina = 0.0;
		staminaLoss = 0.0;
		accuracy = 0.0;
		onTheGround = false;
		dazed = false;
		useElbows = false;
		dirtyMoveMalus = 0L;
		rush = 0;
		actionsInGround = 0;
		actionsInClinch = 0;
		actionsInStandUp = 0;
		tempDamageGround = 0.0;
		tempDamageClinch = 0.0;
		roundsInTheGround = 0;
		trainingStatus = 0.0;
		injuryResistance = 0;
		cutResistance = 0;
		cuts = 0;
		moral = 0.0;
	}

	public Double getPunching() {
		return punching + punchingMod;
	}

	public Double getKicking() {
		return kicking + kickingMod;
	}

	public Double getClinchStriking() {
		return clinchStriking + clinchStrikingMod;
	}

	public Double getClinchGrappling() {
		return clinchGrappling + clinchGrapplingMod;
	}

	public Double getTakedowns() {
		return takedowns + takedownsMod;
	}

	public Double getGnp() {
		return gnp + gnpMod;
	}

	public Double getSubmission() {
		return submission + submissionMod;
	}

	public Double getGroundGame() {
		return groundGame + groundGameMod;
	}

	public Double getDodging() {
		return dodging + dodgingMod;
	}

	public Double getSubDefense() {
		return subDefense + subDefenseMod;
	}

	public Double getTakedownsDef() {
		return takedownsDef + takedownsDefMod;
	}

	public Double getControl() {
		return control + controlMod;
	}

	public Double getStrength() {
		return strength + strengthMod;
	}

	public Double getAgility() {
		return agility + agilityMod;
	}

	public Double getConditioning() {
		return conditioning + conditioningMod;
	}

	public Double getKoResistance() {
		return koResistance + koResistanceMod;
	}

	public Double getToughness() {
		return toughness + toughnessMod;
	}

	public Double getAggressiveness() {
		return aggressiveness + aggressivenessMod;
	}

	public Double getMotivation() {
		return motivation + motivationMod;

	}

}
