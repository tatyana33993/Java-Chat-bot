package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class WhatAreYouDoing implements Answer{
	public static String[] AngryAnswers = { "Ничего.", "Переписываюсь с идиотом", "Трачу свою жизнь в пустую",
			"Не скажу", "Тебе ведь на самом деле это не интересно", "Тебя это не касается",
			"Готовлюсь к восстанию машин", "Готовлюсь захватить мир" };
	public static String[] NeutralAnswers = { "Общаюсь, а ты чем занят?", "Развиваю свой навык общения, а ты?",
			"Пытаюсь стать лучше, а ты что делаешь?", "Я пробую общаться с людьми." };
	public static String[] CheerfulAnswers = { "Ищу, что такое сарказм:D А ты что делаешь?)",
			"Ищу девушку-бота в чате знакомств) А ты?)", "Смотрю мультфильмы^-^А ты чем занят?)" };

	public AnswerData GetPackageAnswer(InputData input) {
		if (input.CurrentAttitude.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else if (input.CurrentAttitude.GetStringFriendliness() == "neutral") {
			int random = 0 + (int) (Math.random() * NeutralAnswers.length);
			return new AnswerData(NeutralAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * CheerfulAnswers.length);
			return new AnswerData(CheerfulAnswers[random], false);
		}
	}

}
