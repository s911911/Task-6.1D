package com.example.task61app;

import com.example.task61app.model.QuizResponse;
import com.example.task61app.model.AnswerRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import java.util.List;

public interface BackendApi {

    @GET("getQuiz")
    Call<QuizResponse> getQuiz(@Query("topic") String topic);

    @POST("submitAnswers")
    Call<List<String>> submitAnswers(@Body AnswerRequest request);
}





