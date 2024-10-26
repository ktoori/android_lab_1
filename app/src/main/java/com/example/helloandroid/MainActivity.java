package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText input_text_1;
    TextView result_text_1;
    private static final int SHOW_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        input_text_1 = findViewById(R.id.input_text_1);
        result_text_1 = findViewById(R.id.result_text_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                String welcome = input_text_1.getText().toString();
                i.putExtra(SecondActivity.WELCOME, welcome);
                startActivityForResult(i, SHOW_SECOND_ACTIVITY);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case (SHOW_SECOND_ACTIVITY):
                if (resultCode == Activity.RESULT_OK) {
                    String name = data.getStringExtra(SecondActivity.NAME);
                    input_text_1.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    result_text_1.setText(name);
                }
                break;
        }

    }

}