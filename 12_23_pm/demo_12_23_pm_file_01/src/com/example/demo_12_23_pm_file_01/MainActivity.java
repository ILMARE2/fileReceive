package com.example.demo_12_23_pm_file_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 操作手机内部存储的文件
 * @author Administrator
 *
 */
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
		this.btnWrite=(Button) findViewById(R.id.button1);
		this.btnRead=(Button) findViewById(R.id.button2);
	}
	private void setListener() {
		this.btnWrite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//MODE_APPEND:实现追加模式
				try {
//					已追加的方式，打开文件
					FileOutputStream fos=
							openFileOutput("neu.txt", MODE_APPEND);
					String msg="圣诞快乐吗?快乐是不可能";
					fos.write(msg.getBytes());
					//if(读取了200M){
//						fos.flush();
					//}
					fos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		this.btnRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					FileInputStream fis=
							openFileInput("neu.txt");
					//根据读取文件的字节数，构建容器
					byte[] b=new byte[fis.available()];
					//返回值为读取数据的真实个数
					int len=fis.read(b);
					fis.close();
					String msg=new String(b);
					textMsg.setText(msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	}
}
