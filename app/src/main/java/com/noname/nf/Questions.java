package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.noname.nf.fragments.FragmentQ1;
import com.noname.nf.fragments.FragmentQ2;

public class Questions extends AppCompatActivity {

    Button next,prev;
    int questions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        next = findViewById(R.id.nextQ);
        prev = findViewById(R.id.prevQ);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new FragmentQ1()).commit();

        next.setOnClickListener(n -> {
            questions ++;
            doingFragmentTransaction(questions);
            String q = String.valueOf(questions);
            Toast.makeText(Questions.this,q,Toast.LENGTH_SHORT).show();
        });

        prev.setOnClickListener(p -> {
            questions--;
            doingFragmentTransaction(questions);
            String q = String.valueOf(questions);
            Toast.makeText(Questions.this,q,Toast.LENGTH_SHORT).show();
        });
    }

    void doingFragmentTransaction(int questions){
        // set prev button visibility
        if (questions > 1) {
            prev.setVisibility(View.VISIBLE);
        }

        if (questions == 1) {
            prev.setVisibility(View.INVISIBLE);
        }

        // make range question count
        if (questions <= 1) {
            questions = 1;
        }

        if (questions >= 15) {
            questions = 15;
        }

        Fragment selectFragments = null;

        switch (questions) {
            case 1:
                selectFragments = new FragmentQ1();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
                break;
            case 2:
                selectFragments = new FragmentQ2();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                break;
        }

        assert selectFragments != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,selectFragments).commit();
    }
}