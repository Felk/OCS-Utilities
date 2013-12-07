package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketUserlist extends Packet {
	public int[] userIds;

	@Override
	public void pack() {
		data = new DNFile("");

		data.addNode("b", userIds);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		userIds = data.getIntArray("b");
		if (userIds == null) throw new MalformedPacketException();
	}

	@Override
	public String getName() {
		return "Userlist";
	}

}
