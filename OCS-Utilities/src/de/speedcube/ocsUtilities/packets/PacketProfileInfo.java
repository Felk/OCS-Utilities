package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

public class PacketProfileInfo extends Packet {

	public int color;
	public String status;
	public int rank;
	public String language;

	@Override
	public void packData() {
		data = new DNFile();

		data.addInt("a", color);
		data.addString("b", status);

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

		color = data.getInt("a");
		status = data.getString("b");
	}

	@Override
	public String getName() {
		return "ProfileInfo";
	}

}
