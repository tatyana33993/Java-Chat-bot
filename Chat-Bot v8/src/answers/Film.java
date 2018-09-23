package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class Film implements Answer{
	public static String[] AngryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };
	public static String[] NeutralAnswers = { "Пожалуй посмотри ", "Можешь посмотреть ", "Советую посмотреть ",
			"Я бы рекомендовал посмотреть ", "Кинопоиск подсказывает мне: " };
	public static String[] CheerfulAnswers = {
			"Я бы на твоём месте не тратил на это свою жизнь, но ты можешь посмотреть ", "Мне очень нравится ",
			"Несколько раз пересматривал ", "Люблю всем советовать: ", "Никогда не смотрю фильмы.Шутка:D Глянь " };
	public static String[] Films = { "Сплит", "Живая сталь", "Железный человек", "Виноваты звёзды", "Время",
			"Первому игроку приготовиться", "Мстители", "Дома странных детей", "Kingsman", "Нерв", "Великий Гэтсби",
			"Люси", "Пираты Карибского моря", "Малыш на драйве", "Аннигиляция", "Интерстеллар",
			"Отличница лёгкого поведения", "Гарри Поттер", "Джуманджи", "Одарённая", "Скрытые фигуры", "Оно", "Чудо",
			"Джунгли", "Атландида", "Книга Генри", "До костей", "Между нами горы", "Очень плохие девчонки",
			"По соображениям совести" };
	

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * Films.length);
			String film = Films[random];
			if (a.GetStringFriendliness() == "neutral") {
				int random1 = 0 + (int) (Math.random() * NeutralAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", NeutralAnswers[random1], film), false);
			} else {
				int random2 = 0 + (int) (Math.random() * CheerfulAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", CheerfulAnswers[random2], film), false);
			}
		}
	}

}
