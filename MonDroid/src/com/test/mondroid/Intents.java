package com.test.saeed;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Intents extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intents);
		
		Intent intent = getIntent();
		String intentAction = intent.getAction();
		if(Intent.ACTION_VIEW.equals(intentAction)) {
			
			TextView web_page_url_text_view = (TextView) findViewById(R.id.web_page_url);
			Uri data = intent.getData();
			URL url;
			try {
				url = new URL(data.getScheme(), data.getHost(), data.getPath());
				web_page_url_text_view.setText(url.toString());
			} 
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		else {
			
			Button sendButton = (Button) findViewById(R.id.send_button);
	        final EditText messageEditText = (EditText) findViewById(R.id.message_edit_text);
	        sendButton.setOnClickListener(new OnClickListener() {	
				@Override
				public void onClick(View v) {
					Intent messageIntent = new Intent(Intents.this, ShowMessage.class);
					messageIntent.putExtra("message", messageEditText.getText().toString());
					startActivity(messageIntent);
				}
			});
	        
	        Button visitWebPageButton = (Button) findViewById(R.id.visit_web_page_button);
	        visitWebPageButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String url = "http://www.google.com";
			        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
			        urlIntent.setData(Uri.parse(url));
			        startActivity(urlIntent);
				}
			});
	        
		}
	}
}
