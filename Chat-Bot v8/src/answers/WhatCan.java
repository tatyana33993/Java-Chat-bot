package answers;

import bot.Answer;
import bot.AnswerData;
import bot.Attitude;

public class WhatCan implements Answer {

	public AnswerData GetPackageAnswer(Attitude a, String textMessage) {
		StringBuilder strb = new StringBuilder();
		strb.append("Пока я мало чего умею, но скоро этот список расширится.");
		strb.append("Cейчас я могу подсказать вам день и время.");
		strb.append("Я хорошо разбираюсь в кино и могу посоветовать, что вам посмотреть:)");
		strb.append("Ещё мы можем поиграть в \"Числа\" или \"Города\"(пока не правда).");
		strb.append("И не забывайте, что вы можете просто поболтать со мной, ведь я очень люблю общаться с людьми^-^.");
		String answer = strb.toString();
		return new AnswerData(answer, false);
	}

}
