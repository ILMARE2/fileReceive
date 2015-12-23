package com.example.demo_12_23_read_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textContent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}
	private void findView() {
		this.textContent=(TextView) findViewById(R.id.main_text_content);
		Intent intent=getIntent();
		String path=intent.getStringExtra("file");
		if(Environment.MEDIA_MOUNTED
				.equals(Environment.getExternalStorageState())){
			File sdcard=
					Environment.getExternalStorageDirectory();
			File file=new File(sdcard,path);
			if(file.exists()){
				try {
					FileInputStream fis=new FileInputStream(file);
					byte[] b=new byte[fis.available()];
					int len=fis.read(b);
					fis.close();
					String content=new String(b,"GBK");
					textContent.setText(content);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				Toast.makeText(this, "你读取的文件不存在", 1000).show();
			}
		}else{
			Toast.makeText(this, "sdcard不可用", 1000).show();
		}
	}
	private void setListener() {
		// TODO Auto-generated method stub
		
	}
}
