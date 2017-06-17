package com.test.saeed;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class Permissions extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.permissions);
		
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        TextView wifiStateTextView = (TextView) findViewById(R.id.wifi_state_text_view);
        boolean wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        if(wifiState) {
        	wifiStateTextView.setText("Wifi is Connected!");
        }
        else {
        	wifiStateTextView.setText("Wifi is not Connected!");
        }
        
        
	}
}
