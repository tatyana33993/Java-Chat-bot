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

public class Bot 
{	
	Pattern pattern; // ƒл€ регул€рки
	Random random = new Random(); // ƒл€ рандомных ответов
	Date date = new Date();// ƒл€ даты и времени
	Attitude attitude = new Attitude();
	Memory memory = new Memory();
	Answer CurrentTheme = null;

	public String sayInReturn(String msg) {
		String say = (msg.trim().endsWith("?")) ? memory.ELUSIVE_ANSWERS[random.nextInt(memory.ELUSIVE_ANSWERS.length)]
				: memory.COMMON_PHRASES[random.nextInt(memory.COMMON_PHRASES.length)];		
		if (CurrentTheme != null)
		{
			  AnswerData data = CurrentTheme.GetPackageAnswer(attitude, msg);
			  if (!data.SaveTheme())
				  CurrentTheme = null;
			  return data.GetAnswer();
		}
		
		String message = String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
		for (String o : memory.PATTERNS_FOR_ANALYSIS.keySet()) 
		{
			pattern = Pattern.compile(o);
			if (pattern.matcher(message).find())
			{
				AnswerData data =  memory.ANSWERS_BY_PATTERNS.get(memory.PATTERNS_FOR_ANALYSIS.get(o))
						.GetPackageAnswer(attitude, msg);
				if (!data.SaveTheme())
					  CurrentTheme = null;
				else
					if (CurrentTheme == null)
						CurrentTheme = memory.ANSWERS_BY_PATTERNS
						.get(memory.PATTERNS_FOR_ANALYSIS.get(o));
				 return data.GetAnswer();
			}
		}
		return say;
	}
}