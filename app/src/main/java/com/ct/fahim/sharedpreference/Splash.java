package com.ct.fahim.sharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.net.sip.SipErrorCode.TIME_OUT;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPreferences sharedPreferences = this.getSharedPreferences("testApp", Activity.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, login.class);
                startActivity(i);
                finish();
                sharedPreferences.edit().putBoolean("IS_FIRST_LOGIN", false).apply();
            }
        }, 5000);
    }
}
