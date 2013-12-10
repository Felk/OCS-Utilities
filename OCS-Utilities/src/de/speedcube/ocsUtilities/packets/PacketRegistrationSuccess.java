package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketRegistrationSuccess extends Packet {
	public String username;

	public PacketRegistrationSuccess() {
		channel = LOGIN_PAGE_CHANNEL;
	}
	
	@Override
	public void packData() {
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
		return "RegistrationSuccess";
	}

}
