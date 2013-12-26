package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketRegistrationError extends Packet {
	public String err;

	public PacketRegistrationError() {
		channel = LOGIN_PAGE_CHANNEL;
	}
	
	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", err);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile();
		try {
			data.fromByteArray(packedData);
		} catch (IOException e) {
			throw new MalformedPacketException();
		}

		err = data.getString("a");
	}

	@Override
	public String getName() {
		return "RegistrationError";
	}

}
