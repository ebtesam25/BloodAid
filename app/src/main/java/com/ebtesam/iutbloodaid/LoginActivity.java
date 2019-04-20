package com.ebtesam.iutbloodaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private EditText emailEditText,passwordEditText;
    private Button forgotPassword;
    private ImageButton logIn,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Sign In");

        emailEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        forgotPassword = findViewById(R.id.forgotPass);
        logIn = findViewById(R.id.loginButton);
        signUp = findViewById(R.id.signupButton);

        signUp.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        logIn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.loginButton
                userLogIn();
                break;

            case R.id.forgotPass

                break;

            case R.id.signupButton
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;


        }



    }

    private void userLogIn() {
        String email=emailEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();

        if(email.isEmpty()){
            emailEditText.setError("Enter an Email Address");
            emailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Enter a valid Email Address");

            emailEditText.requestFocus();
            return;

        }
        if(password.isEmpty()){
            passwordEditText.setError("Enter your password");
            passwordEditText.requestFocus();
            return;
        }
        if(password.length()<6){
            passwordEditText.setError("Minimum length should be 6");
            passwordEditText.requestFocus();
            return;

        }


    }
}
