package com.example.layoutadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView tv_edit, tv_webUrl;
    private TextView tv_five;
    private EditText et_edit;

    private TextInputLayout errorInput, customError;
    private TextInputEditText errorEditText, customEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorEditText = findViewById(R.id.errorEditText);
        customEditText = findViewById(R.id.customErrorEditText);
        customError = findViewById(R.id.customErrorLayout);
        errorInput = findViewById(R.id.errorErrorLayout);
        errorEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > errorInput.getCounterMaxLength()) {
                    errorInput.setError("Error: Max length " + errorInput.getCounterMaxLength());
                } else {
                    errorInput.setError(null);
                }
            }
        });
        customEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > customError.getCounterMaxLength()) {
                    customError.setError("Error:  Max length " + customError.getCounterMaxLength());
                } else {
                    customError.setError(null);
                }
            }
        });

        //task3
        et_edit = findViewById(R.id.et_edit);
        tv_edit = findViewById(R.id.tv_edit);
        et_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_edit.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //task5
        tv_five = findViewById(R.id.tv_five);
        String text = "I would #like to do #something similar to the #twitter app";
        Spannable span = new SpannableString(text);
        Matcher matcher = Pattern.compile("#([A-Za-z0-9_-]+)").matcher(text);
        while (matcher.find()) {
            span.setSpan(new ForegroundColorSpan(Color.BLUE), matcher.start(), matcher.end(), 0);
        }
        tv_five.setText(span);
        //task 6
        tv_webUrl = findViewById(R.id.tv_webUrl);
        String webUrl = "I would like to do something similar to the https://twitter.com app, www.google.com";
        Spannable spanUrl = new SpannableString(webUrl);
        Matcher matcherUrl = Pattern.compile("((http?|https|ftp|file)://)?(([Ww]){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+").matcher(spanUrl);
        while (matcherUrl.find()) {
            spanUrl.setSpan(new ForegroundColorSpan(Color.GREEN), matcherUrl.start(), matcherUrl.end(), 0);
        }
        tv_webUrl.setText(spanUrl);
    }
}