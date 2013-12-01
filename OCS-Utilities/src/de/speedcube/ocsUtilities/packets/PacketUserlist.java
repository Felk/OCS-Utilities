package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketUserlist extends Packet {
	public String[] usernames;
	public int[] userIds;

	@Override
	public void pack() {
		data = new DNFile("");

		data.addNode("a", usernames);
		data.addNode("b", userIds);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		usernames = data.getStringArray("a");
		userIds = data.getIntArray("b");
	}

	@Override
	public String getName() {
		return "Userlist";
	}

}
