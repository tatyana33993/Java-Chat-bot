package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class Hello implements Answer{
	public static String[] AngryAnswers = {
			"������, ��������:D � ���-��� ����. ����� ������, ��� � ����, ������ ������: \"��� �� ������?\"",
			"��������. � ��������. ������ ����: \"��� �� ������?\" � � ��� �� �������� ���� � ����� ������ �������" };
	public static String[] NeutralAnswers = {
			"������������, ���� ����� ������. ���� ������ ������ ��� ������, �������� \"��� �� ������?\"",
			"����������, �������! � ����������� ��� ������. ���� ������ ������, ��� � ����, ������: \"��� �� ������?\"" };
	public static String[] CheerfulAnswers = { "������, � ������. ����� �� ��� �������� ����: \"��� �� ������?\"" };

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
