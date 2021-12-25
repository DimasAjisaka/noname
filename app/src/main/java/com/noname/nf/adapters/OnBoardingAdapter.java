package com.noname.nf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.noname.nf.R;

public class OnBoardingAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public OnBoardingAdapter(Context context) {
        this.context = context;
    }

    int images[] = {R.drawable.ic_onboarding_1,R.drawable.ic_onboarding_2};
    int title[] = {R.string.lorem_ipsum,R.string.ipsum_lorem};
    int text[] = {R.string.onBoarding_1,R.string.onBoarding_2};

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_layout,container,false);

        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView titles = view.findViewById(R.id.title_grammar);
        TextView texts = view.findViewById(R.id.slider_grammar);

        imageView.setImageResource(images[position]);
        titles.setText(title[position]);
        texts.setText(text[position]);

        if (position == 1){
            imageView.setTranslationX(30);
        }

        container.addView(view);

        return view;
    }
}
