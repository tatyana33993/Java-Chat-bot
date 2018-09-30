package answers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import bot.Attitude;
import bot.InputData;

public class TownsDataTest 
{
	@Test
	void RebootTest() 
	{	
		TownsData.Reboot();
		assertEquals(true, TownsData.IsStart());
		assertEquals(false, TownsData.IsEndOfGame());
		TownsData.SetMaxCountCities(DifficultLevel.Madness);
		assertEquals(true, TownsData.GetMaxCountCities() > 1000);
		TownsData.SetMaxCountCities(DifficultLevel.Hard);
		assertEquals(true, TownsData.GetMaxCountCities() > 1000);
		TownsData.Reboot();
	}
}
