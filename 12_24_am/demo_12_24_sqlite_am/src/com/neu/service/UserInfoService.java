package com.neu.service;

import android.content.Context;

import com.neu.dao.impl.UserInfoDaoImpl;

public class UserInfoService {

	private UserInfoDaoImpl userInfoDaoImpl;
	public UserInfoService(Context context){
		userInfoDaoImpl=new UserInfoDaoImpl(context);
	}
	//模块化开发
//	
	public boolean reg(String name,String sex){
		boolean flag=false;
		try {
			this.userInfoDaoImpl.save(name, sex);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
