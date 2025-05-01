package com.example.task61app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TaskDetailActivity extends AppCompatActivity {
    private RadioGroup rgDetail1, rgDetail2;
    private Button btnSubmitDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        rgDetail1 = findViewById(R.id.rgDetail1);
        rgDetail2 = findViewById(R.id.rgDetail2);
        btnSubmitDetail = findViewById(R.id.btnSubmitDetail);

        btnSubmitDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sel1 = rgDetail1.getCheckedRadioButtonId();
                int sel2 = rgDetail2.getCheckedRadioButtonId();

                ArrayList<String> aiResults = BackendClient.submitAnswers(sel1, sel2, 0);

                Intent it = new Intent(TaskDetailActivity.this, ResultActivity.class);
                it.putStringArrayListExtra("results", aiResults);
                startActivity(it);
                finish();
            }
        });
    }
}


