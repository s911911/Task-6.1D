package com.example.task61app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tv1 = findViewById(R.id.tvResult1);
        TextView tv2 = findViewById(R.id.tvResult2);
        TextView tv3 = findViewById(R.id.tvResult3);
        Button btnContinue = findViewById(R.id.btnContinue);

        Intent intent = getIntent();
        String a1 = intent.getStringExtra("answer1");
        String a2 = intent.getStringExtra("answer2");
        String a3 = intent.getStringExtra("answer3");

        tv1.setText("1. Question 1\n" + a1);
        tv2.setText("2. Question 2\n" + a2);
        tv3.setText("3. Question 3\n" + a3);

        btnContinue.setOnClickListener(v -> finish());
    }
}








