package kr.kyu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import kr.kyu.util.CommonUtil;

/**
 * @FileName : DinnerService.java
 * @Project : ImUtils
 * @Date : 2015. 12. 23.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class DinnerService extends Service {
	public static final long NOTIFY_INTERVAL = 20 * 1000;
	public static final long VIBRATE_INTERVAL = 10 * 1000;
	public static final String COMPANY_WIFI_NAME = "NCMobile";
	public static final int START_TIME = 200000;
	public static final int END_TIME = START_TIME + 100;

	// run on another Thread to avoid crash
	private Handler mHandler = new Handler();
	// timer handling
	private Timer mTimer = null;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		// cancel if already existed
		if (mTimer != null) {
			mTimer.cancel();
		} else {
			// recreate new
			mTimer = new Timer();
		}
		// schedule task
//		mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
	}

	class TimeDisplayTimerTask extends TimerTask {
		@Override
		public void run() {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
//					Toast.makeText(getApplicationContext(), getDateTime(), Toast.LENGTH_SHORT).show();

					// 회사 wifi 여부 체크
					if (isCompanyWifi()) {
						String timeStr = new SimpleDateFormat("HHmmss", Locale.KOREA).format(new Date());
						int time = Integer.parseInt(timeStr);
						if (START_TIME <= time && time < END_TIME) {
							CommonUtil.showLongToast(getApplicationContext(), getString(R.string.dinnerMsg), (int) VIBRATE_INTERVAL);
							Vibrator mVibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
							mVibe.vibrate(VIBRATE_INTERVAL);
						}
					}
				}

				/**
				 * <pre>
				 * getWifiName
				 *
				 * <pre>
				 */
				private boolean isCompanyWifi() {
					WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
					String wifi = wifiManager.getConnectionInfo().getSSID();
					if (COMPANY_WIFI_NAME.equals(wifi)) {
						return true;
					}

					return false;
				}
			});
		}

		@SuppressLint("SimpleDateFormat")
		private String getDateTime() {
			// get date time in custom format
			SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/MM/dd - HH:mm:ss]");
			return sdf.format(new Date());
		}

	}
}