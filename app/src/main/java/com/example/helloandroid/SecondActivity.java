package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    public static final String WELCOME = "";
    public static final String NAME = "";
    Button button2;
    EditText input_text_2;
    TextView text_from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent data = getIntent();
        String welcome = data.getStringExtra(WELCOME);
        button2 = findViewById(R.id.button2);
        input_text_2 = findViewById(R.id.input_text_2);
        text_from = findViewById(R.id.text_from);
        text_from.setText(welcome);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                String text = welcome + ", " + input_text_2.getText().toString();
                result.putExtra(NAME, text);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}