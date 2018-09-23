package games;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class MakeGuessNumbers implements Answer{
	public AnswerData GetPackageAnswer(Attitude a, String textMessage) { 
		return new AnswerData("Я пока так не умею.", false);
	}

}
