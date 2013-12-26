package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketChat extends Packet {
	public String text;
	public String chatChannel;

	public PacketChat() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", text);
		data.addString("b", chatChannel);

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
	}

	@Override
	public String getName() {
		return "Chat";
	}

}
