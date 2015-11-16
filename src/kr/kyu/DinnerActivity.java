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
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import kr.kyu.util.CommonUtil;

public class DinnerActivity extends Activity {

	public ImageButton m_btnNetworkInfo = null;
	public TextView m_tvNetworkInfo2 = null;

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
	}

}
