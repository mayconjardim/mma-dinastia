package com.mmadinastia.domain.utils;

import lombok.Data;

@Data
public class JudgePerRound {

	public String points1;
	public String points2;
	public int winner;

	public JudgePerRound(String points1, String points2, int winner) {
		super();
		this.points1 = points1;
		this.points2 = points2;
		this.winner = winner;
	}

}
