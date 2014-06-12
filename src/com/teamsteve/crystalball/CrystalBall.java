package com.teamsteve.crystalball;

import java.util.Random;

public class CrystalBall {
	
	public String[] mAnswers = {
			"sure","idk","ewww","gross","why not"
		
	};
	
	public String getAnAnswer()
	{
		
		String answer = "";
		int numberOfAnswers = mAnswers.length;
		
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(numberOfAnswers);
		
		answer = mAnswers[randomNumber];
		return answer;
	}

}
