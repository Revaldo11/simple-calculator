package com.revaldoputra.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editValue1, editValue2;
    Button btnCalculate;
    TextView textResult;

    RadioGroup radioOperators;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        editValue1 = findViewById(R.id.edit_value_1);
        editValue2 = findViewById(R.id.edit_value_2);
        btnCalculate = findViewById(R.id.btn_calculate);
        textResult = findViewById(R.id.text_result);
        radioOperators = findViewById(R.id.radio_operators);
        setupListener();
    }

    private void setupListener(){
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = editValue1.getText().toString();
                String value2 = editValue2.getText().toString();
                if (value1.isEmpty() || value2.isEmpty() || operator.isEmpty()){
                    showMessage();
                } else {
                    int value1Int = Integer.parseInt(value1);
                    int value2Int = Integer.parseInt(value2);
                    String result = value(value1Int, value2Int);
                    textResult.setText(result);
                }
            }
        });

        radioOperators.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton= findViewById(radioGroup.getCheckedRadioButtonId());
                operator = radioButton.getText().toString();
                textResult.setText("HASIL");
            }
        });
    }

    private String value(int value1, int value2){
        int result = 0;

        switch (operator){
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                result = value1 / value2;
                break;
        }

        return String.valueOf(result);
    }

    private void showMessage() {
        Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
    }
}