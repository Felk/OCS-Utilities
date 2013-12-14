package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketLoginSuccess extends Packet {
	public String username;
	public int userID;

	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", username);
		data.addNode("b", userID);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		username = data.getString("a");
		userID = data.getInt("b");
	}

	@Override
	public String getName() {
		return "LoginSuccess";
	}

}
