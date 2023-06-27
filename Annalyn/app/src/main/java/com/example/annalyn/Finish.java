package com.example.annalyn;

import static com.example.annalyn.Functions.checkSignalPrisoner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_finish);

        Button btnBack = findViewById(R.id.btn_back);
        TextView txtFinish = findViewById(R.id.txt_finish);
        TextView txtStatusFinish = findViewById(R.id.txt_status_finish);

        txtStatusFinish.setText(Variables.txtStatusFinish);
        txtFinish.setText(Variables.txtFinish);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variables.knightIsAwake = false;
                Variables.archerIsAwake = false;
                Variables.prisonerIsAwake = false;
                backToStart();
            }
        });
    }
    private void backToStart() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}