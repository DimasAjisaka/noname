package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

//import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    // variables
    SharedPreferences onBoardingScreen;
//    FirebaseAuth auth;


    private static int SPLASH_SCREEN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        auth = FirebaseAuth.getInstance();

        new Handler().postDelayed((Runnable) () -> {

            // is first time checked
            onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
            boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);

            if (isFirstTime){
                SharedPreferences.Editor editor = onBoardingScreen.edit();
                editor.putBoolean("firstTime",false);
                editor.apply();
                startActivity(new Intent(SplashScreen.this,OnBoardingScreen.class));
                finish();

            } else {
//            // check auth then to dashboard
//            if(auth.getCurrentUser() != null){
//                toMainApp();
//            } else {
                startActivity(new Intent(SplashScreen.this,MainPage.class));
                finish();
//            }
            }
        },SPLASH_SCREEN);
    }

//    public void toMainApp(){
//        startActivity(new Intent(SplashScreen.this,MainPage.class));
//        finish();
//    }
}