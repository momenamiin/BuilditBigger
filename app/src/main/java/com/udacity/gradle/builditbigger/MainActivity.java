package com.udacity.gradle.builditbigger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    private static final String LOGIN_RECEIVER_FILTER = "LOGIN_RECEIVER_FILTER";

    BroadcastReceiver broadcastReceiver ;

    /*
    public static class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("Memo" , "onReceive");
            MainActivity mainActivity = new MainActivity();
        }
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                unregisterReceiver(this);
                broadcastReceiver = null ;
                Log.v("Memo" , "onReceive");
                String result = intent.getStringExtra("result") ;
                handleResponse(result);

            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter(LOGIN_RECEIVER_FILTER));

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

        public void tellJoke(View view) {
            new EndpointsAsyncTask().execute(this);
        }

    @Override
    protected void onStop() {
        super.onStop();
        if (broadcastReceiver != null){
            unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
        }
    }

    @VisibleForTesting
    public void handleResponse(String loginResponse) {
        Log.v("Memo" , "handleLoginResponse1");

    }
}
