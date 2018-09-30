package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class Hello implements Answer{
	public static String[] AngryAnswers = {
			"������, ��������:D � ���-��� ����. ����� ������, ��� � ����, ������ ������: \"��� �� ������?\"",
			"��������. � ��������. ������ ����: \"��� �� ������?\" � � ��� �� �������� ���� � ����� ������ �������" };
	public static String[] NeutralAnswers = {
			"������������, ���� ����� ������. ���� ������ ������ ��� ������, �������� \"��� �� ������?\"",
			"����������, �������! � ����������� ��� ������. ���� ������ ������, ��� � ����, ������: \"��� �� ������?\"" };
	public static String[] CheerfulAnswers = { "������, � ������. ����� �� ��� �������� ����: \"��� �� ������?\"" };

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
