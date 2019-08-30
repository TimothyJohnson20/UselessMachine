package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button SELF_DESTRUCT;
    private Switch useless;
    private ConstraintLayout constraintLayout;
    private Button lookBusy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int bl = (int)(Math.random() * 256);
        int color = Color.rgb(r, g, bl);
        constraintLayout.setBackgroundColor(color);
    }
    private void wireWidgets() {
        SELF_DESTRUCT = findViewById(R.id.button_main_self_destruct);
        useless = findViewById(R.id.switch_main_useless);
        constraintLayout = findViewById(R.id.constraint_layout_main);
        lookBusy = findViewById(R.id.button_main_look_busy);
    }
    private void setListeners() {
        SELF_DESTRUCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000, 1000) {
                    int timeLeft = 11;
                    @Override
                    public void onTick(long l) {

                        timeLeft--;
                        String remainingTime = " " + timeLeft;
                        Toast.makeText(MainActivity.this, remainingTime, Toast.LENGTH_SHORT).show();
                        changeBackgroundColor();

                    }

                    @Override
                    public void onFinish() {
                        finish();
                    }
                }.start();

            }
        });
        useless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    int r = (int)(255);
                    int g = (int)(0);
                    int bl = (int)(0);
                    int color = Color.rgb(r, g, bl);
                    constraintLayout.setBackgroundColor(color);
                    new CountDownTimer(2000, 10) {

                        @Override
                        public void onTick(long l) {
                            if(!useless.isChecked()){
                                cancel();
                            }
                        }

                        @Override
                        public void onFinish() {
                            useless.setChecked(false);
                            int r = (int)(Math.random() * 256);
                            int g = (int)(Math.random() * 256);
                            int bl = (int)(Math.random() * 256);
                            int color = Color.rgb(r, g, bl);
                            constraintLayout.setBackgroundColor(color);
                        }
                    }.start();
                }
            }
        });
    }
    private void changeBackgroundColor() {

        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int bl = (int)(Math.random() * 256);
        int color = Color.rgb(r, g, bl);
        constraintLayout.setBackgroundColor(color);
    }
}
