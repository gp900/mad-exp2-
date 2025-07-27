package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2, etSingleNum;
    TextView tvCalcResult, tvNumResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnFactorial, btnEvenOdd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etSingleNum = findViewById(R.id.etSingleNum);
        tvCalcResult = findViewById(R.id.tvCalcResult);
        tvNumResult = findViewById(R.id.tvNumResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnFactorial = findViewById(R.id.btnFactorial);
        btnEvenOdd = findViewById(R.id.btnEvenOdd);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));

        btnFactorial.setOnClickListener(v -> {
            int num = Integer.parseInt(etSingleNum.getText().toString());
            tvNumResult.setText("Factorial: " + factorial(num));
        });

        btnEvenOdd.setOnClickListener(v -> {
            int num = Integer.parseInt(etSingleNum.getText().toString());
            tvNumResult.setText(num % 2 == 0 ? "Even Number" : "Odd Number");
        });
    }

    @SuppressLint("SetTextI18n")
    private void calculate(char op) {
        double n1 = Double.parseDouble(etNum1.getText().toString());
        double n2 = Double.parseDouble(etNum2.getText().toString());
        double res = 0;

        switch (op) {
            case '+': res = n1 + n2; break;
            case '-': res = n1 - n2; break;
            case '*': res = n1 * n2; break;
            case '/':
                if (n2 != 0) res = n1 / n2;
                else { tvCalcResult.setText("Cannot divide by 0"); return; }
                break;
        }

        tvCalcResult.setText("Result: " + res);
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}
