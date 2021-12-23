package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.noname.nf.fragments.FragmentQ1;

public class Questions extends AppCompatActivity {

    Button next,prev;
    int questions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        next = findViewById(R.id.nextQ);
        prev = findViewById(R.id.prevQ);

        next.setOnClickListener(v -> questions++); // next count question
        prev.setOnClickListener(v -> questions--); // decrement count to prev question

        // set prev button visibility
        if (questions > 1) {
            prev.setVisibility(View.VISIBLE);
        }

        // here to select question using fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragments,new FragmentQ1());
        fragmentTransaction.commit();

//        switch (questions) {
//            case 1:
//                fragmentTransaction.replace(R.id.fragments,new FragmentQ1());
//                fragmentTransaction.commit();
//                break;
//        }
    }
}