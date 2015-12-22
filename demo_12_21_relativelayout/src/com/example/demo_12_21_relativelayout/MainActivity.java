package com.example.demo_12_21_relativelayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textType;
	private String[] types={"男的","女的"};
	//......
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setListener();
	}
	private void setListener() {
		// TODO Auto-generated method stub
		this.textType.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alert=
						new AlertDialog.Builder(MainActivity.this);
				alert.setTitle("选择类型");
				alert.setItems(types, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						textType.setText(types[which]);
					}
				});
				alert.setNegativeButton("取消", null);
				alert.show();
			}
		});
	}
	private void findView() {
		this.textType=(TextView) findViewById(R.id.main_text_type);
		
	}
}
