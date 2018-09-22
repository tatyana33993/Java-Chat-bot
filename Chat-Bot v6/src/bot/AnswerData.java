package bot;

public class AnswerData 
{
	private String answer;
	private boolean saveTheme;
	
	public AnswerData(String a,boolean b)
	{
		answer = a;
		saveTheme = b;
	}
	
	public String GetAnswer()
	{
		return answer;
	}
	
	public boolean SaveTheme()
	{
		return saveTheme;
	}
}
