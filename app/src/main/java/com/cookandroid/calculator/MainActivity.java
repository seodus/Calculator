package com.cookandroid.calculator;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    EditText firstNumEdit, secondNumEdit;
    Button plusBtn, minusBtn, divideBtn, multiplyBtn;
    String firstNum, secondNum;
    int plusR, minusR, divideR, multiplyR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.resultText);
        firstNumEdit = (EditText) findViewById(R.id.firstNumEdit);
        secondNumEdit = (EditText) findViewById(R.id.secondNumEdit);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        divideBtn = (Button) findViewById(R.id.divideBtn);
        multiplyBtn = (Button) findViewById(R.id.multiplyBtn);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firstNum = firstNumEdit.getText().toString();
                    secondNum = secondNumEdit.getText().toString();
                    plusR = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
                    resultText.setText(plusR);

                }
                catch (Exception e){    //숫자를 하나 이상 입력하지 않은 경우
                    Toast.makeText(getApplicationContext(),"숫자를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firstNum = firstNumEdit.getText().toString();
                    secondNum = secondNumEdit.getText().toString();
                    minusR = Integer.parseInt(firstNum) - Integer.parseInt(secondNum);
                    resultText.setText("결과" + "\n" + minusR);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"숫자를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firstNum = firstNumEdit.getText().toString();
                    secondNum = secondNumEdit.getText().toString();
                    divideR = Integer.parseInt(firstNum) / Integer.parseInt(secondNum);
                    resultText.setText("결과" + "\n" + divideR);
                }
                catch (ArithmeticException e){  //나누는 값이 0일때 예외
                    resultText.setText("결과" + "\n" );
                    Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다. 다시 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){   //숫자를 하나 이상 입력하지 않은 경우
                    resultText.setText("결과" + "\n" );
                    Toast.makeText(getApplicationContext(),"숫자를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firstNum = firstNumEdit.getText().toString();
                    secondNum = secondNumEdit.getText().toString();
                    multiplyR = Integer.parseInt(firstNum) * Integer.parseInt(secondNum);
                    resultText.setText("결과" + "\n" + multiplyR);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"숫자를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}