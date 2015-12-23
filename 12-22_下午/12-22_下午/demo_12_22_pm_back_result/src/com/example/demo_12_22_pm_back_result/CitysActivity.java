package com.example.demo_12_22_pm_back_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CitysActivity extends Activity implements OnClickListener {
	private TextView textQingDao;
	private TextView textYanTai;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_citys);
		findView();
		setListener();
	}

	private void findView() {
		this.textQingDao=(TextView) findViewById(R.id.city_text_qingdao);
		this.textYanTai=
				(TextView) findViewById(R.id.city_text_yantai);
	}

	private void setListener() {
		this.textQingDao.setOnClickListener(this);
		this.textYanTai.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String city="";
		switch (v.getId()) {
		case R.id.city_text_qingdao:
			city="青岛";
			break;
		case R.id.city_text_yantai:
			city="烟台";
			break;
		default:
			break;
		}
		//Toast.makeText(this, city, 1000).show();
		//实现返回值得操作
//		resultCode:用于判断是否正确返回
//		data :用于封装返回的数据
//		setResult(resultCode, data);
		//不需要指定目标
		Intent data=new Intent();
		data.putExtra("city", city);
		setResult(200, data);
		//把自己关闭
		finish();
	}
}
