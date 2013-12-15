package de.speedcube.ocsUtilities.packets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.speedcube.ocsUtilities.DNFile.DNFile;

public abstract class Packet {

	protected DNFile data;
	public byte[] packedData;
	public byte[] networkBuffer;
	public int packetID;
	public int channel = DEFAULT_CHANNEL;
	private boolean packed = false;

	public static final int DEFAULT_CHANNEL = 0;
	public static final int CHAT_CHANNEL = 1;
	public static final int LOGIN_PAGE_CHANNEL = 2;

	protected static ArrayList<Class<? extends Packet>> packets = new ArrayList<Class<? extends Packet>>();
	protected static HashMap<Class<? extends Packet>, Integer> packetIdMap = new HashMap<Class<? extends Packet>, Integer>();

	public Packet() {
		setID();
	}

	public void setID() {
		packetID = packetIdMap.get(getClass());
	}

	public static Class<? extends Packet> getPacket(int id) {
		return packets.get(id);
	}

	public abstract void packData();

	public void pack() {
		packData();
		networkBuffer = new byte[packedData.length + 8];
		System.arraycopy(packedData, 0, networkBuffer, 8, packedData.length);
		networkBuffer[0] = (byte) ((packedData.length & 0xff000000) >> 24);
		networkBuffer[1] = (byte) ((packedData.length & 0xff0000) >> 16);
		networkBuffer[2] = (byte) ((packedData.length & 0xff00) >> 8);
		networkBuffer[3] = (byte) ((packedData.length & 0xff));

		networkBuffer[4] = (byte) ((packetID & 0xff000000) >> 24);
		networkBuffer[5] = (byte) ((packetID & 0xff0000) >> 16);
		networkBuffer[6] = (byte) ((packetID & 0xff00) >> 8);
		networkBuffer[7] = (byte) ((packetID & 0xff));
		setPacked(true);
	}

	public abstract void unpack() throws MalformedPacketException;

	public DNFile getData() {
		return data;
	}

	public abstract String getName();

	private static void registerPacket(Class<? extends Packet> packet) {
		packetIdMap.put(packet, packetIdMap.size());
		packets.add(packet);
	}

	public static void dumpIds() {
		for (Map.Entry<Class<? extends Packet>, Integer> e : packetIdMap.entrySet()) {
			System.out.println(e.getValue() + ": " + e.getKey().getSimpleName());
		}
	}

	public boolean isPacked() {
		return packed;
	}

	public void setPacked(boolean packed) {
		this.packed = packed;
	}

	static {
		registerPacket(PacketConnectionInfo.class);//has to be at position 0

		registerPacket(PacketSalt.class);
		registerPacket(PacketSaltGet.class);
		registerPacket(PacketLogin.class);
		registerPacket(PacketLoginError.class);
		registerPacket(PacketLoginSuccess.class);
		registerPacket(PacketUserlist.class);
		registerPacket(PacketUserInfo.class);
		registerPacket(PacketChat.class);
		registerPacket(PacketChatBroadcast.class);
		registerPacket(PacketRegistration.class);
		registerPacket(PacketRegistrationError.class);
		registerPacket(PacketRegistrationSuccess.class);
		registerPacket(PacketLogout.class);
		registerPacket(PacketDisconnect.class);
		registerPacket(PacketChannelEnter.class);
		registerPacket(PacketSystemMessage.class);
		registerPacket(PacketProfileInfo.class);

		//dumpIds();
	}
}
