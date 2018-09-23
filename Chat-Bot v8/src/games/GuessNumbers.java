package games;

import java.util.regex.Pattern;
import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class GuessNumbers implements Answer {

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {

		Pattern pattern1 = Pattern.compile("����������");
		Pattern pattern2 = Pattern.compile("\\d+");

		if (pattern1.matcher(textMessage).find()) {
			return new AnswerData(
					"����.� ������� ����� �� 0 �� 100:) ���� ������ ��� ��������))) �� ����� � ���� ������ ���������:D ��� ������: ����� �����:)",
					true);
		} else if (pattern2.matcher(textMessage).find()) {
			String number = textMessage.replaceAll("[^0-9]", "");
			int UserNumber = Integer.parseInt(number);
			if (UserNumber > PlayNumbers.UnknownNumber) {
				return new AnswerData("�� ����� ������.", true);
			} else if (UserNumber < PlayNumbers.UnknownNumber) {
				return new AnswerData("�� ����� ������.", true);
			} else {
				return new AnswerData("�� ������!", false);
			}
		} else {
			return new AnswerData("��� �� �����!!!�� ��������(", false);
		}
	}
}
