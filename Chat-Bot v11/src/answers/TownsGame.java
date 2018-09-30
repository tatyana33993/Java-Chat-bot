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
			put("���������","endOfGame");
			put("����� ��������","endOfGame");
			put("������\\.*","endOfGame");
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
		String currentMove = "�����-�� ������";
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
				return new AnswerData("�� ����� ������ ��������� ����?", true);
			}
			default:
				return NextCity(input);
		}

	}
	
	private AnswerData Start(InputData input)
	{
		String answer = TownsMemory.GetUnusedTown("��");
		TownsData.SetLastCity(answer);
		return new AnswerData(answer, true);
	}
	
	private AnswerData NextCity(InputData input)
	{
		if (!EqualsFirstAndLastLetter(input.TextMessage))
		{
			String answer = "������ ����� \"" + input.TextMessage
				+"\" � ��������� ����� \"" + TownsData.GetLastCity()
				+"\" �� ���������. �� ���������.";
			Reboot();
			return new AnswerData(answer, false);
		}
		if (CheckInUsed(input.TextMessage))
		{
			String answer = "���� ����� ��� �������� �����." 
					+ "�� ���������.";
			Reboot();
			return new AnswerData(answer, false);
		}
		if (!CheckInUnused(input.TextMessage))
		{
			String answer = "����� ������ ��� � ���� ���� ������. " 
					+ "������ ����� ��� �� ����� � �� ��������� ���� ��������. "
					+ "�� ���������.";
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
		return new AnswerData("� �� ���� ��������� ������� ��������("
				+ "�� ��������", false);
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
		while(s.charAt(s.length() - i) == '�' 
				|| s.charAt(s.length() - i) == '�')
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
		userAnswer = userAnswer.replaceAll("[^�-�]", "");
		if (userAnswer.equals("��"))
		{
			Reboot();
			return new AnswerData("�������, ���� ������� ��������. ������� ���!", false);
		}
		if (userAnswer.equals("���"))
		{
			TownsData.ContinueGame();
			String answer = "����� ��������� �����. ��������� ��� �����: "
					+ TownsData.GetLastCity();
			return new AnswerData(answer, true);
		}
		return new AnswerData("� ���������, � ���� ��� �� ����� ����� ��� � �� ������� ����. "
				+ "�� ������ ��� ������?", true);
	}
}