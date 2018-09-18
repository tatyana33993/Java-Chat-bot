package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Hello;

import bot.Attitude;

class HelloTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		String answer = Hello.GetAnswer(a);
		assertTrue(Arrays.asList(Hello.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		String answer = Hello.GetAnswer(a);
		assertTrue(Arrays.asList(Hello.NeutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		String answer = Hello.GetAnswer(a);
		assertTrue(Arrays.asList(Hello.CheerfulAnswers).contains(answer));
	}

}
