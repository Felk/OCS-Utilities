package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

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
		data = new DNFile("");

		data.addNode("a", type);
		data.addNode("b", rounds);
		data.addNode("c", rounds_counting);
		data.addNode("d", name);
		data.addNode("e", scrambleType);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

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