package answers;

import java.text.SimpleDateFormat;
import java.util.Date;
import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class WhatDay implements Answer {
	public static String[] AngryAnswers = { "У тебя что телефона нет?", "В углу экрана посмотри" };

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		Date date = new Date();
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else {
			return new AnswerData(new SimpleDateFormat("'Сегодня' EE dd.MM.yyyy").format(date), false);
		}
	}
}
