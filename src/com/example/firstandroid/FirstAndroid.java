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

    //准备公用属性
    private TextView dateDisplay;
    private Button pickDate;
    private int mYear;
    private int mMonth;
    private int mDay;
    
    //准备对话框Id
    static final int DATE_DIALOG_ID = 0;
    
    //准备日期设置监听器
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


    //重写创建对话框方法
    @Override
    protected Dialog onCreateDialog(int id){
        switch(id){
        case DATE_DIALOG_ID:
            //把Activity上下文、日期设置监听器、以及日期的年月日都作为参数传给那个新成立的对话框组件
            return new DatePickerDialog(this, dsl, mYear, mMonth, mDay);
        }
        return null;
    }



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
        
      //定义数组
	    String[] provinces = getResources().getStringArray(R.array.provinces);
	    //定义数组适配器
	    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,provinces);
	    //找到自动完成组件
	    AutoCompleteTextView atv = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView01);
	    //为其设置适配器
	    atv.setAdapter(adapter1);


	    
	    //得到当前日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        //获取xml中的组件
        dateDisplay= (TextView)findViewById(R.id.dateDisplay);
        pickDate = (Button)findViewById(R.id.pickDate);
        //给日期显示组件一个初始值
        dateDisplay.setText(mYear+"-"+(mMonth+1)+"-"+mDay);
        //给按钮绑定点击监听器
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
