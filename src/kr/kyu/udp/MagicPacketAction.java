/*
 * @(#)MagicPacketAction.java	2015. 12. 23
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import kr.kyu.vo.MagicPacketVO;


/**
 * The Class MagicPacketMgr.
 * packet 구조는 payload 6bytes 크기의 FF FF FF FF FF FF 를 처음에 붙이고, 다음으로 MAC address 의
 * byte 를 16번 반복하여 붙여서 UDP로 target IP로 전송 한다.
 *
 * [Packet Structure]
 * FF FF FF FF FF FF
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 * 0 -32 -111 50 20 -18
 */
public class MagicPacketAction {

	// payload 패킷 사이즈 (FF FF FF FF FF FF)
	public static final int FIRST_PACKET_SIZE = 6;
	// MAC Address packet loop size
	public static final int MAC_ADDRESS_LOOP_SIZE = 16;
	// MAC Address split symbol
	public static final String MAC_SPLIT_SYMBOL = "-";

	/**
	 * <pre>
	 * process
	 * Magic Packet 전송
	 * </pre>.
	 *
	 * @param bean the bean
	 * @return true, if successful
	 */
	public boolean send(MagicPacketVO bean) throws Exception {
		try {
			byte[] macBytes = getMacBytes(bean.getDestMacAddr());
			int packetCnt = FIRST_PACKET_SIZE + (MAC_ADDRESS_LOOP_SIZE * macBytes.length);
			byte[] bytes = new byte[packetCnt];
			// payload packet 생성
			for (int i = 0; i < FIRST_PACKET_SIZE; i++) {
				bytes[i] = (byte) 0xff;
			}
			// MAC Address byte 정보 16번 bytes 배열에 추가
			for (int i = FIRST_PACKET_SIZE; i < bytes.length; i += macBytes.length) {
				System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
			}

			InetAddress address = InetAddress.getByName(bean.getDestIp());
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, bean.getPort());
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet); // Send The UDP Packet
			socket.close();

		} catch (Exception ex) {
			throw ex;
		}
		return true;
	}

	/**
	 * <pre>
	 * getMacBytes
	 * MAC Address 정보 byte 로 변환
	 * </pre>.
	 *
	 * @param macStr the mac str
	 * @return the mac bytes
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	private byte[] getMacBytes(String macStr) throws IllegalArgumentException {
		String[] hex = macStr.split(MAC_SPLIT_SYMBOL);
		byte[] bytes = new byte[hex.length];
		for (int i = 0; i < hex.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex[i], 16);
		}
		return bytes;
	}
}
