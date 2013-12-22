package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChannelEnter extends Packet {
	public String chatChannel;

	public PacketChannelEnter() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", chatChannel);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		chatChannel = data.getString("a");
		if (chatChannel == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "ChannelEnter";
	}

}