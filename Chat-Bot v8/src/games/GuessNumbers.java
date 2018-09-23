package games;

import java.util.regex.Pattern;
import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class GuessNumbers implements Answer {

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {

		Pattern pattern1 = Pattern.compile("отгадывать");
		Pattern pattern2 = Pattern.compile("\\d+");

		if (pattern1.matcher(textMessage).find()) {
			return new AnswerData(
					"Окей.Я загадал число от 0 до 100:) Твоя задача его отгадать))) Не бойся я буду давать подсказки:D Вот первая: Введи число:)",
					true);
		} else if (pattern2.matcher(textMessage).find()) {
			String number = textMessage.replaceAll("[^0-9]", "");
			int UserNumber = Integer.parseInt(number);
			if (UserNumber > PlayNumbers.UnknownNumber) {
				return new AnswerData("Моё число меньше.", true);
			} else if (UserNumber < PlayNumbers.UnknownNumber) {
				return new AnswerData("Моё число больше.", true);
			} else {
				return new AnswerData("Ты угадал!", false);
			}
		} else {
			return new AnswerData("Это не число!!!Ты проиграл(", false);
		}
	}
}
