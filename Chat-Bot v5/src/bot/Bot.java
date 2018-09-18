/**
 * Class Bot
 *
 * @author Tatyana
 */
package bot;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

import answers.Bye;
import answers.Hello;
import answers.HowAreYou;
import answers.MovieSearch;
import answers.WhatAreYouDoing;

public class Bot {
	final String[] COMMON_PHRASES = { "��� ������ ������ ����, ��������� � ����� � �� �������.",
			"����� �������� ����� ������� ������, ������ ���� ����.",
			"����� ��� ��� ������/�������� ������ ����� ��������.", "�������� � ��������� ���� ������� � ������� ����.",
			"������� ����� ����� ��� ��������������� ������.", "����������� ���� ������� ���������������� ���.",
			"����� ����� ������, �� ����� � ��������.", "��������� �����, �� ��������� �� ����.",
			"��� ���� ������, ��� ���� ��������.", "����� �� ���-�� �� �������������." };
	final String[] ELUSIVE_ANSWERS = { "������ ���������, ����� ����-��� �� ��������.",
			"�� ������, ��� ���������� ����� �����������.", "����� ����� ��������� � ���-�� ������?",
			"��������, �� ��� ����� ������ ������.", "�� ������, ��� ��� ���������� �����.",
			"��������, � ��� ����� �� ��� �����.", "�� ������������� ������ ��� �����?",
			"������, �� ��� ���������� ����.", "����� ��� ����� ����������?", "������� �������� �������?" };
	final Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() {
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
			// yes
			put("��", "yes");
			put("��������", "yes");
			put("���", "yes");
			put("�����", "yes");
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

		}
	};
	final Map<String, Answer> ANSWERS_BY_PATTERNS = new HashMap<String, Answer>() {
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
		}
	};
	
	Pattern pattern; // ��� ���������
	Random random = new Random(); // ��� ��������� �������
	Date date = new Date();// ��� ���� � �������
	Attitude attitude = new Attitude();

	public String sayInReturn(String msg) {
		String say = (msg.trim().endsWith("?")) ? ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)]
				: COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];

		String message = String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
		for (String o : PATTERNS_FOR_ANALYSIS.keySet()) 
		{
			pattern = Pattern.compile(o);
			if (pattern.matcher(message).find())
				return  ANSWERS_BY_PATTERNS.get(PATTERNS_FOR_ANALYSIS.get(o)).GetAnswer(attitude);
		}
		return say;
	}
}