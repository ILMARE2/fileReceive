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
				//ֻ�ʺ�����תҳ��
//				startActivity(intent);
//				�����Ҫactivity���ش���Ľ��������ʹ��һ�·���
				//�ڶ�����������ʾ�����룬�������ָ�������
				startActivityForResult(intent, 110);
			}
		});
	}
	/**
	 * ���ڴ���activity���صĽ��
	 * requestCode��������
	 * resultCode����Ӧ��
	 * data�����ص�����
	 */
	@Override
	protected void onActivityResult(int requestCode,
			int resultCode, 
			Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//�ж��Ƿ���ȷ����
		if(resultCode==200){
//			�ж���ǰ����ֵ�����ĸ����󷵻ص�
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
