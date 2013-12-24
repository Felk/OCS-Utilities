package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketPartyTime extends Packet {
	public int time;
	public int partyID;

	public PacketPartyTime() {
		channel = PARTY_CHANNEL;
	}
	
	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", time);
		data.addNode("b", partyID);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		time = data.getInt("a");
		partyID = data.getInt("b");
	}

	@Override
	public String getName() {
		return "PartyTime";
	}

}