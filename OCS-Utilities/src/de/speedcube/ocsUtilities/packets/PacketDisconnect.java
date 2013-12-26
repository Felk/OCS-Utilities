package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketDisconnect extends Packet {
	public String msg;

	public PacketDisconnect() {
		channel = DEFAULT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", msg);

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

		msg = data.getString("a");
	}

	@Override
	public String getName() {
		return "Disconnect";
	}

}
