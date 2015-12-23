package com.example.demo_12_22_pm_alert;

import java.lang.reflect.Field;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}
	private void findView() {
		this.imageView=(ImageView) findViewById(R.id.imageView1);
		
	}
	private void setListener() {
		this.imageView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//����xml�ļ�������
				LayoutInflater inflater=
						LayoutInflater.from(MainActivity.this);
				//�Ѳ����ļ�����Ϊ��ͼ
				View view=inflater.inflate(R.layout.login, null);
//				������Ҫ�Ŀؼ�
				final EditText edItLoginName=(EditText) view
						.findViewById(R.id.login_edit_loginname);
				
				AlertDialog.Builder alert=
						new AlertDialog.Builder(MainActivity.this);
				alert.setTitle("���¼");
				alert.setCancelable(false);
				alert.setView(view);
				alert.setPositiveButton("��¼", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String name=edItLoginName.getText().toString();
						edItLoginName.setError("��ʽ����");
						setShowing(dialog,false);
						System.out.println("========="+name);
						
					}
				});
				alert.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						setShowing(dialog, true);
					}
				});
				alert.show();
				
			}
		});
		
	}
	private void setShowing(DialogInterface dialog,boolean flag){
		try {
			Field f=dialog.getClass()
					.getSuperclass().getDeclaredField("mShowing");
			f.setAccessible(true);
			f.set(dialog, flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
