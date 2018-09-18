package answers;

import bot.Attitude;

public class MovieSearch {

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
	public static String[] Films = { "�����", "����� �����", "�������� �������", "�������� �����", "�����",
			"������� ������ �������������", "��������", "���� �������� �����", "Kingsman", "����", "������� ������",
			"����", "������ ���������� ����", "����� �� ������", "�����������", "������������",
			"��������� ������ ���������", "����� ������", "���������", "��������", "������� ������", "���", "����",
			"�������", "���������", "����� �����", "�� ������", "����� ���� ����", "����� ������ ��������",
			"�� ������������ �������" };
	public static String[] Series = { "������������������", "����� �������� ����", "������������ ������� ������",
			"��������� - ��� ������", "������ �������� ������", "������� ��������", "�� ��� ������", "���� ���������",
			"������", "������ ����", "�������", "׸���� �������", "������� ��������" };

	public static String GetMovie(Attitude a, String key) {
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return AngryAnswers[random];
		} else if (key == "whatwatch") {
			return "��� �� ������ ����������: �����, ���������� ��� ������?";
		} else {
			String movie = "";
			if (key == "cartoon") {
				int random = 0 + (int) (Math.random() * Cartoons.length);
				movie = Cartoons[random];
			} else if (key == "film") {
				int random = 0 + (int) (Math.random() * Films.length);
				movie = Films[random];
			} else {
				int random = 0 + (int) (Math.random() * Series.length);
				movie = Series[random];
			}
			if (a.GetStringFriendliness() == "neutral") {
				int random1 = 0 + (int) (Math.random() * NeutralAnswers.length);
				return String.format("%s\"%s\".", NeutralAnswers[random1], movie);
			} else {
				int random2 = 0 + (int) (Math.random() * CheerfulAnswers.length);
				return String.format("%s\"%s\".", CheerfulAnswers[random2], movie);
			}
		}
	}

}
