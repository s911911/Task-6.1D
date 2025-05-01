package com.example.task61app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class InterestsActivity extends AppCompatActivity {
    private ToggleButton btnAlgo, btnDS, btnWeb, btnTest;
    private Button btnNext;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_interests);
        prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        btnAlgo = findViewById(R.id.btnAlgo);
        btnDS   = findViewById(R.id.btnDS);
        btnWeb  = findViewById(R.id.btnWeb);
        btnTest = findViewById(R.id.btnTest);
        btnNext = findViewById(R.id.btnNext);

        // 恢复
        btnAlgo.setChecked(prefs.getBoolean("iAlgo", false));
        btnDS.setChecked(prefs.getBoolean("iDS", false));
        btnWeb.setChecked(prefs.getBoolean("iWeb", false));
        btnTest.setChecked(prefs.getBoolean("iTest", false));

        btnNext.setOnClickListener(v->{
            SharedPreferences.Editor e = prefs.edit();
            e.putBoolean("iAlgo", btnAlgo.isChecked());
            e.putBoolean("iDS", btnDS.isChecked());
            e.putBoolean("iWeb", btnWeb.isChecked());
            e.putBoolean("iTest", btnTest.isChecked());
            e.apply();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}


