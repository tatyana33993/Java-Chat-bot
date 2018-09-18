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
		HowAreYou howAreYou = new HowAreYou();
		String answer = howAreYou.GetAnswer(a);
		assertTrue(Arrays.asList(HowAreYou.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		HowAreYou howAreYou = new HowAreYou();
		String answer = howAreYou.GetAnswer(a);
		assertTrue(Arrays.asList(HowAreYou.NeutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		HowAreYou howAreYou = new HowAreYou();
		String answer = howAreYou.GetAnswer(a);
		assertTrue(Arrays.asList(HowAreYou.CheerfulAnswers).contains(answer));
	}

}
