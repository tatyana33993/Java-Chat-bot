package answers;

import java.util.HashMap;

public class TownsGameMetaMemory 
{
	public HashMap<Character, Integer> CountWords = new HashMap<Character, Integer>();
	public HashMap<Character, Integer> NumberFirstItem = new HashMap<Character, Integer>();
	
	public void SetCountWords(Character c, Integer i)
	{
		CountWords.put(c,i);
	}
	
	public void SetNumberFirstItem(Character c, Integer i)
	{
		NumberFirstItem.put(c,i);
	}
}
