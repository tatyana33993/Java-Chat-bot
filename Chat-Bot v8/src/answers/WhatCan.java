package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class WhatCan implements Answer {

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		StringBuilder strb = new StringBuilder();
		strb.append("���� � ���� ���� ����, �� ����� ���� ������ ����������.");
		strb.append("C����� � ���� ���������� ��� ���� � �����.");
		strb.append("� ������ ���������� � ���� � ���� ������������, ��� ��� ����������:)");
		strb.append("��� �� ����� �������� � \"�����\" ��� \"������\"(���� �� ������).");
		strb.append("� �� ���������, ��� �� ������ ������ ��������� �� ����, ���� � ����� ����� �������� � ������^-^.");
		String answer = strb.toString();
		return new AnswerData(answer, false);
	}

}
