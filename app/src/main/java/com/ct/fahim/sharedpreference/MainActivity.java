package com.ct.fahim.sharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // shared preference use for saving data which doesn't need to be saved in database

    //This is A blank activity to decide which activity to go next

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences("testApp", Activity.MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false);
        boolean isFirstLogin = sharedPreferences.getBoolean("IS_FIRST_LOGIN", true);

        if(isFirstLogin == false) {
            if(isLoggedIn == true){
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
            finish();
        } else{
            Intent intent = new Intent(MainActivity.this, Splash.class);
            startActivity(intent);
        }
    }
}
