package com.example.task61app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private TextView tvWelcome, tvTasksDue, tvTaskTitle, tvTaskDesc;
    private Button btnStartTask;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        Log.d("MainActivity", "Setting layout...");
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Finding views...");
        tvWelcome = findViewById(R.id.tvWelcome);
        tvTasksDue = findViewById(R.id.tvTasksDue);
        tvTaskTitle = findViewById(R.id.tvTaskTitle);
        tvTaskDesc = findViewById(R.id.tvTaskDesc);
        btnStartTask = findViewById(R.id.btnStartTask);

        Log.d("MainActivity", "Binding shared preferences...");
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String user = prefs.getString("username", "Student");
        tvWelcome.setText("Hello, " + user);
        tvTasksDue.setText("You have 1 task due");

        Log.d("MainActivity", "Loading task...");
        tvTaskTitle.setText(RecommendationEngine.getGeneratedTaskTitle());
        tvTaskDesc.setText(RecommendationEngine.getGeneratedTaskDesc());

        btnStartTask.setOnClickListener(v ->
                startActivity(new Intent(this, TaskDetailActivity.class))
        );

        Log.d("MainActivity", "Setup complete.");
    }
}



