package com.example.zeki.program;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListArrayAdapter extends ArrayAdapter<String> {

	private Context context;
	private String[] values;
	private LayoutInflater inflater;

	public MyListArrayAdapter(Context context, String[] values) {
		super(context, R.layout.activity_my_list, values);
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if (rowView == null) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.activity_my_list, parent, false);
		}
		
		
		ImageView mImageView = (ImageView) rowView.findViewById(R.id.arrow);
		TextView mTextView = (TextView) rowView.findViewById(R.id.label);
		
		

	
		mTextView.setText(values[position]);
		String s = values[position];

		if (s.equals("Home Calculator"))
			mImageView.setImageResource(R.drawable.right_arrow);
		else if (s.equals("Home Information"))
			mImageView.setImageResource(R.drawable.right_arrow);

		return rowView;

	}
}