package com.jenniferhsia.clothes_minded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateToSignUp(View v) {
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(intent);

    }

    public void navigateToLogin(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void navigateToStats(View v) {
        Intent intent = new Intent(MainActivity.this, Statistics.class);
        startActivity(intent);
    }


}
