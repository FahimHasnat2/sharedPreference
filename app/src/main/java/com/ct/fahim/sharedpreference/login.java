package com.ct.fahim.sharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    String myEmail = "fahim@mail.com";
    String myPassword="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final TextInputLayout passLayout = (TextInputLayout)findViewById(R.id.passwordLayout);;
        final TextInputLayout emailLayout = (TextInputLayout)findViewById(R.id.emailLayout);
        final SharedPreferences sharedPreferences = this.getSharedPreferences("testApp", Activity.MODE_PRIVATE);


        Button logIn = findViewById(R.id.log);
        logIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = emailLayout.getEditText().getText().toString();
                String password = passLayout.getEditText().getText().toString();
                Log.v("log password", password);
                Log.v("log email", email);
                Log.v("My email", myEmail);
                Log.v("My password", myPassword);

                if(email.equals(myEmail) && password.equals(myPassword)){
                    sharedPreferences.edit().putBoolean("IS_LOGGED_IN", true).apply();
                    Intent intent = new Intent(login.this, Home.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(),"Can't Connect",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
