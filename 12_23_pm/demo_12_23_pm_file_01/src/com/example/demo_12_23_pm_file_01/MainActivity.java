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
 * �����ֻ��ڲ��洢���ļ�
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
				//MODE_APPEND:ʵ��׷��ģʽ
				try {
//					��׷�ӵķ�ʽ�����ļ�
					FileOutputStream fos=
							openFileOutput("neu.txt", MODE_APPEND);
					String msg="ʥ��������?�����ǲ�����";
					fos.write(msg.getBytes());
					//if(��ȡ��200M){
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
					//���ݶ�ȡ�ļ����ֽ�������������
					byte[] b=new byte[fis.available()];
					//����ֵΪ��ȡ���ݵ���ʵ����
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
