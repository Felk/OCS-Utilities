package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketChannelWhisper extends Packet {
	public int userID;

	@Override
	public void packData() {
		data = new DNFile();

		data.addInt("a", userID);

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

		userID = data.getInt("a");
	}

	@Override
	public String getName() {
		return "ChannelWhisper";
	}

}