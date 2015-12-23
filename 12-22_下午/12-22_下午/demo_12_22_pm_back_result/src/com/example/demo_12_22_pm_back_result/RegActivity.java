package com.example.demo_12_22_pm_back_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class RegActivity extends Activity {

	private TextView textAddresValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		findView();
		setListener();
	}

	private void findView() {
		this.textAddresValue=
				(TextView) findViewById(R.id.reg_text_address_value);
	}

	private void setListener() {
		// TODO Auto-generated method stub
		this.textAddresValue.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(RegActivity.this,
						CitysActivity.class);
				//只适合于跳转页面
//				startActivity(intent);
//				如果需要activity返回处理的结果，必须使用一下方法
				//第二个参数，表示请求码，用于区分各个请求
				startActivityForResult(intent, 110);
			}
		});
	}
	/**
	 * 用于处理activity返回的结果
	 * requestCode：请求码
	 * resultCode：响应码
	 * data：返回的数据
	 */
	@Override
	protected void onActivityResult(int requestCode,
			int resultCode, 
			Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//判断是否正确返回
		if(resultCode==200){
//			判读当前返回值，是哪个请求返回的
			switch (requestCode) {
			case 110:
				String city=data.getStringExtra("city");
				textAddresValue.setText(city);
				break;

			default:
				break;
			}
		}
	}
}
