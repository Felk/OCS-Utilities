package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketSaltGet extends Packet {
	public String username;

	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", username);

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
	}

	@Override
	public String getName() {
		return "SaltGet";
	}

}
