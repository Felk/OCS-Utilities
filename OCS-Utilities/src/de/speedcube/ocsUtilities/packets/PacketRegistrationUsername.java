package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketRegistrationUsername extends Packet {
	public String username;

	@Override
	public void pack() {
		data = new DNFile("");

		data.addNode("a", username);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		username = data.getString("a");
	}

	@Override
	public String getName() {
		return "RegistrationUsername";
	}

}
