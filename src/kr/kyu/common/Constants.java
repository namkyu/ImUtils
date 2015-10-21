/*
 * @(#)Constants.java	2015. 10. 16
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.common;


/**
 * The Interface Constants.
 */
public interface Constants {

	public static final int FIRST_PACKET_SIZE = 6; // payload 패킷 사이즈 (FF FF FF FF FF FF)
	public static final int MAC_ADDRESS_LOOP_SIZE = 16; // MAC Address packet loop size
	public static final String MAC_SPLIT_SYMBOL = "-"; // MAC Address split symbol

	public static final int NAME_TEXT_BOX_LIMIT_SIZE = 20; // Name 입력 테스트 길이 제한
	public static final int MAC_TEXT_BOX_LIMIT_SIZE = 17; // MAC Address 입력 텍스트 길이 제한
	public static final int IP_TEXT_BOX_LIMIT_SIZE = 20; // IP 입력 테스트 길이 제한
	public static final int PORT_TEXT_BOX_LIMIT_SIZE = 20; // Port 입력 텍스트 길이 제한

	public static final int CURRENT_TAB_LIST_INDEX = 0; // MAC Address 리스트 Activity
	public static final int CURRENT_TAB_ADD_INDEX = 1;// Add 화면 Activity
	public static final int CURRENT_TAB_SCHEDULE_INDEX = 2; // Schedule 화면 Activity

	public static final String KEY_NAME = "name"; // name
	public static final String KEY_MAC_ADDRESS = "mac_address"; // mac_address
	public static final String KEY_IP_ADDRESS = "ip_address"; // ip_address
	public static final String KEY_PORT = "port"; // port
	public static final String KEY_CREATE_TIME = "create_time"; // 입력 시간
	public static final String KEY_ID = "_id"; // primary key id (auto increment)

	public static final String DATABASE_TABLE = "won_info_tbl"; // 테이블 이름
	public static final String DATABASE_NAME = "won.db"; // database 파일 이름
	public static final int DATABASE_VERSION = 1; // database 버전

	public static final boolean LOG_STAT = true; // 로그 기록 여부
	public static final String COMMENT_MARK = "#################################################";
}
