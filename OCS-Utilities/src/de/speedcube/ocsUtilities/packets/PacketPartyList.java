package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketPartyList extends Packet {
	public int[] partyIDs;

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", partyIDs);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		partyIDs = data.getIntArray("a");
		if (partyIDs == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "PartyList";
	}

}