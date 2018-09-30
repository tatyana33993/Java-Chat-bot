package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import bot.Attitude;

import answers.MovieSearch;

class MovieSearchTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.DecreaseFriendliness();
		String answer = MovieSearch.GetMovie(a, "cartoon");
		assertTrue(Arrays.asList(MovieSearch.AngryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.GetMovie(a, "film");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.NeutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.IncreasedFriendliness();
		String answer = MovieSearch.GetMovie(a, "series");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.CheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void cartoonTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.GetMovie(a, "cartoon");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.Cartoons).contains(arrAnswers[1]));
	}

	@Test
	void filmTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.GetMovie(a, "film");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.Films).contains(arrAnswers[1]));
	}

	@Test
	void seriesTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.GetMovie(a, "series");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.Series).contains(arrAnswers[1]));
	}
}
