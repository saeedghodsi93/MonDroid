package com.test.saeed;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        class SaeedArrayAdaptor extends ArrayAdapter<String> {
        	
        	public SaeedArrayAdaptor(Context context, int resource, int textViewResourceId, String[] objects) {
        		super(context, resource, textViewResourceId, objects);
        	}
        	
        	@Override
        	public View getView(int position, View convertView, ViewGroup parent) {
        		LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        		View view = inflator.inflate(R.layout.list_item, parent, false);
        		
        		String[] strings = getResources().getStringArray(R.array.functions);   
        		
        		TextView textView = (TextView) view.findViewById(R.id.functions_text_view);
        		textView.setText(strings[position]);
        		
        		ImageView imageView = (ImageView) view.findViewById(R.id.functions_image_view);
        		if(strings[position].equals("Intents")) {
        			imageView.setImageResource(R.drawable.i_icon);
        		}
        		else if(strings[position].equals("Permissions")) {
        			imageView.setImageResource(R.drawable.p_icon);
        		}
        		else if(strings[position].equals("Animation")) {
        			imageView.setImageResource(R.drawable.a_icon);
        		}
        		
        		
        		return view;
        	}
        	
        }

        setListAdapter(new SaeedArrayAdaptor(this, android.R.layout.simple_list_item_1, R.id.functions_text_view, getResources().getStringArray(R.array.functions)));
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
      
    	String[] strings = getResources().getStringArray(R.array.functions);  
    	
    	if(strings[position].equals("Intents")) {
    		Intent intentsIntent = new Intent(MainActivity.this, Intents.class);
    		startActivity(intentsIntent);
		}
		else if(strings[position].equals("Permissions")) {
			Intent permissionsIntent = new Intent(MainActivity.this, Permissions.class);
			startActivity(permissionsIntent);
		}
		else if(strings[position].equals("Animation")) {
			Intent animationIntent = new Intent(MainActivity.this, Animation.class);
			startActivity(animationIntent);
		}
		
      super.onListItemClick(l, v, position, id);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater menuInflater = getMenuInflater();
    	menuInflater.inflate(R.menu.options_menu, menu);
    	
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getItemId() == R.id.setting) {
    		Intent settingIntent = new Intent(MainActivity.this, Setting.class);
    		startActivity(settingIntent);
    	}
    	else if(item.getItemId() == R.id.about) {
    		Intent aboutIntent = new Intent(MainActivity.this, About.class);
    		startActivity(aboutIntent);
    	}
    	return super.onOptionsItemSelected(item);
    }
}