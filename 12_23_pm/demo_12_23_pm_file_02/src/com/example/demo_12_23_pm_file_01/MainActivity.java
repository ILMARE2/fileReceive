package com.example.demo_12_23_pm_file_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
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
				//�ж�sdcard�Ƿ����
				if(Environment.MEDIA_MOUNTED
						.equals(Environment.getExternalStorageState())){
					//˵��sdcard����
//					��ȡsdcard��Ŀ¼
					File sdcard=Environment.getExternalStorageDirectory();
					//textMsg.setText(sdcard.getPath());
//					��ʱ��Ϊ�ļ��е���
//					2015-12-23
					Date date=new Date();
					//ͨ��java�еĸ�ʽ�����ߣ���ȡ����
					SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
					String pathname=f.format(date);
					File path=new File(sdcard,pathname);
					if(!path.exists()){
						path.mkdir();//ֻ����һ��Ŀ¼
//						path.mkdirs();//��ز��һ�𴴽�
					}
					//����һ���ļ�
					File file=new File(path,"test.txt");
					try {
						FileOutputStream fos=
								new FileOutputStream(file,true);
						String msg="���쿼�ԣ�������";
						fos.write(msg.getBytes());
						fos.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					//sdcard������
				}
			}
		});
		this.btnRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(Environment.MEDIA_MOUNTED
						.equals(Environment.getExternalStorageState())){
					File sdcard=Environment.getExternalStorageDirectory();
					File file=new File(sdcard,"/2015-12-23/test.txt");
					try {
						FileInputStream fis=new FileInputStream(file);
						byte[] b=new byte[fis.available()];
						int len=fis.read(b);
						fis.close();
						String msg=new String(b);
						textMsg.setText(msg);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
	}
}
