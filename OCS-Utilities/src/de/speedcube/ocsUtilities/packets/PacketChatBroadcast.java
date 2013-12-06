package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChatBroadcast extends Packet {
	public String text;
	public String channel;
	public int userId;
	

	@Override
	public void pack() {
		data = new DNFile("");
		data.addNode("a", text);
		data.addNode("b", channel);
		data.addNode("c", userId);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);
		text = data.getString("a");
		channel = data.getString("b");
		userId = data.getInt("c");
	}

	@Override
	public String getName() {
		return "ChatBroadcast";
	}

}
