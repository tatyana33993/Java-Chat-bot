package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Cartoon;
import bot.Attitude;

class CartoonTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.GetPackageAnswer(a, null).GetAnswer();
		assertTrue(Arrays.asList(Cartoon.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Cartoon.NeutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Cartoon.CheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void cartoonTest() {
		Attitude a = new Attitude();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Cartoon.Cartoons).contains(arrAnswers[1]));
	}

}
