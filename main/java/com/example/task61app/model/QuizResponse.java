package com.example.task61app.model;

import java.util.List;

public class QuizResponse {
    public List<QuizItem> quiz;

    public static class QuizItem {
        public String question;
        public List<String> options;
        public String correct_answer;
    }
}


