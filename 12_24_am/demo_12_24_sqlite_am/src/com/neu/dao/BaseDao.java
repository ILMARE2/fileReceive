package com.neu.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.neu.util.DBManager;

/**
 * 操作数据库的父类
 * 封装了insert，delete，update，select的相关操作
 * 只负责执行，不负责sql语句的编写
 * sql在子类中编写
 *
 */
public class BaseDao {
	//获取数据库管理类的对象
	private DBManager manager;
//	操作sql语句对象
	private SQLiteDatabase db;
	
	public BaseDao(Context context){
		//构建管理类对象，需要传递上下文参数
		manager=new DBManager(context);
	}
	/**
	 * 
	 * @param sql:要执行sql语句
	 * @param args:sql语句中的参数，
	 * 如果sql语句中没有参数，不用提供
	 */
	protected final void insert(String sql,String...args){
		//获取可以读写的方式打开数据库连接
		db=manager.getWritableDatabase();
		//执行sql语句
		db.execSQL(sql, args);
		//关系连接
		db.close();
	}
	
	protected final void update(String sql,String...args){
		db=manager.getWritableDatabase();
		//执行sql语句
		db.execSQL(sql, args);
		//关系连接
		db.close();
	}
	
	protected final void delete(String sql,String...args){
		db=manager.getWritableDatabase();
		//执行sql语句
		db.execSQL(sql, args);
		//关系连接
		db.close();
	}
	
	
}




