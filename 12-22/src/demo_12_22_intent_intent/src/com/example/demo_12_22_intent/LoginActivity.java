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
				//ʹ�����ݿ���֤
				//packageContext:�ӵ�ǰ��Ķ���ʼ��
//				  Class	��Ҫ��ת��Ŀ����
				Intent intent=new Intent(LoginActivity.this, 
						MainActivity.class);
				//����ͼ��װ������
				intent.putExtra("user_name", name);
				intent.putExtra("sex", "��");
				
//				��ʼ��ת
				startActivity(intent);
				
			}
		});
	}
}
