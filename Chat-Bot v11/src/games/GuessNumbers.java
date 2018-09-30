package games;

import java.util.regex.Pattern;
import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class GuessNumbers implements Answer {

	public AnswerData GetPackageAnswer(InputData input) {

		Pattern pattern1 = Pattern.compile("отгадывать");
		Pattern pattern2 = Pattern.compile("\\d+");

		if (pattern1.matcher(input.TextMessage).find()) {
			return new AnswerData(
					"Окей.Я загадал число от 0 до 100:) Твоя задача его отгадать))) Не бойся я буду давать подсказки:D Вот первая: Введи число:)",
					true);
		} else if (pattern2.matcher(input.TextMessage).find()) {
			String number = input.TextMessage.replaceAll("[^0-9]", "");
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
