package bot;

import java.util.ArrayList;
import java.util.List;

public class InputData 
{
	public Attitude CurrentAttitude;
	public String TextMessage;
	public ArrayList<String> Log = new ArrayList<String>(); 
	
	public InputData(Attitude a, String s, ArrayList<String> list)
	{
		CurrentAttitude = a;
		TextMessage = s;
		if (list != null)
			Log = (ArrayList<String>) list.clone();
		else
			Log = null;
	}
}
