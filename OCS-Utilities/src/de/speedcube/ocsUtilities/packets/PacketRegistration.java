package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;
import de.speedcube.ocsUtilities.security.Sha2;

public class PacketRegistration extends Packet {
	public String password;
	public String username;
	public String salt = "";

	@Override
	public void pack() {
		data = new DNFile("");

		String encrypted_password = Sha2.hashPassword(password, salt);
		data.addNode("a", encrypted_password);
		data.addNode("b", username);
		data.addNode("c", salt);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		password = data.getString("a");
		username = data.getString("b");
		salt = data.getString("c");
	}

	@Override
	public String getName() {
		return "Registration";
	}

}
