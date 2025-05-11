package com.example.task61app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.task61app.model.QuizResponse;
import com.example.task61app.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskDetailActivity extends AppCompatActivity {
    private TextView tvQ1, tvQ2, tvQ3;
    private RadioGroup rg1, rg2, rg3;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_task_detail);

        tvQ1 = findViewById(R.id.tvQ1);
        tvQ2 = findViewById(R.id.tvQ2);
        tvQ3 = findViewById(R.id.tvQ3);

        rg1 = findViewById(R.id.rgDetail1);
        rg2 = findViewById(R.id.rgDetail2);
        rg3 = findViewById(R.id.rgDetail3);

        btnSubmit = findViewById(R.id.btnSubmitDetail);

        btnSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(TaskDetailActivity.this, ResultActivity.class);
            intent.putExtra("answer1", getSelectedAnswer(rg1));
            intent.putExtra("answer2", getSelectedAnswer(rg2));
            intent.putExtra("answer3", getSelectedAnswer(rg3));
            startActivity(intent);
        });

        fetchQuiz();
    }

    private String getSelectedAnswer(RadioGroup rg) {
        int selectedId = rg.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton rb = findViewById(selectedId);
            return rb.getText().toString();
        } else {
            return "No answer";
        }
    }

    private void fetchQuiz() {
        ApiClient.getApi().getQuiz("film").enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<QuizResponse.QuizItem> list = response.body().quiz;
                    if (list != null && list.size() >= 3) {
                        bindQuestion(tvQ1, rg1, list.get(0), "Question 1");
                        bindQuestion(tvQ2, rg2, list.get(1), "Question 2");
                        bindQuestion(tvQ3, rg3, list.get(2), "Question 3");
                    }
                } else {
                    Toast.makeText(TaskDetailActivity.this, "Quiz format error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {
                Toast.makeText(TaskDetailActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindQuestion(TextView tv, RadioGroup rg, QuizResponse.QuizItem q, String questionLabel) {
        tv.setText(questionLabel + "\n" + q.question);
        rg.removeAllViews();
        for (String option : q.options) {
            RadioButton rb = new RadioButton(this);
            rb.setText(option);
            rg.addView(rb);
        }
    }
}









