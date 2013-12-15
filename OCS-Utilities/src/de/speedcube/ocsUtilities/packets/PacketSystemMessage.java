package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketSystemMessage extends Packet {
	public String msg;
	public String[] values;
	public long timestamp;

	public PacketSystemMessage() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");
		data.addNode("a", msg);
		data.addNode("b", timestamp);
		data.addNode("c", values);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);
		msg = data.getString("a");
		timestamp = data.getLong("b");
		values = data.getStringArray("c");
	}

	@Override
	public String getName() {
		return "SystemMessage";
	}

}
