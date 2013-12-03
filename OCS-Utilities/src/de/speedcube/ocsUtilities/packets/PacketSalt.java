package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketSalt extends Packet {
	public String salt;

	@Override
	public void pack() {
		data = new DNFile("");
		//username = GameOptions.instance.getOption("playerName");

		data.addNode("a", salt);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		salt = data.getString("a");
	}

	@Override
	public String getName() {
		return "Salt";
	}

}
