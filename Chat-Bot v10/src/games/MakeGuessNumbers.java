package games;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;

public class MakeGuessNumbers implements Answer{
	public AnswerData GetPackageAnswer(InputData input) { 
		return new AnswerData("� ���� ��� �� ����.", false);
	}

}
