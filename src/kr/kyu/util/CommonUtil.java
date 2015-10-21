/*
 * @(#)CommonUtil.java	2015. 10. 16
 * 
 * Copyright(c) 2009 namkyu.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.util;

import kr.kyu.common.Constants;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * The Class CustomLog.
 */
public class CommonUtil {

	/**
	 * D.
	 *
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the msg
	 */
	public static void d(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.d(tag, Constants.COMMENT_MARK);
			Log.d(tag, msg);
			Log.d(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * I.
	 *
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the msg
	 */
	public static void i(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.i(tag, Constants.COMMENT_MARK);
			Log.i(tag, msg);
			Log.i(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * W.
	 *
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the msg
	 */
	public static void w(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.w(tag, Constants.COMMENT_MARK);
			Log.w(tag, msg);
			Log.w(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * E.
	 *
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the msg
	 */
	public static void e(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.e(tag, Constants.COMMENT_MARK);
			Log.e(tag, msg);
			Log.e(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * <pre>
	 * showToast
	 * 짧게 표시하기
	 * </pre>
	 * @param context
	 * @param msg
	 */
	public static void showShortToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	/**
	 * <pre>
	 * showLongToast
	 * 길게 표시하기
	 * </pre>
	 * @param context
	 * @param msg
	 */
	public static void showLongToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
}
