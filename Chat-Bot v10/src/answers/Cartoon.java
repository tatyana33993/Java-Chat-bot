package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class Cartoon implements Answer {
	public static String[] AngryAnswers = { "��� ���", "� �� ���� ���� ��������", "������, ��� ������", "���� ������",
			"����� ���-������ ���" };
	public static String[] NeutralAnswers = { "������� �������� ", "������ ���������� ", "������� ���������� ",
			"� �� ������������ ���������� ", "��������� ������������ ���: " };
	public static String[] CheerfulAnswers = {
			"� �� �� ���� ����� �� ������ �� ��� ���� �����, �� �� ������ ���������� ", "��� ����� �������� ",
			"��������� ��� ������������� ", "����� ���� ����������: ", "������� �� ������ ������.�����:D ����� " };
	public static String[] Cartoons = { "���������� ����������", "����������", "��� ��������� �������", "�����'",
			"���������:���������� �������", "��������� �����", "��������� ����", "�������� ������", "�����", "������ �",
			"��������", "������� �����", "����������� ��������", "������� �� ���������", "��� � �������:��� �������",
			"����-�� �����", "���������� ������", "����������", "����", "�����", "����� ��������", "���",
			"������ � ������", "���", "�����", "���������", "�����", "��������� � �������", "���", "������� �������" };

	public AnswerData GetPackageAnswer(InputData input) {
		if (input.CurrentAttitude.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * Cartoons.length);
			String cartoon = Cartoons[random];
			if (input.CurrentAttitude.GetStringFriendliness() == "neutral") {
				int random1 = 0 + (int) (Math.random() * NeutralAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", NeutralAnswers[random1], cartoon), false);
			} else {
				int random2 = 0 + (int) (Math.random() * CheerfulAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", CheerfulAnswers[random2], cartoon), false);
			}
		}
	}
}
