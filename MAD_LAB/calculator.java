package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edittext1,edittext2,edittext3;
    Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1=findViewById(R.id.e1);
        edittext2=findViewById(R.id.e2);
        edittext3=findViewById(R.id.e3);

        bt1=findViewById(R.id.b1);
        bt2=findViewById(R.id.b2);
        bt3=findViewById(R.id.b3);
        bt4=findViewById(R.id.b4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(edittext1.getText().toString());
                double num2 = Double.parseDouble(edittext2.getText().toString());
                double result = num1 + num2;
                edittext3.setText(String.valueOf(result));
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(edittext1.getText().toString());
                double num2 = Double.parseDouble(edittext2.getText().toString());
                double result = num1 - num2;
                edittext3.setText(String.valueOf(result));
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(edittext1.getText().toString());
                double num2 = Double.parseDouble(edittext2.getText().toString());
                double result = num1 * num2;
                edittext3.setText(String.valueOf(result));
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(edittext1.getText().toString());
                double num2 = Double.parseDouble(edittext2.getText().toString());
                double result = num1 / num2;
                edittext3.setText(String.valueOf(result));
            }
        });

    }
}
