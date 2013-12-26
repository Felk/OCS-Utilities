package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketUserlist extends Packet {
	public int[] userIds;

	@Override
	public void packData() {
		data = new DNFile();

		data.addInt("b", userIds);

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

		userIds = data.getIntArray("b");
		if (userIds == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "Userlist";
	}

}