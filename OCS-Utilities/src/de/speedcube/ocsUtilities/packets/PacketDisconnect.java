package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketDisconnect extends Packet {
	public String msg;

	public PacketDisconnect() {
		channel = DEFAULT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", msg);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		msg = data.getString("a");
	}

	@Override
	public String getName() {
		return "Disconnect";
	}

}
