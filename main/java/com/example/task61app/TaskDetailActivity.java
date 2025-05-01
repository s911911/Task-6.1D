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

        // 找到控件
        rgDetail1 = findViewById(R.id.rgDetail1);
        rgDetail2 = findViewById(R.id.rgDetail2);
        btnSubmitDetail = findViewById(R.id.btnSubmitDetail);

        btnSubmitDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 收集用户选择（id 仅示例用，可根据实际逻辑判断对错）
                int sel1 = rgDetail1.getCheckedRadioButtonId();
                int sel2 = rgDetail2.getCheckedRadioButtonId();

                // 调用 BackendClient，得到 ArrayList<String>
                ArrayList<String> aiResults = BackendClient.submitAnswers(sel1, sel2, 0);

                // 通过 Intent 传递给 ResultActivity
                Intent it = new Intent(TaskDetailActivity.this, ResultActivity.class);
                it.putStringArrayListExtra("results", aiResults);
                startActivity(it);
                finish();
            }
        });
    }
}


