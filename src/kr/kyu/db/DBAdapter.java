/*
 * @(#)DBAdapter.java	2015. 12. 23
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import kr.kyu.common.Constants;
import kr.kyu.util.DateTimeUtil;
import kr.kyu.vo.WakeOnLanVO;


/**
 * The Class DBAdapter.
 */
public class DBAdapter {

	/** The database helper. */
	private DatabaseHelper databaseHelper;

	/** The sql. */
	private SQLiteDatabase sql;

	/** The context. */
	private final Context context;

	/**
	 * Instantiates a new dB adapter.
	 *
	 * @param ctx the ctx
	 */
	public DBAdapter(Context ctx) {
		this.context = ctx;
	}

	/**
	 * <pre>
	 * open
	 *
	 * </pre>.
	 *
	 * @return the dB adapter
	 * @throws SQLException the sQL exception
	 */
	public DBAdapter open() throws SQLException {
		databaseHelper = new DatabaseHelper(context);
		sql = databaseHelper.getWritableDatabase();
		return this;
	}

	/**
	 * <pre>
	 * close
	 *
	 * </pre>.
	 */
	public void close() {
		databaseHelper.close();
	}

	/**
	 * <pre>
	 * insertWakeOnLan
	 *
	 * </pre>.
	 *
	 * @param vo the vo
	 * @return the long
	 */
	public boolean insertWakeOnLan(WakeOnLanVO vo) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(Constants.KEY_NAME, vo.getName());
		initialValues.put(Constants.KEY_MAC_ADDRESS, vo.getMacAddress());
		initialValues.put(Constants.KEY_IP_ADDRESS, vo.getIpAddress());
		initialValues.put(Constants.KEY_PORT, vo.getPort());
		initialValues.put(Constants.KEY_CREATE_TIME, DateTimeUtil.getCurrentDate("yyyy-MM-dd"));
		return sql.insert(Constants.DATABASE_TABLE, null, initialValues) > 0;
	}

	/**
	 * <pre>
	 * updateWol
	 *
	 * <pre>
	 * @param vo
	 * @return
	 */
	public boolean updateWol(WakeOnLanVO vo) {
		ContentValues values = new ContentValues();
		values.put(Constants.KEY_NAME, vo.getName());
		values.put(Constants.KEY_MAC_ADDRESS, vo.getMacAddress());
		values.put(Constants.KEY_IP_ADDRESS, vo.getIpAddress());
		values.put(Constants.KEY_PORT, vo.getPort());
		return sql.update(Constants.DATABASE_TABLE, values, Constants.KEY_ID + "=" + vo.getWolId(), null) > 0;
	}

	/**
	 * <pre>
	 * deleteWol
	 *
	 * <pre>
	 * @param id
	 * @return
	 */
	public boolean deleteWol(int id) {
		return sql.delete(Constants.DATABASE_TABLE, Constants.KEY_ID + "=" + id, null) > 0;
	}

	/**
	 * <pre>
	 * wolInfoList
	 *
	 * <pre>
	 * @return
	 */
	public Cursor wolInfoList() {
		String[] colums = new String[] {
				Constants.KEY_ID,
				Constants.KEY_NAME,
				Constants.KEY_MAC_ADDRESS,
				Constants.KEY_IP_ADDRESS,
				Constants.KEY_PORT };
		return sql.query(Constants.DATABASE_TABLE, colums, null, null, null, null, null);

	}

	/**
	 * <pre>
	 * fetchWol
	 *
	 * <pre>
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Cursor fetchWol(long id) throws SQLException {
		Cursor mCursor = sql.query(true, Constants.DATABASE_TABLE, new String[] { Constants.KEY_ID, Constants.KEY_NAME, Constants.KEY_IP_ADDRESS, Constants.KEY_MAC_ADDRESS, Constants.KEY_PORT }, Constants.KEY_ID + "=" + id, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
}
