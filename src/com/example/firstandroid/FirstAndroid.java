package com.example.firstandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;


public class FirstAndroid extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_android);
		
        //找到Xml中定义的下拉列表
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        //准备一个数组适配器
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.colors, android.R.layout.simple_spinner_item);
        //设置下拉样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //为下拉列表设置适配器
        spinner.setAdapter(adapter);
 
        //定义子元素选择监听器
        OnItemSelectedListener oisl=  new OnItemSelectedListener() { 
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                  Toast.makeText(FirstAndroid.this,"选择的色彩： " +
                  parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        //为下拉列表绑定事件监听器
        spinner.setOnItemSelectedListener(oisl);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_android, menu);
		return true;
	}

}
