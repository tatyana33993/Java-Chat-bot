package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class WhatWatch implements Answer{ 
	public static String[] AngryAnswers = { "��� ���", "� �� ���� ���� ��������", "������, ��� ������", "���� ������",
	"����� ���-������ ���" };
	public static String[] NeutralAnswers = { "��� �� ������ ����������: �����, ���������� ��� ������?" };
	
	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		if (a.GetStringFriendliness() == "angry") {
			int random = 0 + (int) (Math.random() * AngryAnswers.length);
			return new AnswerData(AngryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * NeutralAnswers.length);
			return new AnswerData(NeutralAnswers[random], false);
		}
	}
}
