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

        next.setOnClickListener(n -> {
            try {
                questions++;
                doingFragmentTransaction(questions);
            } catch (Exception e) {
                Toast.makeText(this,"Pastikan server berjalan dengan baik",Toast.LENGTH_LONG).show();
            }
        });

        prev.setOnClickListener(p -> {
            questions--;
            doingFragmentTransaction(questions);
        });
    }

    private ArrayList<String> getCompare() {
        ArrayList<String> stringCompare = new ArrayList<>();

        stringCompare.add(FragmentQ1.getCriteriaQuestion1());
        stringCompare.add(FragmentQ2.getCriteriaQuestion2());
        stringCompare.add(FragmentQ3.getCriteriaQuestion3());
        stringCompare.add(FragmentQ4.getCriteriaQuestion4());
        stringCompare.add(FragmentQ5.getCriteriaQuestion5());
        stringCompare.add(FragmentQ6.getCriteriaQuestion6());
        stringCompare.add(FragmentQ7.getCriteriaQuestion7());
        stringCompare.add(FragmentQ8.getCriteriaQuestion8());
        stringCompare.add(FragmentQ9.getCriteriaQuestion9());
        stringCompare.add(FragmentQ10.getCriteriaQuestion10());
        stringCompare.add(FragmentQ11.getCriteriaQuestion11());
        stringCompare.add(FragmentQ12.getCriteriaQuestion12());
        stringCompare.add(FragmentQ13.getCriteriaQuestion13());
        stringCompare.add(FragmentQ14.getCriteriaQuestion14());
        stringCompare.add(FragmentQ15.getCriteriaQuestion15());

        return stringCompare;
    }

    private ArrayList<Float> getIntegrity() {
        ArrayList<Float> compareValue = new ArrayList<>();

        compareValue.add(FragmentQ1.getIntegrityQuestion1());
        compareValue.add(FragmentQ2.getIntegrityQuestion2());
        compareValue.add(FragmentQ3.getIntegrityQuestion3());
        compareValue.add(FragmentQ4.getIntegrityQuestion4());
        compareValue.add(FragmentQ5.getIntegrityQuestion5());
        compareValue.add(FragmentQ6.getIntegrityQuestion6());
        compareValue.add(FragmentQ7.getIntegrityQuestion7());
        compareValue.add(FragmentQ8.getIntegrityQuestion8());
        compareValue.add(FragmentQ9.getIntegrityQuestion9());
        compareValue.add(FragmentQ10.getIntegrityQuestion10());
        compareValue.add(FragmentQ11.getIntegrityQuestion11());
        compareValue.add(FragmentQ12.getIntegrityQuestion12());
        compareValue.add(FragmentQ13.getIntegrityQuestion13());
        compareValue.add(FragmentQ14.getIntegrityQuestion14());
        compareValue.add(FragmentQ15.getIntegrityQuestion15());

        return compareValue;
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
                    break;
                case 2:
                    selectFragments = new FragmentQ2();
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
            postData(getCompare(),getIntegrity());
            startActivity(new Intent(Questions.this,Results.class));
        }
    }

    void postData(ArrayList<String> stringCompare, ArrayList<Float> compareValue) {

        PostInputModel postInputModel = new PostInputModel(stringCompare,compareValue);
        Call<PostResponse> call = Service.getFilmApi().PostDataIntoAhpLogic(postInputModel);

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                assert response.body() != null;
                response.body().getPostInputModel();
                Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}