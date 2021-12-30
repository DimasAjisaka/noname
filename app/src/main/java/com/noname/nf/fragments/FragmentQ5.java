package com.noname.nf.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.noname.nf.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link FragmentQ5#newInstance} factory method to
// * create an instance of this fragment.
// */
public class FragmentQ5 extends Fragment {

    RadioGroup radioGroupCriteriaCompare1,integrityRadio;
    RadioButton radioButtonGenre,radioButtonCountry,inte1,inte2,inte3,inte4,inte5,inte6,inte7,inte8,inte9;
    RelativeLayout integrityLayout;
    static String criteriaSelected;
    static float integrity;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public FragmentQ5() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FragmentQ5.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static FragmentQ5 newInstance(String param1, String param2) {
//        FragmentQ5 fragment = new FragmentQ5();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q5, container, false);

        radioGroupCriteriaCompare1 = view.findViewById(R.id.criteriaCompare5);
        radioButtonGenre = view.findViewById(R.id.genreCheckQ5);
        radioButtonCountry = view.findViewById(R.id.countryCheckQ5);
        integrityLayout = view.findViewById(R.id.integrityLayoutQ5);
        integrityRadio = view.findViewById(R.id.integrityQ5);
        inte1 = view.findViewById(R.id.oneQ5);
        inte2 = view.findViewById(R.id.twoQ5);
        inte3 = view.findViewById(R.id.threeQ5);
        inte4 = view.findViewById(R.id.fourQ5);
        inte5 = view.findViewById(R.id.fiveQ5);
        inte6 = view.findViewById(R.id.sixQ5);
        inte7 = view.findViewById(R.id.sevenQ5);
        inte8 = view.findViewById(R.id.eightQ5);
        inte9 = view.findViewById(R.id.nineQ5);

        radioGroupCriteriaCompare1.setOnCheckedChangeListener((group, checkedId) -> {
            if (radioButtonGenre.isChecked()) {
                integrityLayout.setVisibility(View.VISIBLE);
                criteriaSelected = "genre";
            }

            if (radioButtonCountry.isChecked()) {
                integrityLayout.setVisibility(View.VISIBLE);
                criteriaSelected = "rating";
            }
        });

        integrityRadio.setOnCheckedChangeListener(((group, checkedId) -> {
            if(inte1.isChecked()){
                integrity = 1.0f;
            } else if(inte2.isChecked()){
                integrity = 2.0f;
            } else if(inte3.isChecked()){
                integrity = 3.0f;
            } else if(inte4.isChecked()){
                integrity = 4.0f;
            } else if(inte5.isChecked()){
                integrity = 5.0f;
            } else if(inte6.isChecked()){
                integrity = 6.0f;
            } else if(inte7.isChecked()){
                integrity = 7.0f;
            } else if(inte8.isChecked()){
                integrity = 8.0f;
            } else if(inte9.isChecked()){
                integrity = 9.0f;
            }
        }));

        return view;
    }

    public static String getCriteriaQuestion5() { return criteriaSelected; }
    public static float getIntegrityQuestion5() { return integrity; }
}