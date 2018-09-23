package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Series;
import bot.Attitude;

class SeriesTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		Series series = new Series();
		String answer = series.GetPackageAnswer(a, null).GetAnswer();
		assertTrue(Arrays.asList(Series.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Series series = new Series();
		String answer = series.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.NeutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		Series series = new Series();
		String answer = series.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.CheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void seriesTest() {
		Attitude a = new Attitude();
		Series series = new Series();
		String answer = series.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.Series).contains(arrAnswers[1]));
	}
}
