package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChatBroadcast extends Packet {
	public String text;
	public String chatChannel;
	public int userId;
	public long timestamp;

	public PacketChatBroadcast() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");
		data.addNode("a", text);
		data.addNode("b", chatChannel);
		data.addNode("c", userId);
		data.addNode("d", timestamp);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);
		text = data.getString("a");
		chatChannel = data.getString("b");
		userId = data.getInt("c");
		timestamp = data.getLong("d");
	}

	@Override
	public String getName() {
		return "ChatBroadcast";
	}

}
