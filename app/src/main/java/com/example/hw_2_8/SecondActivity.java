package com.example.hw_2_8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {
    MaterialButton materialButton;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        materialButton = findViewById(R.id.redbutton);

        Double number = getIntent().getDoubleExtra("key",0.0);
        textView = findViewById(R.id.Current_Policies);
        textView.setText(number.toString());
        onclick();


    }

    private void onclick() {
        materialButton.setOnClickListener(view -> {
            finish();
        });


    }
}