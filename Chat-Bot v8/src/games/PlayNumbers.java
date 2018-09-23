package games;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class PlayNumbers implements Answer{
	
	public static int UnknownNumber = (int)Math.floor(Math.random() * 100);
	
	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		return new AnswerData("Хорошо давай сыграем. Ты хочешь отгадывать или загадывать?", false);
	}
}
