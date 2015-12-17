/*
 * @(#)WakeOnLanVO.java	2015. 12. 17
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.vo;


/**
 * The Class WakeOnLanVO.
 */
public class WakeOnLanVO {

	private int wolId;
	/** The name. */
	private String name;
	/** The mac address. */
	private String macAddress;
	/** The ip address. */
	private String ipAddress;
	/** The port. */
	private String port;

	/**
	 * @return the wolId
	 */
	public int getWolId() {
		return wolId;
	}

	/**
	 * @param wolId the wolId to set
	 */
	public void setWolId(int wolId) {
		this.wolId = wolId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the mac address.
	 *
	 * @return the mac address
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * Sets the mac address.
	 *
	 * @param macAddress the new mac address
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * Gets the ip address.
	 *
	 * @return the ip address
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the new ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}

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
		return "WakeOnLanVO [name=" + name + ", macAddress=" + macAddress + ", ipAddress=" + ipAddress + ", port="
				+ port + "]";
	}
}
