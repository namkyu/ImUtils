/*
 * @(#)CommonUtil.java	2015. 12. 23
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import kr.kyu.common.Constants;

/**
 * The Class CustomLog.
 */
public class CommonUtil {

	/**
	 * <pre>
	 * d
	 *
	 * <pre>
	 * @param tag
	 * @param msg
	 */
	public static void d(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.d(tag, Constants.COMMENT_MARK);
			Log.d(tag, msg);
			Log.d(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * <pre>
	 * i
	 *
	 * <pre>
	 * @param tag
	 * @param msg
	 */
	public static void i(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.i(tag, Constants.COMMENT_MARK);
			Log.i(tag, msg);
			Log.i(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * <pre>
	 * w
	 *
	 * <pre>
	 * @param tag
	 * @param msg
	 */
	public static void w(String tag, String msg) {
		if (Constants.LOG_STAT) {
			Log.w(tag, Constants.COMMENT_MARK);
			Log.w(tag, msg);
			Log.w(tag, Constants.COMMENT_MARK);
		}
	}

	/**
	 * <pre>
	 * e
	 *
	 * <pre>
	 * @param tag
	 * @param msg
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
	public static void showLongToast(Context context, String msg, int interval) {
		Toast.makeText(context, msg, interval).show();
	}
}
