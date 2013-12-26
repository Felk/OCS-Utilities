package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;
import de.speedcube.ocsUtilities.security.Sha2;

public class PacketLogin extends Packet {
	public String password;
	public String salt;

	@Override
	public void packData() {
		data = new DNFile();

		String encrypted_password = Sha2.hashPassword(password, salt);
		data.addString("a", encrypted_password);
		
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
	}

	@Override
	public String getName() {
		return "Login";
	}

}
