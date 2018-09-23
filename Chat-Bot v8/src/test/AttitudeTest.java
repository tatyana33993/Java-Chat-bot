package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bot.Attitude;

class AttitudeTest {

	@Test
	void testAttitude() {
		Attitude a = new Attitude();
		assertNotNull(a);
	}

	@Test
	void testGetByteFriendliness() {
		Attitude a = new Attitude();
		for (int i = 5; i < 10; i++) {
			assertTrue(a.GetByteFriendliness() == i);
			a.IncreasedFriendliness();
		}
	}

	@Test
	void testGetStringFriendliness() {
		Attitude a = new Attitude();
		for (int i = 5; i > 3; i--) {
			assertTrue(a.GetStringFriendliness() == "neutral");
			a.DecreaseFriendliness();
		}
		for (int i = 3; i > 0; i--) {
			assertTrue(a.GetStringFriendliness() == "angry");
			a.DecreaseFriendliness();
		}
	}

	@Test
	void testIncreasedFriendliness() {
		Attitude a = new Attitude();
		for (int i = 0; i < 6; i++)
			a.IncreasedFriendliness();
		assertTrue(a.GetByteFriendliness() == 9 && a.GetStringFriendliness() == "cheerful");

	}

	@Test
	void testDecreaseFriendliness() {
		Attitude a = new Attitude();
		for (int i = 0; i < 6; i++)
			a.DecreaseFriendliness();
		assertTrue(a.GetByteFriendliness() == 1 && a.GetStringFriendliness() == "angry");

	}

}
