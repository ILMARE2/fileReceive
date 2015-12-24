package com.example.demo_12_24_sqlite_am;

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
	//����ҵ���߼��Ķ���
	private UserInfoService userInfoService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}

	private void findView() {
		// TODO Auto-generated method stub
		this.btnWrite=(Button) findViewById(R.id.button1);
		
		this.userInfoService=
				new UserInfoService(this);
	}

	private void setListener() {
		this.btnWrite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//��Դ�ڿؼ�
				String name="zhangsan";
				String sex="��";
				boolean flag=userInfoService.reg(name, sex);
				if(flag){
					Toast.makeText(MainActivity.this, "ע��ɹ�", 1000).show();
				}else{
					Toast.makeText(MainActivity.this, "ע��ʧ��", 1000).show();
				}
			}
		});
		
	}
}
