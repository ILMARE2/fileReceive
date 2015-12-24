package com.neu.dao.impl;

import android.content.Context;

import com.neu.dao.BaseDao;

public class UserInfoDaoImpl extends BaseDao {

	public UserInfoDaoImpl(Context context) {
		super(context);
	}

	public void save(String name,String sex){
		//�ڲ������ݿ��ʱ�����ָ������������һ��
//		�ڲ�ѯ��ʱ������ʹ��*
		String sql="insert into user_info(user_name,user_sex) "
				+ "values(?,?)";
		super.insert(sql, name,sex);
	}
	
	public void delete(String id){
		String sql="delete from user_info "
				+ "where user_id="+id;
		//��Ϊsql�����û�� ? ռλ��������Ҫ�ṩ����
		super.delete(sql);
	}
	
	public void update(String name,String sex,String id){
		String sql="update user_info set "
				+ "user_name=?,user_sex=? "
				+ "where user_id=?";
		super.update(sql, name,sex,id);
	}
}
