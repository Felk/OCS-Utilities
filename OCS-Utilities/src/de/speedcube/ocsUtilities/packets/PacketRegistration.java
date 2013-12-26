package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;
import de.speedcube.ocsUtilities.security.RandomString;
import de.speedcube.ocsUtilities.security.Sha2;

public class PacketRegistration extends Packet {
	public String password;
	public String username;
	public String salt = "";

	@Override
	public void packData() {
		data = new DNFile();

		salt = RandomString.getNew(20);
		String encrypted_password = Sha2.hashPassword(password, salt);
		data.addString("a", encrypted_password);
		data.addString("b", username);
		data.addString("c", salt);

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

		password = data.getString("a");
		username = data.getString("b");
		salt = data.getString("c");
	}

	@Override
	public String getName() {
		return "Registration";
	}

}
