package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketLoginSuccess extends Packet {
	public String username;
	public int userID;

	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", username);
		data.addInt("b", userID);

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

		username = data.getString("a");
		userID = data.getInt("b");
	}

	@Override
	public String getName() {
		return "LoginSuccess";
	}

}
