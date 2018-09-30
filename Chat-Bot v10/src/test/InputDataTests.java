package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Series;
import bot.Attitude;
import bot.InputData;

public class InputDataTests 
{
	@Test
	void testLinks() 
	{
		ArrayList<String> Log = new ArrayList<String>();
		Log.add("1");
		Log.add("2");
		InputData input = new InputData(new Attitude(), "message", Log);
		Log.add("3");
		assertEquals(2, input.Log.size());
	}
}
