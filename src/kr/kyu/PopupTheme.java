/*
 * @(#)PopupTheme.java	2015. 12. 17
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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import kr.kyu.common.Constants;
import kr.kyu.db.DBAdapter;
import kr.kyu.util.CommonUtil;

/**
 * The Class InformationTheme.
 */
public class PopupTheme extends Activity {

	/** The db. */
	DBAdapter db;

	/**
	 * <pre>
	 * onCreate
	 *
	 * <pre>
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 삭제
		setContentView(R.layout.popup);

		db = new DBAdapter(this);
		db.open();

		// update 버튼 클릭 이벤트
		Button updateButton = (Button) findViewById(R.id.update);
		updateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = getIntent();
				intent = new Intent(PopupTheme.this, ImUtils.class);
				intent.putExtra("currentIdx", Constants.CURRENT_TAB_ADD_INDEX); // intent 에 parameter key로 설정하여 저장
				intent.putExtra("mode", "update");
				startActivity(intent);
			}
		});

		// delete 버튼 클릭 이벤트
		Button deleteButton = (Button) findViewById(R.id.delete);
		deleteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = getIntent();
				String wolId = intent.getStringExtra("wolId");

				// 삭제
				boolean isSuccess = db.deleteWol(Integer.parseInt(wolId));
				if (isSuccess) {
					CommonUtil.showShortToast(PopupTheme.this, getString(R.string.deleteSuccess));
				} else {
					CommonUtil.showShortToast(PopupTheme.this, getString(R.string.deleteFail));
				}

				intent = new Intent(PopupTheme.this, ImUtils.class);
				intent.putExtra("currentIdx", Constants.CURRENT_TAB_LIST_INDEX); // intent 에 parameter key로 설정하여 저장
				startActivity(intent);
			}
		});
	}
}
