package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class Film implements Answer{
	public static String[] AngryAnswers = { "��� ���", "� �� ���� ���� ��������", "������, ��� ������", "���� ������",
			"����� ���-������ ���" };
	public static String[] NeutralAnswers = { "������� �������� ", "������ ���������� ", "������� ���������� ",
			"� �� ������������ ���������� ", "��������� ������������ ���: " };
	public static String[] CheerfulAnswers = {
			"� �� �� ���� ����� �� ������ �� ��� ���� �����, �� �� ������ ���������� ", "��� ����� �������� ",
			"��������� ��� ������������� ", "����� ���� ����������: ", "������� �� ������ ������.�����:D ����� " };
	public static String[] Films = { "�����", "����� �����", "�������� �������", "�������� �����", "�����",
			"������� ������ �������������", "��������", "���� �������� �����", "Kingsman", "����", "������� ������",
			"����", "������ ���������� ����", "����� �� ������", "�����������", "������������",
			"��������� ������ ���������", "����� ������", "���������", "��������", "������� ������", "���", "����",
			"�������", "���������", "����� �����", "�� ������", "����� ���� ����", "����� ������ ��������",
			"�� ������������ �������" };
	

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
