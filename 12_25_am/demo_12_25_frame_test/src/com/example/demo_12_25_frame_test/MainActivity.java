package com.example.demo_12_25_frame_test;

import com.neu.service.StuInfoService;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private StuInfoService stuInfoService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.stuInfoService=new StuInfoService(this);
		boolean flag=stuInfoService.doReg("zhangsan", "ÄÐ");
		if(flag){
			System.out.println("=================");
		}else{
			System.out.println("====eeeeeeeeeeeeeeeeee");
		}
	}
}
