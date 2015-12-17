/*
 * @(#)AddActivity.java	2015. 12. 17
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu;

import static kr.kyu.common.Constants.*;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import kr.kyu.common.Constants;
import kr.kyu.db.DBAdapter;
import kr.kyu.util.CommonUtil;
import kr.kyu.vo.WakeOnLanVO;


/**
 * The Class AddActivity.
 */
public class FormActivity extends Activity {

	// Name 입력 테스트 길이 제한
	private static final int NAME_TEXT_BOX_LIMIT_SIZE = 20;
	// MAC Address 입력 텍스트 길이 제한
	private static final int MAC_TEXT_BOX_LIMIT_SIZE = 17;
	// IP 입력 테스트 길이 제한
	private static final int IP_TEXT_BOX_LIMIT_SIZE = 20;
	// Port 입력 텍스트 길이 제한
	private static final int PORT_TEXT_BOX_LIMIT_SIZE = 20;

	/** The name edit. */
	private EditText nameEdit;

	/** The mac edit. */
	private EditText macEdit;

	/** The ip edit. */
	private EditText ipEdit;

	/** The port edit. */
	private EditText portEdit;

	/** The db. */
	DBAdapter db;

	/**
	 * <pre>
	 * isUpdate
	 *
	 * <pre>
	 * @param value
	 * @return
	 */
	private boolean isUpdate(String value) {
		if (value != null && "update".equals(value)) {
			return true;
		}
		return false;
	}

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
		setContentView(R.layout.add_layout);

		// sqlite open
		db = new DBAdapter(this);
		db.open();

		nameEdit = (EditText) findViewById(R.id.nameTextBox);
		macEdit = (EditText) findViewById(R.id.macTextBox);
		ipEdit = (EditText) findViewById(R.id.ipTextBox);
		portEdit = (EditText) findViewById(R.id.portTextBox);

		// Edit 박스 길이 제한
		nameEdit.setFilters(new InputFilter[] { new InputFilter.LengthFilter(NAME_TEXT_BOX_LIMIT_SIZE) });
		macEdit.setFilters(new InputFilter[] { new InputFilter.LengthFilter(MAC_TEXT_BOX_LIMIT_SIZE) });
		ipEdit.setFilters(new InputFilter[] { new InputFilter.LengthFilter(IP_TEXT_BOX_LIMIT_SIZE) });
		portEdit.setFilters(new InputFilter[] { new InputFilter.LengthFilter(PORT_TEXT_BOX_LIMIT_SIZE) });

		// MAC Edit change event
		macEdit.addTextChangedListener(mWatcher);

		// intent information
		Intent intent = getIntent();
		final int wolId = intent.getIntExtra(WOL_ID, 0);
		final boolean updateMode = isUpdate(intent.getStringExtra("mode"));

		if (updateMode) {
			Cursor cursor = db.fetchWol(wolId);
			String name = cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME));
			String mac = cursor.getString(cursor.getColumnIndex(Constants.KEY_MAC_ADDRESS));
			String ip = cursor.getString(cursor.getColumnIndex(Constants.KEY_IP_ADDRESS));
			String port = cursor.getString(cursor.getColumnIndex(Constants.KEY_PORT));
			nameEdit.setText(name);
			macEdit.setText(mac);
			ipEdit.setText(ip);
			portEdit.setText(port);
		}

		// Add 버튼 클릭 이벤트
		ImageButton addButton = (ImageButton) findViewById(R.id.addButton);
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = nameEdit.getText().toString();
				String macAddress = macEdit.getText().toString();
				String ipAddress = ipEdit.getText().toString();
				String port = portEdit.getText().toString();

				// 유효성 검사
				if (TextUtils.isEmpty(name)) {
					CommonUtil.showShortToast(FormActivity.this, getString(R.string.nameIsEmpty));
					return;
				} else if (TextUtils.isEmpty(macAddress)) {
					CommonUtil.showShortToast(FormActivity.this, getString(R.string.macAddressIsEmpty));
					return;
				} else if (TextUtils.isEmpty(ipAddress)) {
					CommonUtil.showShortToast(FormActivity.this, getString(R.string.ipAddressIsEmpty));
					return;
				} else if (TextUtils.isEmpty(port)) {
					CommonUtil.showShortToast(FormActivity.this, getString(R.string.portIsEmpty));
					return;
				}

				// vo setting
				WakeOnLanVO vo = new WakeOnLanVO();
				vo.setWolId(wolId);
				vo.setName(name);
				vo.setMacAddress(macAddress);
				vo.setIpAddress(ipAddress);
				vo.setPort(port);

				// save
				boolean saveSuccess = false;
				if (updateMode) {
					saveSuccess = db.updateWol(vo);
				} else {
					saveSuccess = db.insertWakeOnLan(vo);
				}

				// message
				if (saveSuccess) {
					String msg = name + " " + getString(R.string.saveSuccess);
					CommonUtil.showShortToast(FormActivity.this, msg);
				} else {
					CommonUtil.showShortToast(FormActivity.this, getString(R.string.saveFail));
					return;
				}

				// 첫 번째 인자는 현재 컨텍스트이고, 두 번째 인자는 호출 할 Activity의 class 이다.
				Intent intent = new Intent(FormActivity.this, ImUtils.class);
				intent.putExtra("currentIdx", Constants.CURRENT_TAB_LIST_INDEX); // intent 에 parameter key로 설정하여 저장
				startActivity(intent);
			}
		});

		// Cancel 버튼 클릭 이벤트
		ImageButton cancelButton = (ImageButton) findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Editable nameValue = nameEdit.getText();
				Editable macValue = macEdit.getText();
				Editable ipValue = ipEdit.getText();
				Editable portValue = portEdit.getText();

				nameValue.clear();
				macValue.clear();
				ipValue.clear();
				portValue.clear();
			}
		});
	}

	/** The m watcher. */
	TextWatcher mWatcher = new TextWatcher() {
		public void afterTextChanged(Editable s) {
			CommonUtil.d(getClass().getName(), "afterTextChanged");
		}
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			CommonUtil.d(getClass().getName(), "beforeTextChanged");
		}
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			CommonUtil.d(getClass().getName(), "onTextChanged");
		}
	};
}
