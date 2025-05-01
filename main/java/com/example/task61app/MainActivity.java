package com.example.task61app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvHelloMain, tvTasksDue;
    private Button btnViewTask;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        tvHelloMain = findViewById(R.id.tvHelloMain);
        tvTasksDue  = findViewById(R.id.tvTasksDue);
        btnViewTask = findViewById(R.id.btnViewTask);

        String u = prefs.getString("username","User");
        tvHelloMain.setText(getString(R.string.hello_user, u));
        // 假设只有 1 个待做任务
        tvTasksDue.setText(getString(R.string.tasks_due, 1));

        btnViewTask.setOnClickListener(v->{
            startActivity(new Intent(this, TaskDetailActivity.class));
        });
    }
}


