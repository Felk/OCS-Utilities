package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;
import de.speedcube.ocsUtilities.security.Sha2;

public class PacketLogin extends Packet {
	public String username;
	public String password;
	public String salt;

	@Override
	public void pack() {
		data = new DNFile("");
		//username = GameOptions.instance.getOption("playerName");

		data.addNode("username", username);
		String encrypted_password = Sha2.hashPassword(password, salt);
		data.addNode("password", encrypted_password);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		username = data.getString("username");
		password = data.getString("password");
	}

	@Override
	public String getName() {
		return "Login";
	}

}
