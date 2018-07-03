package com.example.abusalameh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/*
         Main Registration
 */
public class MainActivity extends AppCompatActivity {

    EditText name,email,pass,copass;
    Button reg;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    final Boolean savelogin = null;
    CheckBox reme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        copass=(EditText)findViewById(R.id.copass);
        pass=(EditText)findViewById(R.id.pass);

        reg=(Button)findViewById(R.id.logbtn);

        // Creating A shared preference
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);

        reme=(CheckBox)findViewById(R.id.reme);
        editor=sharedPreferences.edit();

        //Switch to Login page button
        Button log = findViewById(R.id.button3);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,login.class);
                startActivity(intent);

            }
        });

        //Register and enter the app button
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    login();

            }
        });
    }

    //Login function to check if everything is correct
    public void login(){

       Boolean n = name.getText().toString().isEmpty();
       Boolean e = email.getText().toString().isEmpty();
       Boolean p = pass.getText().toString().isEmpty();


        if(n || e || p) //Checking if EditText is empty
        {
            //if empty Alert the user by Toast

            Toast.makeText(this, "Please Enter Your Information",Toast.LENGTH_LONG).show();

        } else if (! pass.getText().toString().matches(copass.getText().toString())){

            //if not empty check if password and confirm password matches
            // if they don't match toast a message

            Toast.makeText(this, "Password NOT matched",Toast.LENGTH_LONG).show();
        }else {

            // Now get all strings needed and save it in Shared preferances if Remember me is checked
        String usrname = name.getText().toString();
        String passwrd = pass.getText().toString();
        String emil = email.getText().toString();


            if(reme.isChecked()){
                editor.putBoolean("savelogin",true);
                editor.putString("username",usrname);
                editor.putString("password",passwrd);
                editor.putString("email",emil);
                editor.commit();

            }

            //If all good go to menu

            Intent intent= new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);}
    }

}
