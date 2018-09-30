package answers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Pattern;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class TownsGame implements Answer
{
	private Map<String, String> patternToAnalysis = new HashMap<String, String>() 
	{
		{
			put("наигрался","endOfGame");
			put("давай закончим","endOfGame");
			put("хватит\\.*","endOfGame");
		}
	};
	
	public AnswerData GetPackageAnswer(InputData input) 
	{
		if (TownsData.IsEndOfGame())
			return EndOfGame(input);
		if (TownsData.IsStart())
		{
			Reboot();
			TownsData.FirstCityWas();
			return Start(input);
		}
		String currentMove = "какая-то строка";
		String message = String.join(" ", input.TextMessage.toLowerCase().split("[ {,|.}?]+"));
		for (String o : patternToAnalysis.keySet()) 
		{
			Pattern pattern = Pattern.compile(o);
			if (pattern.matcher(message).find())
			{
				currentMove = patternToAnalysis.get(o);
				break;
			}
		}
		switch (currentMove)
		{
			case "endOfGame":
			{
				TownsData.EndOfGame();
				return new AnswerData("Вы точно хотите завершить игру?", true);
			}
			default:
				return NextCity(input);
		}

	}
	
	private AnswerData Start(InputData input)
	{
		String answer = TownsMemory.GetUnusedTown("Ыа");
		TownsData.SetLastCity(answer);
		return new AnswerData(answer, true);
	}
	
	private AnswerData NextCity(InputData input)
	{
		if (!EqualsFirstAndLastLetter(input.TextMessage))
		{
			String answer = "Первая буква \"" + input.TextMessage
				+"\" и последняя буква \"" + TownsData.GetLastCity()
				+"\" не совпадают. Вы проиграли.";
			Reboot();
			return new AnswerData(answer, false);
		}
		if (CheckInUsed(input.TextMessage))
		{
			String answer = "Этот город уже называли ранее." 
					+ "Вы проиграли.";
			Reboot();
			return new AnswerData(answer, false);
		}
		if (!CheckInUnused(input.TextMessage))
		{
			String answer = "Этого города нет в моей базе данных. " 
					+ "Скорее всего это не город и Вы пытаетесь меня обмануть. "
					+ "Вы проиграли.";
			Reboot();
			return new AnswerData(answer, false);
		}
		TownsMemory.UseTown(GetTrueNameCity(input.TextMessage));
		String answer = TownsMemory.GetUnusedTown(input.TextMessage);
		if (answer != null)
		{
			TownsData.SetLastCity(answer);
			return new AnswerData(answer, true);
		}
		Reboot();
		return new AnswerData("Я не смог подобрать нужного названия("
				+ "Вы выиграли", false);
	}
	
	private String GetTrueNameCity(String s)
	{
		String town = s.toLowerCase();
		String d = s.substring(0, 1).toUpperCase();
		d = d + s.substring(1);
		return d;
	}
	
	private boolean CheckInUnused(String s)
	{
		return TownsMemory.ContainsUnusedTowns(GetTrueNameCity(s));
	}
	
	private boolean CheckInUsed(String s)
	{		
		return TownsMemory.ContainsUsedTowns(GetTrueNameCity(s));
	}
	
	private Character GetLastLetter(String s)
	{
		int i = 1;
		while(s.charAt(s.length() - i) == 'ь' 
				|| s.charAt(s.length() - i) == 'ы')
		{
			i++;
		}
		return s.charAt(s.length() - i);
	}
	
	private boolean EqualsFirstAndLastLetter(String s)
	{		
		String str = s.toLowerCase();
		Character c = GetLastLetter(TownsData.GetLastCity());
		Character d = str.charAt(0);
		return c.equals(d);
	}
	
	private void Reboot()
	{
		TownsData.Reboot();
		TownsMemory.Reboot();
	}
	
	private AnswerData EndOfGame(InputData input)
	{
		String userAnswer= input.TextMessage.toLowerCase().trim();
		userAnswer = userAnswer.replaceAll("[^а-я]", "");
		if (userAnswer.equals("да"))
		{
			Reboot();
			return new AnswerData("Спасибо, было приятно поиграть. Приходи ещё!", false);
		}
		if (userAnswer.equals("нет"))
		{
			TownsData.ContinueGame();
			String answer = "Давай продолжим тогда. Последним был город: "
					+ TownsData.GetLastCity();
			return new AnswerData(answer, true);
		}
		return new AnswerData("К сожалению, я пока ещё не очень умный бот и не понимаю тебя. "
				+ "Ты будешь ещё играть?", true);
	}
}