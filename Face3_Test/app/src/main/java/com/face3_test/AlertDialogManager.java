package com.face3_test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;



@SuppressLint("NewApi")
public class AlertDialogManager extends Activity {
	/**
	 * Function to display simple Alert Dialog
	 * @param context - application context
	 * @param title - alert dialog title
	 * @param message - alert message
	 * @param status - success/failure (used to set icon)
	 * 				 - pass null if you don't want icon
	 * */
	 public Context _context;
	@SuppressWarnings("deprecation")	
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {

		_context = context;
		
		AlertDialog alertDialog = new AlertDialog.Builder(_context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		if(status != null)
			// Setting alert dialog icon
		//	alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				
				start();
				
			}
		});

		
		// Showing Alert Message
		alertDialog.show();
	}
	public void start()
	{
		Intent intent = new Intent(_context, Actorlistcontroller.class);
		Log.i("ffsdfsdf",String.valueOf(_context));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		_context.startActivity(intent);
			}

}
