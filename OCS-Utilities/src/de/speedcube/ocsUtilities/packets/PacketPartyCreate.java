package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketPartyCreate extends Packet {
	public byte type;
	public int rounds;
	public int rounds_counting;
	public String name;
	public String scrambleType;

	public PacketPartyCreate() {
		channel = PARTY_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		data.addByte("a", type);
		data.addInt("b", rounds);
		data.addInt("c", rounds_counting);
		data.addString("d", name);
		data.addString("e", scrambleType);

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

		type = data.getByte("a");
		rounds = data.getInt("b");
		rounds_counting = data.getInt("c");
		name = data.getString("d");
		scrambleType = data.getString("e");
		if (scrambleType == null || name == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "PartyCreate";
	}

}