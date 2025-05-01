package com.example.task61app;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
    public static List<String> getRecommendations(Context ctx) {
        SharedPreferences p = ctx.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        List<String> list = new ArrayList<>();
        if (p.getBoolean("iAlgo", false))      list.add("算法进阶练习");
        if (p.getBoolean("iDS", false))        list.add("数据结构复习");
        if (p.getBoolean("iWeb", false))       list.add("Web 开发项目");
        if (p.getBoolean("iTest", false))      list.add("测试用例设计");
        if (list.isEmpty()) {
            list.add("通用复习材料");
            list.add("每日小测");
        }
        return list;
    }
}

