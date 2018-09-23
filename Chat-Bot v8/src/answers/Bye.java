package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class Bye implements Answer{

	public static String[] AngryAnswers = { "Прощай, надеюсь больше не увидимся", "Пока, лучше больше не пиши мне", "Ну наконец-то, а то я так устал от общения с тобой", "Пока" };
	public static String[] NeutralAnswers = { "Пока, дружище. Рад был тебя видеть", "До встречи, надеюсь, что она будет очень скоро", "Пока. Удачи тебе:)"};
	public static String[] CheerfulAnswers = { "Иди, но обещай вернуться:D", "Чао)))", "До скорой встречи, дружище)"};

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else if (a.GetStringFriendliness() == "neutral") {
			int random = 0 + (int) (Math.random() * NeutralAnswers.length);
			return new AnswerData(NeutralAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * CheerfulAnswers.length);
			return new AnswerData(CheerfulAnswers[random], false);
		}
	}
}
