/*
 * @(#)DinnerActivity.java	2015. 10. 16
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import kr.kyu.util.CommonUtil;

public class DinnerActivity extends Activity implements OnClickListener {

	public ImageButton m_btnNetworkInfo = null;
	public TextView m_tvNetworkInfo2 = null;

	private NotificationManager mNM;
	private Notification mNoti;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dinner_layout);

		m_btnNetworkInfo = (ImageButton) findViewById(R.id.searchButton);
		m_btnNetworkInfo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

				NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

				String wifi = wifiManager.getConnectionInfo().getSSID();
				String baseStation = activeNetwork.getExtraInfo();

				TextView textView5 = (TextView) findViewById(R.id.textView5);
				TextView textView6 = (TextView) findViewById(R.id.textView6);
				textView5.setText(wifi);
				textView6.setText(baseStation);

				// time 정보 가져오기
				TextView textView7 = (TextView) findViewById(R.id.textView7);
				String format = new String("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREA);
				textView7.setText(sdf.format(new Date()));

				// 시간 가져오기
				String hoursStr = new SimpleDateFormat("h", Locale.KOREA).format(new Date());
				CommonUtil.showShortToast(DinnerActivity.this, "현재 시간은 :" + hoursStr);

				int hour = Integer.parseInt(hoursStr);
				if (hour >= 8) { // 저녁 8시 이후라면
					CommonUtil.showShortToast(DinnerActivity.this, "알람을 울려라!!!!!!");
				}
			}
		});

		// 알람
		ImageButton vibrate = (ImageButton) findViewById(R.id.alarmButton);
		vibrate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Vibrator mVibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				mVibe.vibrate(10000);

			}
		});

	}

	/**
	 * <pre>
	 * onClick
	 *
	 * <pre>
	 *
	 * @param dialog
	 * @param which
	 */
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) { // information
			Intent intent = new Intent(DinnerActivity.this, InformationTheme.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
