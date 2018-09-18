package answers;

import bot.Answer;
import bot.Attitude;

public class Hello implements Answer{
	public static String[] AngryAnswers = {
			"Привет, землянин:D Я чат-бот Макс. Чтобы узнать, что я могу, просто спроси: \"Что ты можешь?\"",
			"Приветик. Я Максимка. Спроси меня: \"Что ты можешь?\" и я тут же расскажу тебе о своих крутых навыках" };
	public static String[] NeutralAnswers = {
			"Здравствуйте, меня зовут Максим. Если хотите узнать мои навыки, спросите \"Что ты можешь?\"",
			"Здравствуй, человек! Я дружелюбный бот Максим. Если хочешь узнать, что я умею, спроси: \"Что ты умеешь?\"" };
	public static String[] CheerfulAnswers = { "Привет, я Максим. Может ты уже спросишь меня: \"Что ты умеешь?\"" };

	public String GetAnswer(Attitude a) {
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return AngryAnswers[random];
		} else if (a.GetStringFriendliness() == "neutral") {
			int random = 0 + (int) (Math.random() * NeutralAnswers.length);
			return NeutralAnswers[random];
		} else {
			int random = 0 + (int) (Math.random() * CheerfulAnswers.length);
			return CheerfulAnswers[random];
		}
	}
}
