package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.WhatAreYouDoing;
import bot.Attitude;
import bot.InputData;

class WhatAreYouDoingTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		assertTrue(Arrays.asList(WhatAreYouDoing.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		assertTrue(Arrays.asList(WhatAreYouDoing.NeutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		assertTrue(Arrays.asList(WhatAreYouDoing.CheerfulAnswers).contains(answer));
	}

}
