/*
 * @(#)Constants.java	2015. 12. 17
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.common;


public interface Constants {

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
