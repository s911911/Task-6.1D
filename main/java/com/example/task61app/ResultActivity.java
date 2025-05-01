package com.example.task61app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private TextView tvLabelAi, tvYourResults;
    private ListView lvResults;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvLabelAi     = findViewById(R.id.tvLabelAi);
        tvYourResults = findViewById(R.id.tvYourResults);
        lvResults     = findViewById(R.id.lvResults);
        btnContinue   = findViewById(R.id.btnContinue);

        ArrayList<String> aiResults = getIntent().getStringArrayListExtra("results");
        if (aiResults == null) aiResults = new ArrayList<>();

        // 用 simple_list_item_2 渲染题号 + 回答，并加圆角背景
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                aiResults
        ) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv1 = view.findViewById(android.R.id.text1);
                TextView tv2 = view.findViewById(android.R.id.text2);
                String item = getItem(position);
                if (item != null && item.contains("\n")) {
                    String[] parts = item.split("\n", 2);
                    tv1.setText(parts[0]);
                    tv2.setText(parts[1]);
                }
                view.setBackgroundResource(R.drawable.bg_card_round);
                return view;
            }
        };
        lvResults.setAdapter(adapter);

        btnContinue.setOnClickListener(v -> finish());
    }
}



