package com.face3_test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Arrays;

public class CustomSpinnerAdapter extends ArrayAdapter<String>{

	private String[] _Strings;
	private LayoutInflater _LayoutInflater;
	
	public CustomSpinnerAdapter(Context context, int textViewResourceId,   String[] objects, LayoutInflater inflater) {
		super(context, textViewResourceId, objects);
		
		this._LayoutInflater = inflater;
		this._Strings = objects;		
		Log.i("hhghhg-adp",Arrays.toString(_Strings));
	}
	
	
	@Override
	public View getDropDownView(int position, View convertView,
			ViewGroup parent) {
		Log.i("position1",String.valueOf(position));
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("position2",String.valueOf(position));
		return getCustomView(position, convertView, parent);
	}

	

	public View getCustomView(int position, View convertView, ViewGroup parent) {	
		
		LayoutInflater inflater = this._LayoutInflater;
		View row = inflater.inflate(R.layout.spinner_row, parent, false);
		
		Log.i("position4",String.valueOf(position));
		Log.i("and1",_Strings[position].toString());
		((TextView) row.findViewById(R.id.listitem)).setText(_Strings[position]);
		
		return row;
	}    
}
