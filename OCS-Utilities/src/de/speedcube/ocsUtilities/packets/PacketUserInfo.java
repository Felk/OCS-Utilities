package de.speedcube.ocsUtilities.packets;

import java.util.ArrayList;

import de.speedcube.ocsUtilities.UserInfo;
import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketUserInfo extends Packet {

	ArrayList<UserInfo> userInfos;

	public PacketUserInfo() {
		userInfos = new ArrayList<UserInfo>();
	}

	@Override
	public void pack() {
		data = new DNFile("");

		int[] userIDs = new int[userInfos.size()];

		for (int i = 0; i < userInfos.size(); i++) {
			userIDs[i] = userInfos.get(i).userID;
			data.addNode("b." + userIDs[i], userInfos.get(i).toDNFile().toByteArray());
		}

		data.addNode("a", userIDs);
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		int[] userIDs = data.getIntArray("a");
		if (userIDs == null) throw new MalformedPacketException();

		for (int i = 0; i < userIDs.length; i++) {
			DNFile file = new DNFile("");
			file.fromByteArray(data.getByteArray("b." + userIDs[i]));
			userInfos.add(UserInfo.fromDNFile(file));
		}

	}

	public void addUserInfo(UserInfo userInfo) {
		System.out.println("ADDING USERINFO ID: "+userInfo.userID);
		System.out.println("ADDING USERINFO UN: "+userInfo.username);
		System.out.println("ADDING USERINFO CL: "+userInfo.color);
		System.out.println("ADDING USERINFO RA: "+userInfo.rank);
		System.out.println("ADDING USERINFO ST: "+userInfo.status);
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
