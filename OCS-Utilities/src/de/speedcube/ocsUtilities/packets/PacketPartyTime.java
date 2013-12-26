package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketPartyTime extends Packet {
	public int time;
	public int partyID;

	public PacketPartyTime() {
		channel = PARTY_CHANNEL;
	}
	
	@Override
	public void packData() {
		data = new DNFile();

		data.addInt("a", time);
		data.addInt("b", partyID);

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

		time = data.getInt("a");
		partyID = data.getInt("b");
	}

	@Override
	public String getName() {
		return "PartyTime";
	}

}