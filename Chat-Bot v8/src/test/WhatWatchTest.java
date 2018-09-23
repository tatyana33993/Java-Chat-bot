package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.WhatWatch;
import bot.Attitude;

class WhatWatchTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		WhatWatch whatwatch = new WhatWatch();
		String answer = whatwatch.GetPackageAnswer(a, null).GetAnswer();
		assertTrue(Arrays.asList(WhatWatch.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatWatch whatwatch = new WhatWatch();
		String answer = whatwatch.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(WhatWatch.NeutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		WhatWatch whatwatch = new WhatWatch();
		String answer = whatwatch.GetPackageAnswer(a, null).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(WhatWatch.NeutralAnswers).contains(arrAnswers[0]));
	}
}
