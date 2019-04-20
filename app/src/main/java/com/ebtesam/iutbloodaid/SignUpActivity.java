package com.ebtesam.iutbloodaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEditText,passwordEditText,repasswordEditText;
    private ImageButton signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");

        emailEditText=findViewById(R.id.email);
        passwordEditText=findViewById(R.id.password);
        repasswordEditText=findViewById(R.id.confirmpass);
        signUpButton=findViewById(R.id.signup);

        signUpButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signup){
            userSignUp();
        }

    }

    private void userSignUp() {

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
        String[] arr=str.split("@");
        if(!arr[1].isEqual("iut-dhaka.edu")){
            emailEditText.setError("Enter an IUT provided Email Address");
            emailEditText.requestFocus();
            return;
        }

        Intent intent = new Intent(getApplicationContext(),ChooseActivity.class);
        intent.putExtra("email",email);
        startActivity(intent);


    }
}
