package de.speedcube.ocsUtilities;

import java.util.TreeMap;

public class ScrambleTypes {

	public static TreeMap<String, String> types = new TreeMap<String, String>();
	public static TreeMap<String, String> types_advanced = new TreeMap<String, String>();
	
	static {
		
		types.put("2x2", "2x2X2-CUBE-RANDOM");
		types.put("3x3", "RUBIKS-CUBE-RANDOM");
		types.put("4x4", "4x4x4-CUBE-RANDOM");
		types.put("5x5", "5x5x5-CUBE-RANDOM");
		types.put("6x6", "6x6x6-CUBE-RANDOM");
		types.put("7x7", "7x7x7-CUBE-RANDOM");
		types.put("Clock", "RUBIKS-CLOCK-RANDOM");
		types.put("Megaminx", "MEGAMINX-RANDOM");
		types.put("Pyraminx", "PYRAMINX-RANDOM");
		types.put("Square-1", "SQUARE-1-RANDOM");
		types.put("Floppy", "FLOPPY-CUBE-RANDOM");
		
		types_advanced.put("2x2 URF", "2x2X2-CUBE-URF");
		types_advanced.put("3x3 easy cross", "RUBIKS-CUBE-EASY-CROSS");
		types_advanced.put("3x3 CLL", "RUBIKS-CUBE-CLL-TRAINING");
		types_advanced.put("3x3 ELL", "RUBIKS-CUBE-ELL-TRAINING");
		types_advanced.put("3x3 F2L", "RUBIKS-CUBE-FRIDRICH-F2L-TRAINING");
		types_advanced.put("3x3 OLL", "RUBIKS-CUBE-FRIDRICH-OLL-TRAINING");
		types_advanced.put("3x3 PLL", "RUBIKS-CUBE-FRIDRICH-PLL-TRAINING");
		types_advanced.put("Skewb", "SKEWB-RANDOM");
		types_advanced.put("Tower", "TOWER-CUBE-RANDOM");
		types_advanced.put("Rubik's Tower", "RUBIKS-TOWER-RANDOM");
		types_advanced.put("Rubik's Domino", "RUBIKS-DOMINO-RANDOM");
		
		
	}
	
}
