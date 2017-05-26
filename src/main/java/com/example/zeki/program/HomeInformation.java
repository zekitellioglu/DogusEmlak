package com.example.zeki.program;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeInformation extends Activity {

	private TextView tv;
	private Animation textBlink;
	private ImageView imv, imv1, imv2, imv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home_information);
		
		tv = (TextView) findViewById(R.id.tv2);
		imv=(ImageView) findViewById(R.id.imv1);
		imv1=(ImageView) findViewById(R.id.imv2);
		imv2=(ImageView) findViewById(R.id.imv3);
		imv3 = (ImageView) findViewById(R.id.imv4);
		
		
		textBlink = new AlphaAnimation(0.0f, 1.0f);
		textBlink.setDuration(50);
		textBlink.setStartOffset(20);
		textBlink.setRepeatMode(Animation.REVERSE);
		textBlink.setRepeatCount(Animation.INFINITE);
		tv.startAnimation(textBlink);

	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btna:
			imv.setVisibility(View.VISIBLE);
			imv1.setVisibility(View.INVISIBLE);
			imv2.setVisibility(View.INVISIBLE);
			imv3.setVisibility(View.INVISIBLE);
			break;

		case R.id.btnb:
			imv.setVisibility(View.INVISIBLE);
			imv1.setVisibility(View.VISIBLE);
			imv2.setVisibility(View.INVISIBLE);
			imv3.setVisibility(View.INVISIBLE);
			break;

		case R.id.btnc:
			imv.setVisibility(View.INVISIBLE);
			imv1.setVisibility(View.INVISIBLE);
			imv2.setVisibility(View.VISIBLE);
			imv3.setVisibility(View.INVISIBLE);
			break;

		}
	}

}