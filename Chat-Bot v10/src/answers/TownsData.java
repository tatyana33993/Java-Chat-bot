package answers;

public class TownsData
{
	static private int spreadValues = 20;
	static private boolean start = true;
	static private boolean endOfGame = false;
	static private boolean isSetMaxCountCities = false;
	static private int maxCountCities;
	static private int  currentCountCities;
	static private String lastCity;
	
	static protected void Reboot() 
	{
		start = true;
		isSetMaxCountCities = false;
		endOfGame = false;
		maxCountCities = 0;
		currentCountCities = 0;
		lastCity = null;
	}
	
	static protected void SetMaxCountCities(DifficultLevel lvl)
	{
		if (!isSetMaxCountCities)
		{
			switch (lvl)
			{
				case Easy:
					maxCountCities =  5 + (int) (Math.random() * spreadValues);
					break;
				case Medium:
					maxCountCities =  15 + (int) (Math.random() * spreadValues);
					break;
				case Hard:
					maxCountCities =  50 + (int) (Math.random() * spreadValues);
					break;
				case Madness:
					maxCountCities =  Integer.MAX_VALUE;
					break;
			}
			isSetMaxCountCities = true;
		}
	}
	
	static protected void FirstCityWas()
	{
		start = false;
	}
	
	static protected void ContinueGame()
	{
		endOfGame = false;
	}
	
	static protected void EndOfGame()
	{
		endOfGame = true;
	}
	
	static protected void IncreaseCurrentCities()
	{
		currentCountCities++;
	}
	
	static protected int GetCurrentCountCities()
	{
		return currentCountCities;
	}
	
	static protected int GetMaxCountCities()
	{
		return maxCountCities;
	}
	
	static protected boolean IsEndOfGame()
	{
		return endOfGame;
	}
	
	static protected boolean IsStart()
	{
		return start;
	}
	
	static protected void SetLastCity(String s)
	{
		lastCity = s;
	}
	
	static protected String GetLastCity()
	{
		return lastCity;
	}
}
