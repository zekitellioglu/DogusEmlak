package com.example.zeki.program;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeCalculator extends Activity {

	private Spinner spin;
	private String[] type;
	private EditText et1;
	private RadioButton rdb1, rdb2;
	private double result;
	private String msg;

	private int ind = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home_calculator);

		et1 = (EditText) findViewById(R.id.etCar);
		rdb1 = (RadioButton) findViewById(R.id.rbAd);
		rdb2 = (RadioButton) findViewById(R.id.rbTv);

		type = getResources().getStringArray(R.array.roomtype);

		spin = (Spinner) findViewById(R.id.spinner1);
		spin.setAdapter(new MyAdapter(this, R.layout.spiner_layout, type));
		spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int index, long l) {

				switch (index) {
				case 0:
					ind = 0;

					break;
				case 1:
					ind = 1;

					break;
				case 2:
					ind = 2;

					break;

				}

			}

			public void onNothingSelected(AdapterView<?> adapterView) {
				return;
			}
		});
	}

	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.btnCalc:

			if (et1.getText().length() == 0) {
				displayToast("Please enter valid home type!!!");
				return;
			} else {
				if (et1.getText().toString().equals("Apartment")) {
					if (ind == 0) {

						if (rdb2.isSelected()) {

							result = 100000.0 + 20000.0 + 10000.0;

						} else {
							result = 1000.0 + 250.0 + 200.0;
						}
					} else if (ind == 1) {

						if (rdb2.isSelected()) {

							result = 150000.0 + 15000.0 + 10000.0;

						} else {
							result = 1500.0 + 150.0 + 200.0;
						}
					} else if (ind == 2) {

						if (rdb2.isSelected()) {

							result = 180000.0 + 10000.0 + 10000.0;

						} else {
							result = 2000.0 + 100.0 + 200.0;
						}
					}

				} else if (et1.getText().toString().equals("Dublex")) {
					if (ind == 0) {

						if (rdb2.isSelected()) {

							result = 150000.0 + 20000.0 + 10000.0;

						} else {
							result = 1500.0 + 200.0 + 200.0;
						}
					} else if (ind == 1) {

						if (rdb2.isSelected()) {

							result = 170000.0 + 15000.0 + 10000.0;

						} else {
							result = 1700.0 + 150.0 + 200.0;
						}
					} else if (ind == 2) {

						if (rdb2.isSelected()) {

							result = 200000.0 + 10000.0 + 10000.0;

						} else {
							result = 2000.0 + 100.0 + 200.0;
						}
					}

				} else if (et1.getText().toString().equals("Triplex")) {
					if (ind == 0) {

						if (rdb2.isSelected()) {

							result = 500000.0 + 20000.0 + 10000.0;

						} else {
							result = 5000.0 + 200.0 + 200.0;
						}
					} else if (ind == 1) {

						if (rdb2.isSelected()) {

							result = 540000.0 + 15000.0 + 10000.0;

						} else {
							result = 5400.0 + 150.0 + 200.0;
						}
					} else if (ind == 2) {

						if (rdb2.isSelected()) {

							result = 580000.0 + 10000.0 + 10000.0;

						} else {
							result = 6000.0 + 100.0 + 200.0;
						}
					}

				}
			}

			msg = String.valueOf(result) + " $";
			makeAndShowDialogBox(msg);

			break;
		case R.id.btnClear:
			et1.setText("");
			rdb1.isSelected();
			spin.setSelection(0);

			break;

		}

	}

	private void makeAndShowDialogBox(String msg) {

		AlertDialog.Builder myDialogBox = new AlertDialog.Builder(this);

		// set message, title, and icon
		myDialogBox.setTitle("Your Payment is:");
		myDialogBox.setMessage(msg);
		myDialogBox.setIcon(R.drawable.ic_launcher);

		// Set three option buttons
		myDialogBox.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "Yes" goes
						// here
					}
				});

		myDialogBox.create();
		myDialogBox.show();
	}

	private void displayToast(String msg) {

		Toast toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);

		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

		toast.show();

	}

}
