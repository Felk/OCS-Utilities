package de.speedcube.ocsUtilities;

public class PartyTimeTypes {

	// MÜSSEN < 0 sein!
	public static final int OFF = -1;
	public static final int DNF = -2;
	public static final int DNS = -3;

	public static boolean has(int i) {
		return i == OFF || i == DNF || i == DNS;
	}
	
	public static String getString(int id) {
		switch(id) {
		case OFF: return "offline";
		case DNF: return "DNF";
		case DNS: return "DNS";
		default: return "DNK";
		}
	}
	
}
