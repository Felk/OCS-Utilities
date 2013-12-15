package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketProfileInfo extends Packet {

	public int color;
	public String status;

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", color);
		data.addNode("b", status);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		color = data.getInt("a");
		status = data.getString("b");
	}

	@Override
	public String getName() {
		return "ProfileInfo";
	}

}
