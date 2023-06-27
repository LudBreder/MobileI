package com.example.annalyn;

import static com.example.annalyn.Functions.actionAttack;
import static com.example.annalyn.Functions.actionFreePrisoner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Action extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_action);

        boolean knightIsAwake = Variables.knightIsAwake;
        boolean archerIsAwake = Variables.archerIsAwake;
        boolean prisonerIsAwake = Variables.prisonerIsAwake;

        TextView txtAction = findViewById(R.id.txt_action);
        TextView txtVerifyResul = findViewById(R.id.txt_verify_result);
        Button btnAttack = findViewById(R.id.btn_attack);
        Button btnFree = findViewById(R.id.btn_free);

        txtAction.setText("Você escolheu " + Variables.verifyType);
        txtVerifyResul.setText(Variables.txtVerifyResult);

        String successMessage = "Sucesso!\n" +
                "Pegue o prisioneiro saia rapidamente.";


        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean value = actionAttack(knightIsAwake);
                Variables.txtFinish = value ? successMessage : "Não foi dessa vez!\nO ataque falhou!";
                Variables.txtStatusFinish = value ? "O Cavaleiro está dormindo!" : "O Cavaleiro está acordado!";
                nextStep(v);
            }
        });

        btnFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean value = actionFreePrisoner(archerIsAwake, prisonerIsAwake);
                Variables.txtFinish = value ? successMessage : "O ataque falhou! O prisioneiro estava dormindo, se assustou e acabou acordando todos.";
                Variables.txtStatusFinish = value ? "O Arqueiro está dormindo!" : "O Prisioneiro está dormindo!";
                nextStep(v);
            }
        });
    }

    public void nextStep(View view){
        Intent intent = new Intent(this, Finish.class);
        startActivity(intent);
    }
}

