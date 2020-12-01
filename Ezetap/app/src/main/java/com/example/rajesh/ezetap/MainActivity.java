package com.example.rajesh.ezetap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rajesh.mathops.AdditionActivity;
import com.example.rajesh.mathops.SubtractionActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextOne, editTextTwo;
    private Button addBtn, subBtn;
    private TextView textOutput, textInputOne, textInputTwo, textAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextOne = findViewById(R.id.edit_one);
        editTextTwo = findViewById(R.id.edit_two);
        textOutput = findViewById(R.id.text_output);
        textInputOne = findViewById(R.id.text_one);
        textInputTwo = findViewById(R.id.text_two);
        textAction = findViewById(R.id.text_action);
        addBtn = findViewById(R.id.btn_add);
        subBtn = findViewById(R.id.btn_sub);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(editTextOne.getText().toString());
                int num2 = Integer.parseInt(editTextTwo.getText().toString());
                textInputOne.setText(String.format(Locale.getDefault(), "%d", num1));
                textInputTwo.setText(String.format(Locale.getDefault(), "%d", num2));
                Intent intent = new Intent(MainActivity.this, AdditionActivity.class);
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                startActivityForResult(intent, 1);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(editTextOne.getText().toString());
                int num2 = Integer.parseInt(editTextTwo.getText().toString());
                Intent intent = new Intent(MainActivity.this, SubtractionActivity.class);
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                int add = data.getIntExtra("result", 0);
                // update views
                textAction.setText("Addition");
                textOutput.setText("" + add);
            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                int sub = data.getIntExtra("result", 0);
                // update views
                textAction.setText("Subtraction");
                textOutput.setText("" + sub);
            }
        }
    }
}