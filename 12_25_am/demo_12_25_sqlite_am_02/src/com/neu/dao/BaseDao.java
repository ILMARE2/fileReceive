package com.neu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.neu.util.DBManager;

/**
 * 该类中的方法只需要在子类中访问，通常都是用protected修饰
 * 该类中的方法 不能被子类重写，通常使用final修饰
 * @author Administrator
 *
 */
public class BaseDao {

	private DBManager manager;
	private SQLiteDatabase db;
	/**
	 * 
	 * @param context:因为 构建DBManager对象需要该参数
	 */
	public BaseDao(Context context){
//		context.getPackageName()//获取app程序的包名
		manager=new DBManager(context);
	}
//	数据库的操作分为CRUD：分为两大类
//	修改操作：insert、delete、update
//	查询操作：select
	/**
	 * 用于执行修改操作的方法
	 * insert into user_info values(?,?)
	 */
	protected final void executeUpdate(String sql,Object...args){
		db=manager.getWritableDatabase();
		db.execSQL(sql, args);
		db.close();
	}
	
	/**
	 * 用户执行各种查询
	 */
	protected final List<HashMap<String, String>> executeQuery(
				String sql,	String...args){
		List<HashMap<String, String>> data=
				new ArrayList<HashMap<String,String>>();
		db=manager.getReadableDatabase();
		//返回值为游标，其实就是resultSet
		Cursor cur= db.rawQuery(sql, args);
		//获取查询的所有列名
		String[] names=cur.getColumnNames();
		//获取查询的列数
//		int n= cur.getColumnCount();
//		获取查询的记录总条数
//		int n=cur.getCount();
		//用户保存每一行中的数据
//		存储方式，以列名为key，数据 为value
		HashMap<String, String> item=null;
//		moveToNext() 移动到下一条，如果有返回true
		while(cur.moveToNext()){
			//获取数据
			item=new HashMap<String, String>();
			for(String name:names){
//				根据列名获取该列，所在的下标
//				在根据下标获取对应的数据
				String value=cur.getString(cur.getColumnIndex(name));
//				保存数据
				item.put(name, value);
			}
			//保存改行数据
			data.add(item);
		}
		cur.close();
		db.close();
		return data;
	}
}




