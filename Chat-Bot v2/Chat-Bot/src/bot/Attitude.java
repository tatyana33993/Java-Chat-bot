package bot;

public class Attitude 
{
	private byte friendliness;
	
	public 
	
	public Attitude()
	{
		friendliness = 5;
	}
	
	public void IncreasedFriendlies()
	{
		if (friendliness < 10)
			friendliness++;
	}
	
	public void DecreaseFriendlies()
	{
		if (friendliness > 0)
			friendliness--;
	}
	
	public byte GetFriendliness()
	{
		return friendliness;
	}
}
