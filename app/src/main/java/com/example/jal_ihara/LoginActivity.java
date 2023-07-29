package com.example.jal_ihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    TextView usernameError, passwordError;
    Button loginBtn;
    boolean passVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int right = 2;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= password.getRight() - password.getCompoundDrawables()[right].getBounds().width()) {
                        int select = password.getSelectionEnd();

                        if (passVisible) {
                            // image visibility off
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_visibility_off, 0);
                            // hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passVisible = false;
                        } else {
                            // image visibility on
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_visibility_on, 0);
                            // show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passVisible = true;
                        }

                        password.setSelection(select);
                        return true;
                    }
                }

                return false;
            }
        });

        usernameError = findViewById(R.id.usernameError);
        passwordError = findViewById(R.id.passwordError);
        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener((e) -> {
            String usernameField = username.getText().toString();
            String passwordField = password.getText().toString();
            int flag = 0;
            if (usernameField.isEmpty()) {
                usernameError.setText("Username can't be empty");
                usernameError.setVisibility(View.VISIBLE);
            } else if (usernameField.length() < 6){
                usernameError.setText("Username must be more than 5 character");
                usernameError.setVisibility(View.VISIBLE);
            } else{
                flag = 1;
                usernameError.setVisibility(View.GONE);
            }
            if (passwordField.isEmpty()) {
                passwordError.setText("Password can't be empty");
                passwordError.setVisibility(View.VISIBLE);
                flag = 0;
            } else if (passwordField.length() < 9) {
                passwordError.setText("Password must be more than 8 character");
                passwordError.setVisibility(View.VISIBLE);
                flag = 0;
            } else{
                flag = 1;
                passwordError.setVisibility(View.GONE);
            }

            if(flag == 1) {
                // Save the username in SharedPreferences
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", usernameField);
                editor.apply();

                Intent toHome = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
    }
}
