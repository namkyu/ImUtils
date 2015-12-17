/*
 * @(#)WakeOnLanListActivity.java	2015. 12. 17
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import kr.kyu.common.Constants;
import kr.kyu.db.DBAdapter;
import kr.kyu.udp.WakeOnLanAgent;
import kr.kyu.util.CommonUtil;
import kr.kyu.vo.MagicPacketVO;


/**
 * The Class WakeOnLanListActivity.
 */
public class WakeOnLanListActivity extends ListActivity {

	/** The TAG. */
	private String TAG = getClass().getName();

	/** The db. */
	DBAdapter db;

	/** The adapter. */
	SimpleCursorAdapter adapter;

	/** The long touch flag. */
	private boolean longTouchFlag = false;

	/**
	 * <pre>
	 * onCreate
	 *
	 * </pre>.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		db = new DBAdapter(this);
		db.open();

		Cursor cursor = db.wolInfoList();
		startManagingCursor(cursor);

		String[] from = new String[] { Constants.KEY_NAME };
		int[] to = new int[] { R.id.name };

		adapter = new SimpleCursorAdapter(this, R.layout.list_layout, cursor, from, to);
		setListAdapter(adapter);

		getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Cursor cursor = (Cursor) adapter.getItem(position);
				String wolId = cursor.getString(cursor.getColumnIndex(Constants.KEY_ID));

				// 팝업 Activity
				Intent intent = new Intent(WakeOnLanListActivity.this, PopupTheme.class);
				intent.putExtra("wolId", wolId);
				startActivity(intent);

				longTouchFlag = true;
				return longTouchFlag;
			}
		});
	}

	/**
	 * <pre>
	 * onListItemClick
	 *
	 * </pre>.
	 *
	 * @param list the list
	 * @param view the view
	 * @param position the position
	 * @param id the id
	 */
	@Override
	public void onListItemClick(ListView list, View view, int position, long id) {
		if (longTouchFlag == false) { // 길게 터치를 안 한 경우에만 WON 패킷을 전송 한다.
			Cursor cursor = (Cursor)adapter.getItem(position);
			String name = cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME));
			String mac = cursor.getString(cursor.getColumnIndex(Constants.KEY_MAC_ADDRESS));
			String ip = cursor.getString(cursor.getColumnIndex(Constants.KEY_IP_ADDRESS));
			String port = cursor.getString(cursor.getColumnIndex(Constants.KEY_PORT));
			CommonUtil.d(TAG, "name : " + name + ", mac : " + mac + ", ip : " + ip + ", port : " + port);

			// send magic packet
			WakeOnLanAgent agent = new WakeOnLanAgent();
			MagicPacketVO bean = new MagicPacketVO();
			bean.setDestIp(ip);
			bean.setDestMacAddr(mac);
			bean.setPort(Integer.parseInt(port));
			try {
				agent.packetSend(bean);
			} catch (Exception ex) {
				CommonUtil.e(TAG, "packet send failure " + ex);
				CommonUtil.showShortToast(this, getString(R.string.packetSendFailure));
				return;
			}

			// 성공
			CommonUtil.showShortToast(this, getString(R.string.packetSendSuccess));

		} else {
			longTouchFlag = false;
		}

	}

	/**
	 * <pre>
	 * onCreateOptionsMenu
	 * 메뉴 버튼 클릭 시 동작하는 이벤트
	 * </pre>
	 * @param menu
	 * @return
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, getString(R.string.info));
        return (super.onCreateOptionsMenu(menu));
	}

	/**
	 * <pre>
	 * onOptionsItemSelected
	 * 메뉴 버튼 클릭 시 노출되는 메뉴 클릭 시 동작
	 * </pre>
	 * @param item
	 * @return
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) { // information
			Intent intent = new Intent(WakeOnLanListActivity.this, InformationTheme.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
