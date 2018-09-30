package answers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TownsMemory 
{
	static private HashSet<String> unusedTowns = new HashSet<String>();
	static private HashSet<String> usedTowns =  new HashSet<String>();
	static private HashMap<String, List<String>> firstLetterLists = new HashMap<String, List<String>>();
	static private String pathOriginalInfo = "src/files/OriginalTowns.txt";
	
	static public boolean ContainsUnusedTowns(String str)
	{
		return unusedTowns.contains(str);
	}
	
	static public boolean ContainsUsedTowns(String str)
	{
		return usedTowns.contains(str);
	}
		
	static public void UseTown(String s)
	{
		String firstLetter = GetFirstLetter(s);
		firstLetterLists.get(firstLetter).remove(s);
		unusedTowns.remove(s);
		usedTowns.add(s);
	}
	
	static public String GetUnusedTown(String lastTown)
	{
		String lastLetter = GetLastLetter(lastTown).toUpperCase();
		List<String> currentList = firstLetterLists.get(lastLetter);
		if (currentList.size() == 0)
			return null;
		int random =  (int) (Math.random() * currentList.size());
		String town = currentList.get(random);
		UseTown(town);
		return town;
	}
	
	static private String GetLastLetter(String s)
	{
		int i = 1;
		while(s.charAt(s.length() - i) == 'ü' 
				|| s.charAt(s.length() - i) == 'û')
		{
			i++;
		}
		return s.substring(s.length() - i, s.length() - i + 1);
	}

	static private String GetFirstLetter(String s)
	{
		return s.substring(0, 1);
	}
	
	static public void Reboot()
	{
		unusedTowns.clear();
        String prevFirst = null;
		try {
            File file = new File(pathOriginalInfo);
            FileReader fr = new FileReader(file);           
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) 
            {
            	String firstLetter = GetFirstLetter(line);
            	if (!firstLetter.equals(prevFirst))
            	{
            		firstLetterLists.put(firstLetter, new ArrayList<String>());
            		prevFirst = firstLetter;            		
            	}
            	firstLetterLists.get(firstLetter).add(line);
            	unusedTowns.add(line);
            	line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		usedTowns.clear();
	}
	
	
}
