package com.example.demo_12_23_read_file;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ListActivity extends Activity {

	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
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
				Intent intent=new Intent(ListActivity.this,
							MainActivity.class);
				//传递要显示文件名称和路径
				intent.putExtra("file", "/hello/demo.txt");
				startActivity(intent);
			}
		});
	}
}
