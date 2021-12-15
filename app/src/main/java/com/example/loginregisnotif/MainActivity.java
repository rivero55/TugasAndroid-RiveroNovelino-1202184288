package com.example.loginregisnotif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final EditText username = findViewById(R.id.username);
        final EditText email= findViewById(R.id.email);
        final EditText password= findViewById(R.id.password);
      Button button2= (Button) findViewById(R.id.button2);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
               String newUser = username.getText().toString();
               String  newEmail = email.getText().toString();
               String newPassword = password.getText().toString();

               SharedPreferences.Editor editor= sharedPreferences.edit();
               editor.putString(newUser +  newPassword + "data", newUser + "\n" + newEmail);
               editor.commit();


                Intent login= new Intent(MainActivity.this,MainActivity3.class);
                startActivity(login);

            }
        });
    }
}