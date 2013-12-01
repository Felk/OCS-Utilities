package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketLoginUsername extends Packet {
	public String username;

	@Override
	public void pack() {
		data = new DNFile("");
		//username = GameOptions.instance.getOption("playerName");

		data.addNode("username", username);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		username = data.getString("username");
	}

	@Override
	public String getName() {
		return "LoginUsername";
	}

}
