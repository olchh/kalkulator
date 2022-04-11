package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    int one;
    int two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        one = intent.getIntExtra("first", one);
        two = intent.getIntExtra("second", two);
        TextView mainView = findViewById(R.id.rur);

        if (two<0){
            mainView.setText(one + " + " +"("+ two + ")" + " = " + (one+two));
        }
        else{
            mainView.setText(one + " + " + two + " = " + (one+two));
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.rur);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
            int[] nums = savedInstanceState.getIntArray("nums");

        }
    }
}