package com.example.task61app;

import java.util.ArrayList;

public class BackendClient {
    public static ArrayList<String> submitAnswers(int ans1, int ans2, int ans3) {
        ArrayList<String> results = new ArrayList<>();
        results.add("1. Question 1\nResponse from the model that you're using");
        results.add("2. Question 2\nResponse from the model that you're using");
        results.add("3. Question 3\nResponse from the model that you're using");
        return results;
    }
}


