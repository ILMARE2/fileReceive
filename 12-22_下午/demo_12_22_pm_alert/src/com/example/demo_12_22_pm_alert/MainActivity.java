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
				//创建xml文件解析器
				LayoutInflater inflater=
						LayoutInflater.from(MainActivity.this);
				//把布局文件解析为视图
				View view=inflater.inflate(R.layout.login, null);
//				查找需要的控件
				final EditText edItLoginName=(EditText) view
						.findViewById(R.id.login_edit_loginname);
				
				AlertDialog.Builder alert=
						new AlertDialog.Builder(MainActivity.this);
				alert.setTitle("请登录");
				alert.setCancelable(false);
				alert.setView(view);
				alert.setPositiveButton("登录", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String name=edItLoginName.getText().toString();
						edItLoginName.setError("格式有误！");
						setShowing(dialog,false);
						System.out.println("========="+name);
						
					}
				});
				alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
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
