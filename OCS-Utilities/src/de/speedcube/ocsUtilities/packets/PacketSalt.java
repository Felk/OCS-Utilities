package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketSalt extends Packet {
	public String salt;

	@Override
	public void packData() {
		data = new DNFile();
		//username = GameOptions.instance.getOption("playerName");

		data.addString("a", salt);
		
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

		salt = data.getString("a");
	}

	@Override
	public String getName() {
		return "Salt";
	}

}
