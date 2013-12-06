package de.speedcube.ocsUtilities;

public class UserInfo {
	public int userID;
	public String username;
	public int color;
	public int rank;

	public UserInfo() {
		userID = -1;
		rank = Userranks.GUEST;
		color = 0xffffff;
	}

	public UserInfo(int userID, String username, int color, int rank) {
		this.userID = userID;
		this.username = username;
		this.color = color;
		this.rank = rank;
	}
}
