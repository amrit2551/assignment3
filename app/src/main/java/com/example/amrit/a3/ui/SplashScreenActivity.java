package com.example.amrit.a3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.amrit.a3.BaseActivity;
import com.example.amrit.a3.R;

/**
 * Created by palak on 20/4/17.
 */

public class SplashScreenActivity extends BaseActivity {
	private static final int SPLASH_SCREEN_TIMEOUT = 1000;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_splashscreen );
		new Handler().postDelayed( new Runnable() {
			@Override
			public void run() {
				Intent mainIntent = new Intent(SplashScreenActivity.this,ShowList.class);
				startActivity(mainIntent);
				finish();
			}
		},SPLASH_SCREEN_TIMEOUT);
	}
}
