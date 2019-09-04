package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button SELF_DESTRUCT;
    private Switch useless;
    private ConstraintLayout constraintLayout;
    private Button lookBusy;
    private ProgressBar busyBar;
    private TextView busyText;



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
        busyBar.setVisibility(View.INVISIBLE);
        busyText.setVisibility(View.INVISIBLE);
        final ArrayList<String> busyResponse = new ArrayList<String>(11){};
        busyResponse.add("Looking Busy...");
        busyResponse.add("Doing Busy Stuff...");
        busyResponse.add("Pretending to be busy...");
        busyResponse.add("Eating Sushi...");
        busyResponse.add("Playing Minecraft...");
        busyResponse.add("Studying For AP Comp Sci...");
        busyResponse.add("Complaining about teachers...");
        busyResponse.add("Bribing teachers for an A");
        busyResponse.add("Listening to Country Music...");
        busyResponse.add("Crying about Math Test Score...");
        busyResponse.add("Making Fun Of Kayden...");
        int rand = (int)(Math.random() * 11);
        busyText.setText(busyResponse.get(rand));
    }
    private void wireWidgets() {
        SELF_DESTRUCT = findViewById(R.id.button_main_self_destruct);
        useless = findViewById(R.id.switch_main_useless);
        constraintLayout = findViewById(R.id.constraint_layout_main);
        lookBusy = findViewById(R.id.button_main_look_busy);
        busyBar = findViewById(R.id.ProgressBar_main_lookBusy);
        busyText = findViewById(R.id.textView_main_lookBusy);
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
        lookBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SELF_DESTRUCT.setVisibility(View.INVISIBLE);
                useless.setVisibility(View.INVISIBLE);
                lookBusy.setVisibility(View.INVISIBLE);
                busyBar.setVisibility(View.VISIBLE);
                busyText.setVisibility(View.VISIBLE);
                int r = (int)(Math.random() * 256);
                int g = (int)(Math.random() * 256);
                int bl = (int)(Math.random() * 256);
                int color = Color.rgb(r, g, bl);
                constraintLayout.setBackgroundColor(color);
                final ArrayList<String> busyResponse = new ArrayList<String>(11){};
                busyResponse.add("Looking Busy...");
                busyResponse.add("Doing Busy Stuff...");
                busyResponse.add("Pretending to be busy...");
                busyResponse.add("Eating Sushi...");
                busyResponse.add("Playing Minecraft...");
                busyResponse.add("Studying For AP Comp Sci...");
                busyResponse.add("Complaining about teachers...");
                busyResponse.add("Bribing teachers for an A");
                busyResponse.add("Listening to Country Music...");
                busyResponse.add("Crying about Math Test Score...");
                busyResponse.add("Making Fun Of Kayden...");
                new CountDownTimer(10000, 100){
                    int timeLeft = 0;
                    @Override
                    public void onTick(long l){
                        busyBar.setProgress(timeLeft);
                        timeLeft++;
                        if (timeLeft % 5 == 0){
                            int r = (int)(Math.random() * 256);
                            int g = (int)(Math.random() * 256);
                            int bl = (int)(Math.random() * 256);
                            int color = Color.rgb(r, g, bl);
                            constraintLayout.setBackgroundColor(color);

                        }
                        if (timeLeft % 5 == 0){
                            int rand = (int)(Math.random() * 11);
                            busyText.setText(busyResponse.get(rand));
                        }
                    }
                    public void onFinish(){
                        SELF_DESTRUCT.setVisibility(View.VISIBLE);
                        useless.setVisibility(View.VISIBLE);
                        lookBusy.setVisibility(View.VISIBLE);
                        busyBar.setVisibility(View.INVISIBLE);
                        busyText.setVisibility(View.INVISIBLE);
                        busyBar.setProgress(0);
                    }
                }.start();

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
