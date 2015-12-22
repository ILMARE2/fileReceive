package com.example.demo_12_22_intent;

import com.neu.util.DataUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textMsg;
	private Button btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}
	private void findView() {
		this.btnBack=(Button) findViewById(R.id.main_btn_back);
		//����ע�⣺ʹ�õ�id�Ƿ��ڵ�ǰ�Ĳ����ļ���
		this.textMsg=(TextView) findViewById(R.id.main_text_msg);
//		ҳ����أ���ʾ���ݵ�����
		String msg=DataUtil.map.get("username");
		this.textMsg.setText(msg);
	}
	private void setListener() {
		this.btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
}
