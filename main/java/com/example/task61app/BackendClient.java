package com.example.task61app;

import com.example.task61app.model.AnswerRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BackendClient {

    public interface AnswerCallback {
        void onSuccess(List<String> answers);
        void onFailure(Throwable t);
    }

    public static void submitAnswers(int a1, int a2, int a3, AnswerCallback cb) {
        AnswerRequest request = new AnswerRequest(a1, a2, a3);

        ApiClient.getApi()
                .submitAnswers(request)
                .enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> resp) {
                        if (resp.isSuccessful() && resp.body() != null) {
                            cb.onSuccess(resp.body());
                        } else {
                            cb.onFailure(new Exception("Server error: " + resp.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        cb.onFailure(t);
                    }
                });
    }
}


