package com.neu.service;

import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.neu.dao.impl.UserInfoDaoImpl;

/**
 * ��ɲ��������� UserInfoDaoImpl ��
 * ��Ҫ��������Ķ��󣬲���ʼ�����ſ��Ե������еķ���
 * @author Administrator
 *
 */
public class UserInfoService {
	private UserInfoDaoImpl userInfoDaoImpl;
	public UserInfoService(Context context){
		userInfoDaoImpl=new UserInfoDaoImpl(context);
	}
	
	public boolean doReg(String name,String pwd){
		boolean flag=false;
		try {
			this.userInfoDaoImpl.save(name, pwd);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//���쳣��Ϣ�����¼���߷��ʼ�
		}
		return flag;
	}
	
	public List<HashMap<String, String>> findAll(){
		List<HashMap<String, String>> data=null;
		try {
			data=this.userInfoDaoImpl.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public List<HashMap<String, String>> checkLogin(
			String name,String pwd){
		List<HashMap<String, String>> data=null;
		try {
			data=this.userInfoDaoImpl.checkLogin(name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}






