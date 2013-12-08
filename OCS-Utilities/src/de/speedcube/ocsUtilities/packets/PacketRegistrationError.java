package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketRegistrationError extends Packet {
	public int errNr;

	public PacketRegistrationError() {
		channel = LOGIN_PAGE_CHANNEL;
	}
	
	@Override
	public void pack() {
		data = new DNFile("");

		data.addNode("a", errNr);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		errNr = data.getInt("a");
	}

	@Override
	public String getName() {
		return "RegistrationError";
	}

}
