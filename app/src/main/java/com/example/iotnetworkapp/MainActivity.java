package com.example.iotnetworkapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import java.net.*;
import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
//To be used in the future, once test is successful.

    /*ConnectivityManager cm = (ConnectivityManager)Context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    WifiManager wm = (WifiManager)Context.getApplicationContext.(getSystemService(Context.WIFI_SERVICE));

    WifiInfo connectionInfo = wm.getConnectionInfo();
    int ipAddress = connectionInfo.getIpAddress();
    String ipString = formatter.formatIPAddress(ipAddress);
    */

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.printText);
        String wrong = "nothing worked";
        text.setText(wrong);

        //Test pinging localhost and printing something on the screen when the ping returns.
        try
        {
            InetAddress localhost = InetAddress.getLocalHost();
            byte[] ip = localhost.getAddress();
            String word = "address + address.getHostAddress() + address.getAddress() + address.getHostName() + address.getCanonicalHostName()";

            for (int i = 1; i <= 254; i++) {
                ip[3] = (byte) i;
                InetAddress address = InetAddress.getByAddress(ip);
                if (address.isReachable(30))
                {
                    text.setText(word);
                }
                else
                {
                    Log.d("ERROR", "The address is not reachable.");
                }

            }
        }
        catch(Exception e)
        {
            Log.d("ERROR", "" + e);
        }
    }
}
