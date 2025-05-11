package com.example.task61app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private EditText etU, etE, etCE, etP, etCP, etPhone;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_signup);

        etU = findViewById(R.id.etSignUsername);
        etE = findViewById(R.id.etEmail);
        etCE = findViewById(R.id.etConfirmEmail);
        etP = findViewById(R.id.etSignPassword);
        etCP = findViewById(R.id.etConfirmPassword);
        etPhone = findViewById(R.id.etPhone);
        btnCreate = findViewById(R.id.btnCreateAccount);

        btnCreate.setOnClickListener(v->{
            if(etU.getText().toString().trim().isEmpty()){
                etU.setError("必填"); return;
            }
            startActivity(new Intent(this, InterestsActivity.class));
            finish();
        });
    }
}
