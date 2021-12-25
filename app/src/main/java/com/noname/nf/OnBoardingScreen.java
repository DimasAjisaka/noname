package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.noname.nf.adapters.OnBoardingAdapter;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    OnBoardingAdapter onBoardingAdapter;
    Button button;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        viewPager = findViewById(R.id.view_pager);
        button = findViewById(R.id.next);

        // set adapter
        onBoardingAdapter = new OnBoardingAdapter(this);
        viewPager.setAdapter(onBoardingAdapter);
        viewPager.addOnPageChangeListener(changeListener);

        button.setOnClickListener(v -> startActivity(new Intent(OnBoardingScreen.this,MainPage.class)));
    }

    public void next(View view){
        viewPager.setCurrentItem(currentPos+1);
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPos = position;

            if (position == 0){
                button.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                button.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}