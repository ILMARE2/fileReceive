package com.neu.service;

import android.content.Context;

import com.neu.dao.StuInfoDao;

public class StuInfoService {

	private StuInfoDao stuInfoDao;
	public StuInfoService(Context context){
		stuInfoDao=new StuInfoDao(context);
	}
	public boolean doReg(String name,String sex){
		boolean flag=false;
		try {
			this.stuInfoDao.save(name, sex);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
