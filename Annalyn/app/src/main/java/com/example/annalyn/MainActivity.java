package com.example.annalyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Switch gameMode = findViewById(R.id.switch1);
        Switch archerValue = findViewById(R.id.swt_archer);
        Switch knightValue = findViewById(R.id.swt_knight);
        Switch prisonerValue = findViewById(R.id.swt_prisoner);

        archerValue.setChecked(Variables.archerIsAwake);
        knightValue.setChecked(Variables.knightIsAwake);
        prisonerValue.setChecked(Variables.prisonerIsAwake);

        gameMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Variables.gameMode = isChecked;
                gameMode.setText(isChecked ? "Aleatório": "Manual");
                if(isChecked){
                    archerValue.setVisibility(View.INVISIBLE);
                    knightValue.setVisibility(View.INVISIBLE);
                    prisonerValue.setVisibility(View.INVISIBLE);
                }else {
                    archerValue.setVisibility(View.VISIBLE);
                    knightValue.setVisibility(View.VISIBLE);
                    prisonerValue.setVisibility(View.VISIBLE);
                }
                setGameMode(isChecked);
            }
        });

        archerValue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Variables.archerIsAwake = isChecked;
            }
        });

        knightValue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Variables.knightIsAwake = isChecked;
            }
        });

        prisonerValue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Variables.prisonerIsAwake = isChecked;
            }
        });
    }

    public void setGameMode(boolean isRandom){
        Variables.knightIsAwake = isRandom ? random.nextBoolean() : false;
        Variables.archerIsAwake = isRandom ? random.nextBoolean() : false;
        Variables.prisonerIsAwake = isRandom ? random.nextBoolean() : false;
    }

    public void startGame(View view){
        Intent intent = new Intent(this, Verify.class);
        startActivity(intent);
    }
}