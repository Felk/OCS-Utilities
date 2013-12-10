package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;
import de.speedcube.ocsUtilities.security.Sha2;

public class PacketLogin extends Packet {
	public String password;
	public String salt;

	@Override
	public void packData() {
		data = new DNFile("");

		String encrypted_password = Sha2.hashPassword(password, salt);
		data.addNode("a", encrypted_password);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		password = data.getString("a");
	}

	@Override
	public String getName() {
		return "Login";
	}

}
