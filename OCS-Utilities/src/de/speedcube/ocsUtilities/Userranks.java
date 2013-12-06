package de.speedcube.ocsUtilities;

public class Userranks {

	public static final int GUEST = -1; // also banned
	public static final int NORMAL = 0;
	public static final int HIGH = 1;
	public static final int MOD = 2;
	public static final int SMOD = 3;
	public static final int ADMIN = 4;
	public static final int DEV = 5;

	public static String getRankString(int id) {
		switch(id) {
		case GUEST: return "G";
		case NORMAL: return "U";
		case HIGH: return "U+";
		case MOD: return "M";
		case SMOD: return "M+";
		case ADMIN: return "A";
		case DEV: return "D";
		}
		return "";
	}
	
}
