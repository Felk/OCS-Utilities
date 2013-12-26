package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketSystemMessage extends Packet {
	public String msg;
	public String[] values;
	public long timestamp;
	public String chatChannel;
	public boolean global;

	public PacketSystemMessage() {
		channel = CHAT_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();
		data.addString("a", msg);
		data.addLong("b", timestamp);
		data.addString("c", values);
		data.addString("d", chatChannel);
		data.addBoolean("e", global);
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
		msg = data.getString("a");
		timestamp = data.getLong("b");
		values = data.getStringArray("c");
		chatChannel = data.getString("d");
		global = data.getBoolean("e");
	}

	@Override
	public String getName() {
		return "SystemMessage";
	}

}
