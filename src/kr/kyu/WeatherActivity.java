/*
 * @(#)WeatherActivity.java	2015. 10. 16
 *
 * Copyright(c) 2009 namkyu.
 *
 * NOTICE:
 * This source code that is confidential and proprietary to namkyu.
 * No part of this source code may be reproduced in any form
 * whatsoever without prior approval by namkyu.
 */
package kr.kyu;

import java.util.List;

import org.apache.commons.lang3.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import kr.kyu.vo.Row;
import kr.kyu.vo.WeatherVO;

/**
 * The Class AddActivity.
 */
public class WeatherActivity extends Activity {

	/** The tag. */
	private String TAG = getClass().getName();

	/**
	 * <pre>
	 * onCreate
	 *
	 * </pre>
	 *
	 * .
	 *
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather_layout);

		// 검색 버튼 클릭 이벤트
		ImageButton searchButton = (ImageButton) findViewById(R.id.searchButton);
		searchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				// 미세 먼지 추출
				HttpClient httpClient = new DefaultHttpClient();
				String urlString = "http://openapi.seoul.go.kr:8088/7470784c746c6e673836727a49536b/json/ForecastWarningUltrafineParticleOfDustService/1/5/";
				try {
					HttpGet httpGet = new HttpGet(urlString);
					HttpResponse response = httpClient.execute(httpGet);
					String responseBodyJson = EntityUtils.toString(response.getEntity(), CharEncoding.UTF_8);

					ObjectMapper mapper = new ObjectMapper();
					WeatherVO vo = mapper.readValue(responseBodyJson, WeatherVO.class);
					List<Row> row = vo.getForecastWarningUltrafineParticleOfDustService().getRow();
					for (Row weatherRowData : row) {
						TextView textView5 = (TextView) findViewById(R.id.textView5);
						TextView textView6 = (TextView) findViewById(R.id.textView6);
						TextView textView7 = (TextView) findViewById(R.id.textView7);

						textView5.setText((weatherRowData.getFAON().equals("f")) ? "예보" : "경보");
						textView6.setText(weatherRowData.getCAISTEP());
						textView7.setText(weatherRowData.getALARMCNDT());
						break;
					}

				} catch (Exception e) {
					Log.e(TAG, e.getLocalizedMessage());
					e.printStackTrace();
				}
			}
		});

	}
}
