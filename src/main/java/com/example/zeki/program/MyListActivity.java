package com.example.zeki.program;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;

public class MyListActivity extends ListActivity {

	private Intent intent;
	private String[] menu = { "Home Information", "Home Calculator" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setListAdapter(new MyListArrayAdapter(this, menu));
	}

	protected void onListItemClick(ListView lv, View view, int position, long id) {

		RelativeLayout mLinearLayout = (RelativeLayout) view
				.findViewById(R.id.relativeLayout1);
		mLinearLayout.setBackgroundColor(Color.rgb(200, 200, 200));

		if (position == 0) {
			intent = new Intent(MyListActivity.this, HomeInformation.class);
			startActivity(intent);
		} else if (position == 1) {
			intent = new Intent(MyListActivity.this, HomeCalculator.class);
			startActivity(intent);
		}
	}
}