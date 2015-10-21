/*
 * @(#)MagicPacketBean.java	2015. 10. 16
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.udp;


/**
 * The Class MagicPacketBean.
 */
public class MagicPacketBean {

	/** The port. */
	private int port;

	/** The source ip. */
	private String sourceIp;

	/** The dest ip. */
	private String destIp;

	/** The dest mac addr. */
	private String destMacAddr;

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Gets the source ip.
	 *
	 * @return the source ip
	 */
	public String getSourceIp() {
		return sourceIp;
	}

	/**
	 * Sets the source ip.
	 *
	 * @param sourceIp the new source ip
	 */
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	/**
	 * Gets the dest ip.
	 *
	 * @return the dest ip
	 */
	public String getDestIp() {
		return destIp;
	}

	/**
	 * Sets the dest ip.
	 *
	 * @param destIp the new dest ip
	 */
	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}

	/**
	 * Gets the dest mac addr.
	 *
	 * @return the dest mac addr
	 */
	public String getDestMacAddr() {
		return destMacAddr;
	}

	/**
	 * Sets the dest mac addr.
	 *
	 * @param destMacAddr the new dest mac addr
	 */
	public void setDestMacAddr(String destMacAddr) {
		this.destMacAddr = destMacAddr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * <pre>
	 * toString
	 *
	 * </pre>.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "MagicPacketBean [destIp=" + destIp + ", destMacAddr=" + destMacAddr + ", port=" + port + ", sourceIp="
				+ sourceIp + "]";
	}
}
