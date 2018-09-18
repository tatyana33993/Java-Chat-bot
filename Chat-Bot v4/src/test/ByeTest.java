package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Bye;
import bot.Attitude;

class ByeTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		String answer = Bye.GetAnswer(a);
		assertTrue(Arrays.asList(Bye.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		String answer = Bye.GetAnswer(a);
		assertTrue(Arrays.asList(Bye.NeutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		String answer = Bye.GetAnswer(a);
		assertTrue(Arrays.asList(Bye.CheerfulAnswers).contains(answer));
	}
}
