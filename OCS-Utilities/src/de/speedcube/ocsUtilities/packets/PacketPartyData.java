package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.speedcube.ocsUtilities.PartyResultSet;
import de.nerogar.DNFileSystem.DNFile;

public class PacketPartyData extends Packet {
	public int partyID;
	public int ownerID;
	public byte type;
	public int rounds;
	public int rounds_counting;
	public String name;
	public String scrambleType;
	public String[] scrambles;
	public PartyResultSet[] results;
	public int state;

	public PacketPartyData() {
		channel = PARTY_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		int[] userIDs;
		int[] averages;
		int[] times;

		if (results != null) {
			int time_num = results[0].getTimes().length;

			userIDs = new int[results.length];
			averages = new int[results.length];
			times = new int[results.length * time_num];

			for (int i = 0; i < results.length; i++) {
				PartyResultSet result = results[i];
				userIDs[i] = result.getUserID();
				averages[i] = result.getAverage();
				int length = result.getTimes().length;
				for (int j = 0; j < length; j++) {
					times[i * length + j] = result.getTimes()[j];
				}
			}
		} else {
			userIDs = null;
			averages = null;
			times = null;
		}

		data.addInt("a", partyID);
		data.addInt("b", ownerID);
		data.addByte("c", type);
		data.addInt("d", rounds);
		data.addInt("e", rounds_counting);
		data.addString("f", name);
		data.addString("g", scrambleType);
		data.addString("h", scrambles);
		data.addInt("i", userIDs);
		data.addInt("j", averages);
		data.addInt("k", times);
		data.addInt("l", state);

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

		partyID = data.getInt("a");
		ownerID = data.getInt("b");
		type = data.getByte("c");
		rounds = data.getInt("d");
		rounds_counting = data.getInt("e");
		name = data.getString("f");
		scrambleType = data.getString("g");
		String[] scrambles = data.getStringArray("h");
		int[] userIDs = data.getIntArray("i");
		int[] averages = data.getIntArray("j");
		int[] times = data.getIntArray("k");
		state = data.getInt("l");
		if (name == null || scrambleType == null) throw new MalformedPacketException();

		if (userIDs == null || averages == null || times == null) {
			results = null;
		} else {
			int time_num = times.length / userIDs.length;
			if (scrambles.length != time_num) throw new MalformedPacketException();
			if (userIDs.length == 0 || userIDs.length != averages.length) throw new MalformedPacketException();
			results = new PartyResultSet[userIDs.length];

			for (int i = 0; i < userIDs.length; i++) {
				int[] ts = new int[time_num];
				System.arraycopy(times, i * time_num, ts, 0, time_num);
				results[i] = new PartyResultSet(userIDs[i], ts, averages[i]);
			}
		}
		this.scrambles = scrambles;

	}

	@Override
	public String getName() {
		return "PartyData";
	}

}