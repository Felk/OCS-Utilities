package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

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
		data = new DNFile();
		data.addString("a", text);
		data.addString("b", chatChannel);
		data.addInt("c", userId);
		data.addLong("d", timestamp);
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
