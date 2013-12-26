package de.speedcube.ocsUtilities.packets;

import java.io.IOException;

import de.nerogar.DNFileSystem.DNFile;

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
		data = new DNFile();

		data.addInt("a", sampleRate);
		data.addInt("b", sampleSize);
		data.addByte("c", channels);
		data.addByte("d", soundData);
		
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
