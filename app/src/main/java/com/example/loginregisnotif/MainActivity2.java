package com.example.loginregisnotif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences sharedPreferences= getSharedPreferences("MYPREFS" , MODE_PRIVATE);
        String display= sharedPreferences.getString("display", "");

        TextView info = (TextView) findViewById(R.id.textinfo);
        info.setText(display);
    }
}