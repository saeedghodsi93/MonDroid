package com.test.saeed;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowMessage extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_message);
		
		TextView messageTextView = (TextView) findViewById(R.id.message_text_view);
        messageTextView.setText(getIntent().getExtras().getString("message"));
 
	}

}
