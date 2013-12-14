package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChat extends Packet {
	public String text;
	public String chatChannel;

	public PacketChat() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", text);
		data.addNode("b", chatChannel);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");

		data.fromByteArray(packedData);

		text = data.getString("a");
		chatChannel = data.getString("b");
	}

	@Override
	public String getName() {
		return "Chat";
	}

}
