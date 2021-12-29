package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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
import com.noname.nf.models.PostInputModel;
import com.noname.nf.models.viewmodels.FilmListViewModel;
import com.noname.nf.request.Service;
import com.noname.nf.response.PostResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Questions extends AppCompatActivity {

    Button next,prev;
    int questions = 1;
    FilmListViewModel filmListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        next = findViewById(R.id.nextQ);
        prev = findViewById(R.id.prevQ);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new FragmentQ1()).commit();

        filmListViewModel = new ViewModelProvider(this).get(FilmListViewModel.class);

        // initialize array
//        String[] criteriaCompare = new String[15];
//        float[] compareValue = new float[15];
//
//        // array criteria
//        String criteria1 = FragmentQ1.getCriteriaQuestion1();
//        String criteria2 = FragmentQ2.getCriteriaQuestion2();
//        String criteria3 = FragmentQ3.getCriteriaQuestion3();
//        String criteria4 = FragmentQ4.getCriteriaQuestion4();
//        String criteria5 = FragmentQ5.getCriteriaQuestion5();
//        String criteria6 = FragmentQ6.getCriteriaQuestion6();
//        String criteria7 = FragmentQ7.getCriteriaQuestion7();
//        String criteria8 = FragmentQ8.getCriteriaQuestion8();
//        String criteria9 = FragmentQ9.getCriteriaQuestion9();
//        String criteria10 = FragmentQ10.getCriteriaQuestion10();
//        String criteria11 = FragmentQ11.getCriteriaQuestion11();
//        String criteria12 = FragmentQ12.getCriteriaQuestion12();
//        String criteria13 = FragmentQ13.getCriteriaQuestion13();
//        String criteria14 = FragmentQ14.getCriteriaQuestion14();
//        String criteria15 = FragmentQ15.getCriteriaQuestion15();
//
//        criteriaCompare[0] = criteria1;
//        criteriaCompare[1] = criteria2;
//        criteriaCompare[2] = criteria3;
//        criteriaCompare[3] = criteria4;
//        criteriaCompare[4] = criteria5;
//        criteriaCompare[5] = criteria6;
//        criteriaCompare[6] = criteria7;
//        criteriaCompare[7] = criteria8;
//        criteriaCompare[8] = criteria9;
//        criteriaCompare[9] = criteria10;
//        criteriaCompare[10] = criteria11;
//        criteriaCompare[11] = criteria12;
//        criteriaCompare[12] = criteria13;
//        criteriaCompare[13] = criteria14;
//        criteriaCompare[14] = criteria15;
//
//        // array compare value
//        float integrity1 = FragmentQ1.getIntegrityQuestion1();
//        float integrity2 = FragmentQ2.getIntegrityQuestion2();
//        float integrity3 = FragmentQ3.getIntegrityQuestion3();
//        float integrity4 = FragmentQ4.getIntegrityQuestion4();
//        float integrity5 = FragmentQ5.getIntegrityQuestion5();
//        float integrity6 = FragmentQ6.getIntegrityQuestion6();
//        float integrity7 = FragmentQ7.getIntegrityQuestion7();
//        float integrity8 = FragmentQ8.getIntegrityQuestion8();
//        float integrity9 = FragmentQ9.getIntegrityQuestion9();
//        float integrity10 = FragmentQ10.getIntegrityQuestion10();
//        float integrity11 = FragmentQ11.getIntegrityQuestion11();
//        float integrity12 = FragmentQ12.getIntegrityQuestion12();
//        float integrity13 = FragmentQ13.getIntegrityQuestion13();
//        float integrity14 = FragmentQ14.getIntegrityQuestion14();
//        float integrity15 = FragmentQ15.getIntegrityQuestion15();
//
//        compareValue[0] = integrity1;
//        compareValue[1] = integrity2;
//        compareValue[2] = integrity3;
//        compareValue[3] = integrity4;
//        compareValue[4] = integrity5;
//        compareValue[5] = integrity6;
//        compareValue[6] = integrity7;
//        compareValue[7] = integrity8;
//        compareValue[8] = integrity9;
//        compareValue[9] = integrity10;
//        compareValue[10] = integrity11;
//        compareValue[11] = integrity12;
//        compareValue[12] = integrity13;
//        compareValue[13] = integrity14;
//        compareValue[14] = integrity15;

//        stringCompare.add(FragmentQ1.getCriteriaQuestion1());
//        stringCompare.add(FragmentQ2.getCriteriaQuestion2());
//        stringCompare.add(FragmentQ3.getCriteriaQuestion3());
//        stringCompare.add(FragmentQ4.getCriteriaQuestion4());
//        stringCompare.add(FragmentQ5.getCriteriaQuestion5());
//        stringCompare.add(FragmentQ6.getCriteriaQuestion6());
//        stringCompare.add(FragmentQ7.getCriteriaQuestion7());
//        stringCompare.add(FragmentQ8.getCriteriaQuestion8());
//        stringCompare.add(FragmentQ9.getCriteriaQuestion9());
//        stringCompare.add(FragmentQ10.getCriteriaQuestion10());
//        stringCompare.add(FragmentQ11.getCriteriaQuestion11());
//        stringCompare.add(FragmentQ12.getCriteriaQuestion12());
//        stringCompare.add(FragmentQ13.getCriteriaQuestion13());
//        stringCompare.add(FragmentQ14.getCriteriaQuestion14());
//        stringCompare.add(FragmentQ15.getCriteriaQuestion15());



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

    void doingFragmentTransaction(int questions) {
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

        if (questions > 15) {
//            postData();
//            startActivity(new Intent(Questions.this,Results.class));
            startActivity(new Intent(Questions.this,Results.class));
        }
    }

//    void postData() {
//
//        PostInputModel postInputModel = new PostInputModel("criteriaCompare");
//        Call<PostResponse> call = Service.getFilmApi().PostDataIntoAhpLogic(postInputModel);
//
//        call.enqueue(new Callback<PostResponse>() {
//            @Override
//            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
//                response.body().getPostInputModel();
//                Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<PostResponse> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}