package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.noname.nf.fragments.FragmentQ1;
import com.noname.nf.fragments.FragmentQ10;
import com.noname.nf.fragments.FragmentQ11;
import com.noname.nf.fragments.FragmentQ12;
import com.noname.nf.fragments.FragmentQ13;
import com.noname.nf.fragments.FragmentQ14;
import com.noname.nf.fragments.FragmentQ15;
import com.noname.nf.fragments.FragmentQ2;
import com.noname.nf.fragments.FragmentQ3;
import com.noname.nf.fragments.FragmentQ4;
import com.noname.nf.fragments.FragmentQ5;
import com.noname.nf.fragments.FragmentQ6;
import com.noname.nf.fragments.FragmentQ7;
import com.noname.nf.fragments.FragmentQ8;
import com.noname.nf.fragments.FragmentQ9;

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
//            String q = String.valueOf(questions);
//            Toast.makeText(Questions.this,q,Toast.LENGTH_SHORT).show();
        });

        prev.setOnClickListener(p -> {
            questions--;
            doingFragmentTransaction(questions);
//            String q = String.valueOf(questions);
//            Toast.makeText(Questions.this,q,Toast.LENGTH_SHORT).show();
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

//        // make range question count
//        if (questions <= 1) {
//            questions = 1;
//        }
//
//        if (questions >= 15) {
//            questions = 15;
//        }

        if (questions <= 15){
            Fragment selectFragments = null;

            switch (questions) {
                case 1:
                    selectFragments = new FragmentQ1();
//                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
                    break;
                case 2:
                    selectFragments = new FragmentQ2();
//                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                    break;
                case 3:
                    selectFragments = new FragmentQ3();
                    break;
                case 4:
                    selectFragments = new FragmentQ4();
                    break;
                case 5:
                    selectFragments = new FragmentQ5();
                    break;
                case 6:
                    selectFragments = new FragmentQ6();
                    break;
                case 7:
                    selectFragments = new FragmentQ7();
                    break;
                case 8:
                    selectFragments = new FragmentQ8();
                    break;
                case 9:
                    selectFragments = new FragmentQ9();
                    break;
                case 10:
                    selectFragments = new FragmentQ10();
                    break;
                case 11:
                    selectFragments = new FragmentQ11();
                    break;
                case 12:
                    selectFragments = new FragmentQ12();
                    break;
                case 13:
                    selectFragments = new FragmentQ13();
                    break;
                case 14:
                    selectFragments = new FragmentQ14();
                    break;
                case 15:
                    selectFragments = new FragmentQ15();
                    break;
            }

            assert selectFragments != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments,selectFragments).commit();
        }
    }
}