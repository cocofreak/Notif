package com.example.toast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class StartActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_start);
        button = findViewById(R.id.button);

       final NotificationCompat.Builder b = new NotificationCompat.Builder(this,"chanellID");
        b.setSmallIcon(R.drawable.ic_launcher_background);
        b.setContentTitle("This is the Notification Title");
        b.setContentText("I am the message");

        PendingIntent intent = PendingIntent.getActivity(this,1,new Intent(this,MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        b.setContentIntent(intent);

        final NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(0, b.build());
            }
        });
    }
}
