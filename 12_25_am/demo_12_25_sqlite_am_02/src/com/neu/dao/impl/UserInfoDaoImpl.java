package com.neu.dao.impl;

import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.neu.dao.BaseDao;
/**
 * ��дsql���,����ʹ��Ԥ����ĸ�ʽ
 * �ڲ������ʱ�򣬱���ָ�������ľ�����
 * @author Administrator
 *
 */
public class UserInfoDaoImpl extends BaseDao {

	public UserInfoDaoImpl(Context context) {
		super(context);
	}
	public void save(String name,String pwd){
		String sql="insert into user_info(user_name,user_pwd)"
				+ "values(?,?)";
		super.executeUpdate(sql, name,pwd);
	}
	
	public List<HashMap<String, String>> findAll(){
		//������ʹ��  * ��
		String sql="select user_id,user_name,"
				+ " user_pwd from user_info";
		List<HashMap<String, String>> data=
				super.executeQuery(sql);
		return data;
	}
	
	public List<HashMap<String, String>> checkLogin(
			String name,String pwd){
		//��дsql��䣬���� �ͼӿո�
		String sql="select user_id,user_name,user_pwd from user_info"
				+ " where user_name=? and user_pwd=?";
		return super.executeQuery(sql, name,pwd);
	}
	
	
	
	

}
