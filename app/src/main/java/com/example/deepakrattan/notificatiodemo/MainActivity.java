package com.example.deepakrattan.notificatiodemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSendNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewByID
        btnSendNotification = (Button) findViewById(R.id.btnSendNotification);
        btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                //on clicking notification ,corresponding activity should be launched.We want
                //to launch an activity displaying google page
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);


                builder.setSmallIcon(R.drawable.icon);
                builder.setContentTitle("My Notification");
                builder.setContentText("Welcome to all android students");
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(001,builder.build());






            }
        });
    }
}
