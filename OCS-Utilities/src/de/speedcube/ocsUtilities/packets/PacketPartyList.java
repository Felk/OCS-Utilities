package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketPartyList extends Packet {
	public int[] partyIDs;

	public PacketPartyList() {
		channel = PARTY_CHANNEL;
	}
	
	@Override
	public void packData() {
		data = new DNFile();

		data.addInt("a", partyIDs);

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

		partyIDs = data.getIntArray("a");
		if (partyIDs == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "PartyList";
	}

}