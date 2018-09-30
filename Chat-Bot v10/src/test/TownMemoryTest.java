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
		TownsMemory.UseTown("������");
		assertTrue(TownsMemory.ContainsUsedTowns("������"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryA2() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("������");
		assertTrue(!TownsMemory.ContainsUnusedTowns("������"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryA3() 
	{
		TownsMemory.Reboot();
		assertTrue(TownsMemory.ContainsUnusedTowns("����"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryCheckTownInUsed() 
	{
		TownsGameMemory memory = new TownsGameMemory();
		boolean answer = memory.CheckTownInUsed("������");
		assertEquals(answer, false);
		memory.ShutDown();
	}
	@Test
	void testMemoryUseTown1() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("������");
		assertTrue(TownsMemory.ContainsUsedTowns("������"));
		TownsMemory.UseTown("�����");
		assertTrue(TownsMemory.ContainsUsedTowns("������"));
		assertTrue(TownsMemory.ContainsUsedTowns("�����"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryUseTown3() 
	{
		TownsMemory.Reboot();
		TownsMemory.UseTown("������");
		assertFalse(TownsMemory.ContainsUnusedTowns("������"));
		TownsMemory.UseTown("�����");
		assertFalse(TownsMemory.ContainsUnusedTowns("������"));
		assertFalse(TownsMemory.ContainsUnusedTowns("�����"));
		TownsMemory.Reboot();
	}
	@Test
	void testMemoryReboot() 
	{
		TownsMemory.Reboot();
		assertFalse(TownsMemory.ContainsUsedTowns("������"));
		assertFalse(TownsMemory.ContainsUsedTowns("�����"));
		assertTrue(TownsMemory.ContainsUnusedTowns("������"));
		assertTrue(TownsMemory.ContainsUnusedTowns("�����"));
		TownsMemory.Reboot();
	}
}
