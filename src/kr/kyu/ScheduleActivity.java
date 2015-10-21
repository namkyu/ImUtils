/*
 * @(#)ScheduleActivity.java	2015. 10. 16
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
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * The Class ScheduleActivity.
 */
public class ScheduleActivity extends Activity {

	/** The adapter. */
	ArrayAdapter<CharSequence> adapter;

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
		setContentView(R.layout.schedule_layout);

		Spinner spin = (Spinner)findViewById(R.id.scheduleSpinner);
		spin.setPrompt(getString(R.string.spinner_prompt_text));

		adapter = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adapter);

		spin.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ScheduleActivity.this,adapter.getItem(position) + " 지정하셨습니다.", Toast.LENGTH_SHORT).show();
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
}
