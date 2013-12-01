package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketRegistration extends Packet {
	public String username;
	public String password;

	@Override
	public void pack() {
		data = new DNFile("");

		data.addNode("a", username);
		data.addNode("b", username);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		username = data.getString("a");
		password = data.getString("b");
	}

	@Override
	public String getName() {
		return "Registration";
	}

}
