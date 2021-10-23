package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    // variables
    FirebaseAuth auth;
    private static int SPLASH_SCREEN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        auth = FirebaseAuth.getInstance();

        new Handler().postDelayed((Runnable) () -> {
            // check auth then to dashboard
            if(auth.getCurrentUser() != null){
                toMainApp();
            } else {
                startActivity(new Intent(SplashScreen.this,Login.class));
                finish();
            }
        },SPLASH_SCREEN);
    }

    public void toMainApp(){
        startActivity(new Intent(SplashScreen.this,MainPage.class));
        finish();
    }
}