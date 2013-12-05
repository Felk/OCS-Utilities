package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketChat extends Packet {
	public String text;
	public String channel;

	@Override
	public void pack() {
		data = new DNFile("");
		
		data.addNode("a", text);
		data.addNode("b", channel);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		
		data.fromByteArray(packedData);
		
		text = data.getString("a");
		channel = data.getString("b");
	}

	@Override
	public String getName() {
		return "Chat";
	}

}
