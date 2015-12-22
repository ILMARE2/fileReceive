package com.example.demo_12_22_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText editUserName;
	private Button btnSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findView();
		setListener();
	}
	
	private void findView() {
		//ctrl+1
		this.editUserName=(EditText) findViewById(R.id.login_edit_user_name);
		this.btnSubmit=(Button) findViewById(R.id.login_btn_submit);
	}
	private void setListener() {
		this.btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name=editUserName.getText().toString();
				//使用数据库验证
				//packageContext:从当前类的对象开始跳
//				  Class	：要跳转的目标类
				Intent intent=new Intent(LoginActivity.this, 
						MainActivity.class);
				//向意图中装载数据
				intent.putExtra("user_name", name);
				intent.putExtra("sex", "男");
				
//				开始跳转
				startActivity(intent);
				
			}
		});
	}
}
