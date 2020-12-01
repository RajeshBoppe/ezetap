package com.example.rajesh.mathops;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SubtractionActivity extends AppCompatActivity {

    private TextView textInputOne, textInputTwo, textResult;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        textInputOne = findViewById(R.id.text_one);
        textInputTwo = findViewById(R.id.text_two);
        textResult = findViewById(R.id.text_result);
        btnResult = findViewById(R.id.btn_result);

        Bundle bundle = getIntent().getExtras();
        int num1 = bundle.getInt("num1");
        int num2 = bundle.getInt("num2");
        int sub = num1 - num2;

        textInputOne.setText(String.format(Locale.getDefault(), "%d", num1));
        textInputTwo.setText(String.format(Locale.getDefault(), "%d", num2));
        textResult.setText(String.format(Locale.getDefault(), "%d", sub));

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", sub);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}