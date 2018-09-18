package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.HowAreYou;
import bot.Attitude;

class HowAreYouTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		String answer = HowAreYou.GetAnswer(a);
		assertTrue(Arrays.asList(HowAreYou.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		String answer = HowAreYou.GetAnswer(a);
		assertTrue(Arrays.asList(HowAreYou.NeutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		String answer = HowAreYou.GetAnswer(a);
		assertTrue(Arrays.asList(HowAreYou.CheerfulAnswers).contains(answer));
	}

}
