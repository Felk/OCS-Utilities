package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketRegistrationError extends Packet {
	public String err;

	public PacketRegistrationError() {
		channel = LOGIN_PAGE_CHANNEL;
	}
	
	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", err);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		err = data.getString("a");
	}

	@Override
	public String getName() {
		return "RegistrationError";
	}

}
