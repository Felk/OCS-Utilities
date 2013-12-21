package de.speedcube.ocsUtilities;

public class PartyStates {

	public static final int OPEN = 0;
	public static final int RUNNING = 1;
	public static final int OVER = 2;

	public static boolean has(int i) {
		return i == OPEN || i == RUNNING || i == OVER;
	}
	
	public static String getString(int id) {
		switch(id) {
		case OPEN: return "open";
		case RUNNING: return "running";
		case OVER: return "over";
		}
		return "";
	}
	
}
