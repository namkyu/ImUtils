/*
 * @(#)ImUtils.java	2015. 10. 16
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import kr.kyu.common.Constants;


/**
 * The Class SmartWakeUp.
 */
@SuppressWarnings("deprecation")
public class ImUtils extends TabActivity {

	/** The tab host. */
	private TabHost tabHost;

	/**
	 * <pre>
	 * onCreate
	 *
	 * </pre>.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// 현재의 Activity를 호출한 Intent를 가져온다.
		Intent intent = getIntent();
		// intent에 저장되어 있던 currentIdx 값 가져오기
		int currentIdx = intent.getIntExtra("currentIdx", Constants.CURRENT_TAB_LIST_INDEX);

		tabHost = getTabHost();

//		tabHost.addTab(tabHost
//				.newTabSpec(getString(R.string.tabIdList))
//				.setIndicator(getString(R.string.list), getResources().getDrawable(R.drawable.list))
//				.setContent(new Intent(this, WakeOnLanListActivity.class)));
//
//		tabHost.addTab(tabHost
//				.newTabSpec(getString(R.string.tabIdAdd))
//				.setIndicator(getString(R.string.add), getResources().getDrawable(R.drawable.add))
//				.setContent(new Intent(this, AddActivity.class)));

		tabHost.addTab(tabHost
				.newTabSpec(getString(R.string.tabIdWeather))
				.setIndicator(getString(R.string.weather), getResources().getDrawable(R.drawable.add))
				.setContent(new Intent(this, WeatherActivity.class)));

		tabHost.addTab(tabHost
				.newTabSpec(getString(R.string.tabIdDinner))
				.setIndicator(getString(R.string.dinner), getResources().getDrawable(R.drawable.time))
				.setContent(new Intent(this, DinnerActivity.class)));

		// tab 변경 이벤트 리스너
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String tabId) {
				Animation translateLeftAnim = AnimationUtils.loadAnimation(ImUtils.this, android.R.anim.slide_in_left);
				tabHost.getCurrentView().startAnimation(translateLeftAnim);
			}
		});

		tabHost.setCurrentTab(currentIdx);
	}

	/**
	 * <pre>
	 * onWindowFocusChanged
	 *
	 * <pre>
	 * @param hasFocus
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		//image 객체 생성
	}
}