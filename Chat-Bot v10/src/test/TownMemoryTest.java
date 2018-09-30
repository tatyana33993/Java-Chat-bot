package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import answers.TownsGameMemory;
import answers.TownsGameMetaMemory;
import answers.TownsMemory;
import bot.Attitude;

public class TownMemoryTest 
{
	@Test
	void testMemoryA1() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("Абакан");
		assertTrue(TownsMemory.ContainsUsedTowns("Абакан"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryA2() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("Абакан");
		assertTrue(!TownsMemory.ContainsUnusedTowns("Абакан"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryA3() 
	{
		TownsMemory.Reboot();
		assertTrue(TownsMemory.ContainsUnusedTowns("Омск"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryCheckTownInUsed() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean answer = memory.CheckTownInUsed("Абакан");
		assertEquals(answer, false);
		memory.ShutDown();
	}
	@Test
	void testMemoryUseTown1() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("Абакан");
		assertTrue(TownsMemory.ContainsUsedTowns("Абакан"));
		TownsMemory.UseTown("Киров");
		assertTrue(TownsMemory.ContainsUsedTowns("Абакан"));
		assertTrue(TownsMemory.ContainsUsedTowns("Киров"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryUseTown3() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("Абакан");
		assertFalse(TownsMemory.ContainsUnusedTowns("Абакан"));
		TownsMemory.UseTown("Киров");
		assertFalse(TownsMemory.ContainsUnusedTowns("Абакан"));
		assertFalse(TownsMemory.ContainsUnusedTowns("Киров"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryReboot() 
	{
		TownsMemory.Reboot();
		assertFalse(TownsMemory.ContainsUsedTowns("Абакан"));
		assertFalse(TownsMemory.ContainsUsedTowns("Киров"));
		assertTrue(TownsMemory.ContainsUnusedTowns("Абакан"));
		assertTrue(TownsMemory.ContainsUnusedTowns("Киров"));
		TownsMemory.Reboot();
	}
}
