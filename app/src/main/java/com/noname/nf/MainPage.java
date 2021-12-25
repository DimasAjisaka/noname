package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        button = findViewById(R.id.nextToCriteria);

        button.setOnClickListener(v -> startActivity(new Intent(MainPage.this,Questions.class)));
    }
}