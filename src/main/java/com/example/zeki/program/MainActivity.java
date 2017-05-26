package com.example.zeki.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Intent intent;
	private MediaPlayer media;
	LoginDataBaseAdapter loginDataBaseAdapter;
	Button btnSignIn, btnSignUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// create a instance of SQLite Database
		loginDataBaseAdapter = new LoginDataBaseAdapter(this);
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		// Get The Refference Of Buttons
		btnSignIn = (Button) findViewById(R.id.buttonSignIN);
		btnSignUp = (Button) findViewById(R.id.buttonSignUP);

		// Set OnClick Listener on SignUp button
		btnSignUp.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// / Create Intent for SignUpActivity abd Start The Activity
				Intent intentSignUP = new Intent(getApplicationContext(),
						SignUpActivity.class);
				startActivity(intentSignUP);

			}
		});
		btnSignIn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// / Create Intent for SignUpActivity abd Start The Activity
				Intent intentSignIn = new Intent(getApplicationContext(),
						SignInActivity.class);
				startActivity(intentSignIn);

			}
		});

	}

	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			if (media.isPlaying()) {
				media.stop();
				media.reset();
				media.release();
			}

		}

		return false;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (media.isPlaying()) {
			media.stop();
			media.reset();
			media.release();
		}
		loginDataBaseAdapter.close();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		media = MediaPlayer.create(this, R.raw.evde);
		media.setLooping(true);
		media.start();
	}

	
}