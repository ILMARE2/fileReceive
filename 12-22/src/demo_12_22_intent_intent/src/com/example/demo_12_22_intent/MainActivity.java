package com.example.demo_12_22_intent;

import android.app.Activity;
import android.content.Intent;
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
		this.textMsg=(TextView) findViewById(R.id.main_text_msg);
//		获取对方传递的意图,只有在对方传递数据才使用
		Intent intent=getIntent();
		//从意图中获取指定key对应的数据，必须注意数据类型
		String msg=intent.getStringExtra("user_name");
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
