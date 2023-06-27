package com.example.annalyn;

import static com.example.annalyn.Functions.checkSignalPrisoner;
import static com.example.annalyn.Functions.checkSpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Verify extends AppCompatActivity {

    private TextView txtVerify;
    private  TextView txtStatus;

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_verify);

        boolean knightIsAwake = Variables.knightIsAwake;
        boolean archerIsAwake = Variables.archerIsAwake;
        boolean prisonerIsAwake = Variables.prisonerIsAwake;

        Button btnSpy = findViewById(R.id.btn_spy);
        Button btnSign = findViewById(R.id.btn_sign);

        txtStatus = findViewById(R.id.txt_status);

        btnSpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variables.verifyType = "Espiar";
               boolean value = checkSpy(knightIsAwake, archerIsAwake, prisonerIsAwake);
               Variables.txtVerifyResult = value ? "Existe alguém acordado!": "Todos estão dormindo!\nCuidado com seu próximo passo.";
               nextStep(v);
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variables.verifyType= "Assoviar";
                boolean value =  checkSignalPrisoner(archerIsAwake, prisonerIsAwake);
                Variables.txtVerifyResult = value
                        ? "Existe alguém acordado!\nO Arqueiro está acordado! Ele pode inteceptar sua mensagem."
                        : "Todos estão dormindo!\nCuidado com seu próximo passo.";
                nextStep(v);
            }
        });
    }

    public void nextStep(View view){
        Intent intent = new Intent(this, Action.class);
        startActivity(intent);
    }
}