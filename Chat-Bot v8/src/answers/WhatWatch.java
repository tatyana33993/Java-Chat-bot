package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class WhatWatch implements Answer{ 
	public static String[] AngryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
	"Давай как-нибудь сам" };
	public static String[] NeutralAnswers = { "Что ты хочешь посмотреть: фильм, мультфильм или сериал?" };
	
	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * NeutralAnswers.length);
			return new AnswerData(NeutralAnswers[random], false);
		}
	}
}
