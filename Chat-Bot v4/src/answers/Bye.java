package answers;

import bot.Attitude;

public class Bye {

	public static String[] AngryAnswers = { "������, ������� ������ �� ��������", "����, ����� ������ �� ���� ���", "�� �������-��, � �� � ��� ����� �� ������� � �����", "����" };
	public static String[] NeutralAnswers = { "����, �������. ��� ��� ���� ������", "�� �������, �������, ��� ��� ����� ����� �����", "����. ����� ����:)"};
	public static String[] CheerfulAnswers = { "���, �� ������ ���������:D", "���)))", "�� ������ �������, �������)"};

	public static String GetAnswer(Attitude a) {
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
