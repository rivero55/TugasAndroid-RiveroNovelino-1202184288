package com.example.loginregisnotif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText setName = (EditText) findViewById(R.id.usernameedit);
        final EditText setPassword = (EditText) findViewById(R.id.passwordedit);
        Button btnLogin = (Button) findViewById(R.id.buttonLogin);



btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String user = setName.getText().toString();
        String pass = setPassword.getText().toString();
        String message = "";

        if(user == null || pass == null){
            message = "Username / Password Salah";
        }else{
            message = "Berhasil Login";

        }

        SharedPreferences sharedPreferences= getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String userDetail= sharedPreferences.getString(user + pass + "data","Username Password Salah");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("display", userDetail);
        editor.commit();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("mynotif","mynotif", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity3.this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Login");
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                // Set the intent that will fire when the user taps the notification
        builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

        manager.notify(1,builder.build());


    }
});

    }
}