package com.example.jal_ihara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                final int right=2;

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
        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener((e)->{
            String usernameField = username.getText().toString();
            String passwordField = password.getText().toString();

            if (usernameField.isEmpty() || passwordField.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please input all fields", Toast.LENGTH_SHORT).show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Success");
                builder.setMessage("You have successfully logged in!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent toHome = new Intent(LoginActivity.this, HomeActivity.class);
                        // passing data
                        toHome.putExtra("username", usernameField);
                        startActivity(toHome);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
