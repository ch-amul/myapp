package com.cherukuriamul.firstproject;

import android.content.Intent;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private TextView signup;
    private Button login;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.login_emaiid);
        password = (EditText) findViewById(R.id.login_password);
        signup = (TextView) findViewById(R.id.login_signup);
        login = (Button) findViewById(R.id.login_button);
        firebaseAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String login_mail_user = email.getText().toString();
                String login_pass_user = password.getText().toString();

                if (!TextUtils.isEmpty(login_mail_user) && !TextUtils.isEmpty(login_pass_user)) {
                    firebaseAuth.signInWithEmailAndPassword(login_mail_user, login_pass_user).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                Intent profile_intent = new Intent(MainActivity.this, profileactivity.class);
                                startActivity(profile_intent);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "USer not Verified", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Username/Password field Missing", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



        signup.OnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc=new Intent(MainActivity.this,signup.class);
                startActivity(abc);

            }
        });


    }
}
