package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Film;
import bot.Attitude;
import bot.InputData;

class FilmTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		Film film = new Film();
		String answer = film.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		assertTrue(Arrays.asList(Film.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Film film = new Film();
		String answer = film.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Film.NeutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		Film film = new Film();
		String answer = film.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Film.CheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void filmTest() {
		Attitude a = new Attitude();
		Film film = new Film();
		String answer = film.GetPackageAnswer(new InputData(a,null,null)).GetAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Film.Films).contains(arrAnswers[1]));
	}

}
