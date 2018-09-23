package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

import answers.WhatTime;
import bot.Attitude;

class WhatTimeTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		WhatTime whattime = new WhatTime();
		String answer = whattime.GetPackageAnswer(a, null).GetAnswer();
		assertTrue(Arrays.asList(WhatTime.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatTime whattime = new WhatTime();
		String answer = whattime.GetPackageAnswer(a, null).GetAnswer();
		Date date = new Date();
		assertTrue(answer.equals(new SimpleDateFormat("'Сейчас' kk:mm").format(date)));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		WhatTime whattime = new WhatTime();
		String answer = whattime.GetPackageAnswer(a, null).GetAnswer();
		Date date = new Date();
		assertTrue(answer.equals(new SimpleDateFormat("'Сейчас' kk:mm").format(date)));
	}

}
