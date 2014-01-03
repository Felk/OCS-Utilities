package de.speedcube.ocsUtilities.packets;

import java.io.IOException;
import java.util.ArrayList;

import de.speedcube.ocsUtilities.UserInfo;
import de.nerogar.DNFileSystem.DNFile;

public class PacketUserInfo extends Packet {

	ArrayList<UserInfo> userInfos;

	public PacketUserInfo() {
		channel = DEFAULT_CHANNEL;
		userInfos = new ArrayList<UserInfo>();
	}

	@Override
	public void packData() {
		data = new DNFile();

		int[] userIDs = new int[userInfos.size()];

		for (int i = 0; i < userInfos.size(); i++) {
			userIDs[i] = userInfos.get(i).userID;
			data.addByte("b." + userIDs[i], userInfos.get(i).toDNFile().toByteArray());
		}

		data.addInt("a", userIDs);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile();
		try {
			data.fromByteArray(packedData);

			int[] userIDs = data.getIntArray("a");
			if (userIDs == null) throw new MalformedPacketException();

			for (int i = 0; i < userIDs.length; i++) {
				DNFile file = new DNFile();
				file.fromByteArray(data.getByteArray("b." + userIDs[i]));
				userInfos.add(UserInfo.fromDNFile(file));
			}
		} catch (IOException e) {
			throw new MalformedPacketException();
		}
	}

	public void addUserInfo(UserInfo userInfo) {
		userInfos.add(userInfo);
	}

	public ArrayList<UserInfo> getUserInfos() {
		return userInfos;
	}

	@Override
	public String getName() {
		return "UserInfo";
	}

}
