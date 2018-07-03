package com.example.abusalameh.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/*
Login Page
 */

public class login extends AppCompatActivity {
    EditText user,pas;
    Button reg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.namelog);
        pas=(EditText)findViewById(R.id.passwordlog);

        // Button to Back to registration page
        Button reg = findViewById(R.id.bktoreg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(login.this,MainActivity.class);
                startActivity(intent);

            }
        });

        //Retrive data from shared Preferances
        SharedPreferences res = getSharedPreferences("loginref",MODE_PRIVATE);



            user.setText(res.getString("username",null));
            pas.setText(res.getString("password",null));

            Button lo = findViewById(R.id.logbtn);
            lo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login1();
                }
            });


}
    // function to check if all good
    private void login1() {
        if(user.getText().toString().isEmpty() || pas.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter Your Information",Toast.LENGTH_LONG).show();
        } else {
            Intent intent= new Intent(login.this,Main2Activity.class);
            startActivity(intent); // Go to menu
        }
    }
}
