package com.neu.dao.impl;

import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.neu.dao.BaseDao;
/**
 * 编写sql语句,尽量使用预编译的格式
 * 在操作表的时候，必须指明操作的具体列
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
		//不允许使用  * 号
		String sql="select user_id,user_name,"
				+ " user_pwd from user_info";
		List<HashMap<String, String>> data=
				super.executeQuery(sql);
		return data;
	}
	
	public List<HashMap<String, String>> checkLogin(
			String name,String pwd){
		//编写sql语句，换行 就加空格
		String sql="select user_id,user_name,user_pwd from user_info"
				+ " where user_name=? and user_pwd=?";
		return super.executeQuery(sql, name,pwd);
	}
	
	
	
	

}
