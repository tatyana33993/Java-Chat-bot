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
	private ArrayList<String> log = new ArrayList<String>();
	private Pattern pattern; // ƒл€ регул€рки
	private Random random = new Random(); // ƒл€ рандомных ответов
	private Date date = new Date();// ƒл€ даты и времени
	private Attitude attitude = new Attitude();
	private Memory memory = new Memory();
	private Answer CurrentTheme = null;
	private InputData input = new InputData(null, null, null);

	private void UpdateInputData(String userAnswer)
	{
		log.add(userAnswer);
		input = new InputData(attitude, userAnswer, log);
	}
	
	public String sayInReturn(String msg) 
	{
		UpdateInputData(msg);
		String say = (msg.trim().endsWith("?")) ? memory.ELUSIVE_ANSWERS[random.nextInt(memory.ELUSIVE_ANSWERS.length)]
				: memory.COMMON_PHRASES[random.nextInt(memory.COMMON_PHRASES.length)];		
		if (CurrentTheme != null)
		{
			  AnswerData data = CurrentTheme.GetPackageAnswer(input);
			  if (!data.SaveTheme())
				  CurrentTheme = null;
			  UpdateInputData(data.GetAnswer());
			  return data.GetAnswer();
		}
		
		String message = String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
		for (String o : memory.PATTERNS_FOR_ANALYSIS.keySet()) 
		{
			pattern = Pattern.compile(o);
			if (pattern.matcher(message).find())
			{
				AnswerData data =  memory.ANSWERS_BY_PATTERNS.get(memory.PATTERNS_FOR_ANALYSIS.get(o))
						.GetPackageAnswer(input);
				if (!data.SaveTheme())
					  CurrentTheme = null;
				else
					if (CurrentTheme == null)
						CurrentTheme = memory.ANSWERS_BY_PATTERNS
						.get(memory.PATTERNS_FOR_ANALYSIS.get(o));
				UpdateInputData(data.GetAnswer());
				return data.GetAnswer();
			}
		}
		UpdateInputData(say);
		return say;
	}
}