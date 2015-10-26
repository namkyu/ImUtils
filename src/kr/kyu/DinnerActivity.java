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

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DinnerActivity extends Activity {

	public ImageButton m_btnNetworkInfo = null;
	public TextView m_tvNetworkInfo2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dinner_layout);

		m_btnNetworkInfo = (ImageButton) findViewById(R.id.searchButton);
		m_tvNetworkInfo2 = (TextView) findViewById(R.id.resultDinner);

		m_btnNetworkInfo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

				NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
				String m_strName = new String();
				String m_strNetType = new String();
				int m_iNetworkType = activeNetwork.getType();
				if (m_iNetworkType == ConnectivityManager.TYPE_WIFI) {
					// Wi_Fi 사용 시 AP의 SSID를 가져온다.
					m_strName = wifiManager.getConnectionInfo().getSSID();
					m_strNetType = "Wi-Fi";
				} else if (m_iNetworkType == ConnectivityManager.TYPE_MOBILE) {
					// 모바일 네트워크 사용 시 네트워크 정보를 가져온다.
					m_strName = activeNetwork.getExtraInfo();
					m_strNetType = "Mobile";
				} else {
					m_strNetType = "None";
				}

				m_tvNetworkInfo2.setText("Name : " + m_strName + ", NetworkType : " + m_strNetType);
			}
		});
	}

}
