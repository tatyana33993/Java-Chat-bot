package bot;

public class Attitude {
	private byte friendliness;

	public Attitude() {
		friendliness = 5;
	}

	public void IncreasedFriendliness() {
		if (friendliness < 9)
			friendliness++;
	}

	public void DecreaseFriendliness() {
		if (friendliness > 1)
			friendliness--;
	}

	public byte GetByteFriendliness() {
		return friendliness;
	}

	public String GetStringFriendliness() {
		if (friendliness < 4)
			return "angry";
		else if (friendliness < 7)
			return "neutral";
		else
			return "cheerful";
	}

}