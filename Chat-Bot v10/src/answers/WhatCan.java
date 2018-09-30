package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class WhatCan implements Answer {

	public AnswerData GetPackageAnswer(InputData input) {
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
