package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText e3;
    Button[] numberButtons = new Button[10];
    Button btnAdd,btnSubtract,btnMultiply,btnDivide,btnEqual,btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e3 = findViewById(R.id.e3);

        numberButtons[0] = findViewById(R.id.b0);
        numberButtons[1] = findViewById(R.id.b1);
        numberButtons[2] = findViewById(R.id.b2);
        numberButtons[3] = findViewById(R.id.b3);
        numberButtons[4] = findViewById(R.id.b4);
        numberButtons[5] = findViewById(R.id.b5);
        numberButtons[6] = findViewById(R.id.b6);
        numberButtons[7] = findViewById(R.id.b7);
        numberButtons[8] = findViewById(R.id.b8);
        numberButtons[9] = findViewById(R.id.b9);

        btnAdd = findViewById(R.id.b_add);
        btnSubtract = findViewById(R.id.b_sub);
        btnMultiply = findViewById(R.id.b_mul);
        btnDivide = findViewById(R.id.b_div);
        btnEqual = findViewById(R.id.b_equal);
        btnClear = findViewById(R.id.b_back);

        for(int i=0 ; i<=9 ; i++) {
            int finalI = i;
            numberButtons[i].setOnClickListener(v -> e3.append(String.valueOf(finalI)));
        }

        btnAdd.setOnClickListener(v -> e3.append("+"));
        btnSubtract.setOnClickListener(v -> e3.append("-"));
        btnMultiply.setOnClickListener(v -> e3.append("*"));
        btnDivide.setOnClickListener(v -> e3.append("/"));

        btnClear.setOnClickListener(v -> e3.setText(""));

        btnEqual.setOnClickListener(v -> {
            String expr = e3.getText().toString();

            int opIndex = -1;
            char operator = ' ';

            if(expr.contains("+")){
                opIndex = expr.indexOf("+");
                operator = '+';
            }
            else if(expr.contains("-")){
                opIndex = expr.indexOf("-");
                operator = '-';
            }
            else if(expr.contains("*")){
                opIndex = expr.indexOf("*");
                operator = '*';
            }
            else if(expr.contains("/")){
                opIndex = expr.indexOf("/");
                operator = '/';
            }
            if(opIndex > 0 && opIndex < expr.length() -1){
                String num1 = expr.substring(0,opIndex);
                String num2 = expr.substring(opIndex + 1);

                int n1 = Integer.valueOf(num1);
                int n2 = Integer.valueOf(num2);
                int result = 0;

                if(operator == '+') result = n1 + n2;
                else if(operator == '-') result = n1 - n2;
                else if(operator == '*') result = n1 * n2;
                else if(operator == '/') result = n1 / n2;

                e3.setText(String.valueOf(result));
            }
        });
    }
}
