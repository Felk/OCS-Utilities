package de.speedcube.ocsUtilities;

import de.nerogar.DNFileSystem.DNFile;

public class UserInfo {
	public int userID;
	public String username;
	public int color;
	public int rank;
	public String status;

	public UserInfo() {
		userID = -1;
		username = "ANONYMOUS";
		rank = Userranks.GUEST;
		color = 0xffffff;
		status = "not logged in";
	}
	
	public String getHexColor() {
		return String.format("%06X", (0xFFFFFF & color));
	}

	public UserInfo(int userID, String username, int rank, int color, String status) {
		this.userID = userID;
		this.username = username;
		this.color = color;
		this.rank = rank;
		this.status = status;
	}

	public DNFile toDNFile() {
		DNFile file = new DNFile();
		file.addInt("id", userID);
		file.addString("name", username);
		file.addInt("col", color);
		file.addInt("rank", rank);
		file.addString("status", status);
		return file;
	}

	public void setFromDNFile(DNFile file) {
		userID = file.getInt("id");
		username = file.getString("name");
		color = file.getInt("col");
		rank = file.getInt("rank");
		status = file.getString("status");
	}

	public static UserInfo fromDNFile(DNFile file) {
		UserInfo info = new UserInfo();
		info.userID = file.getInt("id");
		info.username = file.getString("name");
		info.color = file.getInt("col");
		info.rank = file.getInt("rank");
		info.status = file.getString("status");
		return info;
	}
}
