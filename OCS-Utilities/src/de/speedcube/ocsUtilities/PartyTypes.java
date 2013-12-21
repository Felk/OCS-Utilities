package de.speedcube.ocsUtilities;

public class PartyTypes {

	public static final int AVG = 1;
	public static final int BEST = 2;

	public static boolean has(int i) {
		return i == AVG || i == BEST;
	}
	
	public static String getString(int id) {
		switch(id) {
		case AVG: return "Average";
		case BEST: return "Best of";
		}
		return "";
	}
	
}
