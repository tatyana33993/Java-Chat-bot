package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import answers.TownsGameMemory;
import answers.TownsGameMetaMemory;
import bot.Attitude;

public class TownMemoryTest 
{
	@Test
	void testMemoryA1() {
		TownsGameMemory memory = new TownsGameMemory();
		assertEquals(memory.GetUnusedTowns()[4], "Îìñê");
		memory.ShutDown();
	}
	@Test
	void testMemoryA2() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean lol = memory.CheckTownInUnused("Îìñê");
		assertEquals(lol, true);
		memory.ShutDown();
	}
	@Test
	void testMemoryA3() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		assertEquals(memory.CheckTownInUsed("Îìñê"), false);
		memory.ShutDown();
	}
	@Test
	void testMemoryA4() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		assertEquals(memory.GetUsedTowns().contains("Àáàêàí"), false);
		memory.ShutDown();
	}
	@Test
	void testMemoryA5() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		assertEquals(memory.GetUsedTowns().isEmpty(), true);
		memory.ShutDown();
	}
	@Test
	void testMemoryCheckTownInUsed() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean answer = memory.CheckTownInUsed("Àáàêàí");
		assertEquals(answer, false);
		memory.ShutDown();
	}
	@Test
	void testMemoryUseTown1() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean answer = memory.UseTown("Àáàêàí", false);
		assertEquals(answer, true);
		memory.ShutDown();
	}
	@Test
	void testMemoryUseTown2() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean a = memory.UseTown("Àáàêàí", true);
		TownsGameMemory memory1 = new TownsGameMemory();
		boolean answer = memory1.CheckTownInUsed("Àáàêàí");
		assertEquals(answer, true);
		memory.ShutDown();
	}
	@Test
	void testMemoryUseTown3() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean a = memory.UseTown("Áàêó", true);
		TownsGameMemory memory1 = new TownsGameMemory();
		boolean answer = memory1.CheckTownInUsed("Áàêó");
		assertEquals(answer, true);
		memory.ShutDown();
	}
	@Test
	void testMemoryReboot() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean a = memory.UseTown("Áàêó", true);
		memory.ShutDown();
		memory = new TownsGameMemory();
		boolean flag = memory.GetUsedTowns().isEmpty();
		assertEquals(flag, true);
		memory.ShutDown();
	}
}
