package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketLogout extends Packet {
	public String msg;

	public PacketLogout() {
		channel = LOGIN_PAGE_CHANNEL;
	}

	@Override
	public void pack() {
		data = new DNFile("");

		data.addNode("a", msg);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		msg = data.getString("a");
	}

	@Override
	public String getName() {
		return "Logout";
	}

}
