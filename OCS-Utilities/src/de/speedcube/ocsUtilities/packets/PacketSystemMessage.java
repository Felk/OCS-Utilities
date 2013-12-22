package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketSystemMessage extends Packet {
	public String msg;
	public String[] values;
	public long timestamp;
	public String chatChannel;
	public boolean global;

	public PacketSystemMessage() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");
		data.addNode("a", msg);
		data.addNode("b", timestamp);
		data.addNode("c", values);
		data.addNode("d", chatChannel);
		data.addNode("e", global);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);
		msg = data.getString("a");
		timestamp = data.getLong("b");
		values = data.getStringArray("c");
		chatChannel = data.getString("d");
		global = data.getBoolean("e");
	}

	@Override
	public String getName() {
		return "SystemMessage";
	}

}
