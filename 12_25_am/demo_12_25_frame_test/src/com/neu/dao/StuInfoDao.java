package com.neu.dao;

import android.content.Context;

public class StuInfoDao extends BaseDao {

	public StuInfoDao(Context context) {
		super(context);
	}

	public void save(String name,String sex){
		String sql="insert into stu_info(stu_name,stu_sex)"
				+ " values(?,?)";
		super.executeUpdate(sql, name,sex);
	}
}
