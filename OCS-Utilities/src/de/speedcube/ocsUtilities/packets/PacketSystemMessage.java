package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketSystemMessage extends Packet {
	public String msg;
	public long timestamp;

	public PacketSystemMessage() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");
		data.addNode("a", msg);
		data.addNode("b", timestamp);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);
		msg = data.getString("a");
		timestamp = data.getLong("b");
	}

	@Override
	public String getName() {
		return "SystemMessage";
	}

}
