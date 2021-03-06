package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.speedcube.ocsUtilities.PartyResultSet;
import de.speedcube.ocsUtilities.PartyStates;
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
	public int round;

	//public int[] users;

	public PacketPartyData() {
		channel = PARTY_CHANNEL;
	}

	@Override
	public void packData() {
		data = new DNFile();

		int[] userIDs;
		int[] averages;
		int[] times;

		if (results == null) return;
		int time_num = 0;
		for (PartyResultSet prs : results) {
			if (prs.getTimes() == null) continue;
			time_num = Math.max(time_num, prs.getTimes().length);
		}

		userIDs = new int[results.length];
		averages = new int[results.length];
		if (state == PartyStates.OPEN) {
			times = null;
		} else {
			times = new int[results.length * time_num];
		}

		for (int i = 0; i < results.length; i++) {
			PartyResultSet result = results[i];
			userIDs[i] = result.getUserID();
			averages[i] = result.getAverage();
			//if (result.getTimes() == null) {
			//if (i == 0) times = null;
			if (result.getTimes() == null) {
				continue;
			} else if (times != null) {
				int length = result.getTimes().length;
				for (int j = 0; j < length; j++) {
					times[i * length + j] = result.getTimes()[j];
				}
			}
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
		data.addInt("m", round);

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
		round = data.getInt("m");
		if (name == null || scrambleType == null || userIDs == null || averages == null) throw new MalformedPacketException();

		int time_num = (userIDs.length <= 0 || times == null) ? 0 : times.length / userIDs.length;
		if (userIDs.length != averages.length) throw new MalformedPacketException();
		results = new PartyResultSet[userIDs.length];

		for (int i = 0; i < userIDs.length; i++) {
			if (times != null) {
				int[] ts = new int[time_num];
				System.arraycopy(times, i * time_num, ts, 0, time_num);
				results[i] = new PartyResultSet(userIDs[i], ts, averages[i]);
			} else {
				results[i] = new PartyResultSet(userIDs[i], null, averages[i]);
			}
		}

		this.scrambles = scrambles;

	}

	@Override
	public String getName() {
		return "PartyData";
	}

}