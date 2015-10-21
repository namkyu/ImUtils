/*
 * @(#)DatabaseHelper.java	2015. 10. 16
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.db;

import kr.kyu.common.Constants;
import kr.kyu.util.CommonUtil;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * The Class DatabaseHelper.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	/** The TAG. */
	private String TAG = getClass().getName();

	/** The db. */
	DBAdapter adapter;

	/**
	 * Instantiates a new database helper.
	 *
	 * @param context the context
	 */
	public DatabaseHelper(Context context) {
		super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
		CommonUtil.d(TAG, "initial open database");
	}

	/**
	 * <pre>
	 * onCreate
	 * android application 첫 설치 시 호출되는 메서드
	 * </pre>.
	 *
	 * @param db the db
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {

		CommonUtil.d(TAG, "onCreate method call!!" + db);
		db.execSQL(createTable());
	}

	/**
	 * <pre>
	 * onUpgrade
	 *
	 * </pre>.
	 *
	 * @param db the db
	 * @param oldVersion the old version
	 * @param newVersion the new version
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		CommonUtil.d(TAG, "Upgrading db from version" + oldVersion + " to" + newVersion + ", which will destroy all old data");
		db.execSQL(dropTable());
		onCreate(db);
	}

	/**
	 * <pre>
	 * dropTable
	 * drop table 쿼리문
	 * </pre>
	 * @return
	 */
	private String dropTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("\n drop table   ");
		sql.append("\n 	if exists won_info_tbl  ");

		CommonUtil.d(TAG, sql.toString());
		return sql.toString();
	}

	/**
	 * <pre>
	 * createTable
	 * 테이블 생성
	 * </pre>
	 * @return
	 */
	private String createTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("\n create table won_info_tbl (  ");
		sql.append("\n 	_id integer primary key autoincrement,   ");
		sql.append("\n 	name varchar(20),   ");
		sql.append("\n 	mac_address varchar(20),  ");
		sql.append("\n 	ip_address varchar(20),   ");
		sql.append("\n 	port varchar(20),   ");
		sql.append("\n 	create_time date  ");
		sql.append("\n )  ");

		CommonUtil.d(TAG, sql.toString());
		return sql.toString();
	}
}
