package com.example.demo_12_25_sqlite_am_01;

import java.util.HashMap;
import java.util.List;

import com.neu.service.UserInfoService;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnWrite;
	private Button btnRead;
	private UserInfoService userInfoService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}
	private void findView() {
		this.btnWrite=(Button) findViewById(R.id.button1);
		this.btnRead=(Button) findViewById(R.id.button2);
		
		this.userInfoService=new UserInfoService(this);
	}
//	操作sqlite数据，sql语句编写问题
	private void setListener() {
		this.btnWrite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name="zhangsan";
				String pwd="123456";
				boolean flag=userInfoService.doReg(name, pwd);
				if(flag){
					Toast.makeText(MainActivity.this, "注册成功", 1000)
						.show();
				}else{
					Toast.makeText(MainActivity.this, "注册失败", 1000)
						.show();
				}
			}
		});
		this.btnRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name="zhangsan";
				String pwd="123456";
				List<HashMap<String, String>> data=
						userInfoService.findAll();
				if(data==null){
					Toast.makeText(MainActivity.this, "没有数据显示", 1000)
					.show();
				}else{
					System.out.println("======"+data);
				}
			}
		});
		
	}
}
