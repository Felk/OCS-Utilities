package de.speedcube.ocsUtilities.packets;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public class PacketSound extends Packet {
	public int sampleRate;
	public int sampleSize;
	public byte channels;
	public byte[] soundData;

	public PacketSound() {
		channel = DEFAULT_CHANNEL;
	}
	
	@Override
	public void packData() {
		data = new DNFile("");

		data.addNode("a", sampleRate);
		data.addNode("b", sampleSize);
		data.addNode("c", channels);
		data.addNode("d", soundData);
		
		packedData = data.toByteArray();
	}

	@Override
	public void unpack() {
		data = new DNFile("");
		data.fromByteArray(packedData);

		sampleRate = data.getInt("a");
		sampleSize = data.getInt("b");
		channels = data.getByte("c");
		soundData = data.getByteArray("d");
	}

	@Override
	public String getName() {
		return "Sound";
	}

}
