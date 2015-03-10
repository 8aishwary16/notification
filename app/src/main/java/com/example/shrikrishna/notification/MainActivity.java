package com.example.shrikrishna.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        displayNotification();
    }

    public void displayNotification(){
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID",notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,0);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Notification notif = new Notification(
                R.drawable.ic_launcher,"Reminder:Meeting starts in 5 minutes",System.currentTimeMillis()
        );

        CharSequence from = "SystemAlarm";
        CharSequence message = "Meeting with customer at 3 pm";

        notif.setLatestEventInfo(this,from,message,pendingIntent);
        nm.notify(notificationID,notif);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
