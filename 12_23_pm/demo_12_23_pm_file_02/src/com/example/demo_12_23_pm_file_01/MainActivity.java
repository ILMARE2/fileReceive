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
				//判断sdcard是否存在
				if(Environment.MEDIA_MOUNTED
						.equals(Environment.getExternalStorageState())){
					//说明sdcard存在
//					获取sdcard的目录
					File sdcard=Environment.getExternalStorageDirectory();
					//textMsg.setText(sdcard.getPath());
//					以时间为文件夹的名
//					2015-12-23
					Date date=new Date();
					//通过java中的格式化工具，提取数据
					SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
					String pathname=f.format(date);
					File path=new File(sdcard,pathname);
					if(!path.exists()){
						path.mkdir();//只创建一级目录
//						path.mkdirs();//相关层次一起创建
					}
					//构建一个文件
					File file=new File(path,"test.txt");
					try {
						FileOutputStream fos=
								new FileOutputStream(file,true);
						String msg="明天考试！！！！";
						fos.write(msg.getBytes());
						fos.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					//sdcard不可用
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
