package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketConnectionInfo extends Packet {
	public String version;

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", version);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		version = data.getString("a");
	}

	@Override
	public String getName() {
		return "ConnectionInfo";
	}

}
