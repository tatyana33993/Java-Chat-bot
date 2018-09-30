package bot;

import java.util.HashMap;
import java.util.Map;

import answers.Bye;
import answers.Hello;
import answers.HowAreYou;
import answers.TownsGame;
import answers.WhatAreYouDoing;
import answers.WhatCan;
import answers.WhatDay;
import answers.WhatTime;

public class Memory 
{
	String[] COMMON_PHRASES = { "��� ������ ������ ����, ��������� � ����� � �� �������.",
			"����� �������� ����� ������� ������, ������ ���� ����.",
			"����� ��� ��� ������/�������� ������ ����� ��������.", "�������� � ��������� ���� ������� � ������� ����.",
			"������� ����� ����� ��� ��������������� ������.", "����������� ���� ������� ���������������� ���.",
			"����� ����� ������, �� ����� � ��������.", "��������� �����, �� ��������� �� ����.",
			"��� ���� ������, ��� ���� ��������.", "����� �� ���-�� �� �������������." };
	String[] ELUSIVE_ANSWERS = { "������ ���������, ����� ����-��� �� ��������.",
			"�� ������, ��� ���������� ����� �����������.", "����� ����� ��������� � ���-�� ������?",
			"��������, �� ��� ����� ������ ������.", "�� ������, ��� ��� ���������� �����.",
			"��������, � ��� ����� �� ��� �����.", "�� ������������� ������ ��� �����?",
			"������, �� ��� ���������� ����.", "����� ��� ����� ����������?", "������� �������� �������?" };
	Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() {
		{
			// hello
			put("���", "hello");
			put("������", "hello");
			put("�������", "hello");
			put("����������", "hello");
			put("��������", "hello");
			// who
			put("���\\s.*��", "who");
			put("��\\s.*���", "who");
			// name
			put("���\\s.*�����", "name");
			put("���\\s.*���", "name");
			put("����\\s.*���", "name");
			put("�����\\s.*���", "name");
			// whatcan
			put("���\\s.*������", "whatcan");
			put("���\\s.*������", "whatcan");
			// howareyou
			put("���\\s.*����", "howareyou");
			put("���\\s.*�����", "howareyou");
			// whatareyoudoing
			put("�����\\s.*���", "whatareyoudoing");
			put("�����\\s.*�����", "whatareyoudoing");
			put("���\\s.*�������", "whatareyoudoing");
			put("���\\s.*�����������", "whatareyoudoing");
			put("���\\s.*�������", "whatareyoudoing");
			put("���\\s.*�����", "whatareyoudoing");
			// whatdoyoulike
			put("���\\s.*��������", "whatdoyoulike");
			put("���\\s.*������", "whatdoyoulike");
			// iamfeelling
			put("�������", "iamfeelling");
			put("��������", "iamfeelling");
			put("���������", "iamfeelling");
			// whatday
			put("�����\\s.*����", "whatday");
			put("�����\\s.*�����", "whatday");
			put("���� ������", "whatday");
			put("����", "whatday");
			put("�����", "whatday");
			// whattime
			put("�������\\s.*���", "whattime");
			put("�������\\s.*�����", "whattime");
			// bye
			put("������", "bye");
			put("����", "bye");
			put("������", "bye");
			put("��������", "bye");
			put("��\\s.*��������", "bye");
			// whatwatch
			put("���\\s.*����������", "whatwatch");
			put("���\\s.�������", "whatwatch");
			// cartoon
			put("����������", "cartoon");
			put("�������", "cartoon");
			put("�����\\s.*����������", "cartoon");
			put("��������\\s.*����������", "cartoon");
			put("���������\\s.*����������", "cartoon");
			// film
			put("�����", "film");
			put("�������", "film");
			put("�����\\s.*�����", "film");
			put("��������\\s.*�����", "film");
			put("���������\\s.*�����", "film");
			// series
			put("������", "series");
			put("����������", "series");
			put("�����\\s.*������", "series");
			put("��������\\s.*������", "series");
			put("���������\\s.*������", "series");
			// towns
			put("������", "towns");
		}
	};
	Map<String, Answer> ANSWERS_BY_PATTERNS = new HashMap<String, Answer>() {
		{
			//put("who", "� ������� ���-���.");
			//put("name", "������ ���� ����:)");
			//put("whatcan", "���� � ���� ���� ����, �� ����� ���� ������ ����������."
			//		+ "� ���� � ���� ���������� �����, ������������ ��� ��� ���������� ��� �� ������ ������ ��������� �� ����");
			//put("whatdoyoulike", "��� �������� ������ ��� � �� ������ ���������.");
			//put("iamfeelling", "��� ����� ��� ��������? ���������� ���� ���������.");
			//put("yes", "�������� ���� ������� ��� ������ ������������� ������.");
			put("hello", new Hello());
			put("bye", new Bye());
			put("howareyou", new HowAreYou());
			put("whatareyoudoing", new WhatAreYouDoing());
			put("whatday", new WhatDay());
			put("whattime", new WhatTime());
			put("whatcan", new WhatCan());
			put("towns", new TownsGame());
		}
	};
}
