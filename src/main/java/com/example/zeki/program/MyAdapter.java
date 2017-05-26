package com.example.zeki.program;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {
	private Context context;
	private String[] values;
	private LayoutInflater inflater;

	public MyAdapter(Context context, int layoutResourceId, String[] values) {
		super(context, layoutResourceId, values);
		this.context = context;
		this.values = values;
	}

	// This method is used to display the dropdown popup that contains data.
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	// This method is used to return the customized view at a specified position
	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		return getCustomView(pos, convertView, parent);
	}

	public View getCustomView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if (rowView == null) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.spiner_layout, parent, false);
		}

		TextView textView = (TextView) rowView.findViewById(R.id.tv_main);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.left_pic);

		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		if (s.equals("Fuel"))
			imageView.setImageResource(R.drawable.ucartibir);
		else if (s.equals("Diesel"))
			imageView.setImageResource(R.drawable.dortartibir);
		else if (s.equals("Gas"))
			imageView.setImageResource(R.drawable.besartibir);

		return rowView;

	}
}
