package com.example.mmatviyiv.myapplication;

import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HelloName extends Activity {
    private EditText edit;
    private TextView TextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        edit = findViewById(R.id.edittext);
        TextView = findViewById(R.id.text);
    }

    public void clickButton(View view) {
        String text = edit.getText().toString();
        TextView.setText("Hello" + " " + text + "!");
    }


    public void clearButton(View view) {
        edit.setText("");
    }
}