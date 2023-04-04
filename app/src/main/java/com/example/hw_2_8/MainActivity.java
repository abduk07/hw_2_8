package com.example.hw_2_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hw_2_8.R;
import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    MaterialButton transition;
    private Double first, second, sum;//переменные в которых храняться первое,второе слагаемое и сумма
    private Boolean isOperationClick;//проверка на нажатие кнопок операции
    private String operation = "";//переменная с помощью которой мы будем проверять ту или иную операцию на нажатие
    private Double percent = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        transition=findViewById(R.id.transition);
    }

    private void setNumber(String number) {//метод который проверяет нажатие кнопок цифр,точки и очистить
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;//проверка на нажатие кнопок операции
    }

    public void onClickNumber(View view) {
        switch (view.getId()) {
            case R.id.one:
                setNumber("1");//нажимаем на кнопку 1
                break;
            case R.id.two:
                setNumber("2");//нажимаем на кнопку 2
                break;
            case R.id.three:
                setNumber("3");//нажимаем на кнопку 3
                break;
            case R.id.four:
                setNumber("4");//нажимаем на кнопку 4
                break;
            case R.id.five:
                setNumber("5");//нажимаем на кнопку 5
                break;
            case R.id.six:
                setNumber("6");//нажимаем на кнопку 6
                break;
            case R.id.seven:
                setNumber("7");//нажимаем на кнопку 7
                break;
            case R.id.eight:
                setNumber("8");//нажимаем на кнопку 8
                break;
            case R.id.nine:
                setNumber("9");//нажимаем на кнопку 9
                break;
            case R.id.zero:
                setNumber("0");//нажимаем на кнопку 0
                break;
            case R.id.dot://нажимаем на точку
                if (!textView.getText().toString().contains(".")) {//если получаемый текст textView не имеет "." в строке то прикрепи к нему точку
                    textView.append(".");
                    break;
                }
            case R.id.clear://нажимаем на кнопку AС
                textView.setText("0");//даем значение 0
                first = 0.0;//даем значение 0 первой переменной
                second = 0.0;//даем значение 0 второй переменной
                break;
        }
        isOperationClick = false;//проверка на нажатие кнопок операции
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operation = "+";//нажимаем на +
                first = Double.parseDouble(textView.getText().toString());//parseDouble возвращает примитивный дубль
                isOperationClick = true;
                break;
            case R.id.minus://нажимаем на -
                operation = "-";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.multiply://нажимаем на х
                operation = "×";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.divide://нажимаем на /
                operation = "÷";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.percent://нажимаем на %
                operation = "%";
                first = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "÷";

//                switch (operation) {
//                    case "÷":
//                        sum = first * second / 100;
//                        sum = sum /100;
//                        break;
//                }
                break;
            case R.id.equals://нажимаем на =
                second = Double.parseDouble(textView.getText().toString());
                sum = 0.0;

                switch (operation) {//проверка нажал ты на операцию или нет
                    case "+":
                        sum = first + second;//простая арифметика
                        break;
                    case "-":
                        sum = first - second;
                        break;
                    case "×":
                        sum = first * second;
                        break;
                    case "÷":
                        sum = first / second;
                        break;
                    case "%":
                        percent = second / 100;
                        sum = first * percent;
                        break;
                }
                textView.setText(new DecimalFormat("##.#####").format(sum));//выводим ответ в строку
                transition.setVisibility(View.VISIBLE);
                onClick();
                isOperationClick = true;
                break;
        }
    }

    private void onClick() {
        transition.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("key",sum);
            startActivity(intent);
        });

    }
}