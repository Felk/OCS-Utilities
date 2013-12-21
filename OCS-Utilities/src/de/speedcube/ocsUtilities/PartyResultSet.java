package de.speedcube.ocsUtilities;

public class PartyResultSet {

	private int userID;
	private int[] times;
	private int average;
	
	public PartyResultSet(int userID, int[] times, int average) {
		this.userID = userID;
		this.times = times;
		this.average = average;
	}

	public int getUserID() {
		return userID;
	}
	
	public int[] getTimes() {
		return times;
	}

	public int getAverage() {
		return average;
	}
	
}
