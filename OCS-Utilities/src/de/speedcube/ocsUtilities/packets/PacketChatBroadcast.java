package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChatBroadcast extends Packet {
	public String text;
	public int userId;

	@Override
	public void pack() {
		data = new DNFile("");
		data.addNode("a", text);
		data.addNode("b", userId);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);
		text = data.getString("a");
		userId = data.getInt("b");
	}

	@Override
	public String getName() {
		return "ChatBroadcast";
	}

}
