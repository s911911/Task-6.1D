package com.example.task61app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvNeedAccount;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_login);
        prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        tvNeedAccount = findViewById(R.id.tvNeedAccount);

        btnLogin.setOnClickListener(v->{
            String u = etUsername.getText().toString().trim();
            String p = etPassword.getText().toString().trim();
            if(u.isEmpty()||p.isEmpty()){
                if(u.isEmpty()) etUsername.setError("必填");
                if(p.isEmpty()) etPassword.setError("必填");
                return;
            }
            // 简单存用户名
            prefs.edit().putString("username", u).apply();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        tvNeedAccount.setOnClickListener(v->{
            startActivity(new Intent(this, SignupActivity.class));
        });
    }
}


