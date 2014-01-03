package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketChannelLeave extends Packet {
	public String chatChannel;

	public PacketChannelLeave() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		data.addString("a", chatChannel);

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

		chatChannel = data.getString("a");
		if (chatChannel == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "ChannelLeave";
	}

}