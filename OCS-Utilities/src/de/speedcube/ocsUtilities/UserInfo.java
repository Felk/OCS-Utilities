package de.speedcube.ocsUtilities;

import de.speedcube.ocsUtilities.DNFile.DNFile;

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

	public UserInfo(int userID, String username, int rank, int color) {
		this.userID = userID;
		this.username = username;
		this.color = color;
		this.rank = rank;
	}

	public DNFile toDNFile() {
		DNFile file = new DNFile("");
		file.addNode("id", userID);
		file.addNode("name", username);
		file.addNode("col", color);
		file.addNode("rank", rank);
		return file;
	}

	public void setFromDNFile(DNFile file) {
		userID = file.getInt("id");
		username = file.getString("name");
		color = file.getInt("col");
		rank = file.getInt("rank");
	}

	public static UserInfo fromDNFile(DNFile file) {
		UserInfo info = new UserInfo();
		info.userID = file.getInt("id");
		info.username = file.getString("name");
		info.color = file.getInt("col");
		info.rank = file.getInt("rank");
		return info;
	}
}
