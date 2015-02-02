package com.face3_test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;

public class Splashscreen extends Activity {

	public static int SPLASH_TIME_OUT = 3000;

	private Intent _DashboardIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splashscreen);

		this._DashboardIntent = new Intent(getApplicationContext(),
				Actorlistcontroller.class);

		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity

					startActivity(_DashboardIntent);
					finish();

			
				
				//back 
				//overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
				
				
				//entry
				//overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

				// close this activity

				}

		}, SPLASH_TIME_OUT);

		// Check if Internet present

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splashscreen, menu);
		return true;
	}

}
