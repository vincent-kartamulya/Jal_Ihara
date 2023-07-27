package com.example.jal_ihara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        EditText editText = findViewById(R.id.editText);
        String userInput = editText.getText().toString();
    }
}