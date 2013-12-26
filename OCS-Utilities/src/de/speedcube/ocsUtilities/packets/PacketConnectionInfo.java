package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketConnectionInfo extends Packet {
	public String version;

	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", version);

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

		version = data.getString("a");
	}

	@Override
	public String getName() {
		return "ConnectionInfo";
	}

}
