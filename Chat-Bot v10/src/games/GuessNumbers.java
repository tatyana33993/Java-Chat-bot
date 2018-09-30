package games;

import java.util.regex.Pattern;
import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class GuessNumbers implements Answer {

	public AnswerData GetPackageAnswer(InputData input) {

		Pattern pattern1 = Pattern.compile("����������");
		Pattern pattern2 = Pattern.compile("\\d+");

		if (pattern1.matcher(input.TextMessage).find()) {
			return new AnswerData(
					"����.� ������� ����� �� 0 �� 100:) ���� ������ ��� ��������))) �� ����� � ���� ������ ���������:D ��� ������: ����� �����:)",
					true);
		} else if (pattern2.matcher(input.TextMessage).find()) {
			String number = input.TextMessage.replaceAll("[^0-9]", "");
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
