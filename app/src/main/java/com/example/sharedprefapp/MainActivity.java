package com.example.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends Activity {

    EditText et1, et2, et3;
    Button bt;
    String myPreferences = "MyPrefs",name = "nameKey",password = "passKey",email = "emailKey";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.tfName);
        et2 = (EditText)findViewById(R.id.tfPass);
        et3 = (EditText)findViewById(R.id.tfEmail);

        bt=findViewById(R.id.btnSave);
        sharedPref = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = et1.getText().toString();
                String pw = et2.getText().toString();
                String e = et3.getText().toString();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(name, n);
                editor.putString(password, pw);
                editor.putString(email, e);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });
    }
}