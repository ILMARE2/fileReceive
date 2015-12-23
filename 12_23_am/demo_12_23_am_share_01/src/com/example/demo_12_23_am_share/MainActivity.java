package com.example.demo_12_23_am_share;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textMsg;
	private Button btnWrite;
	private Button btnRead;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}

	private void findView() {
		this.textMsg=(TextView) findViewById(R.id.textView1);
		this.btnRead=(Button) findViewById(R.id.button2);
		this.btnWrite=(Button) findViewById(R.id.button1);
		
	}

	private void setListener() {
		this.btnWrite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sp=
						getSharedPreferences("neu", MODE_PRIVATE);
				SharedPreferences.Editor edit=
						sp.edit();
				edit.putString("login_name", "ÀîÐ¡¾ü");
				edit.putInt("age", 20);
				edit.commit();
			}
		});
		this.btnRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sp=
						getSharedPreferences("neu", MODE_PRIVATE);
				String login_name=
						sp.getString("login_name", null);
				int age=sp.getInt("age", -1);
				textMsg.setText(String.valueOf(age)+":"+login_name);
			}
		});
	}
}
