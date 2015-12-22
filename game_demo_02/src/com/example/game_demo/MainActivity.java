package com.example.game_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
//	布局文件中的控件，都要产生对象
	private TextView textMsg;
	private ImageView[] imageViews=new ImageView[3];
	private Button btnReSet;
	private int[] images={
			R.drawable.shoe_ok,
			R.drawable.shoe_sorry,
			R.drawable.shoe_sorry
	};
	private boolean flag;//用于判断是否点击过图片
	//交换图片
	private void initImages(){
		for(int i=0;i<images.length;i++){
			int index=(int) (Math.random()*images.length);
			int temp=images[index];
			images[index]=images[i];
			images[i]=temp;
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//nullpointerException
		findView();
		setListener();
	}
	private void setListener() {
		this.btnReSet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				textMsg.setText(R.string.main_text_msg);
				for(ImageView iv:imageViews){
					iv.setImageResource(R.drawable.shoe_default);
					iv.setImageAlpha(255);
				}
				flag=false;
			}
		});
		imageViews[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				isCheck(0);
			}
		});
		imageViews[1].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				isCheck(1);
			}
		});
		imageViews[2].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				isCheck(2);
			}
		});
	}
	//学过泛型方法
	private void findView() {
		this.textMsg=(TextView) findViewById(R.id.main_text_msg);
		imageViews[0]=getViewById(R.id.main_image_01);
		imageViews[1]=getViewById(R.id.main_image_02);
		imageViews[2]=getViewById(R.id.main_image_03);
		this.btnReSet=getViewById(R.id.main_btn_reset);
	}
	//用于检测是否正确
	private void isCheck(int index){
		if(flag){
			return ;
		}
		initImages();
		//给imageView控件赋值
		for(int i=0;i<images.length;i++){
			imageViews[i].setImageResource(images[i]);
			imageViews[i].setImageAlpha(150);
		}
		imageViews[index].setImageAlpha(255);
		if(images[index]==R.drawable.shoe_ok){
			textMsg.setText("恭喜你，猜对了!!!");
		}else{
			textMsg.setText("不要灰心，下一一定猜对！");
		}
		flag=true;
	}
	
	//泛型方法，会根据接收数据的类型，自动更改T的类型
	private <T>T getViewById(int id){
		View view=findViewById(id);
		return (T) view;
	}
}
