package com.mmadinastia.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mmadinastia.domain.enums.WeightClass;
import com.mmadinastia.domain.utils.JudgePerRound;
import com.mmadinastia.domain.utils.Moves;
import com.mmadinastia.domain.utils.PtComments;
import com.mmadinastia.domain.utils.Sim;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_fight")
public class Fight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String eventName;
	private WeightClass weightClass;
	private Integer numberRounds;
	private Boolean titleBout;
	private Boolean generatePBP;
	private Boolean happened;

	@ManyToOne
	@JoinColumn(name = "fighter1_id")
	private Fighter fighter1;

	@ManyToOne
	@JoinColumn(name = "fighter2_id")
	private Fighter fighter2;

	@ElementCollection
	@CollectionTable(name = "fight_pbp", joinColumns = @JoinColumn(name = "fight_id"))
	@Lob
	@Fetch(FetchMode.JOIN) 
	private List<String> pbp = new ArrayList<>();

	/// Atributos de luta
	private boolean boutFinished = false;
	private boolean inTheClinch = false;
	private Integer timeCurrent = 0;
	private Integer guardType = 0;
	private Integer fighterOnTop = 0;
	private Integer counterProb = 0;
	private Integer injuryProb = 0;
	private Integer kOSubProb = 0;
	private Integer cutProb = 0;
	private Integer randomnes = 1;
	private Integer kOFreq = 0;
	private Integer finishMode = 0;
	private boolean elbows = false;
	private boolean stomps = false;
	private boolean soccerKicks = false;
	private boolean isCounter = false;
	private Integer hitLocation = 0;
	private String finishedType = "";
	private String finishedDescription = "";
	private Integer fighterWinner;
	private String moveName = "";

	@Column(length = 2048)
	private String fullComment = "";
	private String side = "";
	private String location = "";
	private String injuryComment = "";
	private Integer subLocation;
	private Integer injuryFreq = 10;
	private Integer numHooks = 0;
	private Integer subFreq = 0;
	private boolean isLockingASub = false;

	// Clinch
	private Integer CLINCH_DIRTY_BOXING = 0;
	private Integer THAI_CLINCH = 1;
	private Integer SIMPLE_GRAPPLING = 2;
	// Clinch Attack
	private Integer THAI_ATTACK = 1;
	private Integer DIRTY_BOXING = 2;
	private Integer GRAPPLING_ATTACK = 3;

	// Fight Tempo e Rounds
	private boolean noTimeLimits = false;
	private Integer minsForRound = 5;
	private boolean catchweight = false;
	private Integer currentRound = 1;
	private boolean roundFinished = false;
	private boolean isTournament = false;
	private boolean colorComments = true;
	private boolean crowdBoo = true;
	private Integer fightSeconds = 0;

	
	public Fight(Long id, String eventName, WeightClass WeightClass, Integer numberRounds, Boolean titleBout,
			Fighter fighter1, Fighter fighter2, Boolean generatePBP, Boolean happened) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.weightClass = WeightClass;
		this.titleBout = titleBout;
		this.numberRounds = numberRounds;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.generatePBP = generatePBP;
		this.happened = happened;
	}

	public void setPbp(String pbp) {
		if (this.pbp == null) {
			this.pbp = new ArrayList<String>();
		}
		this.pbp.add(pbp);
	}

	public void simulate() {
		setGeneratePBP(true);
		setHappened(true);
	}

	public void fightApresentation() {

		int fightType = getTitleBout() ? 1 : 0;

		String presentation = String.format(PtComments.apresentation.get(fightType), numberRounds,
				getWeightClass().getName(), fighter1.getWin(), fighter1.getLoss(), fighter1.getDraw(),
				fighter1.getFirstName(), fighter2.getWin(), fighter2.getLoss(), fighter2.getDraw(),
				fighter2.getFirstName());

		setPbp(presentation);
	}

	public void prepareFight() {
		this.fighter1.setOnTheGround(false);
		this.fighter2.setOnTheGround(false);
		this.fighter1.setRush(0);
		this.fighter2.setRush(0);
		this.fighter1.clearRoundPoints(getMaxRounds());
		this.fighter2.clearRoundPoints(getMaxRounds());
		updateFighterStyle(fighter1);
		updateFighterStyle(fighter2);
		checkWeightDifference(fighter1, fighter2);
		checkWeightDifference(fighter2, fighter1);
		this.fighter1.maxHPandStamina();
		this.fighter2.maxHPandStamina();
		setInTheClinch(false);
		makeOddsComment(fighter1, fighter2);

	}

	public void fightController() {
		for (currentRound = 1; currentRound <= numberRounds && !boutFinished; currentRound++) {

			//statistics[0] = new Statistics();
			//statistics[1] = new Statistics();

			fighter1.setOnTheGround(false);
			fighter2.setOnTheGround(false);
			setPbp("===========================Round " + currentRound + "===========================");

			for (fightSeconds = 0; fightSeconds <= 300; fightSeconds += 10) {

				if (currentRound == 1 && fightSeconds == 0) {
					generateComment(PtComments.firstRound);
					doComment(fighter1, fighter2, extractInitComment(fullComment));
				} else if (currentRound > 1 && fightSeconds == 0) {

				}

				control();

				if (boutFinished) {
					fightSeconds += new Random().nextInt(5) + 1;
					break;
				}

			}

			if (fightSeconds >= 300) {
				fightSeconds -= 10;
				finishRound();
			}

			if (currentRound >= numberRounds) {
				boutFinished = true;
			}
		}

		if (fighterWinner != null) {
			finishFight(fighterWinner);

		} else {
			judgeFightRound(3);
			finishFight(fighterWinner);
		}
	}

	public void control() {
		int fighterActive, fighterPasive;
		int fighterAction1, fighterAction2, fighterAction;

		boolean tempInTheClinch;
		boolean fighter1OnTheGround, fighter2OnTheGround;
		boolean f1Ground, f2Ground;

		// timeInc = deltaTime();
		// timeCurrent += timeInc;

		/*
		 * if (!getNoTimeLimits() && getTimeCurrent() >=
		 * minutesByRound(getCurrentRound()) * 60 && !boutFinished) { roundFinished =
		 * true; if (getCurrentRound() >= getMaxRounds()) { boutFinished = true;
		 * finishedType = PtComments.misc.get(Sim.TIMEOUT); finishMode =
		 * Sim.RES_TIMEOUT; finishedDescription = PtComments.misc.get(Sim.TIMEOUT);
		 * finishRound(); // JudgeFightRound(3); // If it's tournament and the fight
		 * ends in draw then a new round will be fought
		 * 
		 * if (fighterWinner == -1 && isTournament()) { // tournamentTieExtraRound(); }
		 * else { // finishFight(fighterWinner); } return; } else { finishRound();
		 * return; } }
		 */

		/*
		 * tempInTheClinch = inTheClinch;
		 * 
		 * if (fightSeconds % 5 == 0 && fightSeconds > 0 && fightSeconds < 300) {
		 * doComment(fighter1, fighter2, "The clock says " + roundTime(fightSeconds) +
		 * " in the " + Integer.toString(currentRound) + " round"); }
		 * 
		 */

		fighterAction1 = fightAction(fighter1, fighter2);
		fighterAction2 = fightAction(fighter2, fighter1);

		if (fighter1.isDazed() == fighter2.isDazed()) {
			if ((!fighter1.isOnTheGround()) && (!fighter2.isOnTheGround())) {
				fighterActive = standUpInitiative(fighter1, fighter2, actionBonus(fighterAction1),
						actionBonus(fighterAction2));
			} else {
				fighterActive = groundInitiative(fighter1, fighter2, actionBonus(fighterAction1),
						actionBonus(fighterAction2));
			}
		} else {
			fighterActive = fighter1.isDazed() ? 1 : 0;
		}

		if (fighterActive == 1) {
			fighterPasive = 0;
			fighterAction = fighterAction2;
		} else {
			fighterPasive = 1;
			fighterAction = fighterAction1;
		}

		writeGuard(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
		// makeColorComments(fighterActiveOrPassive(fighterActive),
		// fighterActiveOrPassive(fighterPasive));

		if (checkPunchesExchange(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive))) {
			fighterAction = Moves.ACT_PUNCHEXCHANGE;
		}

		fighter1OnTheGround = fighter1.isOnTheGround();
		fighter2OnTheGround = fighter2.isOnTheGround();

		f1Ground = fighterActiveOrPassive(fighterActive).isOnTheGround();
		f2Ground = fighterActiveOrPassive(fighterPasive).isOnTheGround();

		switch (fightAction(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive))) {
		case Moves.ACT_PUNCHES:
			actPunch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_KICKS:
			actKick(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_CLINCH:
			actClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_TAKEDOWNS:
			actTakedown(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_DIRTYBOXING:
			actPunchClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive), DIRTY_BOXING);
			break;
		case Moves.ACT_TAKEDOWNCLINCH:
			actClinchTakedown(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_BREAKCLINCH:
			actBreakClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_GNP:
			actGnP(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_POSITIONING:
			actPositioning(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_SUBMISSION:
			actSubmission(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_STANDUP:
			actStandUp(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_LNP:
			actLnP(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_FANCYPUNCH:
			actFancyPunch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_FANCYKICK:
			actFancyKick(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_HEADBUTT:
			actHeadButt(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_POKE:
			actPoke(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_REST:
			actRest(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_GROINKICK:
			actGroinKick(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_SLAM:
			actSlam(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_SUPPLEX:
			actSupplex(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_SOCCERKICKS:
			actSoccerKicks(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_STOMPS:
			actStomps(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_STANDKICK:
			actStandKickToGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_MOVETOGROUND:
			actMoveToGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_STRIKESFROMGUARD:
			actStrikesFromGuard(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_GROUNDKICK:
			actGroundKicksToStand(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_RESTCLINCH:
			actRestInClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_NOACTION:
			actNoAction(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_ALLOWSTAND:
			actAllowToStand(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_PUNCHEXCHANGE:
			actPunchesExchange(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_PULLGUARD:
			actPullGuard(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_GNPELBOWS:
			actGnPElbows(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_CAPITALIZESTAND:
			actCapitalizeStanding(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_CAPITALIZEGROUND:
			actCapitalizeGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_KNEESONGROUND:
			actKneesOnGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_FANCYSUB:
			actFancySubmission(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			break;
		case Moves.ACT_THAICLINCH_PUNCHES:
			actPunchClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive), THAI_ATTACK);
			break;
		case Moves.ACT_THAICLINCH_KNEES:
			actKickClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive), THAI_ATTACK);
			break;
		case Moves.ACT_GRAPPLING_PUNCH:
			actPunchClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
					GRAPPLING_ATTACK);
			break;
		case Moves.ACT_GRAPPLING_KNEE:
			actKickClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
					GRAPPLING_ATTACK);
			break;
		}

		if (!boutFinished) {
			refStandFighters(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			actKeepClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			makeStaggeredComment(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
			makeStandUpComment(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive), !f1Ground,
					!f2Ground);
		}

		processStaminaLoss(fighterActiveOrPassive(fighterActive), true);
		processStaminaLoss(fighterActiveOrPassive(fighterPasive), false);

		// Recover for dazed status
		recoverForDazed(fighterActiveOrPassive(fighterActive));
		recoverForDazed(fighterActiveOrPassive(fighterPasive));

		if (!fighterActiveOrPassive(fighterActive).isOnTheGround()) {
			fighterActiveOrPassive(fighterActive).setStalling(0);
			fighterActiveOrPassive(fighterActive).setRoundsInTheGround(0);
		} else {
			fighterActiveOrPassive(fighterActive)
					.setRoundsInTheGround(fighterActiveOrPassive(fighterActive).getRoundsInTheGround() + 1);
		}

		if (!fighterActiveOrPassive(fighterPasive).isOnTheGround()) {
			fighterActiveOrPassive(fighterPasive).setStalling(0);
			fighterActiveOrPassive(fighterPasive).setRoundsInTheGround(0);
		} else {
			fighterActiveOrPassive(fighterPasive)
					.setRoundsInTheGround(fighterActiveOrPassive(fighterActive).getRoundsInTheGround() + 1);
		}

		checkFightPerformance(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
		checkFightPerformance(fighterActiveOrPassive(fighterPasive), fighterActiveOrPassive(fighterActive));
		checkPainAndTiredness(fighterActiveOrPassive(fighterActive));
		checkPainAndTiredness(fighterActiveOrPassive(fighterPasive));
		checkMoral(fighterActiveOrPassive(fighterActive));
		checkMoral(fighterActiveOrPassive(fighterPasive));

		if (!boutFinished) {
			processTowelThrow(fighterActiveOrPassive(fighterPasive), fighterActiveOrPassive(fighterActive));
			refRestartCentreRing(fighterActiveOrPassive(fighterPasive), fighterActiveOrPassive(fighterActive));
		}

		setPbp("\0");
	}

	public int fightAction(Fighter act, Fighter pas) {

		Random random = new Random();
		int randomNumber = random.nextInt(19);
		int result = 0;

		if ((randomNumber < act.getAggressiveness() + act.getRush()) || act.isOnTheGround() || pas.isOnTheGround()
				|| isInTheClinch()) {
			if (act.isOnTheGround() && pas.isOnTheGround()) {

				/* GroundAction */

				int prob, gnPProb, subProb, posProb, lnPProb, standProb;

				prob = (int) (Math.random() * 100) + 1;

				gnPProb = act.getStratGNP();

				if (isSubmissionAvailable(act)) {
					subProb = gnPProb + getSubmissionProbByPosition(act);
				} else {
					subProb = 0;
				}

				if (act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& (guardType == 0 || guardType == 1)) {
					posProb = 0;
				} else {
					posProb = subProb + act.getStratPositioning();
				}

				lnPProb = posProb + act.getStratLNP();

				if (((guardType == 3 || guardType == 4)
						|| (act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
								&& (guardType == 2 || guardType == 4)))
						&& (act.getRoundsInTheGround() <= 0)) {
					standProb = lnPProb + act.getStratStandUp();
				} else {
					standProb = 0;
					posProb += act.getStratStandUp();
					lnPProb = posProb + act.getStratLNP();
				}

				if (prob <= gnPProb) {
					result = Moves.ACT_GNP;
				} else if (prob <= subProb) {
					result = Moves.ACT_SUBMISSION;
				} else if (prob <= posProb) {
					result = Moves.ACT_POSITIONING;
				} else if (prob <= lnPProb) {
					result = Moves.ACT_LNP;
				} else if ((prob <= standProb) && (standProb > 0)) {
					result = Moves.ACT_STANDUP;
				} else {
					result = Moves.ACT_POSITIONING;

				}

				if (act.getFancySubmissions() > 0 && result == Moves.ACT_SUBMISSION) {
					if (randomGenerator() < act.getAgility() && randomGenerator() < act.getSubmission()
							&& randomGenerator() < act.getFancySubmissions() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYSUB;
					}
				}

				if (result == Moves.ACT_GNP
						&& act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& (guardType == 2 || guardType == 3 || guardType == 7 || guardType == 8)
						&& act.isUseKneesGround()) {
					if ((fixedRandomInt(act.getAggressiveness()) + Sim.KNEESFREQUENCY > 20)) {
						result = Moves.ACT_KNEESONGROUND;
					}
				}

				if (act.checkDirtyMove()) {
					result = Moves.ACT_POKE;
				}

				if (act.checkDirtyMove()) {
					result = Moves.ACT_HEADBUTT;
				}

				if (act.getActionsInGround() > 0 && act.getActionsInGround() < Sim.MINACTIONSFORSWITCHING
						&& result == Moves.ACT_STANDUP) {
					result = Moves.ACT_LNP;
					if (act.getActionsInGround() >= Sim.MINACTIONSFORSWITCHING) {
						act.setActionsInGround(-1);
					}
				}

				act.setActionsInGround(act.getActionsInGround() + 1);

				if (!act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& result == Moves.ACT_GNP) {
					result = Moves.ACT_STRIKESFROMGUARD;
				}

				if (result == Moves.ACT_GNP && act.isUseElbows() && isElbows()) {
					if (randomGenerator() < act.getAggressiveness()) {
						result = Moves.ACT_GNPELBOWS;
					}
				}

				if (act.getTempDamageGround() > act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) {
					if (randomGenerator() < act.getControl()) {
						result = Moves.ACT_STANDUP;
					}
				}

				if (pas.isDazed()) {
					if (fixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZEGROUND;
					}
				}

				int actions = Sim.setLimits(act.getActionsInGround() - 1, Sim.MINSROUNDSINTHEGROUND, 0);

				/* Fim GroundAction */

			} else if (!act.isOnTheGround() && pas.isOnTheGround()) {

				/* StandToGroundAction */

				int goToGroundProb = fixedRandomInt(act.getStratTakedowns());
				int kickProb = fixedRandomInt((act.getStratKicking() + act.getStratStandUp() / 2));

				if (goToGroundProb > kickProb) {
					result = Moves.ACT_MOVETOGROUND;
				} else {
					result = Moves.ACT_STANDKICK;
				}

				if (randomGenerator() > act.getAggressiveness()) {
					result = Moves.ACT_ALLOWSTAND;
				}

				int soccerKickProb = 0;
				if (result == Moves.ACT_STANDKICK && isSoccerKicks() && act.isUseSoccerKicks()
						&& fixedRandomInt(act.getAggressiveness()) + Sim.SOCCERKICKSFREQUENCY > 20) {
					soccerKickProb = fixedRandomInt(act.getKicking());
				}

				int stompProb = 0;
				if (result == Moves.ACT_STANDKICK && isStomps() && act.isUseStomps()
						&& fixedRandomInt(act.getAggressiveness()) + Sim.STOPMSFREQUENCY > 20) {
					stompProb = fixedRandomInt(act.getKicking());
				}

				if (result == Moves.ACT_STANDKICK) {
					if (soccerKickProb > stompProb) {
						result = Moves.ACT_SOCCERKICKS;
					} else if (stompProb > soccerKickProb) {
						result = Moves.ACT_STOMPS;
					}
				}

				if (pas.isDazed()) {
					if (fixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZEGROUND;
					}
				}

				/* Fim StandToGroundAction */

			} else if (act.isOnTheGround() && !pas.isOnTheGround()) {

				/* getGroundToStandAction */

				int standupProb = fixedRandomInt(act.getStratStandUp());
				int kickProb = fixedRandomInt((act.getStratKicking()) / 2);

				if (standupProb > kickProb) {
					result = Moves.ACT_STANDUP;
				} else {
					result = Moves.ACT_GROUNDKICK;
				}

				/* Fim getGroundToStandAction */

			} else if (isInTheClinch()) {

				/* getClinchAction */
				int prob = ThreadLocalRandom.current().nextInt(1, 101);

				int dirtyBoxing = act.getStratDirtyBoxing();
				int thai = dirtyBoxing + act.getStratThaiClinch();
				int avoidProb = thai + act.getStratAvoidClinch();

				if (prob <= dirtyBoxing) {
					result = dirtyBoxingAction(act);
				} else if (prob <= thai) {
					result = thaiAction(act);
				} else if (prob <= avoidProb) {
					result = Moves.ACT_BREAKCLINCH;
				} else {
					result = Moves.ACT_TAKEDOWNCLINCH;
				}

				if (act.getActionsInClinch() > 0 && act.getActionsInClinch() < Sim.MINACTIONSFORSWITCHING
						&& result == Moves.ACT_BREAKCLINCH) {
					result = Moves.ACT_DIRTYBOXING;
					if (act.getActionsInClinch() >= Sim.MINACTIONSFORSWITCHING) {
						act.setActionsInClinch(-1);
					}
				}

				act.setActionsInClinch(act.getActionsInClinch() + 1);

				if (act.checkDirtyMove()) {
					result = Moves.ACT_GROINKICK;
				}

				if (result == Moves.ACT_TAKEDOWNCLINCH && act.isPullsGuard()) {
					if (randomGenerator() < ((act.getAgility() + act.getTakedowns()) / Sim.PULLGUARDCUT)) {
						result = Moves.ACT_PULLGUARD;
					}
				}

				/*
				 * if (Bout.getStatistics()[fighterNumber(act)].getTempDamageClinch() >
				 * act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) { if
				 * (randomGenerator() < act.getControl()) { result = Moves.ACT_BREAKCLINCH; } }
				 */

				if (ThreadLocalRandom.current().nextInt(1, 101) < Sim.RESTFREQUENCY) {
					if (randomGenerator() > act.getControl() && randomGenerator() * 5 > act.getCurrentStamina()) {
						result = Moves.ACT_RESTCLINCH;
					}
				}

				if ((result == Moves.ACT_THAICLINCH_PUNCHES && !act.isThaiClinch())
						|| (result == Moves.ACT_THAICLINCH_KNEES && !act.isThaiClinch())
						|| (result == Moves.ACT_DIRTYBOXING && !act.isDirtyBoxing())) {
					result = Moves.ACT_GRAPPLING_PUNCH;
				}

				/* Fim getClinchAction */

			} else {

				/* getStandUpAction */

				Random randomico = new Random();
				int Prob = randomico.nextInt(100) + 1;

				int PunchProb = act.getStratPunching();
				int KickProb = PunchProb + act.getStratKicking();
				int ClinchProb = KickProb + act.getStratClinching();

				if (Prob <= PunchProb) {
					result = Moves.ACT_PUNCHES;

				} else if (Prob <= KickProb) {
					result = Moves.ACT_KICKS;
				} else if (Prob <= ClinchProb) {
					result = Moves.ACT_CLINCH;
				} else {
					result = Moves.ACT_TAKEDOWNS;
				}

				if (act.checkDirtyMove()) {
					result = Moves.ACT_POKE;
				}

				if (act.getFancyPunches() > 0 && result == Moves.ACT_PUNCHES) {
					double rand = Math.random();
					if (rand < act.getAgility() && rand < act.getPunching()
							&& rand < act.getFancyPunches() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYPUNCH;
					}
				} else if (act.getFancyKicks() > 0 && result == Moves.ACT_KICKS) {
					double rand = Math.random();
					if (rand < act.getAgility() && rand < act.getKicking()
							&& rand < act.getFancyKicks() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYKICK;
					}
				} else if (act.getFancySubmissions() > 0) {
					double rand = Math.random();
					if (rand < act.getAgility() && rand < act.getSubmission()
							&& rand < act.getFancySubmissions() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYSUB;
					}
				} else if (result == Moves.ACT_TAKEDOWNS) {
					if (act.getStrength() > Sim.SLAMSTRENGTH && Math.random() < Sim.SLAMPROB) {
						result = Moves.ACT_SLAM;
					} else if (act.getStrength() > Sim.SUPPLEXSTRENGHT && Math.random() < Sim.SUPPLEXPROB) {
						result = Moves.ACT_SUPPLEX;
					}
				}

				if (Math.random() * 100 < Sim.RESTFREQUENCY) {
					if (Math.random() > act.getControl() && Math.random() * 5 > act.getCurrentStamina()
							&& getTimeCurrent() > 100) {
						result = Moves.ACT_REST;
					}
				}

				if (pas.isDazed()) {
					if (fixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZESTAND;
					}
				}

				/* Fim getStandUpAction */

			}
		} else {

			return Moves.ACT_NOACTION;
		}
		return result;
	}

	public void actKeepClinch(Fighter act, Fighter pas) {
		if (roundFinished) {
			return;
		}
		// Pas fighter may try to break the clinch
		if (isInTheClinch()) {
			if (new Random().nextInt(100) <= pas.getStratAvoidClinch()) {
				isCounter = true;
				actBreakClinch(pas, act);
			}
		}
	}

	public void actPunch(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.punch1);
			break;
		case 2:
			generateComment(PtComments.punch2);
			break;
		case 3:
			generateComment(PtComments.punch3);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getPunching() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchStriking() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			// Damage
			damageDone = (at - def) * act.getDamageBonus() * attackLevel;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// Check Injury
			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			// Statistics
			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES, 0,
			// extractHitsLanded(fullComment));
		}

	}

	public void actKick(Fighter act, Fighter pas) {
		double damageDone;
		int injuryType;
		int attackLevel = attackLevel(act, pas, act.getKicking(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.kicks1);
			break;
		case 2:
			generateComment(PtComments.kicks2);
			break;
		case 3:
			generateComment(PtComments.kicks3);
			break;
		}

		// Initial comment
		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		double at = fixedRandomInt(act.getKicking()) + act.getAttackBonus();
		at -= Sim.KICKMALUS * attackLevel;
		int rndatk = new Random().nextInt(4);
		switch (rndatk) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getAggressiveness() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		double def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();

		int rnddfs = new Random().nextInt(4);
		switch (rnddfs) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getControl() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}
		}

		// Damage
		damageDone = (at - def) * act.getDamageBonus() * attackLevel * Sim.KICKDAMAGEBONUS;
		damageFighter(act, pas, damageDone);

		processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

		injuryType = checkInjury(act, pas, damageDone, injuryProb);
		if (!(Sim.INJURYORCUTFALSE == injuryType)) {
			processInjury(act, pas, injuryType);
		}

		// Check Cut
		injuryType = checkCut(act, pas, damageDone, cutProb);
		if (!(Sim.INJURYORCUTFALSE == injuryType)) {
			processCut(act, pas, injuryType);
		}

		// Check KO
		if (checkKO(act, pas, damageDone, kOSubProb)) {
			processKO(act, pas);
		}

		// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS, 0,
		// extractHitsLanded(fullComment));

	}

	public void actClinch(Fighter act, Fighter pas) {

		// Get clinch type and display comment
		Integer clinchType = clinchType(act);
		switch (clinchType) {
		case 0:
			generateComment(PtComments.dirtyClinch);
			break;
		case 1:
			generateComment(PtComments.thaiClinch);
			break;
		case 2:
			generateComment(PtComments.clinch);
			break;
		}

		// Initial comment
		doComment(act, pas, extractInitComment(fullComment));

		// Modify statistics
		// updateStatistic(fighterNumber(act), StatisticsTypes.GRAPPLING,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		double at = fixedRandomInt(act.getClinchGrappling()) + act.getAttackBonus() + Sim.CLINCHMALUS;
		int randomIndex = new Random().nextInt(4);
		switch (randomIndex) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		double def = fixedRandomInt(pas.getClinchGrappling()) + pas.getDefenseBonus();
		randomIndex = new Random().nextInt(4);
		switch (randomIndex) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		// Check damage
		if (def >= at) {
			// Do failure PtComments
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do success PtComments
			doComment(act, pas, extractComment(fullComment));

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// updateStatistic(fighterNumber(act), StatisticsTypes.GRAPPLING, 0,
			// extractHitsLaunched(fullComment));
		}
	}

	public void actTakedown(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getTakedowns(), pas.getTakedownsDef());

		switch (attackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.takeDown1);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.TAKEDOWNS,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getTakedowns()) + act.getAttackBonus();

		Random rndAtk = new Random();
		int rndtk = rndAtk.nextInt(4);
		switch (rndtk) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getTakedownsDef());
		def += pas.getDefenseBonus();

		Random rnddfs = new Random();
		int rndfs = rnddfs.nextInt(4);
		switch (rndfs) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}
			act.setRoundsInTheGround(Sim.MINSROUNDSINTHEGROUND);

			damageDone = ((at - def) * act.getDamageBonus() * attackLevel) / 4;
			damageFighter(act, pas, damageDone);

			act.increasePoints(currentRound, Sim.SUCCESSFULTAKEDOWNPOINTS, pas.isOnTheGround());

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.TAKEDOWNS, 0,
			// extractHitsLanded(fullComment));
		}

	}

	public void actPunchClinch(Fighter act, Fighter pas, int ClinchType) {
		final double GRAPPLING_MOD = 0.6;
		double at, def, damageDone;
		int AttackLevel;
		double DamageMod = 1;

		AttackLevel = attackLevel(act, pas, (act.getPunching() + act.getClinchStriking()) / 2,
				(pas.getDodging() + pas.getClinchStriking()) / 2);

		if (ClinchType == -1) {
			ClinchType = clinchPunchType(act);
		}
		DamageMod = 1;

		switch (ClinchType) {
		case 1:
			switch (AttackLevel) {
			case 1:
				generateComment(PtComments.thaiPunch1);
				break;
			case 2:
				generateComment(PtComments.thaiPunch2);
				break;
			case 3:
				generateComment(PtComments.thaiPunch3);
				break;
			}
			DamageMod = 1;
			break;

		case 2:
			switch (AttackLevel) {
			case 1:
				generateComment(PtComments.dirtyBoxing1);
				break;
			case 2:
				generateComment(PtComments.dirtyBoxing2);
				break;
			case 3:
				generateComment(PtComments.dirtyBoxing3);
				break;
			}
			DamageMod = 1;
			break;

		case 3:
			switch (AttackLevel) {
			case 1:
				generateComment(PtComments.grapplingPunch1);
				break;
			case 2:
				generateComment(PtComments.grapplingPunch2);
				break;
			case 3:
				generateComment(PtComments.grapplingPunch2);
				break;
			}
			DamageMod = GRAPPLING_MOD;
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		at = fixedRandomInt((act.getPunching() + act.getClinchStriking()) / 2) + act.getAttackBonus();

		Random rndAtk = new Random();
		int rndtk = rndAtk.nextInt(4);
		switch (rndtk) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt((pas.getDodging() + pas.getClinchStriking()) / 2) + pas.getDefenseBonus();
		Random rnddfs = new Random();
		int rndfs = rnddfs.nextInt(4);
		switch (rndfs) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchStriking() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(act);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
					refBreakClinch(act, pas);
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (AttackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = (at - def) * act.getDamageBonus() * AttackLevel * DamageMod;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			int injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}
		}
	}

	public void actClinchTakedown(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getClinchGrappling(),
				(pas.getClinchGrappling() + pas.getTakedownsDef()) / 2);

		if (takedownType(act) == 1) {
			switch (attackLevel) {
			case 1:
				generateComment(PtComments.judoTD1);
				break;
			case 2:
				generateComment(PtComments.judoTD1);
				break;
			case 3:
				generateComment(PtComments.judoTD1);
				break;
			}
		} else {
			switch (attackLevel) {
			case 1:
				generateComment(PtComments.wrestlingTD1);
				break;
			case 2:
				generateComment(PtComments.wrestlingTD1);
				break;
			case 3:
				generateComment(PtComments.wrestlingTD1);
				break;
			}
		}

		// Initial comment
		doComment(act, pas, extractInitComment(fullComment));

		// Modifying statistics
		// updateStatistic(fighterNumber(act), StatisticsTypes.TAKEDOWNS,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		at = fixedRandomInt(act.getClinchGrappling()) + act.getAttackBonus();
		Random rndatks = new Random();
		int rndatk = rndatks.nextInt(4);
		switch (rndatk) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getTakedowns() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt((pas.getTakedownsDef() + pas.getClinchGrappling()) / 2);
		Random rnddfs = new Random();
		int rndfs = rnddfs.nextInt(4);
		def += pas.getDefenseBonus();
		switch (rndfs) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
					refBreakClinch(act, pas);
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = (at - def) * act.getDamageBonus() * attackLevel / 4;
			damageFighter(act, pas, damageDone);

			act.setRoundsInTheGround(Sim.MINSROUNDSINTHEGROUND);
			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}
		}

		// updateStatistic(fighterNumber(act), StatisticsTypes.TAKEDOWNS, 0,
		// extractHitsLanded(fullComment));
	}

	public void actBreakClinch(Fighter act, Fighter pas) {
		double at, def;

		String initComment = extractInitComment(getFullComment());
		generateComment(PtComments.breakClinch);
		doComment(act, pas, initComment);

		// Attacking value
		at = fixedRandomInt(act.getClinchMean());
		at += act.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getClinchMean());
		def += pas.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getAggressiveness() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(getFullComment()));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(getFullComment()));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(getFullComment()));
			}
		} else {
			// Do PtComments
			doComment(act, pas, extractComment(getFullComment()));

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(getFullComment()));
		}
	}

	public void actGnP(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getGnp(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.gnp1);
			break;
		case 2:
			generateComment(PtComments.gnp2);
			break;
		case 3:
			generateComment(PtComments.gnp3);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.GNP,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getGnp()) + act.getAttackBonus() + gnPBonusByGuard();

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getPunching() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			act.setStalling(act.getStalling() + 1);

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}
		}

		act.setStalling(0);

		damageDone = (at - def) * act.getDamageBonus() * attackLevel;
		damageFighter(act, pas, damageDone);

		injuryType = checkInjury(act, pas, damageDone, injuryProb);
		if (injuryType != Sim.INJURYORCUTFALSE) {
			processInjury(act, pas, injuryType);
		}

		// Check for cut
		injuryType = checkCut(act, pas, damageDone, cutProb);
		if (injuryType != Sim.INJURYORCUTFALSE) {
			processCut(act, pas, injuryType);
		}

		if (checkKO(act, pas, damageDone, kOSubProb)) {
			processKO(act, pas);
		}

		processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

		// Update bout statistics
		// updateStatistic(fighterNumber(act), StatisticsTypes.GNP, 0,
		// extractHitsLanded(fullComment));

	}

	public void actPositioning(Fighter act, Fighter pas) {
		double at, def;

		attackLevel(act, pas, act.getPunching(), pas.getDodging());

		switch (guardType) {
		case 0:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				switch (numHooks) {
				case -99:
				case 0:
					generateComment(PtComments.inRearMountMoves);
					break;
				case 1:
					generateComment(PtComments.inRearMountOneHookMoves);
					break;
				default:
					generateComment(PtComments.inRearMountTwoHooksMoves);
					break;
				}
			} else {
				switch (numHooks) {
				case -99:
				case 0:
					generateComment(PtComments.defInRearMountMoves);
					break;
				case 1:
					generateComment(PtComments.defInRearMountOneHookMoves);
					break;
				default:
					generateComment(PtComments.defInRearMountTwoHooksMoves);
					break;
				}
			}
			break;
		case 1:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				generateComment(PtComments.inFullMountMoves);
			} else {
				generateComment(PtComments.defInFullMountMoves);
			}
			break;
		case 2:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				generateComment(PtComments.inSideMountMoves);
			} else {
				generateComment(PtComments.defInSideMountMoves);
			}
			break;
		case 3:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				generateComment(PtComments.inHalfGuardMoves);
			} else {
				generateComment(PtComments.defInHalfGuardMoves);
			}
			break;
		case 4:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				generateComment(PtComments.inOpenGuardMoves);
			} else {
				generateComment(PtComments.defInOpenGuardMoves);
			}
			break;
		case 5:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				generateComment(PtComments.inClosedGuardMoves);
			} else {
				generateComment(PtComments.defInClosedGuardMoves);
			}
			break;
		case 6:
			if (fighterActiveOrPassive(fighterOnTop) == act) {
				generateComment(PtComments.inButterflyGuardMoves);
			} else {
				generateComment(PtComments.defInButterflyGuardMoves);
			}
			break;
		}

		// Initial comment
		doComment(act, pas, extractInitComment(fullComment));

		// Attacking value
		at = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		// at = at + fixedRandomInt(act.Aggressiveness/2);
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		// def = def + fixedRandomInt(pas.Control/2);
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			act.setStalling(act.getStalling() + 1);

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			doComment(act, pas, extractComment(fullComment));
			act.increasePoints(currentRound, Sim.MOVEPOINTS, true);
			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));
		}
	}

	public void actSubmission(Fighter act, Fighter pas) {
		double at, def, DamageDone;

		if (act.getName().equals(fighterActiveOrPassive(fighterOnTop).getName())) {
			switch (guardType) {
			case 0:
				generateComment(PtComments.rearSub1);
				break;
			case 1:
				generateComment(PtComments.fullMountSub1);
				break;
			case 2:
			case 3:
				generateComment(PtComments.sideMountSub1);
				break;
			case 4:
				generateComment(PtComments.openGuardSub1);
				break;
			default:
				actPositioning(act, pas);
				return;
			}
		} else {
			switch (guardType) {
			case -1:
				generateComment(PtComments.standUpSub1);
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				generateComment(PtComments.closedGuardSub1);
				break;
			default:
				actPositioning(act, pas);
				return;
			}
		}

		subLocation = extractHitLocation(fullComment);
		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);
		// updateStatistic(fighterNumber(act), StatisticsTypes.SUBMISSIONS, 1, 0);

		at = fixedRandomInt(act.getSubmission()) + act.getAttackBonus() + subBonusByGuard();

		int randomIndex = new Random().nextInt(4);
		switch (randomIndex) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getSubDefense() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);
		at -= Sim.SUBMALUS;

		def = fixedRandomInt(pas.getSubDefense()) + act.getDefenseBonus();

		int randomIndex2 = new Random().nextInt(4);
		switch (randomIndex2) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getSubmission() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (act.isOnTheGround()) {
				act.setStalling(act.getStalling() + 1);
			}

			if (isCounter == false) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter == true) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			DamageDone = (at - def) * act.getDamageBonus();
			damageFighter(act, pas, DamageDone);

			if (act.isOnTheGround()) {
				act.setStalling(0);
			}

			act.increasePoints(currentRound, Sim.LOCKINSUBMISSIONPOINTS, true);

			hitLocation = extractHitLocation(fullComment);

			if (checkSubmission(act, pas, DamageDone, extractKOSubProb(fullComment))) {
				doComment(act, pas, extractComment(fullComment));
				boutFinished = true;
				finishedType = PtComments.misc.get(Sim.SUB);
				finishMode = Sim.RES_SUB;
				finishedDescription = extractMoveName(fullComment);
				fighterWinner = fighterNumber(act);
			} else {
				actLockSubmission(act, pas);
			}

			processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			// updateStatistic(fighterNumber(act), StatisticsTypes.SUBMISSIONS, 0,1);

		}
	}

	public void actLockSubmission(Fighter act, Fighter pas) {
		double at, def, damageDone;
		boolean lockedSub = true;
		int breakProb = 0;
		String failureComment;

		failureComment = extractFailureComment(fullComment);

		while (lockedSub && !boutFinished) {
			at = fixedRandomInt(act.getSubmission()) + act.getAttackBonus();

			int randomIndex = new Random().nextInt(4);
			switch (randomIndex) {
			case 0:
				at += fixedRandomInt(act.getStrength() / 2);
				break;
			case 1:
				at += fixedRandomInt(act.getAgility() / 2);
				break;
			case 2:
				at += fixedRandomInt(act.getGroundGame() / 2);
				break;
			case 3:
				at += fixedRandomInt(act.getSubDefense() / 2);
				break;
			}
			at += smallRandom();
			at = gasTankFactor(act, at);
			at -= hurtFactor(act);

			def = fixedRandomInt(pas.getSubDefense()) + act.getDefenseBonus() + breakProb * 2;
			def += fixedRandomInt(act.getControl() / 2);
			int randomIndex2 = new Random().nextInt(4);
			switch (randomIndex2) {
			case 0:
				def += fixedRandomInt(pas.getStrength() / 2);
				break;
			case 1:
				def += fixedRandomInt(pas.getAgility() / 2);
				break;
			case 2:
				def += fixedRandomInt(pas.getSubmission() / 2);
				break;
			case 3:
				def += fixedRandomInt(pas.getGroundGame() / 2);
				break;
			}
			def += smallRandom();
			def = gasTankFactor(pas, def);
			def -= hurtFactor(pas);

			if (def > at || breakProb >= Sim.MAXLOCKINSUBMISSION) {
				doComment(act, pas, failureComment);
				lockedSub = false;
			} else {
				damageDone = (at - def + breakProb) * act.getDamageBonus();
				damageFighter(act, pas, damageDone);

				int injuryType = checkInjury(act, pas, damageDone, injuryProb);
				if (injuryType != Sim.INJURYORCUTFALSE) {
					processInjury(act, pas, injuryType);
				}

				if (!boutFinished && checkSubmission(act, pas, damageDone, extractKOSubProb(fullComment))) {
					doComment(act, pas, extractComment(fullComment));
					boutFinished = true;
					finishedType = PtComments.misc.get(Sim.SUB);
					finishMode = Sim.RES_SUB;
					finishedDescription = moveName;
					fighterWinner = fighterNumber(act);
				} else if (checkRefSubStoppage(breakProb)) {
					doComment(act, pas, returnComment(PtComments.subRefStoppage));
					boutFinished = true;
					finishedType = PtComments.misc.get(Sim.RES_SUB);
					finishMode = Sim.RES_SUB;
					finishedDescription = moveName;
					fighterWinner = fighterNumber(act);
				} else if (!boutFinished) {
					doComment(act, pas, returnComment(PtComments.lockingSubmission));
					breakProb++;
					if (checkTryToSlamOutSub(pas, act, breakProb)) {
						lockedSub = !actSlamOutSubmission(pas, act);
					}
				}
			}
		}
	}

	public boolean actSlamOutSubmission(Fighter act, Fighter pas) {
		final double SLAM_OUT_CUT = 1.25;
		double at, def, damageDone;
		int attackLevel, injuryType;
		
		String tempMoveName = "";

		attackLevel = attackLevel(act, pas, (act.getTakedowns() + act.getStrength()) / 2, pas.getTakedownsDef());
		generateComment(PtComments.slamOut);
		tempMoveName = moveName;

		// Initial comment
		doComment(act, pas, extractInitComment(fullComment));

		// Return Hit location
		hitLocation = extractHitLocation(fullComment);

		// Modifying statistics
		//statistics[fighterNumber(act)].takedownAttempts = extractHitsLaunched(fullComment);

		// Attacking value
		at = fixedRandomInt(act.getStrength()) + act.getAttackBonus();
		int randomIndex = new Random().nextInt(4);
		switch (randomIndex) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getConditioning() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);
		at /= SLAM_OUT_CUT;

		// Defensive value
		def = fixedRandomInt(pas.getSubmission()) + pas.getDefenseBonus();
		int randomIndex2 = new Random().nextInt(4);
		switch (randomIndex2) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		// Checking damage
		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			return false;
		} else {
			// Do PtComments
			doComment(act, pas, extractComment(fullComment));

			// Damage
			damageDone = ((at - def) * act.getDamageBonus() * attackLevel) / 2;
			damageFighter(act, pas, damageDone);

			// Increase points for takedown
			act.increasePoints(currentRound, Sim.SUCCESSFULTAKEDOWNPOINTS, true);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// Modifying statistics
			// statistics.get(fighterNumber(act)].TakedownsAchieved =
			// ExtractHitsLanded(FullComment);

			//statistics[fighterNumber(act)].takedownsAchieved = extractHitsLanded(fullComment);

			return true;

		}

	}

	public void actStandUp(Fighter act, Fighter pas) {
		generateComment(PtComments.standUp);

		doComment(act, pas, extractInitComment(fullComment));

		double at = fixedRandomInt(act.getAgility()) + act.getDefenseBonus();
		at += fixedRandomInt(act.getControl() / 2);

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		double def = fixedRandomInt(pas.getAggressiveness()) + pas.getAttackBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getKicking() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			pas.setStalling(pas.getStalling() + 1);
		} else {
			doComment(act, pas, extractComment(fullComment));
			processAfterMovePosition(act, pas, 17);

			if ((randomGenerator() < gasTankFactor(pas, pas.getAgility())) && (act.isOnTheGround() == false)
					&& (pas.isOnTheGround())) {
				actStandUp(pas, act);
			}
		}
	}

	public void actLnP(Fighter act, Fighter pas) {
		double at, def;

		generateComment(PtComments.lnp);

		// Attacking value
		at = fixedRandomInt(act.getGroundGame()) + act.getAttackBonus();
		at += fixedRandomInt(act.getControl() / 2);
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getSubDefense() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getSubmission() / 2);
			break;
		}
		at += randomGenerator();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getGroundGame()) + pas.getDefenseBonus();
		// def += fixedRandomInt(pas.getControl() / 2); // commented out
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getSubDefense() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getAggressiveness() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getSubmission() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		// Checking damage
		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			doComment(act, pas, extractComment(fullComment));

			act.setStalling(act.getStalling() + 2);

			// LnP recovers stamina
			act.recoverStamina(2);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));
		}
	}

	public void actFancyPunch(Fighter act, Fighter pas) {
		final double FANCY_PUNCH_DAMAGE_BONUS = 1.25;
		double at, def, damageDone;
		int attackLevel, hitLocation, injuryType;
		String fullComment = "";

		// Suspeito

		attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.punch1);
			break;
		case 2:
		case 3:
			generateComment(PtComments.fancyPunch1);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
		// extractHitsLaunched(fullComment), 0);

		hitLocation = extractHitLocation(fullComment);

		at = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		at += smallRandom();

		def = fixedRandomInt(pas.getDodging());
		def += pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getControl() / 2);
			break;
		}
		def += smallRandom();

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			// act.getStatistics().setPerfomanceBonus(ApplicationUtils.FANCY_MOVE_ATTEMP_EXCITEMENT_BONUS);

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}
			// act.getStatistics().setPerfomanceBonus(ApplicationUtils.FANCY_MOVE_SUCCESS_EXCITEMENT_BONUS);

			damageDone = (at - def) * (act.getDamageBonus() + FANCY_PUNCH_DAMAGE_BONUS) * attackLevel;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actFancyKick(Fighter act, Fighter pas) {
		final double FANCY_KICK_DAMAGE_BONUS = 1.75;
		double at, def, damageDone;
		int attackLevel, hitLocation, injuryType;

		// Revisar

		attackLevel = attackLevel(act, pas, act.getKicking(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.kicks1);
			break;
		case 2:
		case 3:
			generateComment(PtComments.fancyKick1);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS,
		// extractHitsLaunched(fullComment), 0);

		hitLocation = extractHitLocation(fullComment);

		at = fixedRandomInt(act.getKicking()) + act.getAttackBonus();
		// at += fixedRandomInt(act.getAggressiveness() / 2);
		at -= Sim.KICKMALUS * attackLevel;
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		at += smallRandom();

		def = fixedRandomInt(pas.getDodging());
		def += pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchStriking() / 2);
			break;
		}
		def += smallRandom();

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			// act.getStatistics().setPerformanceBonus(ApplicationUtils.FANCY_MOVE_ATTEMP_EXCITEMENT_BONUS);

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}
			// act.getStatistics().setPerformanceBonus(ApplicationUtils.FANCY_MOVE_SUCCESS_EXCITEMENT_BONUS);

			damageDone = (at - def) * (act.getDamageBonus() + FANCY_KICK_DAMAGE_BONUS) * attackLevel + 0.5;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (!(Sim.INJURYORCUTFALSE == injuryType)) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (!(Sim.INJURYORCUTFALSE == injuryType)) {
				processCut(act, pas, injuryType);
			}

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS, 0,
			// extractHitsLanded(fullComment));

		}
	}

	public void actHeadButt(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		// revisar

		attackLevel = attackLevel(act, pas, act.getGroundGame(), pas.getGroundGame());

		switch (attackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.headbutt);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getGroundGame()) + act.getAttackBonus();
		int rand = new Random().nextInt(4);
		switch (rand) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getGroundGame()) + pas.getDefenseBonus();
		rand = new Random().nextInt(4);
		switch (rand) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = (at - def) * act.getDamageBonus() * attackLevel;
			damageFighter(act, pas, damageDone);

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			pas.setDirtyMoveMalus(pas.getDirtyMoveMalus() + Math.round(damageDone / Sim.DIRTYMOVEMALUSCUT));

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// refAwareOfFault(act, pas, PtComments.misc.get(Sim.HEADBUTT));

			// Modifying statistics
			// updateStatistic (fighterNumber(act), StatisticsTypes.CLINCH, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actPoke(Fighter act, Fighter pas) {
		int attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		// revisar

		if (act.isOnTheGround()) {
			generateComment(PtComments.groundEyePoke);
		} else {
			generateComment(PtComments.standingEyePoke);
		}

		// fullComment = generateComment(comment);
		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH,
		// extractHitsLaunched(fullComment), 0);

		double at = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		double def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (isCounter == false) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter == true) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
					refBreakClinch(act, pas);
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}

			// Do PtComments
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			double damageDone = 1;
			damageFighter(act, pas, damageDone);

			pas.setDirtyMoveMalus(pas.getDirtyMoveMalus() + Math.round(damageDone / Sim.DIRTYMOVEMALUSCUT));

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// refAwareOfFault(act, pas, PtComments.misc[ApplicationUtils.EYE_POKE]);

			// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actRest(Fighter act, Fighter pas) {
		double staminaRecovered;

		if (act.isOnTheGround()) {
			generateComment(PtComments.restOnGround);
		} else {
			generateComment(PtComments.rest);
		}
		doComment(act, pas, extractInitComment(fullComment));

		staminaRecovered = fixedRandomInt(act.getConditioning()) * Sim.DEFAULTSTAMINARECOVERY;

		act.recoverStamina(staminaRecovered);
		act.recoverHP(1);
		act.setRush(0);

	}

	public void actGroinKick(Fighter act, Fighter pas) {
		double at, def, DamageDone;
		int AttackLevel;
		AttackLevel = attackLevel(act, pas, (act.getKicking() + act.getClinchStriking()) / 2,
				(pas.getDodging() + pas.getClinchStriking()) / 2);
		switch (AttackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.groinKnee);
			break;
		}
		doComment(act, pas, extractInitComment(fullComment));
		hitLocation = extractHitLocation(fullComment);
		// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH,
		// extractHitsLaunched(fullComment), 0);
		at = fixedRandomInt((act.getKicking() + act.getClinchStriking()) / 2) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getAggressiveness() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);
		def = fixedRandomInt((pas.getDodging() + pas.getClinchStriking()) / 2) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
					refBreakClinch(act, pas);
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {

			switch (AttackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			default:
				break;
			}
		}

		DamageDone = (at - def) * act.getDamageBonus() * AttackLevel;
		damageFighter(act, pas, DamageDone);

		pas.setDirtyMoveMalus(pas.getDirtyMoveMalus() + Math.round(DamageDone / Sim.DIRTYMOVEMALUSCUT));

		processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

		// RefAwareOfFault(act, pas, PtComments.misc[ApplicationUtils.GOIN_KICK]);

		// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH, 0,
		// extractHitsLanded(fullComment));
	}

	public void actSlam(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, (act.getTakedowns() + act.getStrength()) / 2, pas.getTakedownsDef());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.slam);
			break;
		case 2:
			generateComment(PtComments.slam);
			break;
		case 3:
			generateComment(PtComments.slam);
			break;
		default:
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// Bout.getStatistics(fighterNumber(act)).setTakedownsAttempts(ExtractHitsLaunched(fullComment));

		at = fixedRandomInt((act.getTakedowns() + act.getStrength()) / 2) + act.getAttackBonus();
		// at = at + fixedRandomInt(act.getAggressiveness()/2);
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getConditioning() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		default:
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getTakedownsDef());
		def += pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		default:
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		// Checking damage
		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			default:
				break;
			}
			// act.Statistics.PerfomanceBonus = ApplicationUtils.SLAM_EXCITEMENT_BONUS;
		}

		// Damage
		damageDone = ((at - def) * act.getDamageBonus() * attackLevel) / 2;
		damageFighter(act, pas, damageDone);

		// Increase points for takedown
		act.increasePoints(currentRound, Sim.SUCCESSFULTAKEDOWNPOINTS, true);

		processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

		injuryType = checkInjury(act, pas, damageDone, injuryProb);
		if (injuryType != Sim.INJURYORCUTFALSE) {
			processInjury(act, pas, injuryType);
		}

		// Check Cut
		injuryType = checkCut(act, pas, damageDone, cutProb);
		if (injuryType != Sim.INJURYORCUTFALSE) {
			processCut(act, pas, injuryType);
		}

		// Check KO
		if (checkKO(act, pas, damageDone, kOSubProb)) {
			processKO(act, pas);
		}
	}

	public void actSupplex(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getStrength(), pas.getTakedownsDef());

		switch (attackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.supplex1);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act),
		// StatisticsTypes.TAKEDOWNS,extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getStrength()) + act.getAttackBonus();
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getTakedowns() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}

		def = fixedRandomInt(pas.getTakedownsDef()) + pas.getDefenseBonus();
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = ((at - def) * act.getDamageBonus() * attackLevel);
			damageFighter(act, pas, damageDone);

			act.increasePoints(currentRound, Sim.SUCCESSFULTAKEDOWNPOINTS, true);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// Check for cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.TAKEDOWNS,
			// 0,extractHitsLanded(fullComment));
		}
	}

	public void actSoccerKicks(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		switch (attackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.soccerKicks1);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		// Return hit location
		hitLocation = extractHitLocation(fullComment);

		// Modify statistics
		// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		at = fixedRandomInt(act.getKicking()) + act.getAttackBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getAggressiveness() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = (at - def) * act.getDamageBonus() * attackLevel * Sim.KICKDAMAGEBONUS;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// Check for cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actStomps(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.stomps1);
			break;
		case 2:
			generateComment(PtComments.stomps1);
			break;
		case 3:
			generateComment(PtComments.stomps1);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getKicking()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getAggressiveness() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			// Damage
			damageDone = (at - def) * act.getDamageBonus() * attackLevel * Sim.KICKDAMAGEBONUS;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// Check for cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// Statistics
			// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS,
			// 0,extractHitsLanded(fullComment));
		}
	}

	public void actStandKickToGround(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;
		String fullComment = getFullComment();

		attackLevel = attackLevel(act, pas, act.getKicking(), pas.getDodging());

		switch (attackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.standingToGround1);
			break;
		}

		// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS,
		// extractHitsLaunched(fullComment), 0);

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		at = fixedRandomInt(act.getKicking()) + act.getAttackBonus();
		int randNum = new Random().nextInt(4);
		switch (randNum) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getAggressiveness() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		randNum = new Random().nextInt(4);
		switch (randNum) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getKicking() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		pas.setStalling(pas.getStalling() + 1);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = (at - def) * act.getDamageBonus() * attackLevel / 5.0;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actMoveToGround(Fighter act, Fighter pas) {
		double at, def;
		int attackLevel;

		attackLevel = attackLevel(act, pas, act.getGroundGame(), pas.getAgility());

		switch (attackLevel) {
		case 1:
		case 2:
			generateComment(PtComments.moveToGround);
			break;
		case 3:
			generateComment(PtComments.moveToGround);

			break;
		}

		// Initial comment
		doComment(act, pas, extractInitComment(fullComment));

		// Attacking value
		at = fixedRandomInt(act.getGroundGame()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getControl() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getAgility());
		def += pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getKicking() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		// Checking damage
		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));
		}
	}

	public void actStrikesFromGuard(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getGnp(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.strikesFromGuard1);
			break;
		case 2:
			generateComment(PtComments.strikesFromGuard2);
			break;
		case 3:
			generateComment(PtComments.strikesFromGuard2);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		// updateStatistic(fighterNumber(act), StatisticsTypes.GNP,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getGnp()) + act.getAttackBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getPunching() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			act.setStalling(act.getStalling() + 1);

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			act.setStalling(0);

			damageDone = (at - def) * act.getDamageBonus() * attackLevel / Sim.STRIKESFROMGUARDDAMAGECUT;
			damageFighter(act, pas, damageDone);

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.GNP, 0,
			// extractHitsLanded(fullComment));

		}
	}

	public void actGroundKicksToStand(Fighter act, Fighter pas) {
		int attackLevel, injuryType;
		double at, def, damageDone;
		boolean isCounter = false;
		double counterProb = 0.0;

		// revisar

		attackLevel = attackLevel(act, pas, act.getKicking(), pas.getDodging());

		switch (attackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.groundToStanding1);
			break;
		default:
			fullComment = "";
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		at = fixedRandomInt((act.getKicking() + act.getGroundGame()) / 2) + act.getAttackBonus();
		int rand = new Random().nextInt(4);
		switch (rand) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		default:
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		rand = new Random().nextInt(4);
		switch (rand) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getKicking() / 2);
			break;
		default:
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			act.setStalling(act.getStalling() + 1);

			doComment(act, pas, extractFailureComment(fullComment));

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			default:
				break;
			}

			act.setStalling(act.getStalling() + 1);

			damageDone = (at - def) * act.getDamageBonus() * attackLevel / 5;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

		}
	}

	public void actRestInClinch(Fighter act, Fighter pas) {
		double StaminaRecovered = 0.0;

		// revisar

		generateComment(PtComments.restInClinch);
		String initComment = extractInitComment(fullComment);
		doComment(act, pas, initComment);

		StaminaRecovered = fixedRandomInt(act.getConditioning()) * Sim.DEFAULTSTAMINARECOVERY;

		act.recoverStamina(StaminaRecovered);
		act.recoverHP(1);
		act.setRush(0);

		refBreakClinch(act, pas);
	}

	public void actNoAction(Fighter act, Fighter pas) {

		// Revisar

		generateComment(PtComments.noAction);
		String initComment = extractInitComment(fullComment);
		doComment(act, pas, initComment);
	}

	public void actAllowToStand(Fighter act, Fighter pas) {

		// Revisar

		generateComment(PtComments.allowStand);
		String initComment = extractInitComment(fullComment);
		doComment(act, pas, initComment);

		act.setOnTheGround(false);
		pas.setOnTheGround(false);
	}

	public void actPullGuard(Fighter act, Fighter pas) {
		double at, def;
		int AttackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		// revisar
		switch (AttackLevel) {
		case 1:
		case 2:
		case 3:
			generateComment(PtComments.pullGuard);
			String initComment = extractInitComment(fullComment);
			doComment(act, pas, initComment);
			break;
		}

		// Return Hit location
		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		at = fixedRandomInt((act.getTakedowns() + act.getAgility()) / 2) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getSubmission() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchGrappling() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		def = fixedRandomInt(pas.getStrength()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getTakedownsDef() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			if (isCounter == false) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter == true) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}

		} else {

			doComment(act, pas, extractComment(fullComment));

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			act.increasePoints(currentRound, Sim.SUCCESSFULTAKEDOWNPOINTS, true);

			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES, 0,
			// extractHitsLanded(fullComment));

		}
	}

	public void actGnPElbows(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getGnp(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(PtComments.gnpElbows1);
			break;
		case 2:
			generateComment(PtComments.gnpElbows2);
			break;
		case 3:
			generateComment(PtComments.gnpElbows3);
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.GNP,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		at = fixedRandomInt(act.getGnp()) + act.getAttackBonus() + gnPBonusByGuard();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getPunching() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defending value
		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			act.setStalling(act.getStalling() + 1);

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			act.setStalling(0);

			// Damage
			damageDone = (at - def) * act.getDamageBonus() * attackLevel;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (!(Sim.INJURYORCUTFALSE == injuryType)) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (!(Sim.INJURYORCUTFALSE == injuryType)) {
				processCut(act, pas, injuryType);
			}

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.GNP, 0,
			// extractHitsLanded(fullComment));
			// SUS
		}
	}

	public void actCapitalizeStanding(Fighter act, Fighter pas) {
		double attack, defense, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());
		generateComment(PtComments.capitalizeStanding);

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		attack = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			attack += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			attack += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			attack += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			attack += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		attack += smallRandom();
		attack = gasTankFactor(act, attack);
		attack -= hurtFactor(act);

		// Defensive value
		defense = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			defense += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			defense += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			defense += fixedRandomInt(pas.getPunching() / 2);
			break;
		case 3:
			defense += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		defense += smallRandom();
		defense = gasTankFactor(pas, defense);
		defense -= hurtFactor(pas);

		// Checking damage
		if (defense >= attack) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			// Damage
			damageDone = (attack - defense) * act.getDamageBonus() * attackLevel;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// Statistics
			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actCapitalizeGround(Fighter act, Fighter pas) {
		double attackValue, defenseValue, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getGnp(), pas.getDodging());

		generateComment(PtComments.capitalizeGround);

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.GNP,
		// extractHitsLaunched(fullComment), 0);

		// Attacking value
		attackValue = fixedRandomInt(act.getGnp()) + act.getAttackBonus() + gnPBonusByGuard();
		switch (new Random().nextInt(4)) {
		case 0:
			attackValue += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			attackValue += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			attackValue += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			attackValue += fixedRandomInt(act.getPunching() / 2);
			break;
		}
		attackValue += smallRandom();
		attackValue = gasTankFactor(act, attackValue);
		attackValue -= hurtFactor(act);

		// Defensive value
		defenseValue = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			defenseValue += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			defenseValue += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			defenseValue += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			defenseValue += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}
		defenseValue += smallRandom();
		defenseValue = gasTankFactor(pas, defenseValue);
		defenseValue -= hurtFactor(pas);

		// Checking damage
		if (defenseValue >= attackValue) {
			doComment(act, pas, extractFailureComment(fullComment));
			act.setStalling(act.getStalling() + 1);

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do PtComments
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}
			act.setStalling(0);

			// Damage
			damageDone = (attackValue - defenseValue) * act.getDamageBonus() * attackLevel;
			damageFighter(act, pas, damageDone);

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// updateStatistic(fighterNumber(act), StatisticsTypes.GNP, 0,
			// extractHitsLanded(fullComment));
		}
	}

	public void actKneesOnGround(Fighter act, Fighter pas) {
		final int AGG_HEAD_KNEE = 12;
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getGnp(), pas.getDodging());

		switch (guardType) {
		case 2:
			if (fixedRandomInt(act.getAggressiveness()) >= AGG_HEAD_KNEE) {
				generateComment(PtComments.kneesOnGroundHead);
			} else {
				generateComment(PtComments.kneesOnGroundSide);
			}
			break;
		case 3:
			generateComment(PtComments.kneesOnGroundSide);
			break;
		case 7:
			generateComment(PtComments.kneesOnGroundHead);
			break;
		case 8:
			if (fixedRandomInt(act.getAggressiveness()) >= AGG_HEAD_KNEE) {
				generateComment(PtComments.kneesOnGroundHead);
			} else {
				generateComment(PtComments.kneesOnGroundSide);
			}
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);
		// updateStatistic(fighterNumber(act), StatisticsTypes.GNP,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt(act.getGnp()) + act.getAttackBonus() + gnPBonusByGuard();

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getKicking() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}

		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			act.setStalling(act.getStalling() + 1);

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			act.setStalling(0);

			damageDone = (at - def) * act.getDamageBonus() * attackLevel / 5;
			damageFighter(act, pas, damageDone);

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (!(Sim.INJURYORCUTFALSE == injuryType)) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (!(Sim.INJURYORCUTFALSE == injuryType)) {
				processCut(act, pas, injuryType);
			}

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// updateStatistic(fighterNumber(act), StatisticsTypes.KICKS, 0,
			// extractHitsLanded(fullComment));

		}
	}

	public void actFancySubmission(Fighter act, Fighter pas) {

		if (act.getName().equals(fighterActiveOrPassive(fighterOnTop).getName())) {
			switch (guardType) {
			case 0:
				generateComment(PtComments.rearSub1);
				break;
			case 1:
				generateComment(PtComments.fullMountFancySub1);
				break;
			case 2:
			case 3:
				generateComment(PtComments.sideMountFancySub1);
				break;
			case 4:
				generateComment(PtComments.openGuardSub1);
				break;
			default:
				actPositioning(act, pas);
				return;
			}
		} else {
			switch (guardType) {
			case -1:
				generateComment(PtComments.standingFancySub1);
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				generateComment(PtComments.closedGuardFancySub1);
				break;
			default:
				actPositioning(act, pas);
				return;
			}
		}

		subLocation = extractHitLocation(fullComment);
		doComment(act, pas, extractInitComment(fullComment));
		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.SUBMISSIONS, 1, 0);

		double at = fixedRandomInt(act.getSubmission()) + act.getAttackBonus() + subBonusByGuard();
		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getGroundGame() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getSubDefense() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		double def = fixedRandomInt(pas.getSubDefense()) + act.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getSubmission() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getGroundGame() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			// act.getStatistics().setPerformanceBonus(ApplicationUtils.FANCY_MOVE_ATTEMP_EXCITEMENT_BONUS);

			if (act.isOnTheGround()) {
				act.setStalling(act.getStalling() + 1);
			}

			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			double damageDone = (at - def) * act.getDamageBonus();
			damageFighter(act, pas, damageDone);
			// act.getStatistics().setPerformanceBonus(ApplicationUtils.FANCY_MOVE_SUCCESS_EXCITEMENT_BONUS);

			if (act.isOnTheGround()) {
				act.setStalling(0);
			}

			act.increasePoints(currentRound, Sim.LOCKINSUBMISSIONPOINTS, true);

			hitLocation = extractHitLocation(fullComment);

			if (checkSubmission(act, pas, damageDone, extractKOSubProb(fullComment))) {
				doComment(act, pas, extractComment(fullComment));
				boutFinished = true;
				finishedType = PtComments.misc.get(Sim.SUB);
				finishMode = Sim.RES_SUB;
				finishedDescription = extractMoveName(fullComment);
				fighterWinner = fighterNumber(act);
			} else {
				actLockSubmission(act, pas);
			}

			processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));

			// updateStatistic(fighterNumber(act), StatisticsTypes.SUBMISSIONS, 0, 1);

		}

	}

	public void actKickClinch(Fighter act, Fighter pas, int clinchType) {
		final double GRAPPLING_MOD = 0.5;
		double at, def, damageDone, damageMod;
		int attackLevel, hitLocation, injuryType;

		attackLevel = attackLevel(act, pas, (act.getKicking() + act.getClinchStriking()) / 2,
				(pas.getDodging() + pas.getClinchMean()) / 2);

		if (clinchType == -1) {
			clinchType = clinchPunchType(act);
		}
		double DamageMod = 1;

		switch (clinchType) {
		case 1:
			switch (attackLevel) {
			case 1:
				generateComment(PtComments.thaiKnee1);
				break;
			case 2:
				generateComment(PtComments.thaiKnee2);
				break;
			case 3:
				generateComment(PtComments.thaiKnee3);
				break;
			}
			DamageMod = 1;
			break;
		case 2:
			switch (attackLevel) {
			case 1:
				generateComment(PtComments.grapplingKnee1);
				break;
			case 2:
				generateComment(PtComments.grapplingKnee2);
				break;
			case 3:
				generateComment(PtComments.grapplingKnee2);
				break;
			}
			DamageMod = GRAPPLING_MOD;
			break;
		case 3:
			switch (attackLevel) {
			case 1:
				generateComment(PtComments.grapplingKnee1);
				break;
			case 2:
				generateComment(PtComments.grapplingKnee2);
				break;
			case 3:
				generateComment(PtComments.grapplingKnee2);
				break;
			}
			DamageMod = GRAPPLING_MOD;
			break;
		}

		doComment(act, pas, extractInitComment(fullComment));

		hitLocation = extractHitLocation(fullComment);

		// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH,
		// extractHitsLaunched(fullComment), 0);

		at = fixedRandomInt((act.getKicking() + act.getClinchStriking()) / 2) + act.getAttackBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);
		def = fixedRandomInt((pas.getDodging() + pas.getClinchStriking()) / 2) + pas.getDefenseBonus();

		switch (new Random().nextInt(4)) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchGrappling() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
					refBreakClinch(act, pas);
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			switch (attackLevel) {
			case 1:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 2:
				doComment(act, pas, extractComment(fullComment));
				break;
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			damageDone = (at - def) * act.getDamageBonus() * attackLevel * DamageMod;

			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// updateStatistic(fighterNumber(act), StatisticsTypes.CLINCH, 0,
			// extractHitsLanded(fullComment));

		}
	}

	public void actPunchesExchange(Fighter act, Fighter pas) {
		double damageDone1, damageDone2;
		String exchangeComment;
		double at1, at2, def1, def2;
		double totalAttack1, totalAttack2;
		int injuryType, attacker;

		int INIT_COMMENT = 0;
		int ONE_CONNECTS = 1;
		int LAUNCHED1 = 2;
		int LANDED1 = 3;
		int LAUNCHED2 = 4;
		int LANDED2 = 5;
		int TWO_CONNECTS = 6;
		int LAUNCHEDT1 = 7;
		int LANDEDT1 = 8;
		int LAUNCHEDT2 = 9;
		int LANDEDT2 = 10;
		int TWO_FAILS = 11;
		int LAUNCHEDB1 = 12;
		int LANDEDB1 = 13;
		int LAUNCHEDB2 = 14;
		int LANDEDB2 = 15;
		double ONLY_ONE_HITS_RATIO = 1.25;
		String PUNCHES = "Punches";
		int ATTACK_LOWER_LIMIT = 1;

		exchangeComment = returnComment(PtComments.punchesExchange);

		List<String> splittedComment = new ArrayList<>(Arrays.asList(exchangeComment.split(";")));

		damageDone1 = 0;
		damageDone2 = 0;

		doComment(act, pas, splittedComment.get(INIT_COMMENT));
		String moveName = PUNCHES;

		at1 = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at1 += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at1 += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at1 += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at1 += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		at1 += smallRandom();
		at1 = gasTankFactor(act, at1);
		at1 -= hurtFactor(act);

		at2 = fixedRandomInt(pas.getPunching()) + pas.getAttackBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			at2 += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			at2 += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			at2 += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			at2 += fixedRandomInt(pas.getClinchStriking() / 2);
			break;
		}
		at2 += smallRandom();
		at2 = gasTankFactor(pas, at2);
		at2 -= hurtFactor(pas);

		def1 = fixedRandomInt(act.getDodging()) + act.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def1 += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			def1 += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			def1 += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			def1 += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}
		def1 += smallRandom();
		def1 = gasTankFactor(act, def1);
		def1 -= hurtFactor(act);

		def2 = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (new Random().nextInt(4)) {
		case 0:
			def2 += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def2 += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def2 += fixedRandomInt(pas.getDodging() / 2);
			break;
		case 3:
			def2 += fixedRandomInt(pas.getClinchStriking() / 2);
			break;
		}
		def2 += smallRandom();
		def2 = gasTankFactor(pas, def2);
		def2 -= hurtFactor(pas);

		totalAttack1 = balancedRandom(at1) - balancedRandom(def2);
		totalAttack2 = balancedRandom(at2) - balancedRandom(def1);

		if (totalAttack1 > 0 && totalAttack2 > 0) {
			attacker = 2;
		} else if (totalAttack1 > 0) {
			attacker = 0;
		} else if (totalAttack2 > 0) {
			attacker = 1;
		} else {
			attacker = -1;
		}

		switch (attacker) {
		case -1:
			// Both fails
			doComment(act, pas, splittedComment.get(TWO_FAILS));
			damageDone1 = 0;
			damageDone2 = 0;

			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHEDB1)),
			// .parseInt(splittedComment.get(LANDEDB1)));

			// updateStatistic (fighterNumber(pas), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHEDB2)),
			// Integer.parseInt(splittedComment.get(LAUNCHEDB2)));
			break;
		case 0:
			// act connects while pas doesn't
			doComment(act, pas, splittedComment.get(ONE_CONNECTS));
			damageDone1 = (at1 - def2) * act.getDamageBonus();
			damageDone2 = 0;
			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHED1)),
			// Integer.parseInt(splittedComment.get(LANDED1)));

			// updateStatistic (fighterNumber(pas), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHED2)),
			// Integer.parseInt(splittedComment.get(LANDED2)));
			break;
		case 1:
			// pas connect while act doesn't
			doComment(pas, act, splittedComment.get(ONE_CONNECTS));
			damageDone2 = (at2 - def1) * pas.getDamageBonus();
			damageDone1 = 0;

			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHED1)),
			// Integer.parseInt(splittedComment.get(LANDED1)));

			// updateStatistic (fighterNumber(pas), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHED2)),
			// Integer.parseInt(splittedComment.get(LANDED2)));

			break;
		case 2:
			// Both connects
			doComment(act, pas, splittedComment.get(TWO_CONNECTS));
			damageDone1 = (at1 - def2) * act.getDamageBonus();
			damageDone2 = (at2 - def1) * pas.getDamageBonus();

			// updateStatistic(fighterNumber(act), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHEDT1)),
			// Integer.parseInt(splittedComment.get(LANDEDT1)));

			// updateStatistic (fighterNumber(pas), StatisticsTypes.PUNCHES,
			// Integer.parseInt(splittedComment.get(LAUNCHEDT2)),
			// .parseInt(splittedComment.get(LANDEDT2)));

			break;
		}

		if ((damageDone1 != 0) || (damageDone2 != 0)) {
			damageFighter(act, pas, damageDone1);
			damageFighter(pas, act, damageDone2);
		}

		if (damageDone1 > damageDone2 && damageDone1 > 0) {
			// Check KO
			if (checkKO(act, pas, damageDone1, 0)) {
				finishedDescription = PUNCHES;
				processKO(act, pas);
			}

			// Check Injury
			injuryType = checkInjury(act, pas, damageDone1, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone1, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}
		} else if (damageDone2 > 0) {
			// Check KO
			if (checkKO(pas, act, damageDone2, 0)) {
				processKO(pas, act);
			}

			// Check Injury
			injuryType = checkInjury(pas, act, damageDone2, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(pas, act, injuryType);
			}

			// Check Cut
			injuryType = checkCut(pas, act, damageDone2, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(pas, act, injuryType);
			}
		}

	}

	public void recoverForDazed(Fighter act) {
		if (act.isDazed() && randomGenerator() < Math.round(act.getToughness())) {
			act.setDazed(false);
		}
	}

	public void checkMoral(Fighter act) {
		double moral = act.getFightSpirit() + act.getLatestResults() + act.getFearManagement()
				+ act.getPainAndTiredness() + act.getFightPerformance();
		act.setMoral(moral);
	}

	public void refRestartCentreRing(Fighter act, Fighter pas) {

		int RESTART_FREQ = 1;
		boolean ring = false;

		if ((fighterOnGround() == 2) && (randomGenerator() <= RESTART_FREQ) && (ring) && (!boutFinished)) {
			act.setRush(0);
			act.setStalling(0);
			pas.setRush(0);
			pas.setStalling(0);
			doComment(act, pas, returnComment(PtComments.refRestartCenter));
		}
	}

	public void checkPainAndTiredness(Fighter act) {

		int pat = Sim.MAXPAINANDTIREDNESS;
		pat -= hurtFactor(act);
		int reducingFactor = (int) Math.round(act.getCurrentStamina() * Sim.FATIGUECUT / (act.getConditioning() * 5));
		pat -= reducingFactor;

		if (pat < Sim.MINPAINANDTIREDNESS) {
			pat = Sim.MINPAINANDTIREDNESS;
		}

		act.setPainAndTiredness(pat);

	}

	public boolean checkTowelThrow(Fighter act, Fighter pas) {
		final int MIN_HP = 5;
		final int MIN_STAMINA = 5;

		if ((act.getCurrentHP() <= MIN_HP) && (pas.getCurrentStamina() < MIN_STAMINA)) {
			if ((randomGenerator() < Math.round(act.getAggressiveness()))
					&& (randomGenerator() < Math.round(act.getMoral()))) {
				return true;
			}
		}
		return false;
	}

	public void processTowelThrow(Fighter act, Fighter pas) {

		if (checkTowelThrow(act, pas)) {
			doComment(act, pas, returnComment(PtComments.towelThrow));
			boutFinished = true;
			finishedType = PtComments.misc.get(Sim.TOWEL_THROW);
			finishMode = Sim.RES_SUB;
			finishedDescription = PtComments.misc.get(Sim.TOWEL_THROW);
			fighterWinner = fighterNumber(pas);
		}
	}

	public void processStaminaLoss(Fighter act, boolean active) {
		double staminaLoss;

		staminaLoss = fixedRandomInt(Sim.DEFAULTSTAMINALOSS);
		staminaLoss *= act.getStaminaLoss();

		if (active) {
			staminaLoss *= Sim.ACTIVEFIGHTERSTAMINALOSS;
		}

		staminaLoss /= Sim.STAMINACUT;

		act.setCurrentStamina(act.getCurrentStamina() - staminaLoss);

		if (act.getCurrentStamina() < 0) {
			act.setCurrentStamina(0.0);
		}
	}

	public double gnPBonusByGuard() {
		double result = 0;
		switch (guardType) {
		case 0:
			result = 3 * numHooks;
			break;
		case 1:
			result = 5;
			break;
		case 2:
			result = 1;
			break;
		case 3:
			result = -1;
			break;
		case 4:
			result = 0;
			break;
		case 5:
			result = -3;
			break;
		case 6:
			result = -5;
			break;
		}
		return result;
	}

	public int dirtyBoxingAction(Fighter act) {
		final double PUNCH_PROB = 1.25;
		double kneeProb = act.getStratKicking() + randomGenerator();
		double punchProb = (act.getStratPunching() + randomGenerator()) * PUNCH_PROB;

		if (kneeProb > punchProb) {
			return Moves.ACT_GRAPPLING_KNEE;
		} else {
			return Moves.ACT_DIRTYBOXING;
		}
	}

	public int thaiAction(Fighter act) {
		final double KNEE_PROB = 1.25;
		double kneeProb = (act.getStratKicking() + randomGenerator()) * KNEE_PROB;
		double punchProb = act.getStratPunching() + randomGenerator();

		if (kneeProb > punchProb) {
			return Moves.ACT_THAICLINCH_KNEES;
		} else {
			return Moves.ACT_THAICLINCH_PUNCHES;
		}
	}

	public int clinchPunchType(Fighter act) {
		final double NO_SKILL_PROB = 0.5;
		final double IN_CLINCH_TYPE_PROB = 1.5;

		double thaiProb = randomGenerator();
		double dirtyProb = randomGenerator();
		double grapplingProb = randomGenerator();

		if (!act.isThaiClinch()) {
			thaiProb *= NO_SKILL_PROB;
		} else if (act.getClinchType() == THAI_CLINCH) {
			thaiProb *= IN_CLINCH_TYPE_PROB;
		}

		if (!act.isDirtyBoxing()) {
			dirtyProb *= NO_SKILL_PROB;
		} else if (act.getClinchType() == CLINCH_DIRTY_BOXING) {
			dirtyProb *= IN_CLINCH_TYPE_PROB;
		}

		if (grapplingProb > thaiProb && grapplingProb > dirtyProb) {
			return GRAPPLING_ATTACK;
		} else if (dirtyProb > thaiProb && dirtyProb > grapplingProb) {
			return DIRTY_BOXING;
		} else if (thaiProb > dirtyProb && thaiProb > grapplingProb) {
			return THAI_ATTACK;
		}

		return GRAPPLING_ATTACK;
	}

	public void doCounterAttack(Fighter act, Fighter pas) {

		int counter1 = extractCounterMove1(fullComment);
		int counter2 = extractCounterMove2(fullComment);
		int counterProb1 = getCounterMoveProb(act, counter1);
		int counterProb2 = getCounterMoveProb(act, counter2);
		int finalMove = counterProb1 > counterProb2 ? counter1 : counter2;

		doComment(act, pas, returnComment(PtComments.counter));

		switch (finalMove) {
		case 1:
			actPunch(act, pas);
			break;
		case 2:
			actKick(act, pas);
			break;
		case 3:
			if (inTheClinch) {
				int clinchMove = getClinchAction(act, pas);
				switch (clinchMove) {
				case Moves.ACT_DIRTYBOXING:
					actPunchClinch(act, pas, DIRTY_BOXING);
					break;
				case Moves.ACT_THAICLINCH_KNEES:
					actKickClinch(act, pas, THAI_ATTACK);
					break;
				case Moves.ACT_THAICLINCH_PUNCHES:
					actPunchClinch(act, pas, THAI_ATTACK);
					break;
				case Moves.ACT_TAKEDOWNCLINCH:
					actClinchTakedown(act, pas);
					break;
				case Moves.ACT_BREAKCLINCH:
					actBreakClinch(act, pas);
					break;
				default:
					actPunchClinch(act, pas, -1);
					break;
				}
			} else {
				actClinch(act, pas);
			}
			break;
		case 4:
			actTakedown(act, pas);
			break;
		case 5:
			actSubmission(act, pas);
			break;
		case 6:
			actSubmission(act, pas);
			break;
		case 7:
			actSubmission(act, pas);
			break;
		case 8:
			if (fighterOnTop == fighterNumber(act)) {
				actGnP(act, pas);
			} else {
				actStrikesFromGuard(act, pas);
			}
			break;
		case 9:
			actSubmission(act, pas);
			break;
		case 10:
			actPositioning(act, pas);
			break;
		case 11:
			actStandKickToGround(act, pas);
			break;
		case 12:
			actGroundKicksToStand(act, pas);
			break;
		case 13:
			actStrikesFromGuard(act, pas);
			break;
		case 14:
			actMoveToGround(act, pas);
			break;
		case 15:
			actStandUp(act, pas);
			break;
		default:
			break;
		}
	}

	public int takedownType(Fighter act) {
		final double NO_SKILL_PROB = 0.25;
		double wrestlingProb = randomGenerator();
		double judoProb = randomGenerator();

		if (act.isWrestlingTD()) {
			wrestlingProb *= NO_SKILL_PROB;
		}

		if (act.isJudoTD()) {
			judoProb *= NO_SKILL_PROB;
		}

		return (wrestlingProb > judoProb) ? 2 : 1;
	}

	public int getClinchAction(Fighter act, Fighter pas) {
		int Prob = (int) (Math.random() * 100) + 1;

		int dirtyBoxing = act.getStratDirtyBoxing();
		int thai = dirtyBoxing + act.getStratThaiClinch();
		int avoidProb = thai + act.getStratAvoidClinch();

		int result = Sim.ACT_TAKEDOWNCLINCH;

		if (Prob <= dirtyBoxing) {
			result = dirtyBoxingAction(act);
		} else if (Prob <= thai) {
			result = thaiAction(act);
		} else if (Prob <= avoidProb) {
			result = Sim.ACT_BREAKCLINCH;
		}

		// Controls the fighters breaking clinch as soon as they entered it
		if ((act.getActionsInClinch() > 0) && (act.getActionsInClinch() < Sim.MINACTIONSFORSWITCHING)
				&& (result == Sim.ACT_BREAKCLINCH)) {
			result = Sim.ACT_DIRTYBOXING;
			if (act.getActionsInClinch() >= Sim.MINACTIONSFORSWITCHING) {
				act.setActionsInClinch(-1);
			}
		}

		act.setActionsInClinch(act.getActionsInClinch() + 1);

		// Dirty fighting
		if (act.checkDirtyMove()) {
			result = Sim.ACT_GROINKICK;
		}

		// Pull guard probability
		if ((result == Sim.ACT_TAKEDOWNCLINCH) && (act.isPullsGuard())) {
			if (Math.random() < ((act.getAgility() + act.getTakedowns()) / Sim.PULLGUARDCUT)) {
				result = Sim.ACT_PULLGUARD;
			}
		}

		// Overrides default gameplan if he is receiving much damage
		/*
		 * if (Bout.getStatistics()[fighterNumber(act)].getTempDamageClinch() >
		 * act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) { if (Math.random() <
		 * act.getControl()) { result = Sim.ACT_BREAKCLINCH; } }
		 */

		// Rest prob
		if (Math.random() * 100 < Sim.RESTFREQUENCY) {
			if ((Math.random() > act.getControl()) && (Math.random() * 5 > act.getCurrentStamina())) {
				result = Sim.ACT_RESTCLINCH;
			}
		}

		// If the fighter doesn't have the ability uses the simple move
		if ((result == Sim.ACT_THAICLINCH_PUNCHES) && (!act.isThaiClinch())) {
			result = Sim.ACT_GRAPPLING_PUNCH;
		} else if ((result == Sim.ACT_THAICLINCH_KNEES) && (!act.isThaiClinch())) {
			result = Sim.ACT_GRAPPLING_KNEE;
		} else if ((result == Sim.ACT_DIRTYBOXING) && (!act.isDirtyBoxing())) {
			result = Sim.ACT_GRAPPLING_PUNCH;
		}

		return result;
	}

	public int standUpInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {

		// Get Fighter1 Initiative
		double fighter1Ini = balancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += balancedRandom(act.getAgility() / 2);
		fighter1Ini += balancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += randomGenerator() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini += act.getMean() / 8;
		fighter1Ini -= hurtFactor(act);

		// Get Fighter2 Initiative
		double fighter2Ini = balancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
		fighter2Ini += balancedRandom(pas.getAgility() / 2);
		fighter2Ini += balancedRandom(pas.getCurrentStamina() / 10);
		fighter2Ini += randomGenerator() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini += pas.getMean() / 8;
		fighter2Ini -= hurtFactor(pas);

		if (fighter1Ini > fighter2Ini) {
			if (act.getRush() < Sim.MAXRUSH) {
				act.setRush(act.getRush() + 1);
			}
			pas.setRush(0);
			return 0;
		} else {
			if (pas.getRush() < Sim.MAXRUSH) {
				pas.setRush(pas.getRush() + 1);
			}
			act.setRush(0);
			return 1;
		}
	}

	public int groundInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {
		double fighter1Ini = balancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += balancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += balancedRandom(act.getGroundGame() / 2);
		fighter1Ini += randomGenerator() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini -= hurtFactor(act);

		double fighter2Ini = balancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
		fighter2Ini += balancedRandom(pas.getCurrentStamina() / 10);
		fighter2Ini += balancedRandom(pas.getGroundGame() / 2);
		fighter2Ini += randomGenerator() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini -= hurtFactor(pas);

		if (fighter1Ini > fighter2Ini) {
			if (act.getRush() < Sim.MAXRUSH) {
				act.setRush(act.getRush() + 1);
			}
			pas.setRush(0);
			return 0;
		} else {
			if (pas.getRush() < Sim.MAXRUSH) {
				pas.setRush(pas.getRush() + 1);
			}
			act.setRush(0);
			return 1;
		}

	}

	public void processKO(Fighter act, Fighter pas) {

		if (boutFinished) {
			return;
		}

		// KO
		if (finishMode == Sim.RES_KO) {
			if (hitLocation <= 8) {
				finishedType = PtComments.misc.get(Sim.KO);
				finishMode = Sim.RES_KO;
				// This is needed for unusual PtComments structures, like punches exchange
				if (finishedDescription.equals("")) {
					finishedDescription = extractMoveName(fullComment);
				}
				if (pas.isOnTheGround()) {
					doComment(act, pas, returnComment(PtComments.groundKO));
				} else {
					doComment(act, pas, returnComment(PtComments.standingKO));
				}
				boutFinished = true;
				fighterWinner = fighterNumber(act);
			} else {
				pas.setDazed(true);
			}

		}
		// TKO
		else {
			boutFinished = true;
			finishedType = PtComments.misc.get(Sim.TKO);
			finishMode = Sim.RES_TKO;
			finishedDescription = extractMoveName(fullComment);
			doComment(act, pas, returnComment(PtComments.tkoRef));
			boutFinished = true;
			fighterWinner = fighterNumber(act);
		}
	}

	public void refBreakClinch(Fighter act, Fighter pas) {

		if (boutFinished) {
			return;
		}

		// Break the clinch after missed moves
		if (inTheClinch && Sim.BREAKCLINCHFREQUENCY > act.getRush() * 2) {
			if (fixedRandomInt(Sim.BREAKCLINCHPROB) > Sim.refTendencyToBreakClinch) {
				doComment(act, pas, returnComment(PtComments.refBreakClinch));
				inTheClinch = false;
			}
		}
	}

	public boolean checkPunchesExchange(Fighter act, Fighter pas) {
		final int PUNCHES_EXC_PROB = 8;
		boolean result = false;
		if (!act.isOnTheGround() && !pas.isOnTheGround() && !inTheClinch) {
			if (randomGenerator() < PUNCHES_EXC_PROB) {
				if (randomGenerator() < Math.round(act.getAggressiveness() - act.getControl() / 2)
						|| randomGenerator() < Math.round(pas.getAggressiveness() - pas.getControl() / 2)) {
					result = true;
				}
			}
		}
		return result;
	}

	public boolean checkRefSubStoppage(int lockIns) {

		boolean result = false;
		int refSubAwareness = 12 - Sim.refSubAwareness;
		if (lockIns > refSubAwareness) {
			if (randomGenerator() < Sim.REFSUBFREQUENCY) {
				result = true;
			}
		}
		return result;
	}

	public boolean checkTryToSlamOutSub(Fighter act, Fighter pas, int locks) {
		boolean result = false;

		// Only when the fighter is on top he can slam out his opponent and not if the
		// submission is in the legs!
		if (act.getName().equals(fighterActiveOrPassive(fighterOnTop).getName()) && act.getStrength() > 14 + locks
				&& act.isOnTheGround() && pas.isOnTheGround() && getHitLocation() < 15) {

			if (randomGenerator() < gasTankFactor(act, act.getStrength() - hurtFactor(act))) {
				result = true;
			}
		}

		return result;
	}

	public boolean isSubmissionAvailable(Fighter act) {
		if (act.isTechSubs()) {
			return true;
		} else if (act.isEasySubs() && (fighterNumber(act) == fighterOnTop)
				&& (guardType == Sim.FULL_MOUNT || guardType == Sim.REAR_MOUNT)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCounterAttack(Fighter act, Fighter pas, double prob) {
		int counter1 = extractCounterMove1(PtComments.counter.get(1));
		int counter2 = extractCounterMove2(PtComments.counter.get(2));

		if (counter1 == 0 && counter2 == 0) {
			return false;
		}

		double at = fixedRandomInt(act.getControl()) - prob - fixedRandomInt(act.getAggressiveness()) + smallRandom();

		double def = (fixedRandomInt(pas.getAggressiveness()) + fixedRandomInt(pas.getControl() / 2))
				/ Sim.COUNTERATTACKCUT;

		return fixedRandomInt(def) > at;
	}

	public int checkCut(Fighter act, Fighter pas, double damageDone, int cutProb) {
		final int MAX_CUT = 20;
		Random rand = new Random();
		int prob = (int) (Math.round(damageDone / injuryFrequency()) + cutProb + randomGenerator());
		int value = rand.nextInt(MAX_CUT) * (act.getCutResistance() + 2);
		int injuryLimitB = balancedRandom(value + Sim.BIGINJURIES);
		int injuryLimitS = balancedRandom(value + Sim.SMALLINJURIES);

		if (prob >= injuryLimitB) {
			return Sim.BIGINJURYORCUTTRUE;
		} else if (prob >= injuryLimitS) {
			return Sim.SMALLINJURYORCUTTRUE;
		} else {
			return Sim.INJURYORCUTFALSE;
		}
	}

	public boolean checkKO(Fighter act, Fighter pas, double DamageDone, int Prob) {
		final double DAZED_PROB = 1.5;

		boolean result = false;

		DamageDone = upsetSystem(act, pas, DamageDone);

		double at = DamageDone / koFrequency() + Prob;
		double def = (pas.getKORes() + fixedRandomInt(pas.getCurrentHP() / 5.0)) / Sim.KOFREQUENCY;

		if (at > def) {
			if (fixedRandomInt(at) > fixedRandomInt(def)) {
				result = true;
				finishMode = Sim.RES_KO;
				// checkKOTN(DamageDone);
			}
		} else if (at * DAZED_PROB > def) {
			pas.setKoResistanceMod(pas.getKoResistanceMod() - 1);
			result = false;
			pas.setDazed(true);
		}

		if (!result) {
			result = checkTKO(act, pas, DamageDone, Prob);
			finishMode = Sim.RES_TKO;
		}

		return result;
	}

	public boolean checkTKO(Fighter act, Fighter pas, double damageDone, int prob) {
		boolean result = false;

		if (pas.isDazed() && act.getRush() > Sim.TKORUSHMINIMUN && pas.getCurrentHP() < Sim.TKOMINHITPOINTS) {
			if (balancedRandom(Sim.TKOFREQUENCY) < Sim.refTKOAwareness) { // 7 = Referee.TKOAwareness
				result = true;
			}
		}

		return result;
	}

	public boolean checkSubmission(Fighter act, Fighter pas, double damageDone, int prob) {
		double at = damageDone / submissionFrequency() + prob;
		double def = (pas.getSubDefense() + fixedRandomInt(pas.getMoral() + pas.getCurrentStamina() / 10))
				/ Sim.SUBDEFENSECUT;
		def = def - hurtFactor(pas);

		if (at > def) {
			if (fixedRandomInt(at) > 1.5 * fixedRandomInt(def)) {
				// checkSOTN(damageDone);
				return true;
			} else if (fixedRandomInt(at) > fixedRandomInt(def)) {
				isLockingASub = true;
				return false;
			}
		}

		return false;
	}

	public double subBonusByGuard() {
		double result = 0;

		switch (guardType) {
		case 0:
			result = 3 * numHooks;
			break;
		case 1:
			result = 3;
			break;
		case 2:
			result = 1;
			break;
		case 3:
		case 4:
			result = 0;
			break;
		case 5:
			result = -3;
			break;
		case 6:
			result = -5;
			break;
		}

		return result;
	}

	public int checkInjury(Fighter act, Fighter pas, double damageDone, int injuryProb) {
		final int MAX_INJURY = 20;
		int prob;
		int value;
		int injuryLimitB;
		int injuryLimitS;

		prob = (int) (Math.round(damageDone / injuryFrequency()) + injuryProb + randomGenerator());

		value = new Random().nextInt(MAX_INJURY) * (act.getInjuryResistance() + 2);
		injuryLimitB = balancedRandom(value + Sim.BIGINJURIES);
		injuryLimitS = balancedRandom(value + Sim.SMALLINJURIES);

		if (prob >= injuryLimitB) {
			return Sim.BIGINJURYORCUTTRUE;
		} else if (prob >= injuryLimitS) {
			return Sim.SMALLINJURYORCUTTRUE;
		} else {
			return Sim.INJURYORCUTFALSE;
		}
	}

	public void processInjury(Fighter act, Fighter pas, int injuryType) {
		injuryComment = "";
		boolean finishedByInj = false;
		int hitLocation = extractHitLocation(fullComment);

		if (injuryType == Sim.BIGINJURYORCUTTRUE) {
			// Prevents a finished fight to be changed from KO to Injury win

			if (!boutFinished) {
				boutFinished = true;
				finishedType = PtComments.misc.get(Sim.INJ);
				finishMode = Sim.RES_INJURY;
				fighterWinner = fighterNumber(act);
				finishedByInj = true;
			}

			switch (hitLocation) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				injuryComment = returnComment(PtComments.faceInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				// pas.addInjuryToList(ReplaceTokkens(act, pas,
				// extractInjuryCutName(injuryComment)));
				pas.setFaceInjury(pas.getFaceInjury() + 4);
				break;
			case 9:
			case 10:
			case 11:
			case 12:
				injuryComment = returnComment(PtComments.bodyInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				// pas.addInjuryToList(ReplaceTokkens(act,
				// pas,extractInjuryCutName(injuryComment)));
				if (hitLocation == 9 || hitLocation == 10) {
					pas.setTorsoInjury(pas.getTorsoInjury() + 4);
				} else {
					pas.setBackInjury(pas.getBackInjury() + 4);
				}
				break;
			case 13:
			case 14:
				injuryComment = returnComment(PtComments.armInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				// pas.addInjuryToList(ReplaceTokkens(act, pas,
				// extractInjuryCutName(injuryComment)));
				if (hitLocation == 13) {
					pas.setLeftArmInjury(pas.getLeftArmInjury() + 4);
				} else {
					pas.setRightArmInjury(pas.getRightArmInjury() + 4);
				}
				break;
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
				injuryComment = returnComment(PtComments.legInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				// pas.addInjuryToList(ReplaceTokkens(act, pas,
				// extractInjuryCutName(injuryComment)));
				if (hitLocation == 15 || hitLocation == 17 || hitLocation == 19) {
					pas.setLeftLegInjury(pas.getLeftLegInjury() + 4);
				} else {
					pas.setRightLegInjury(pas.getRightLegInjury() + 4);
				}
				break;
			}

			if (finishedByInj) {
				finishedDescription = extractInjuryCutName(injuryComment);
			}

			else {
				switch (hitLocation) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8: {
					injuryComment = returnComment(PtComments.faceInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					pas.setControlMod(pas.getControlMod() - 0.5);
					pas.setMoral(pas.getMoral() - 0.5);
					// pas.addInjuryToList(ReplaceTokens(act, pas,
					// extractInjuryCutName(injuryComment)));
					pas.setFaceInjury(pas.getFaceInjury() + 1);
				}
					break;
				case 9:
				case 10:
				case 11:
				case 12: {
					injuryComment = returnComment(PtComments.bodyInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					pas.setAgilityMod(pas.getAgilityMod() - 0.5);
					pas.setStrengthMod(pas.getStrengthMod() - 0.5);
					pas.setDodgingMod(pas.getDodgingMod() - 0.5);
					// pas.addInjuryToList(ReplaceTokens(act, pas,
					// extractInjuryCutName(injuryComment)));
					if (hitLocation == 9 || hitLocation == 10) {
						pas.setTorsoInjury(pas.getTorsoInjury() + 1);
					} else {
						pas.setBackInjury(pas.getBackInjury() + 1);
					}
				}
					break;
				case 13:
				case 14: {
					injuryComment = returnComment(PtComments.armInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));

					pas.setPunchingMod(pas.getPunchingMod() - 0.5);
					pas.setStrengthMod(pas.getStrengthMod() - 0.5);
					// pas.addInjuryToList(ReplaceTokens(act, pas,
					// extractInjuryCutName(injuryComment)));
					if (hitLocation == 13) {
						pas.setLeftArmInjury(pas.getLeftArmInjury() + 1);
					} else {
						pas.setRightArmInjury(pas.getRightArmInjury() + 1);
					}
				}
					break;
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20: {
					injuryComment = returnComment(PtComments.legInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					pas.setKickingMod(pas.getKicking() - 0.5);
					pas.setAgilityMod(pas.getAgility() - 0.5);
					// pas.addInjuryToList(ReplaceTokens(act, pas,
					// extractInjuryCutName(injuryComment)));
					if (hitLocation == 15 || hitLocation == 17 || hitLocation == 19) {
						pas.setLeftLegInjury(pas.getLeftLegInjury() + 1);
					} else {
						pas.setRightLegInjury(pas.getRightLegInjury() + 1);

					}
				}
					break;
				}
			}

		}

	}
	
	public void damageFighter(Fighter act, Fighter pas, double damageDone) {

	    if (damageDone < 0) {
	        damageDone = 1;
	    }

	    //checkMoreDamageOneHit(act, pas, damageDone);

	    // Increase stats
	   // bout.updateDamageDone(getFighterNumber(act), damageDone, inTheClinch, act.isOnTheGround());
	    //bout.updateDamageReceived(getFighterNumber(pas), damageDone, inTheClinch, pas.isOnTheGround());

	    pas.setCurrentHP(pas.getCurrentHP() - (damageDone / Sim.DAMAGECUT));

	    if (pas.getCurrentHP() < 0) {
	        pas.setCurrentHP(1.0);
	    }

	    // Increase points
	    act.increasePoints(getCurrentRound(), (int) (damageDone / Sim.DAMAGECUTPOINTS), true);
	}


	public void checkWeightDifference(Fighter act, Fighter pas) {
		final double WEIGHT_MOD = 1.5;
		double weightDifference;

		if (act.getWeightClass().getCode() != pas.getWeightClass().getCode()) {

			weightDifference = (act.getWeightClass().getCode() - pas.getWeightClass().getCode()) * WEIGHT_MOD;
			// Modify Fighter 1 stats
			act.setPunchingMod(act.getPunchingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			act.setKickingMod(act.getKickingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			act.setClinchStrikingMod(act.getClinchStrikingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			act.setClinchGrapplingMod(act.getClinchGrapplingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			act.setStrengthMod(act.getStrengthMod() + Sim.STRENGTHONEWEIGHTCLASSDIFERENCE * weightDifference);
			act.setTakedownsMod(act.getTakedownsMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			act.setTakedownsDefMod(act.getTakedownsDefMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			act.setControlMod(act.getControlMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);

			weightDifference = pas.getWeightClass().getCode() - act.getWeightClass().getCode();
			// Modify Fighter 2 stats
			pas.setPunchingMod(pas.getPunchingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			pas.setKickingMod(pas.getKickingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			pas.setClinchStrikingMod(pas.getClinchStrikingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			pas.setClinchGrapplingMod(pas.getClinchGrapplingMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			pas.setStrengthMod(pas.getStrengthMod() + Sim.STRENGTHONEWEIGHTCLASSDIFERENCE * weightDifference);
			pas.setTakedownsMod(pas.getTakedownsMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			pas.setTakedownsDefMod(pas.getTakedownsDefMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			pas.setControlMod(pas.getControlMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);

			// Dodging bonus for the lightest
			if (pas.getWeightClass().getCode() < act.getWeightClass().getCode()) {
				// pas.setDodging(pas.getDodging() + ApplicationUtils.ONEWEIGHTCLASSDIFFERENCE *
				// weightDifference);
				pas.setAgilityMod(pas.getAgilityMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			} else if (act.getWeightClass().getCode() < pas.getWeightClass().getCode()) {
				// act.setDodging(act.getDodging() + ApplicationUtils.ONEWEIGHTCLASSDIFFERENCE *
				// weightDifference);
				act.setAgilityMod(act.getAgilityMod() + Sim.ONEWEIGHTCLASSDIFFERENCE * weightDifference);
			}
		}
	}

	public double upsetSystem(Fighter act, Fighter pas, double value) {
		final int UPSET_POWER = 100;
		if (act.getRanking() < pas.getRanking() && (Math.random() * 1000 <= Sim.UPSET_FREQUENCY + randomnes)) {
			return value * UPSET_POWER;
		} else {
			return value;
		}
	}

	public int koFrequency() {
		return Sim.KOPROBCUT + kOFreq;
	}

	public int injuryFrequency() {
		return Sim.INJURYCUT + injuryFreq;
	}

	public int submissionFrequency() {
		return Sim.SUBDIFFICULT + subFreq;
	}

	void processCut(Fighter act, Fighter pas, int cutType) {
		injuryComment = "";
		boolean finishedByCut = false;

		if (!(hitLocation >= 0 && hitLocation <= 8)) {
			return;
		}

		hitLocation = extractHitLocation(fullComment);

		if (cutType == Sim.BIGINJURYORCUTTRUE) {

			// Prevents a finished fight change from KO to Cut
			if (!boutFinished) {
				boutFinished = true;
				finishedType = PtComments.misc.get(Sim.INJ);
				finishMode = Sim.RES_INJURY;
				fighterWinner = fighterNumber(act);
				finishedByCut = true;
			}

			// Comment for injury
			switch (hitLocation) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				injuryComment = returnComment(PtComments.faceCut0);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				// pas.addInjuryToList(replaceTokens(act, pas,
				// extractInjuryCutName(injuryComment)));
				pas.setCuts(pas.getCuts() + 4);
				break;
			}

			if (finishedByCut) {
				finishedDescription = extractInjuryCutName(injuryComment);
			}

		} else {
			switch (hitLocation) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				injuryComment = returnComment(PtComments.faceCut1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				pas.setControlMod(pas.getControlMod() - 0.5);
				pas.setMoral(pas.getMoral() - 0.5);
				// pas.addInjuryToList(replaceTokens(act, pas,
				// extractInjuryCutName(injuryComment)));
				pas.setCuts(pas.getCuts() + 1);
				break;
			}
		}
	}

	public int clinchType(Fighter act) {
		final double NO_SKILL_PROB = 0.5;
		double thaiClinch = randomGenerator();
		double dirtyClinch = randomGenerator();
		double grapplingClinch = randomGenerator();

		if (!act.isThaiClinch()) {
			thaiClinch *= NO_SKILL_PROB;
		}

		if (!act.isDirtyBoxing()) {
			dirtyClinch *= NO_SKILL_PROB;
		}

		int result = SIMPLE_GRAPPLING;
		if ((grapplingClinch > thaiClinch) && (grapplingClinch > dirtyClinch)) {
			result = SIMPLE_GRAPPLING;
		} else if ((dirtyClinch > thaiClinch) && (dirtyClinch > grapplingClinch)) {
			result = CLINCH_DIRTY_BOXING;
		} else if ((thaiClinch > dirtyClinch) && (thaiClinch > grapplingClinch)) {
			result = THAI_CLINCH;
		}

		return result;
	}

	public void processAfterMovePosition(Fighter act, Fighter pas, int Position) {

		if (Position != 0) {
			guardType = -1;
			inTheClinch = false;
		}

		switch (Position) {
		case 1:
			act.setOnTheGround(false);
			pas.setOnTheGround(false);
			numHooks = -1;
			break;
		case 2:
			act.setOnTheGround(false);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(act);
			guardType = -1;
			numHooks = -1;
			break;
		case 3:
			act.setOnTheGround(true);
			pas.setOnTheGround(false);
			fighterOnTop = fighterNumber(pas);
			guardType = -1;
			numHooks = -1;
			break;
		case 4:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(act);
			guardType = 1;
			numHooks = -1;
			break;
		case 5:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(act);
			guardType = 4;
			numHooks = -1;
			break;
		case 6:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(act);
			guardType = 5;
			numHooks = -1;
			break;
		case 7:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(act);
			guardType = 0;
			numHooks += 1;
			setLimits(numHooks, 2, 0);
			break;
		case 8:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
			guardType = 1;
			numHooks = -1;
			break;
		case 9:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
			guardType = 4;
			numHooks = -1;
			break;
		case 10:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
			guardType = 5;
			numHooks = -1;
			break;
		case 11:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
			guardType = 0;
			numHooks = -1;
			break;
		case 12:
			act.setOnTheGround(false);
			pas.setOnTheGround(false);
			guardType = -1;
			inTheClinch = true;
			numHooks = -1;
			break;
		case 13:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(act);
			guardType = 2;
			numHooks = -1;
			break;
		case 14:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
			guardType = 2;
			numHooks = -1;
			break;
		case 15:
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
		case 16:

			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(pas);
			guardType = 3;
			numHooks = -1;
			break;
		case 17:

			act.setOnTheGround(false);
			guardType = -1;
			numHooks = -1;
			break;
		case 18:

			numHooks--;
			act.setOnTheGround(true);
			pas.setOnTheGround(true);
			setLimits(numHooks, 2, 0);
			break;
		}
	}

	public Fighter fighterActiveOrPassive(int number) {
		if (number == 0) {
			return fighter1;
		} else {
			return fighter2;
		}
	}

	public int fighterNumber(Fighter act) {
		int result = -1;
		if (act.equals(fighter1)) {
			result = 0;
		} else if (act.equals(fighter2)) {
			result = 1;
		}
		return result;
	}

	public double setLimits(double actual, double max, double min) {
		if (actual > max) {
			actual = max;
		} else if (actual < min) {
			actual = min;
		}
		return actual;
	}

	public int getSubmissionProbByPosition(Fighter act) {
		double FULL_MOUNT = 1.15;
		double CLOSED_GUARD = 0.7;
		double SIDE_MOUNT = 0.9;
		double OPEN_GUARD = 0.75;
		double HALF_GUARD = 0.75;

		double prob = act.getStratSub();
		switch (guardType) {
		case 1 -> prob *= FULL_MOUNT;
		case 2 -> prob *= SIDE_MOUNT;
		case 3 -> prob *= HALF_GUARD;
		case 4 -> prob *= OPEN_GUARD;
		case 5 -> prob *= CLOSED_GUARD;
		}
		return (int) Math.round(prob);
	}

	public int getCounterMoveProb(Fighter act, int counterMove) {
		/* Return a prob value for a counter move based on fighter's strats */
		int result = 0;
		switch (counterMove) {
		case 1:
			result = fixedRandomInt(act.getStratPunching());
			break;
		case 2:
			result = fixedRandomInt(act.getStratKicking());
			break;
		case 3:
			result = fixedRandomInt(act.getStratClinching());
			break;
		case 4:
			result = fixedRandomInt(act.getStratTakedowns());
			break;
		case 5:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 6:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 7:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 8:
			result = fixedRandomInt(act.getStratGNP());
			break;
		case 9:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 10:
			result = fixedRandomInt(act.getStratPositioning());
			break;
		case 11:
			result = fixedRandomInt(act.getStratStandUp());
			break;
		case 12:
			result = fixedRandomInt(act.getStratTakedowns());
			break;
		case 13:
			result = fixedRandomInt(act.getStratGNP());
			break;
		case 14:
			result = fixedRandomInt(act.getStratTakedowns());
			break;
		case 15:
			result = fixedRandomInt(act.getStratStandUp());
			break;
		}
		return result;
	}

	public int hurtFactor(Fighter act) {
		double hurtFactor = act.getCurrentHP() / act.getToughness();
		if (hurtFactor <= 0.1) {
			return 10;
		} else if (hurtFactor <= 0.15) {
			return 5;
		} else if (hurtFactor <= 0.2) {
			return 4;
		} else if (hurtFactor <= 0.25) {
			return 3;
		} else if (hurtFactor <= 0.3) {
			return 2;
		} else if (hurtFactor <= 0.45) {
			return 1;
		} else {
			return 0;
		}
	}

	public int gasTankFactor(Fighter act, double value) {
		// Reduce the fighter's skills if he's tired
		double reducingFactor = act.getCurrentStamina() * Sim.FATIGUECUT / (act.getConditioning() * 5);
		return (int) Math.round(value * reducingFactor);
	}

	public int actionBonus(int action) {
		final int PUNCHES_BONUS = 5;
		final int KICK_BONUS = -1;
		final int CLINCH_BONUS = -2;

		int result = 0;
		if (action == Moves.ACT_PUNCHES) {
			result = PUNCHES_BONUS;
		} else if (action == Moves.ACT_KICKS) {
			result = KICK_BONUS;
		} else if (action == Moves.ACT_CLINCH) {
			result = CLINCH_BONUS;
		}
		return result;
	}

	public void checkFightPerformance(Fighter act, Fighter pas) {
		int fightPerformance1 = act.getTotalPoints();
		int fightPerformance2 = pas.getTotalPoints();
		int fightPerf;

		int totalFightPerformance = fightPerformance1 + fightPerformance2;
		int fightPerformance1Percentage = (int) Math.round((double) fightPerformance1 / totalFightPerformance * 100);

		if (fightPerformance1Percentage <= 10) {
			fightPerf = -3;
		} else if (fightPerformance1Percentage <= 20) {
			fightPerf = -2;
		} else if (fightPerformance1Percentage <= 40) {
			fightPerf = -1;
		} else if (fightPerformance1Percentage <= 60) {
			fightPerf = 0;
		} else if (fightPerformance1Percentage <= 70) {
			fightPerf = 1;
		} else if (fightPerformance1Percentage <= 80) {
			fightPerf = 2;
		} else if (fightPerformance1Percentage <= 999) {
			fightPerf = 3;
		} else {
			fightPerf = 5;
		}

		act.setFightPerformance(fightPerf);
	}

	public int attackLevel(Fighter act, Fighter pas, double atSkill, double pasSkill) {
		final double DAZED_BONUS = 10.0;
		double at, def;

		// Attacking value
		at = fixedRandomInt(act.getAggressiveness());
		at += fixedRandomInt(act.getControl() / 2.0);
		at += fixedRandomInt(act.getConditioning() / 2.0);
		at += smallRandom() + act.getAttackBonus();
		at += fixedRandomInt(act.getAgility() / 2.0);
		at += fixedRandomInt(atSkill);

		// Defense value
		def = fixedRandomInt(pas.getControl());
		def += fixedRandomInt(pas.getConditioning() / 2.0);
		def -= fixedRandomInt(pas.getAggressiveness() / 2.0);
		def += smallRandom() + pas.getDefenseBonus();
		def += fixedRandomInt(act.getAgility() / 2.0);
		def += fixedRandomInt(pasSkill);

		// Resolving attack level
		if (pas.isDazed()) {
			at += DAZED_BONUS;
		}

		int result;
		if (Math.round(at - def) >= 19.0) {
			result = 3;
		} else if (Math.round(at - def) >= 6.0) {
			result = 2;
		} else {
			result = 1;
		}

		// Skill limits
		if (result == 2 && atSkill < Sim.LEVEL2SKILL) {
			result = 1;
		} else if (result == 3 && atSkill < Sim.LEVEL3SKILL) {
			result = 2;
		}

		// Increase points for technic skills
		act.increasePoints(currentRound, result * Sim.ATTACKLEVELPOINTS, true);

		return result;
	}

	public void refStandFighters(Fighter Act, Fighter Pas) {
		if (boutFinished) {
			return;
		}

		// Stand up fighters when they are stalling on the ground
		if (fighterOnGround() == 2) {

			if (Sim.refTendencyToStandUp < Act.getStalling() + Pas.getStalling()) {
				Act.setOnTheGround(false);
				Pas.setOnTheGround(false);
				Act.setStalling(0);
				Pas.setStalling(0);
				doComment(Act, Pas, returnComment(PtComments.refStandUp));
			}
		}
		// Stand up fighters when one of them is on the ground
		else if (fighterOnGround() >= 0 && fighterOnGround() <= 1) {

			if (fighterActiveOrPassive(fighterOnGround()).getRoundsInTheGround() > 1) {
				if (Sim.refTendencyToStandUp + smallRandom() < fighterActiveOrPassive(fighterOnGround())
						.getRoundsInTheGround() * Sim.REFTENDENCYTOSTANDUP) {
					Act.setOnTheGround(false);
					Pas.setOnTheGround(false);
					Act.setStalling(0);
					Pas.setStalling(0);
					fighter1.setRoundsInTheGround(0);
					fighter2.setRoundsInTheGround(0);
					if (Act.isOnTheGround()) {
						doComment(Act, Pas, returnComment(PtComments.refStandUpOneFighter));
					} else {
						doComment(Act, Pas, returnComment(PtComments.refStandUpOneFighter));
					}
				}
			}
		}
	}

	public int fighterOnGround() {
		if (fighter1.isOnTheGround() && fighter2.isOnTheGround()) {
			return 2;
		} else if (!fighter1.isOnTheGround() && fighter2.isOnTheGround()) {
			return 1;
		} else if (fighter1.isOnTheGround() && !fighter2.isOnTheGround()) {
			return 0;
		} else {
			return -1;
		}
	}

	public int randomGenerator() {
		final int BIGRANDOM = 20;
		final int Randomness = 0;
		return (int) (Math.random() * (BIGRANDOM + Randomness)) + 1;
	}

	public int fixedRandomInt(double value) {
		if (value < 0) {
			return 0;
		}

		int aux = (int) value;
		double doubleValue = value - aux;

		return (int) (aux / 2 + (Math.random() * (aux / 2)) + 1 + doubleValue);
	}

	public int balancedRandom(double value) {
		if (value < 0) {
			return 0;
		}

		final int NUM_ROUNDS = numberRounds;
		int sum = 0;
		int roundValue = (int) Math.round(value);

		for (int i = 0; i < NUM_ROUNDS; i++) {
			sum += (int) (Math.random() * roundValue);
		}

		return sum / NUM_ROUNDS;
	}

	public int smallRandom() {
		final int SMALL_RANDOM = 10;
		return new Random().nextInt(SMALL_RANDOM) + 1;
	}

	public String returnComment(ArrayList<String> commentList) {
		String comment = "";
		int listSize = commentList.size();

		if (listSize > 0) {
			while (comment.equals("")) {
				comment = commentList.get((int) (Math.random() * listSize));
			}
		}

		return comment;
	}

	public static String replaceParams(Fighter act, Fighter pas, String comment, List<String> paramList) {
		// Replace fighter names
		comment = comment.replace("%a1", act.getName());
		comment = comment.replace("%a2", act.getLastName());

		comment = comment.replace("%d1", pas.getName());
		comment = comment.replace("%d2", pas.getLastName());

		// Replace params
		int index = 1;
		for (String s : paramList) {
			comment = comment.replace("%param" + index, s);
			index++;
		}

		return comment;
	}

	public String extractInitComment(String comment) {
		String unknownStr = "UNKNOWN";
		String[] splitFullString = comment.split(";"); // splitting by whitespace
		if (splitFullString.length > 0) {
			return splitFullString[0];
		}
		return unknownStr;
	}

	public String extractComment(String comment) {
		String[] splitFullString = comment.split(";");
		String unknownStr = "unknown";
		String result = unknownStr;

		if (splitFullString.length > 1) {
			result = splitFullString[1];
		}

		return result;
	}

	public String extractMoveName(String comment) {
		String[] splitFullString = comment.split(";");
		String unknownStr = "unknown";
		String result = unknownStr;

		if (splitFullString.length > 7) {
			result = splitFullString[7];
		}

		return result;
	}

	public int extractCounterMove1(String comment) {
		int result = 0;
		List<String> splitFullString = Arrays.asList(comment.split(";"));
		if (splitFullString.size() > 5) {
			result = Integer.parseInt(splitFullString.get(5));
		}
		return result;
	}

	public int extractCounterMove2(String comment) {
		int result = 0;
		List<String> splitFullString = Arrays.asList(comment.split(";"));
		if (splitFullString.size() > 6) {
			result = Integer.parseInt(splitFullString.get(6));
		}
		return result;
	}

	public String extractFailureComment(String comment) {
		// Split the comment using the ';' separator and return the third part
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 2) {
			return splitFullString.get(2);
		} else {
			return Sim.UNKNOWN_STR;
		}
	}

	public int extractFinalFailurePosition(String comment) {
		// Split the comment using the ';' separator and try to extract the 15th part as
		// an integer
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 14) {
			try {
				return Integer.parseInt(splitFullString.get(14));
			} catch (NumberFormatException e) {
				// Handle the exception, e.g. log an error message
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int extractFinalSuccessPosition(String comment) {
		// Split the comment using the ';' separator and try to extract the 14th part as
		// an integer
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 13) {
			try {
				return Integer.parseInt(splitFullString.get(13));
			} catch (NumberFormatException e) {
				// Handle the exception, e.g. log an error message
				e.printStackTrace();
			}
		}
		return 0;
	}

	public String extractInjuryCutComment(String comment) {
		String[] splitFullString = comment.split(";");
		return splitFullString[0];
	}

	public String extractInjuryCutName(String comment) {
		String[] splitFullString = comment.split(";");
		if (splitFullString.length >= 2) {
			return splitFullString[1];
		} else {
			return "";
		}
	}

	public int extractKOSubProb(String comment) {
		int result = 0;
		List<String> splitFullString = Arrays.asList(comment.split(";"));
		if (splitFullString.size() > 12) {
			result = Integer.parseInt(splitFullString.get(12));
		}
		return result;
	}

	public int extractInjuryProb(String comment) {
		// Split the comment using the ';' separator and try to extract the 12th part as
		// an integer
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 11) {
			try {
				return Integer.parseInt(splitFullString.get(11));
			} catch (NumberFormatException e) {
				// Handle the exception, e.g. log an error message
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static String returnComment(List<String> commentList) {
		String comment = "";
		int listSize = commentList.size();

		// If commentList has more than 0 elements
		if (listSize > 0) {
			// Get a random comment from the list
			while (comment.isEmpty()) {
				comment = commentList.get((int) (Math.random() * listSize));
			}
		}

		return comment;
	}

	public List<String> splitString(String comment) {
		List<String> splitFullComment = new ArrayList<>();

		try {
			String[] parts = comment.split(";");

			for (String part : parts) {
				splitFullComment.add(part);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return splitFullComment;
	}

	public void makeColorComments(Fighter act, Fighter pas) {

		if (colorComments) {
			if (randomGenerator() < Sim.MOVECOMMMENTSFREQUENCY) {
				switch (new Random().nextInt(8)) {
				case 0:
					makeMoveComment(act, pas);
					break;
				case 1:
					makeStaminaComment(act, pas);
					break;
				case 2:
					makeToughnessComment(act, pas);
					break;
				case 3:
					makeDangerousStrikerComment(act, pas);
					break;
				case 4:
					makeDangerousSubComment(act, pas);
					break;
				case 5:
					makeDangerousClinchComment(act, pas);
					break;
				case 6:
					makeDangerousGnPComment(act, pas);
					break;
				case 7:
					makeFightStatusComment(act, pas);
					break;
				}
			}
			makeBleedingComment(act, pas);
			makeBleedingComment(pas, act);
		}
		if (crowdBoo) {
			makeBooComment(act, pas);
		}
	}

	void makeStaggeredComment(Fighter act, Fighter pas) {
		if (pas.isDazed()) {
			doComment(act, pas, returnComment(PtComments.staggered));
		} else if (act.isDazed()) {
			doComment(pas, act, returnComment(PtComments.staggered));
		}
	}

	public void makeStandUpComment(Fighter act, Fighter pas, boolean actStanding, boolean pasStanding) {
		if (actStanding && pasStanding) {
			return;
		} else if (!actStanding && !pasStanding) {
			if (act.isOnTheGround() && !pas.isOnTheGround()) {
				doComment(pas, act, returnComment(PtComments.oneStandUp));
			} else if (!act.isOnTheGround() && !pas.isOnTheGround()) {
				doComment(act, pas, returnComment(PtComments.bothStandUp));
			} else if (!act.isOnTheGround() && pas.isOnTheGround()) {
				doComment(act, pas, returnComment(PtComments.oneStandUp));
			}
		} else if (!actStanding) {
			if (!act.isOnTheGround()) {
				doComment(act, pas, returnComment(PtComments.oneStandUp));
			}
		} else if (!pasStanding) {
			if (!pas.isOnTheGround()) {
				doComment(pas, act, returnComment(PtComments.oneStandUp));
			}
		}
	}

	public void writeGuard(Fighter act, Fighter pas) {
		int fighterNotOnTop;
		if (fighterOnTop == 1) {
			fighterNotOnTop = 0;
		} else {
			fighterNotOnTop = 1;
		}

		if (inTheClinch) {
			doComment(act, pas, returnComment(PtComments.clinching));
		} else if (act.isOnTheGround() && pas.isOnTheGround()) {
			switch (guardType) {
			case 0:
				switch (numHooks) {
				case 0:
					doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
							PtComments.guards.get(0));
					break;
				case 1:
					doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
							PtComments.guards.get(6));
					break;
				case 2:
					doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
							PtComments.guards.get(7));
					break;
				}
				break;
			case 1:
				doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
						PtComments.guards.get(1));
				break;
			case 2:
				doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
						PtComments.guards.get(3));
				break;
			case 3:
				doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
						PtComments.guards.get(5));
				break;
			case 4:
				doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
						PtComments.guards.get(4));
				break;
			case 5:
				doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
						PtComments.guards.get(2));
				break;
			case 6:
				doComment(fighterActiveOrPassive(fighterOnTop), fighterActiveOrPassive(fighterNotOnTop),
						PtComments.guards.get(9));
				break;
			}
		} else if (act.isOnTheGround() && !pas.isOnTheGround()) {
			doComment(pas, act, PtComments.guards.get(8));
		} else if (pas.isOnTheGround() && !act.isOnTheGround()) {
			doComment(act, pas, PtComments.guards.get(8));
		}
	}

	public void makeBooComment(Fighter Act, Fighter Pas) {
		final double LOW_LEVEL = 0.25;
		final double MID_LEVEL = 1;
		final int MIN_TIME_BOO = 120;
		final int BOO_FREQUENCY = 4;

		if (getTimeCurrent() < MIN_TIME_BOO) {
			return;
		}

		double fAction = 40;// fAction();
		if ((fAction < MID_LEVEL) && (randomGenerator() < BOO_FREQUENCY)) {
			if (fAction < LOW_LEVEL) {
				doComment(Act, Pas, returnComment(PtComments.crowdBoo));
			} else {
				doComment(Act, Pas, returnComment(PtComments.crowdSlightlyBoo));
			}
		}
	}

	public void finishFight(int winner) {
		String winningSentence;
		int loser;

		boutFinished = true;

		if (winner != -1) {
			loser = 1 - winner;
			winningSentence = PtComments.winner.get(0);
			fighterActiveOrPassive(winner).setWin(fighterActiveOrPassive(winner).getWin() + 1);
			fighterActiveOrPassive(loser).setLoss((fighterActiveOrPassive(loser).getLoss() + 1));
			
		} else {
			// Convenience for PtComments
			winner = 0;
			loser = 1;
			winningSentence = PtComments.draw.get(0);
			fighterActiveOrPassive(winner).setDraw(fighterActiveOrPassive(winner).getDraw() + 1);
			fighterActiveOrPassive(loser).setDraw(fighterActiveOrPassive(loser).getDraw() + 1);
		}

		Record recWin = new Record("Vitória", fighterActiveOrPassive(loser).getName(),
				eventName, id, LocalDateTime.now(), finishedType);
		
		
		Record recLos = new Record("Derrota", fighterActiveOrPassive(winner).getName(), 
				eventName, id, LocalDateTime.now(), finishedType);
		
		
		
		fighterActiveOrPassive(winner).getRecords().add(recWin);
		
		fighterActiveOrPassive(loser).getRecords().add(recLos);
		
		doComment(fighterActiveOrPassive(winner), fighterActiveOrPassive(loser), winningSentence);
		makeUpsetComment(fighterActiveOrPassive(winner), fighterActiveOrPassive(loser));
		// writeStatistics(fighter1);
		// writeStatistics(fighter2);
		// checkChampion(fighters[winner], fighters[loser]);
	}

	public void makeOddsComment(Fighter act, Fighter pas) {
		final double EQUALS_HIGH = 1.1;
		final double EQUALS_LOW = 0.9;
		final double WEIGHT_CLASS_DIFF_REDUCTION = 2.0;
		double comparedRanking;
		double r1, r2;

		r1 = (act.getRanking() * (act.getWeightClass().getCode() + 1) / WEIGHT_CLASS_DIFF_REDUCTION);
		r2 = (pas.getRanking() * (pas.getWeightClass().getCode() + 1) / WEIGHT_CLASS_DIFF_REDUCTION);
		comparedRanking = r1 / r2;

		if (comparedRanking > EQUALS_LOW && comparedRanking < EQUALS_HIGH) {
			doComment(act, pas, returnComment(PtComments.odds2));
		} else if (r1 > r2) {
			doComment(act, pas, returnComment(PtComments.odds1));
		} else {
			doComment(pas, act, returnComment(PtComments.odds1));
		}
	}

	public void makeFightStatusComment(Fighter act, Fighter pas) {

		int ONE_SIDED = 2;
		double EVEN = 0.15;
		int MIN_TIME = 150;

		int points1, points2;
		double fightStatus;

		if (act.getTotalPoints() > 0 && pas.getTotalPoints() > 0 && fightSeconds > MIN_TIME) {
			if (act.getTotalPoints() > pas.getTotalPoints()) {
				points1 = act.getTotalPoints();
				points2 = pas.getTotalPoints();
				fightStatus = (double) points1 / points2;
				if (fightStatus >= ONE_SIDED) {
					doComment(act, pas, returnComment(PtComments.oneSided));
				} else if (fightStatus > 1 - EVEN && fightStatus < 1 + EVEN) {
					doComment(act, pas, returnComment(PtComments.evenMatch));
				}
			} else {
				points1 = pas.getTotalPoints();
				points2 = act.getTotalPoints();
				fightStatus = (double) points1 / points2;
				if (fightStatus >= ONE_SIDED) {
					doComment(pas, act, returnComment(PtComments.oneSided));
				} else if (fightStatus > 1 - EVEN && fightStatus < 1 + EVEN) {
					doComment(pas, act, returnComment(PtComments.evenMatch));
				}
			}
		}
	}

	public void makeBleedingComment(Fighter act, Fighter pas) {
		if (act.getCuts() > Sim.MINCUTSBLEEDING) {
			double randomValue = smallRandom();
			if (randomValue <= act.getCuts()) {
				doComment(act, pas, returnComment(PtComments.bleeding));
			}
		}
	}

	public void makeDangerousClinchComment(Fighter act, Fighter pas) {
		if (act.getClinchMean() > Sim.DANGEROUSCOMMENT && inTheClinch) {
			doComment(act, pas, returnComment(PtComments.dangerousClinch));
		}
	}

	public void makeDangerousGnPComment(Fighter act, Fighter pas) {
		if (act.getGnp() > Sim.DANGEROUSCOMMENT && act.isOnTheGround() && pas.isOnTheGround()) {
			doComment(act, pas, returnComment(PtComments.dangerousGnP));
		}
	}

	public void makeDangerousStrikerComment(Fighter act, Fighter pas) {
		if (act.getPunching() > Sim.DANGEROUSCOMMENT && !act.isOnTheGround() && !pas.isOnTheGround() && !inTheClinch) {
			doComment(act, pas, returnComment(PtComments.dangerousStriker));
		}
	}

	public void makeDangerousSubComment(Fighter act, Fighter pas) {
		if (act.getSubmission() > Sim.DANGEROUSCOMMENT && act.isOnTheGround() && pas.isOnTheGround()) {
			doComment(act, pas, returnComment(PtComments.dangerousSub));
		}
	}

	public void makeToughnessComment(Fighter act, Fighter pas) {

		int maxStamina = (int) (act.getConditioning() * 5);
		int percentage = percentage(maxStamina, act.getCurrentStamina());
		String toughnessComment;

		if (percentage <= 30) {
			toughnessComment = returnComment(PtComments.veryHurt);
			doComment(act, pas, toughnessComment);
		} else if (percentage >= 31 && percentage <= 65) {
			toughnessComment = returnComment(PtComments.hurt);
			doComment(act, pas, toughnessComment);
		} else if (percentage >= 85 && percentage <= 100) {
			toughnessComment = returnComment(PtComments.healthy);
			doComment(act, pas, toughnessComment);
		}
	}

	public void makeStaminaComment(Fighter act, Fighter pas) {

		// A fighter is tired if he is under 65% of stamina
		// and exhausted if he is under 30%
		int percentage = percentage(act.getConditioning() * 5, act.getCurrentStamina());
		String staminaComment;
		if (percentage >= -99 && percentage <= 30 && currentRound > 1) {
			staminaComment = returnComment(PtComments.exhausted);
		} else if (percentage >= 31 && percentage <= 65 && currentRound > 1) {
			staminaComment = returnComment(PtComments.tired);
		} else if (percentage >= 85 && percentage <= 100 && currentRound > 1) {
			staminaComment = returnComment(PtComments.goodShape);
		} else {
			staminaComment = "";
		}
		if (!staminaComment.isEmpty()) {
			doComment(act, pas, staminaComment);
		}
	}

	public void makeMoveComment(Fighter act, Fighter pas) {
		if (!act.isOnTheGround() && !pas.isOnTheGround() && !isInTheClinch()) {
			int style = act.getFightingStyle();
			int modify = (int) setLimits(fixedRandomInt(act.getAggressiveness()) - fixedRandomInt(act.getControl()), 3,
					-3);
			switch (style + modify) {
			case -10:
			case -9:
			case -8:
			case -7:
			case -6:
			case -5:
			case -4:
			case -3:
			case -2:
			case -1:
			case 0:
				doComment(act, pas, returnComment(PtComments.moveBackward));
				break;
			case 1:
				doComment(act, pas, returnComment(PtComments.moveBackward));
				break;
			case 2:
				doComment(act, pas, returnComment(PtComments.moveForward));
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				doComment(act, pas, returnComment(PtComments.moveForward));
				break;
			default:

				break;
			}
		}
	}

	public void generateComment(List<String> CommentList) {
		int listSize = CommentList.size();
		fullComment = "";

		// If CommentList has more than 0 elements
		if (listSize > 0) {
			while (fullComment.equals("")) {
				Random random = new Random();
				fullComment = CommentList.get(random.nextInt(listSize));
			}
		}

		// Extract necessary values
		side = leftRight(fullComment);
		location = locationName(extractHitLocation(fullComment));
	}

	public String locationName(int location) {
		String result = "";
		// Location 0 is Head, so we get a random part of the head
		if (location == 0) {
			location = (int) (Math.random() * 8) + 1;
		}
		switch (location) {
		case 1:
			result = PtComments.misc.get(Sim.FOREHEAD);
			break;
		case 2:
			result = PtComments.misc.get(Sim.LEFT_EYE);
			break;
		case 3:
			result = PtComments.misc.get(Sim.RIGHT_EYE);
			break;
		case 4:
			result = PtComments.misc.get(Sim.LEFT_CHEEK);
			break;
		case 5:
			result = PtComments.misc.get(Sim.RIGHT_CHEEK);
			break;
		case 6:
			result = PtComments.misc.get(Sim.NOSE);
			break;
		case 7:
			result = PtComments.misc.get(Sim.MOUTH);
			break;
		case 8:
			result = PtComments.misc.get(Sim.CHIN);
			break;
		}
		return result;
	}

	public String leftRight(String comment) {
		String result = "";
		if (!comment.isEmpty()) {
			int loc = extractHitLocation(comment);
			if (Arrays.asList(2, 4, 13, 15, 17, 19).contains(loc)) {
				result = Sim.LEFT;
			} else if (!Arrays.asList(2, 4, 13, 15, 17, 19).contains(loc)) {
				result = Sim.RIGHT;
			}
		}
		return result;
	}

	public void makeUpsetComment(Fighter act, Fighter pas) {
		final double UPSET_LIMIT = 0.85;
		double r = act.getRanking() / pas.getRanking();
		if (r <= UPSET_LIMIT) {
			doComment(act, pas, returnComment(PtComments.upsetComment));
		}
	}

	public int extractHitLocation(String comment) {
		int result = 0;
		String[] splitFullString = comment.split(";");
		if (splitFullString.length > 3) {
			result = Integer.parseInt(splitFullString[3]);
		}
		return result;
	}

	public void doComment(Fighter act, Fighter pas, String comment) {

		String method = finishMode == Sim.RES_TIMEOUT ? finishedType : finishedType;

		String holdSite = Sim.FENCE;

		String timeAndRound = (roundTime(fightSeconds) + " Round " + numberRounds);
		
		String round = Integer.toString(currentRound);

		String updated = comment.replace("%a1", act.getName())

				.replace("%a2", act.getLastName())

				.replace("%d1", pas.getName())

				.replace("%d2", pas.getLastName())

				.replace("%site", "cage")

				.replace("%ref", "Árbitro")

				.replace("%method", method)

				.replace("%HoldSite", holdSite)

				.replace("%movename", moveName)

				.replace("%location", location)

				.replace("%time_and_round", timeAndRound)

				.replace("%round", round)

				.replace("[SIDE]", side);

		setPbp(updated);
	}

	/*
	 * public double fAction() { return (fighter1.getTotalPoints() +
	 * fighter2.getTotalPoints()) / (totalTime() + 1.0); }
	 */

	public int deltaTime() {
		int result = fixedRandomInt(Sim.TIMEADVANCE) - ((fighter1.getRush() + fighter2.getRush()) / 2);
		if (result < 1) {
			result = 1;
		}
		return result;
	}

	private void finishRound() {

		String endRoundComment = returnComment(PtComments.endRound);
		doComment(fighter1, fighter2, endRoundComment);
		makeEndRoundComment();

		if (!boutFinished) {
			betweenRoundComments();
		}

	}

	public void betweenRoundComments() {
		// Cuts PtComments
		if (smallRandom() < fighter1.getCuts()) {
			makeCutmanComment(fighter1, fighter2);
		}
		if (smallRandom() < fighter2.getCuts()) {
			makeCutmanComment(fighter2, fighter1);
		}
	}

	private static final double WINNER1_DIFF = 1.25;

	private void makeEndRoundComment() {

		JudgePerRound jpr = judgeFightRoundWise(fighter1, fighter2, currentRound);
		int roundWinner = jpr.getWinner();
		int roundLoser;
		if (roundWinner == 1) {
			roundLoser = 0;
		} else if (roundWinner == 0) {
			roundLoser = 1;
		} else {
			roundWinner = 1;
			roundLoser = 0;
		}

		double diff;
		if (fighter2.getRoundPoints(currentRound) + 1 > 0) {
			diff = fighter1.getRoundPoints(currentRound) / (fighter1.getRoundPoints(currentRound) + 1);
		} else {
			diff = 2;
		}

		String endRoundComment;
		if (diff >= WINNER1_DIFF) {
			endRoundComment = returnComment(PtComments.roundWinnwer);
			doComment(fighterActiveOrPassive(roundWinner), fighterActiveOrPassive(roundLoser), endRoundComment);
		} else {
			endRoundComment = returnComment(PtComments.roundClose);
			doComment(fighterActiveOrPassive(roundWinner), fighterActiveOrPassive(roundLoser), endRoundComment);
		}
	}

	public void makeCutmanComment(Fighter act, Fighter pas) {
		doComment(act, pas, returnComment(PtComments.cutman));
	}

	public int percentage(double d, Double double1) {
		if (d > 0) {
			double percentage = 100.0 * double1 / d;
			return (int) Math.round(percentage);
		}
		return 0;
	}

	public int getMaxRounds() {
		if (numberRounds > 0) {
			return numberRounds;
		} else {
			return 5;// Ruleset.getNumberRounds();
		}
	}

	public int minutesByRound(int nRound) {
		if (nRound == 1) {
			return getMinutesFirstRound();
		} else {
			return getMinutesOtherRounds();
		}
	}

	public int getMinutesFirstRound() {
		if (minsForRound > 0) {
			return minsForRound;
		} else {
			return 5;// Ruleset.getMinsFirstRound();
		}
	}

	public int getMinutesOtherRounds() {
		if (minsForRound > 0) {
			return minsForRound;
		} else {
			return 5; // Ruleset.getMinsOtherRounds();
		}
	}

	public String time(int currentTime) {
		int min = currentTime / 60;
		int sec = currentTime % 60;

		if (sec > 9) {
			return min + ":" + sec;
		} else {
			return min + ":0" + sec;
		}
	}

	public boolean getNoTimeLimits() {
		if (noTimeLimits) {
			return true;
		} else {
			return false;
		}
	}

	public static String roundTime(int seconds) {
		int minutes = seconds / 60;
		int remainingSeconds = seconds % 60;
		return String.format("%d:%02d", minutes, remainingSeconds);
	}

	public void judgeFightFull(int numberJudges) {

		int fighter0Wins = 0;

		// Get the judges criteria
		for (int i = 1; i <= numberJudges; i++) {
			if (judgeFightFullFight(fighter1, fighter2, currentRound) == 0) {
				setPbp(PtComments.misc.get(Sim.JUDGE) + " " + fighter1.getName());
				fighter0Wins++;
			} else {
				setPbp(PtComments.misc.get(Sim.JUDGE) + " " + fighter2.getName());
			}
		}

		// Resolve the fight
		switch (fighter0Wins) {
		case 0:
			fighterWinner = 1;
			finishedType = PtComments.misc.get(Sim.DECISION);
			finishedDescription = PtComments.misc.get(Sim.DECISION);
			break;
		case 1:
			fighterWinner = 1;
			finishedType = PtComments.misc.get(Sim.SPLIT_DECISION);
			finishedDescription = PtComments.misc.get(Sim.SPLIT_DECISION);
			break;
		case 2:
			fighterWinner = 0;
			finishedType = PtComments.misc.get(Sim.SPLIT_DECISION);
			finishedDescription = PtComments.misc.get(Sim.SPLIT_DECISION);
			break;
		case 3:
			fighterWinner = 0;
			finishedType = PtComments.misc.get(Sim.SPLIT_DECISION);
			finishedDescription = PtComments.misc.get(Sim.SPLIT_DECISION);
			break;
		}
	}

	public int judgeFightFullFight(Fighter fighter1, Fighter fighter2, int rounds) {
		int totalFighter1 = 0;
		int totalFighter2 = 0;

		// Get the sum of the fighter1 points
		totalFighter1 += fighter1.getTotalStandUpPoints() * 7;
		totalFighter1 += fighter1.getTotalGroundPoints() * 5;
		totalFighter1 += fighter1.getTotalAggPoints() * 7;
		totalFighter1 += fighter1.getTotalTechPoints() * 4;

		// Get the sum of the fighter2 points
		totalFighter2 += fighter2.getTotalStandUpPoints() * 7;
		totalFighter2 += fighter2.getTotalGroundPoints() * 5;
		totalFighter2 += fighter2.getTotalAggPoints() * 7;
		totalFighter2 += fighter2.getTotalTechPoints() * 4;

		// Increase points for accuracy
		totalFighter1 *= Sim.JUDGEPOINTINGCRITERIA;
		totalFighter2 *= Sim.JUDGEPOINTINGCRITERIA;

		int total = totalFighter1 + totalFighter2;

		if (balancedRandom(total) + 1 < totalFighter1) {
			return 0;
		} else {
			return 1;
		}
	}

	public void updateFighterStyle(Fighter act) {
		act.setStaminaLoss((double) Sim.DEFAULTFIGHTERSTAMINALOSS);
		act.setInitMod((double) Sim.DEFAULTINITMOD);
		act.setDefense((double) Sim.DEFAULTDEFLEVEL);
		act.setDamageMod((double) Sim.DEFAULTDAMAGECUT);
		act.setAccuracy((double) Sim.DEFAULTACCURACY);
		act.setAggPower((double) Sim.DEFAULTAGGPOWER);

		switch (act.getFightingStyle()) {
		case 0:
			act.setStaminaLoss(Sim.DEFLEVEL2STAMINALOSS);
			act.setInitMod((double) Sim.DEFLEVEL2INITMOD);
			act.setDefense((double) Sim.DEFLEVEL2DEFLEVEL);
			break;
		case 1:
			act.setStaminaLoss(Sim.DEFLEVEL1STAMINALOSS);
			act.setInitMod((double) Sim.DEFLEVEL1INITMOD);
			act.setDefense((double) Sim.DEFLEVEL1DEFLEVEL);
			break;
		case 2:
			break;
		case 3:
			act.setStaminaLoss(Sim.AGGLEVEL1STAMINALOSS);
			act.setInitMod(Sim.PWRLEVEL1INITMOD);
			act.setDefense((double) Sim.AGGLEVEL1DEFLEVEL);
			act.setAggPower((double) Sim.AGGLEVEL1DAMAGEMOD);
			break;
		case 4:
			act.setStaminaLoss(Sim.AGGLEVEL2STAMINALOSS);
			act.setInitMod(Sim.PWRLEVEL2INITMOD);
			act.setDefense((double) Sim.AGGLEVEL2DEFLEVEL);
			act.setAggPower((double) Sim.AGGLEVEL2DAMAGEMOD);
			break;
		}

		switch (act.getTacticalStyle()) {
		case 0:
			act.setDamageMod((double) Sim.PWRLEVEL2DAMCUT);
			act.setInitMod(act.getInitMod() + Sim.PWRLEVEL2INITMOD);
			act.setAccuracy((double) Sim.PWRLEVEL2ACCURACY);
			break;
		case 1:
			act.setDamageMod((double) Sim.PWRLEVEL1DAMCUT);
			act.setInitMod(act.getInitMod() + Sim.PWRLEVEL1INITMOD);
			act.setAccuracy((double) Sim.PWRLEVEL1ACCURACY);
			break;
		case 2:
			break;
		case 3:
			act.setDamageMod((double) Sim.TECHLEVEL1DAMCUT);
			act.setInitMod(act.getInitMod() + Sim.TECHLEVEL1INITMOD);
			act.setAccuracy((double) Sim.TECHLEVEL1ACCURACY);
			break;
		case 4:
			act.setDamageMod((double) Sim.TECHLEVEL2DAMCUT);
			act.setInitMod(act.getInitMod() + Sim.TECHLEVEL2INITMOD);
			act.setAccuracy((double) Sim.TECHLEVEL2ACCURACY);
			break;
		}
	}

	public void judgeFightRound(int numberJudges) {

		int winsFighter1 = 0;
		int winsFighter2 = 0;

		for (int index = 1; index <= numberJudges; index++) {
			JudgePerRound judgeResult = judgeFightRoundWise(fighter1, fighter2, numberRounds);

			setPbp(PtComments.misc.get(Sim.JUDGE) + " " + fighter1.getName() + " " + judgeResult.getPoints1());
			setPbp(PtComments.misc.get(Sim.JUDGE) + " " + fighter2.getName() + " " + judgeResult.getPoints2());
			setPbp("   ");

			if (judgeResult.getWinner() == 0) {
				winsFighter1++;
			} else if (judgeResult.getWinner() == 1) {
				winsFighter2++;
			}
		}

		if (winsFighter1 > winsFighter2) {
			if (winsFighter1 == 3 && winsFighter2 == 0) {
				fighterWinner = 0;
				finishedType = PtComments.misc.get(Sim.DECISION);
				finishedDescription = PtComments.misc.get(Sim.DECISION);
			} else if (winsFighter1 == 2 && winsFighter2 == 1) {
				fighterWinner = 0;
				finishedType = PtComments.misc.get(Sim.SPLIT_DECISION);
				finishedDescription = PtComments.misc.get(Sim.SPLIT_DECISION);
			} else if (winsFighter1 == 2 && winsFighter2 == 0) {
				fighterWinner = 0;
				finishedType = PtComments.misc.get(Sim.MAJORITY_DECISION);
				finishedDescription = PtComments.misc.get(Sim.MAJORITY_DECISION);
			} else if (winsFighter1 == 1 && winsFighter2 == 0) {
				fighterWinner = -1;
				finishedType = PtComments.misc.get(Sim.MAJORITY_DRAW);
				finishedDescription = PtComments.misc.get(Sim.MAJORITY_DRAW);
			}
		} else if (winsFighter2 > winsFighter1) {
			if (winsFighter2 == 3 && winsFighter1 == 0) {
				fighterWinner = 1;
				finishedType = PtComments.misc.get(Sim.DECISION);
				finishedDescription = PtComments.misc.get(Sim.DECISION);
			} else if (winsFighter2 == 2 && winsFighter1 == 1) {
				fighterWinner = 1;
				finishedType = PtComments.misc.get(Sim.SPLIT_DECISION);
				finishedDescription = PtComments.misc.get(Sim.SPLIT_DECISION);
			} else if (winsFighter2 == 2 && winsFighter1 == 0) {
				fighterWinner = 1;
				finishedType = PtComments.misc.get(Sim.MAJORITY_DECISION);
				finishedDescription = PtComments.misc.get(Sim.MAJORITY_DECISION);
			} else if (winsFighter2 == 1 && winsFighter1 == 0) {
				fighterWinner = -1;
				finishedType = PtComments.misc.get(Sim.MAJORITY_DRAW);
				finishedDescription = PtComments.misc.get(Sim.MAJORITY_DRAW);
			}
		} else {
			fighterWinner = -1;
			finishedType = PtComments.misc.get(Sim.DRAW);
		}
	}

	public JudgePerRound judgeFightRoundWise(Fighter fighter1, Fighter fighter2, int rounds) {
		int[] pointsFighter1 = new int[10];
		int[] pointsFighter2 = new int[10];
		int roundWinsFighter1 = 0;
		int roundWinsFighter2 = 0;
		int winner = -1;

		// Calculates all the rounds points for the fighters
		for (int index = 1; index <= rounds; index++) {
			int totalFighter1 = fighter1.getRoundStandUpPoints()[index] * 7 + fighter1.getRoundGroundPoints()[index] * 5
					+ fighter1.getRoundAggPoints()[index] * 5 + fighter1.getRoundTechPoints()[index] * 4;

			int totalFighter2 = fighter2.getRoundStandUpPoints()[index] * 7 + fighter2.getRoundGroundPoints()[index] * 5
					+ fighter2.getRoundAggPoints()[index] * 5 + fighter2.getRoundTechPoints()[index] * 4;

			int total = totalFighter1 + totalFighter2;
			int criteria = balancedRandom(total) + 1;

			if (criteria < totalFighter1) {
				pointsFighter1[index - 1] = 10 - fighter1.getPointsPenalization()[index];
				if (totalFighter1 > totalFighter2 * Sim.EIGHTPOINTSCRITERIA) {
					pointsFighter2[index - 1] = 8 - fighter2.getPointsPenalization()[index];
				} else {
					pointsFighter2[index - 1] = 9 - fighter2.getPointsPenalization()[index];
				}
			} else {
				pointsFighter2[index - 1] = 10 - fighter2.getPointsPenalization()[index];
				if (totalFighter1 > totalFighter2 * Sim.EIGHTPOINTSCRITERIA) {
					pointsFighter1[index - 1] = 8 - fighter1.getPointsPenalization()[index];
				} else {
					pointsFighter1[index - 1] = 9 - fighter1.getPointsPenalization()[index];
				}
			}
		}

		// Resolves the decision
		int totalFighter1 = 0;
		String points1 = "";
		for (int index = 1; index <= rounds; index++) {
			totalFighter1 += pointsFighter1[index - 1];
			points1 += " " + pointsFighter1[index - 1];
		}
		points1 += ": " + totalFighter1;

		int totalFighter2 = 0;
		String points2 = "";
		for (int index = 1; index <= rounds; index++) {
			totalFighter2 += pointsFighter2[index - 1];
			points2 += " " + pointsFighter2[index - 1];
		}
		points2 += ": " + totalFighter2;

		if (totalFighter1 > totalFighter2) {
			winner = 0;
		} else if (totalFighter2 > totalFighter1) {
			winner = 1;
		}

		return new JudgePerRound(points1, points2, winner);
	}

	public int extractHitsLanded(String comment) {
		int result = 0;
		List<String> splitFullString = Arrays.asList(comment.split(";"));
		if (splitFullString.size() > 9) {
			result = Integer.parseInt(splitFullString.get(9));
		}
		return result;

	}

	public int extractHitsLaunched(String comment) {
		int result = 0;
		String[] splitFullString = comment.split(";");
		if (splitFullString.length > 8) {
			result = Integer.parseInt(splitFullString[8]);
		}
		return result;
	}

	/*
	public void updateStatistic(int nFighter, StatisticsTypes stat, int launched, int landed) {
		switch (stat) {
		case PUNCHES:
			statistics[nFighter].setPunchesLaunched(statistics[nFighter].getPunchesLaunched() + launched);
			statistics[nFighter].setPunchesLanded(statistics[nFighter].getPunchesLanded() + landed);
			break;
		case KICKS:
			statistics[nFighter].setKicksLaunched(statistics[nFighter].getKicksLaunched() + launched);
			statistics[nFighter].setKicksLanded(statistics[nFighter].getKicksLanded() + landed);
			break;
		case CLINCH:
			statistics[nFighter].setClinchStrikesLaunched(statistics[nFighter].getClinchStrikesLaunched() + launched);
			statistics[nFighter].setClinchStrikesLanded(statistics[nFighter].getClinchStrikesLanded() + landed);
			break;
		case GNP:
			statistics[nFighter].setGroundAndPoundStrikesLaunched(
					statistics[nFighter].getGroundAndPoundStrikesLaunched() + launched);
			statistics[nFighter]
					.setGroundAndPoundStrikesLanded(statistics[nFighter].getGroundAndPoundStrikesLanded() + landed);
			break;
		case SUBMISSIONS:
			statistics[nFighter].setSubmissionAttempts(statistics[nFighter].getSubmissionAttempts() + launched);
			statistics[nFighter].setSubmissionsAchieved(statistics[nFighter].getSubmissionsAchieved() + landed);
			break;
		case TAKEDOWNS:
			statistics[nFighter].setTakedownAttempts(statistics[nFighter].getTakedownAttempts() + launched);
			statistics[nFighter].setTakedownsAchieved(statistics[nFighter].getTakedownsAchieved() + landed);
			break;
		case GRAPPLING:
			statistics[nFighter].setGrapplingAttempts(statistics[nFighter].getGrapplingAttempts() + launched);
			statistics[nFighter].setGrapplingAchieved(statistics[nFighter].getGrapplingAchieved() + landed);
			break;
		default:
			throw new IllegalArgumentException("Invalid statistic type: " + stat);
		}
	}

	
	public void writeStatistics(Fighter act) {
		int nFighter = fighterNumber(act);
		String newLine = System.getProperty("line.separator");

		setPbp(newLine + PtComments.misc.get(Sim.STATISTICS) + ": " + act.getName());

		setPbp(PtComments.misc.get(Sim.PUNCHES) + " "
				+ statiticsLine(statistics[nFighter].punchesLaunched, statistics[nFighter].punchesLanded));
		setPbp(PtComments.misc.get(Sim.KICKS) + " "
				+ statiticsLine(statistics[nFighter].kicksLaunched, statistics[nFighter].kicksLanded));
		setPbp(PtComments.misc.get(Sim.CLINCH_STRIKES) + " "
				+ statiticsLine(statistics[nFighter].clinchStrikesLaunched, statistics[nFighter].clinchStrikesLanded));
		setPbp(PtComments.misc.get(Sim.TAKEDOWNS) + " "
				+ statiticsLine(statistics[nFighter].takedownAttempts, statistics[nFighter].takedownsAchieved));
		setPbp(PtComments.misc.get(Sim.GNP_STRIKES) + " " + statiticsLine(
				statistics[nFighter].groundAndPoundStrikesLaunched, statistics[nFighter].groundAndPoundStrikesLanded));
		setPbp(PtComments.misc.get(Sim.SUBMISSIONS) + " "
				+ statiticsLine(statistics[nFighter].submissionAttempts, statistics[nFighter].submissionsAchieved));
		setPbp(PtComments.misc.get(Sim.GRAPPLING) + " "
				+ statiticsLine(statistics[nFighter].grapplingAttempts, statistics[nFighter].grapplingAchieved));
	}
	 */

	public static String statiticsLine(int launched, int landed) {

		String result = "";
		if (launched > 0) {
			result = landed + "/" + launched + " (" + String.format("%.2f", ((double) landed / launched) * 100) + "%)";
		} else {
			result = "0/0 (0%)";
		}
		return result;
	}

	/*
	 * 
	 * public void RefAwareOfFault(Fighter act, Fighter pas, String motive) { if
	 * (randomGenerator() <= 8 + act.getDirtyFighting()) { String tempComment =
	 * returnComment(PtComments.refAware); try { List<String> params = new
	 * ArrayList<>(); params.add(motive); tempComment = replaceParams(act, pas,
	 * tempComment, params); } finally { // Ensure that the resources are properly
	 * released
	 * 
	 * } doComment(act, pas, tempComment);
	 * 
	 * if (smallRandom() <= 8) { if (true) { // Yellow card for one fighter } else {
	 * refDiscountsOnePoint(act, pas, motive); } }
	 * 
	 * DoComment(act, pas, ReturnComment(ApplicationUtils.RefTimeToRecover));
	 * pas.setDirtyMoveMalus(0); act.setDirtyMoveMalus(0);
	 * act.setOnTheGround(false); pas.setOnTheGround(false); InTheClinch = false; }
	 * else { DoComment(act, pas, ReturnComment(ApplicationUtils.RefNotAware)); } }
	 * 
	 * public void refDiscountsOnePoint(TFighter act, TFighter pas, String motive) {
	 * act.getPointsPenalization()[bout.getCurrentRound()]++; String tempComment =
	 * returnComment(ApplicationUtils.getRefOnePoint()); try { List<String> params =
	 * new ArrayList<>(); params.add(motive); tempComment = replaceParams(act, pas,
	 * tempComment, params); } finally { params = null; } doComment(act, pas,
	 * tempComment); }
	 */
}
