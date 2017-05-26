package com.example.zeki.program;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends Activity {
	Intent intent;
    Button btnSignIn,btnSignUp;
    EditText editTextUserName,editTextPassword;
    LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in);
		 // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);

        editTextUserName=(EditText) findViewById(R.id.editTextUserNameToLogin);
        editTextPassword=(EditText) findViewById(R.id.editTextPasswordToLogin);

	}
	
	public void onClick(View v) {
        // get The User name and Password
        String userName=editTextUserName.getText().toString();
        String password=editTextPassword.getText().toString();
        
        // fetch the Password form database for respective user name
        String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

        // check if the Stored password matches with  Password entered by user
        if(password.equals(storedPassword))
        {
        	intent = new Intent(getApplicationContext(), MyListActivity.class);
		    startActivity(intent);
        }
        else
        {
            Toast.makeText(SignInActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
        }
    }
	
	 @Override
	    protected void onDestroy() {
	        super.onDestroy();
	        // Close The Database
	        loginDataBaseAdapter.close();
	    }
}
