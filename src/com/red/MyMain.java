package com.red;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
 
public class MyMain extends Activity {
	
	ArrayAdapter<String> adapter;
	EditText inputSearch;
	ListView lv;
	String[] adobe_products;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main_act);
         
        // storing string resources into Array
        adobe_products = getResources().getStringArray(R.array.adobe_products);
         
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, adobe_products);
        lv.setAdapter(adapter);
 
        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
               
              // selected item
              String product = ((TextView) view).getText().toString();
               
              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getApplicationContext(), SingleListItem.class);
              // sending data to new activity
              i.putExtra("product", product);
              startActivity(i);
             
          }
        });
        
        inputSearch.addTextChangedListener(new TextWatcher() {
            
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
            	MyMain.this.adapter.getFilter().filter(cs);  
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
                 
            }
             
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                         
            }

			
        });
    }
}