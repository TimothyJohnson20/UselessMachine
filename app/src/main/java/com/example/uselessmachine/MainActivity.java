package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();

    }
    private void wireWidgets() {
        SELF_DESTRUCT = findViewById(R.id.button_main_self_destruct);
        useless = findViewById(R.id.switch_main_useless);
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
                        }
                    }.start();
                }


//                if(b){
//                    Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_SHORT).show();
//
//                }
            }
        });
    }
}
