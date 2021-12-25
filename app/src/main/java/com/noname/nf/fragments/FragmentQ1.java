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
// * Use the {@link FragmentQ1#newInstance} factory method to
// * create an instance of this fragment.
// */
public class FragmentQ1 extends Fragment {

    RadioGroup radioGroupCriteriaCompare1;
    RadioButton radioButtonGenre,radioButtonCountry;
    RelativeLayout integrityLayout;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public FragmentQ1() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FragmentQ1.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static FragmentQ1 newInstance(String param1, String param2) {
//        FragmentQ1 fragment = new FragmentQ1();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

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
        View view = inflater.inflate(R.layout.fragment_q1, container, false);

        radioGroupCriteriaCompare1 = view.findViewById(R.id.criteriaCompare1);
        radioButtonGenre = view.findViewById(R.id.genreCheckQ1);
        radioButtonCountry = view.findViewById(R.id.countryCheckQ1);
        integrityLayout = view.findViewById(R.id.integrityLayout);

        radioGroupCriteriaCompare1.setOnCheckedChangeListener((group, checkedId) -> {
            if (radioButtonGenre.isChecked()) {
                integrityLayout.setVisibility(View.VISIBLE);
            }

            if (radioButtonCountry.isChecked()) {
                integrityLayout.setVisibility(View.VISIBLE);
            }
        });


        return view;
    }
}