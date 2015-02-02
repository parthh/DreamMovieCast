package com.face3_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToastAdapter {
	Handler handler = new Handler();
	private Context _Context;
	private String _Message;
	private String _Title;
	private Toast _Toast = null;
	private int _Image;
	private String _TitleColor = "#1F7BBE";
	private String _Titlec = "#1F7BBE";

	public CustomToastAdapter(Context context, String message) {

		this.setContext(context);
		this.setMessage(message);
	}

	public Context getContext() {
		return _Context;
	}

	public void setContext(Context context) {
		this._Context = context;
	}

	public String getMessage() {
		return _Message;
	}

	public void setMessage(String message) {
		this._Message = message;
	}

	public Toast getToast() {
		return _Toast;
	}

	public void setToast(Toast toast) {
		this._Toast = toast;
	}
	
	public String getTitle() {
		return _Title;
	}

	public void setTitle(String title) {
		this._Title = title;
	}

	public int getImage() {
		return _Image;
	}

	public void setImage(int _Image) {
		this._Image = _Image;
	}

	public void showToast() {

		Toast.makeText(this.getContext(), this.getMessage(), Toast.LENGTH_SHORT)
				.show();
	}


	public void showCenterToast() {

		this.setToast(Toast.makeText(this.getContext(), this.getMessage(),
				Toast.LENGTH_SHORT));
		this.getToast().setGravity(Gravity.CENTER, 0, 0);
		this.getToast().show();
	}


	@SuppressLint("ShowToast")
	public void showImageToast(int imageid) {

		this.setToast(Toast.makeText(this.getContext(), this.getMessage(), Toast.LENGTH_LONG));

		this.getToast().setGravity(Gravity.CENTER, 0, 0);

		LinearLayout toastView = (LinearLayout) this.getToast().getView();
		ImageView imageCodeProject = new ImageView(this.getContext());
		imageCodeProject.setImageResource(imageid);
		toastView.addView(imageCodeProject, 0);

		this.getToast().show();
	}


	@SuppressLint("ShowToast")
	public void showCustomToast(LayoutInflater _LayoutInflater, ViewGroup _ViewGroup) {

		View _ViewLayout = _LayoutInflater.inflate(R.layout.customtoast, _ViewGroup);

		TextView _TotalTitle = (TextView) _ViewLayout.findViewById(R.id.toast_title);
		_TotalTitle.setText(this.getTitle());
		//_TotalTitle.setB
		
		TextView text = (TextView) _ViewLayout.findViewById(R.id.toast_text);
		text.setText(this.getMessage());		
				
		this.setToast(Toast.makeText(this.getContext(), this.getMessage(), Toast.LENGTH_LONG));
		this.getToast().setGravity(Gravity.FILL_HORIZONTAL, 0, 0);
		
		
		this.getToast().setView(_ViewLayout);
		
		_Toast.show();
	}

	public void showToast1(final Context context) {
		handler.post(new Runnable() {
			public void run() {
				Toast.makeText(context, "Hello, The Code Project!",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	
	
	
	@SuppressLint("ShowToast")
	public void showsimpleToast(String data) {

		this.setToast(Toast.makeText(this.getContext(), this.getMessage(), Toast.LENGTH_LONG));

		this.getToast().setGravity(Gravity.CENTER, 0, 0);

		LinearLayout toastView = (LinearLayout) this.getToast().getView();
		TextView imageCodeProject = new TextView(this.getContext());
		imageCodeProject.setText(data);
		toastView.addView(imageCodeProject, 0);

		this.getToast().show();
	}
	

	public String getTitleColor() {
		return _TitleColor;
	}

	public void setTitleColor(String _TitleColor) {
		this._TitleColor =_TitleColor;
	}
	
}
