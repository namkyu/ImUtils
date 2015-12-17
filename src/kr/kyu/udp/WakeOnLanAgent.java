/*
 * @(#)WakeOnLanAgent.java	2015. 12. 17
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.udp;

import kr.kyu.vo.MagicPacketVO;

/**
 * The Class WakeOnLanAgent.
 */
public class WakeOnLanAgent {

	/**
	 * <pre>
	 * wakeUpSend
	 *
	 * </pre>.
	 *
	 * @param bean the bean
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean packetSend(MagicPacketVO bean) throws Exception {
		MagicPacketAction mgr = new MagicPacketAction();
		boolean isSuccess = mgr.send(bean);
		return isSuccess;
	}
}
