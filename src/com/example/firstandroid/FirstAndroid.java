package com.example.firstandroid;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class FirstAndroid extends Activity {

    //׼����������
    private TextView dateDisplay;
    private Button pickDate;
    private int mYear;
    private int mMonth;
    private int mDay;
    
    //׼���Ի���Id
    static final int DATE_DIALOG_ID = 0;
    
    //׼���������ü�����
    private OnDateSetListener dsl = new DatePickerDialog.OnDateSetListener(){
    	@Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            mYear =year;
            mMonth= monthOfYear;
            mDay= dayOfMonth;
            dateDisplay.setText(mYear+"-"+(mMonth+1)+"-"+mDay);
        }
    };


    //��д�����Ի��򷽷�
    @Override
    protected Dialog onCreateDialog(int id){
        switch(id){
        case DATE_DIALOG_ID:
            //��Activity�����ġ��������ü��������Լ����ڵ������ն���Ϊ���������Ǹ��³����ĶԻ������
            return new DatePickerDialog(this, dsl, mYear, mMonth, mDay);
        }
        return null;
    }



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
        
      //��������
	    String[] provinces = getResources().getStringArray(R.array.provinces);
	    //��������������
	    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,provinces);
	    //�ҵ��Զ�������
	    AutoCompleteTextView atv = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView01);
	    //Ϊ������������
	    atv.setAdapter(adapter1);


	    
	    //�õ���ǰ����
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        //��ȡxml�е����
        dateDisplay= (TextView)findViewById(R.id.dateDisplay);
        pickDate = (Button)findViewById(R.id.pickDate);
        //��������ʾ���һ����ʼֵ
        dateDisplay.setText(mYear+"-"+(mMonth+1)+"-"+mDay);
        //����ť�󶨵��������
        pickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_android, menu);
		return true;
	}

}
