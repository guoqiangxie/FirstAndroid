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
		
        //�ҵ�Xml�ж���������б�
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        //׼��һ������������
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.colors, android.R.layout.simple_spinner_item);
        //����������ʽ
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Ϊ�����б�����������
        spinner.setAdapter(adapter);
 
        //������Ԫ��ѡ�������
        OnItemSelectedListener oisl=  new OnItemSelectedListener() { 
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                  Toast.makeText(FirstAndroid.this,"ѡ���ɫ�ʣ� " +
                  parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        //Ϊ�����б���¼�������
        spinner.setOnItemSelectedListener(oisl);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_android, menu);
		return true;
	}

}
