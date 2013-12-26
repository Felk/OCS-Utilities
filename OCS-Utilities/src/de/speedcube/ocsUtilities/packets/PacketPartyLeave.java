package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketPartyLeave extends Packet {
	public int partyID;

	public PacketPartyLeave() {
		channel = PARTY_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		data.addInt("a", partyID);

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

		partyID = data.getInt("a");
	}

	@Override
	public String getName() {
		return "PartyLeave";
	}

}