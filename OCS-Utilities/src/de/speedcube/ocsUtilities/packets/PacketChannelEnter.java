package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChannelEnter extends Packet {
	public String channel;

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", channel);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		channel = data.getString("a");
		if (channel == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "ChannelEnter";
	}

}