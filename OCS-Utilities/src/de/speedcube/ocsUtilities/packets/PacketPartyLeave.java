package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketPartyLeave extends Packet {
	public int partyID;

	public PacketPartyLeave() {
		channel = PARTY_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", partyID);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		partyID = data.getInt("a");
	}

	@Override
	public String getName() {
		return "PartyLeave";
	}

}