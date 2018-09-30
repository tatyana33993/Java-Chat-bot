package answers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TownsGameMemory 
{
	private String pathUsedTowns = "src/files/usedTowns.txt";
	private String pathUnusedTowns = "src/files/unusedTowns.txt";
	private String pathOriginalInfo = "src/files/OriginalTowns.txt";
	
	private TownsGameMetaMemory metaInfo = new TownsGameMetaMemory();	
	
	private String[] unusedTowns = new String[5000];
	private String[] usedCities = new String[5000];
	private int pointerInUsedTowns = 0;
	
	public String[] GetUnusedTowns()
	{
		return unusedTowns.clone();
	}
	
	private HashSet<String> usedTowns = new HashSet<String>() 
	{
		{
		}
	};

	public HashSet<String> GetUsedTowns()
	{
		return usedTowns;
	}
	
	
	private Map<String, String> patternsForAnalisys = new HashMap<String, String>() {
		{
			//Конец игры
			put("наигрался", "end");
			put("не\\s.*хочу\\\\s.*больше", "end");
			put("хватит", "end");
			
		}
	};
	
	public boolean CheckTownInUsed(String town)
	{
		return usedTowns.contains(town);
	}
	
	public boolean CheckTownInUnused(String town)
	{
		char ch = town.charAt(0);
		int start = metaInfo.NumberFirstItem.get(ch);
		int end = metaInfo.CountWords.get(ch);
		for (int i = start; i <= start + end; i++)
		{
			if (unusedTowns[i].equals(town))
				return true;
		}
		return false;
	}
	
	private void RewriteFile(String path,String town)
	{
		String[] cities = (path.equals(pathUnusedTowns)) ? unusedTowns : usedCities;
		boolean addTown = (path.equals(pathUnusedTowns)) ? false : true;
		File file = new File(path);
		file.deleteOnExit();
		file = new File(path);
		boolean writeSomething = false;
		try(PrintWriter writer = new PrintWriter(path))
	 		{
				boolean first = true;
		 		for(String city: cities)
		 		{	
		 			if (city != null)
		 			{
		 				if (!city.equals(town))
		 				{
		 					if (first)
		 					{
		 						writer.print(city);
		 						first = false;
		 						writeSomething = true;
		 					}
		 					else
		 					{
		 						writer.println();
		 						writer.print(city);	
		 						writeSomething = true;
		 					}
		 				}
		 				else
		 				{
		 					boolean c = true;
		 					c = false;
		 				}
		 			}
		 		}
		 		if (addTown)
		 		{
		 			if (!writeSomething)
		 			{
		 				writer.print(town);
		 			}
		 			else
		 			{
		 				writer.println();
		 				writer.print(town);
		 			}		 			
		 		}
	 		}
		catch (IOException e)
	 		{
		 		System.out.println(e);
	 		}
	}	
	
	public boolean UseTown(String town, boolean refresh)
	{
		if (refresh)
		{
			RewriteFile(pathUsedTowns, town);
			RewriteFile(pathUnusedTowns, town);
			return true;
		}
		else
		{			
			char ch = town.charAt(0);
			int start = metaInfo.NumberFirstItem.get(ch);
			int end = metaInfo.CountWords.get(ch);
			for (int i = start; i <= start + end; i++)
			{
				if (unusedTowns[i].equals(town))
				{
					unusedTowns[i] = null;	
					usedCities[pointerInUsedTowns] = town;
					pointerInUsedTowns++;
					usedTowns.add(town);
					return true;
				}
			}
			return false;
		}
	}
	
	public void ShutDown()
	{
		//почистить файл used
		//почистить файл unsed и загрузить в него всё из файла all
		 try(FileWriter writer = new FileWriter(pathUsedTowns, false))
	        {
	            writer.write("");             
	        }
	        catch(IOException ex)
		 	{
	             
	            System.out.println(ex.getMessage());
	        }
		 
		 String[] original = new String[5000];
		 try 
		 {
	            File file = new File(pathOriginalInfo);
	            FileReader fr = new FileReader(file);           
	            BufferedReader reader = new BufferedReader(fr);
	            String line = reader.readLine();
	            int count = 0;
	            while (line != null) 
	            {
	            	original[count] = line;
	            	count++;
	                line = reader.readLine();
	            }
	        } 
		 catch (FileNotFoundException e) 
		 {
	            e.printStackTrace();
	     }
	 	 catch (IOException e) 
	 	 {
	 		 	e.printStackTrace();
	 	 }
		 File file = new File(pathUnusedTowns);
		 file.deleteOnExit();
		 file = new File(pathUnusedTowns);
		 try(PrintWriter writer = new PrintWriter(pathUnusedTowns))
	 		{
				boolean first = true;
		 		for(String city: original)
		 		{	
		 			if (city != null)
		 			{
		 				if (first)
		 				{
		 					writer.print(city);
		 					first = false;
		 				}
		 				else
		 				{
		 					writer.println();
		 					writer.print(city);	
		 				}	
		 			}
		 		}
	 		}
		 	catch (IOException e)
	 		{
		 		System.out.println(e);
	 		}
	}	
	
	public String GetUnusedTown(Character d) 
	{
		Character c = d.toUpperCase(d);
		int random = metaInfo.NumberFirstItem.get(c) +
				(int) (Math.random() * metaInfo.CountWords.get(c));
		int count = 0;
		while (unusedTowns[random] != null && count < 10)
		{
			random = metaInfo.NumberFirstItem.get(c) +
			(int) (Math.random() * metaInfo.CountWords.get(c));
			count++;
		}
		if (unusedTowns[random] != null)
			UseTown(unusedTowns[random], true);
		return unusedTowns[random];
	}
	
	public TownsGameMemory()
	{
        int count = 0;
        int allCount = 0;      
        Character currentFirstChar = null;
		try {
            File file = new File(pathUnusedTowns);
            FileReader fr = new FileReader(file);           
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) 
            {
            	Character ch = line.charAt(0);
            	char charCH = ch.charValue();
            	char charCurrentFirstChar = (currentFirstChar == null) ? 'Z'
            			: currentFirstChar.charValue();
            	if (charCH != charCurrentFirstChar)
            	{
            		if (allCount != 0)
            		{
            			metaInfo.SetCountWords(currentFirstChar, count - 1);
            			metaInfo.SetNumberFirstItem(ch, allCount);
            		}
            		else
            			metaInfo.SetNumberFirstItem(ch, allCount);
            		count = 0;
            		currentFirstChar = ch;
            	}
            	unusedTowns[allCount] = line;
            	allCount++;
            	count++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		metaInfo.SetCountWords(currentFirstChar, count);
		SetUsedTowns();
	}
	
	private void SetUsedTowns()
	{
		try {
            File file = new File(pathUsedTowns);
            FileReader fr = new FileReader(file);           
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) 
            {
            	usedTowns.add(line);
            	usedCities[pointerInUsedTowns] = line;
            	pointerInUsedTowns++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
}