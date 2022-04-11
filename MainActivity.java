package com.example.kalkylator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
        public int one = 0;
        public int two = 0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            EditText one1 = (EditText) findViewById(R.id.wuw);
            EditText two2 = (EditText) findViewById(R.id.wuw2);

            one1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        one1.setText("");
                    }
                }
            });
            two2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        two2.setText("");
                    }
                }
            });
        }

        public void plus(View view){
            TextView one1 = findViewById(R.id.wuw);
            TextView two2 = findViewById(R.id.wuw2);

            try {
                one = Integer.parseInt(String.valueOf(one1.getText()));
                two = Integer.parseInt(String.valueOf(two2.getText()));
                //запуск активити с ответом
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("first", one);
                intent.putExtra("second",two);
                startActivity(intent);
            }
            catch (Exception ex){
                //ошибки с окном предупреждений
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("oшибка");
                builder.setMessage("попробуйте еще раз");
                builder.setPositiveButton("Ок", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        }


        protected void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putIntArray("nums", new int[] {one, two});
        }
        protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
            if (savedInstanceState != null && savedInstanceState.containsKey("nums")) {
                int[] nums = savedInstanceState.getIntArray("nums");
                one = nums[0];
                two = nums[1];
                if (!(one == 0 && two == 0)){
                    resetUI();
                }

            }
        }
        protected void resetUI(){
            TextView leftScore = findViewById(R.id.wuw);
            leftScore.setText(String.valueOf(one));
            TextView rightScore = findViewById(R.id.wuw2);
            rightScore.setText(String.valueOf(two));
        }
    }
