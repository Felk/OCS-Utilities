package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChannelWhisper extends Packet {
	public int userID;

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", userID);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		userID = data.getInt("a");
	}

	@Override
	public String getName() {
		return "ChannelWhisper";
	}

}