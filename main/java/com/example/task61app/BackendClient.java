package com.example.task61app;

import java.util.ArrayList;

/**
 * 模拟调用后端 / LLM 服务，返回每道题的 AI 回答
 */
public class BackendClient {
    public static ArrayList<String> submitAnswers(int ans1, int ans2, int ans3) {
        ArrayList<String> results = new ArrayList<>();
        // 这里用固定的示例文字
        results.add("1. Question 1\nResponse from the model that you're using");
        results.add("2. Question 2\nResponse from the model that you're using");
        results.add("3. Question 3\nResponse from the model that you're using");
        return results;
    }
}


