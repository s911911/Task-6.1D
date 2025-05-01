package com.example.task61app;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
    public static List<String> getRecommendations(Context ctx) {
        SharedPreferences p = ctx.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        List<String> list = new ArrayList<>();
        if (p.getBoolean("iAlgo", false))      list.add("Algo learning");
        if (p.getBoolean("iDS", false))        list.add("data strcture");
        if (p.getBoolean("iWeb", false))       list.add("web project");
        if (p.getBoolean("iTest", false))      list.add("test");
        if (list.isEmpty()) {
            list.add("Learning Material");
            list.add("Exam everyday");
        }
        return list;
    }
}

