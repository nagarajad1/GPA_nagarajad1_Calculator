package com.example.gpa_nagarajad1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4, editText5;
    Button button;
    TextView outputllabel;

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            button = (Button) findViewById(R.id.button1);
            button.setText(R.string.computegpa);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button1);

        editText1 = (EditText) findViewById(R.id.editTextTextPersonName1);
        editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        editText3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        editText4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        editText5 = (EditText) findViewById(R.id.editTextTextPersonName5);

        editText1.addTextChangedListener(watcher);
        editText2.addTextChangedListener(watcher);
        editText3.addTextChangedListener(watcher);
        editText4.addTextChangedListener(watcher);
        editText5.addTextChangedListener(watcher);


    }


    public void computeandclear(View view) {
        final ConstraintLayout constraintLayout;
        constraintLayout = findViewById(R.id.clVar1);

        outputllabel = (TextView) findViewById(R.id.gpaLabel);

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        String value3 = editText3.getText().toString();
        String value4 = editText4.getText().toString();
        String value5 = editText5.getText().toString();


        String buttonText = button.getText().toString();

        if (buttonText.equals("Compute GPA")) {
            if (TextUtils.isEmpty(value1)) {
                editText1.setError("This field is required");
                return;
            }
            if (TextUtils.isEmpty(value2)) {
                editText2.setError("This field is required");
                return;
            }
            if (TextUtils.isEmpty(value3)) {
                editText3.setError("This field is required");
                return;
            }
            if (TextUtils.isEmpty(value4)) {
                editText4.setError("This field is required");
                return;
            }
            if (TextUtils.isEmpty(value5)) {
                editText5.setError("This field is required");
                return;
            }

            int finalValue1 = Integer.parseInt(value1);
            int finalValue2 = Integer.parseInt(value2);
            int finalValue3 = Integer.parseInt(value3);
            int finalValue4 = Integer.parseInt(value4);
            int finalValue5 = Integer.parseInt(value5);

            if (finalValue1 >= 0 ^ finalValue1 <= 100) {
                editText1.setError("This field Value should be 0 - 100");
                return;
            }
            if (finalValue2 >= 0 ^ finalValue2 <= 100) {
                editText2.setError("This field Value should be 0 - 100");
                return;
            }
            if (finalValue3 >= 0 ^ finalValue3 <= 100) {
                editText3.setError("This field Value should be 0 - 100");
                return;
            }
            if (finalValue4 >= 0 ^ finalValue4 <= 100) {
                editText4.setError("This field Value should be 0 - 100");
                return;
            }
            if (finalValue5 >= 0 ^ finalValue5 <= 100) {
                editText5.setError("This field Value should be 0 - 100");
                return;
            }

            int finalValue = (finalValue1 + finalValue2 + finalValue3 + finalValue4 + finalValue5) / 5;
            outputllabel.setText(String.valueOf(finalValue));
            button.setText(R.string.clearform);

            if (finalValue > 80) {
                constraintLayout.setBackgroundResource(R.color.green);
            } else if (finalValue > 60) {
                constraintLayout.setBackgroundResource(R.color.yellow);
            } else {
                constraintLayout.setBackgroundResource(R.color.red);
            }

        } else {
            editText1.getText().clear();
            editText2.getText().clear();
            editText3.getText().clear();
            editText4.getText().clear();
            editText5.getText().clear();
            button.setText(R.string.clearform);
            constraintLayout.setBackgroundResource(R.color.white);
        }
    }
}