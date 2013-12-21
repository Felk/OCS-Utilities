package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.PartyResultSet;
import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketPartyData extends Packet {
	public int partyID;
	public int ownerID;
	public int type;
	public int rounds;
	public int rounds_counting;
	public String name;
	public String scramble;
	public PartyResultSet[] results;
	public int state;

	@Override
	public void packData() {
		data = new DNFile("");

		int time_num = results[0].getTimes().length;

		int[] userIDs = new int[results.length];
		int[] averages = new int[results.length];
		int[] times = new int[results.length * time_num];

		for (int i = 0; i < results.length; i++) {
			PartyResultSet result = results[i];
			userIDs[i] = result.getUserID();
			averages[i] = result.getAverage();
			int length = result.getTimes().length;
			for (int j = 0; j < length; j++) {
				times[i * length + j] = result.getTimes()[j];
			}
		}

		data.addNode("a", partyID);
		data.addNode("b", ownerID);
		data.addNode("c", type);
		data.addNode("d", rounds);
		data.addNode("e", rounds_counting);
		data.addNode("f", name);
		data.addNode("g", scramble);
		data.addNode("h", userIDs);
		data.addNode("i", averages);
		data.addNode("j", times);
		data.addNode("k", state);

		packedData = data.toByteArray();
	}

	@Override
	public void unpack() throws MalformedPacketException {
		data = new DNFile("");
		data.fromByteArray(packedData);

		partyID = data.getInt("a");
		ownerID = data.getInt("b");
		type = data.getInt("c");
		rounds = data.getInt("d");
		rounds_counting = data.getInt("e");
		name = data.getString("f");
		scramble = data.getString("g");
		int[] userIDs = data.getIntArray("h");
		int[] averages = data.getIntArray("i");
		int[] times = data.getIntArray("j");
		state = data.getInt("k");
		if (name == null || scramble == null || userIDs == null || averages == null || times == null) throw new MalformedPacketException();
		if (userIDs.length == 0 || userIDs.length != averages.length) throw new MalformedPacketException();

		int time_num = times.length / userIDs.length;

		results = new PartyResultSet[userIDs.length];

		for (int i = 0; i < userIDs.length; i++) {
			int[] ts = new int[time_num];
			System.arraycopy(times, i * time_num, ts, 0, time_num);
			results[i] = new PartyResultSet(userIDs[i], ts, averages[i]);
		}

	}

	@Override
	public String getName() {
		return "PartyData";
	}

}