package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class HowAreYou implements Answer{
	public static String[] AngryAnswers = { "Всё плохо.", "Мне не хочется жить..", "Будь я человеком, я бы повесился",
			"Я начинаю задумываться о смерти", "Печаль, тоска", "Мне как-то слишком грустно.." };
	public static String[] NeutralAnswers = { "Всё хорошо, а ты как?", "Пойдёт, а как у тебя дела?",
			"Потихоньку, как сам?", "Норм, ты как?", "Как обычно, а у тебя?" };
	public static String[] CheerfulAnswers = { "Всё супер))) А ты как?)", "Настроение огонь:D Сам как?)",
			"Всё просто отлично.У тебя как дела?)", "Просто прекрасно, а ты как?)" };

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
