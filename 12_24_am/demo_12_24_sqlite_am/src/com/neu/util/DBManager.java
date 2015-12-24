package com.neu.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 
 * 用于管理数据库
 * <p>负责数据库文件的创建</p>
 * <p>负责数据库中表的创建和表结构的修改</p>
 *
 */
public class DBManager extends SQLiteOpenHelper {

	//数据库文件名，有没有后缀都可以
	private static final String name="neu.db";
//	表示数据的版本号，如果由1 变为 2 表示数据库升级，
//	系统会自动删除并创建表
	private static final int version=1;
	/**
	 * 
	 * @param context	:当前创建的数据库文件保存的位置
	 * @param name		:表示创建数据库文件的名称
	 * @param factory	:查询得到的结果如何遍历,null表示默认方式遍历
	 * @param version	:表示数据库的版本号
	 */
	public DBManager(Context context) {
		super(context, name, null, version);
	}

	/**
	 * 负责数据表的创建
	 * 把创建数据表的sql语句都写在该方法中
	 * 习惯上，sql关键字 大写
	 * ctrl+shift +x :更为大写
	 * ctrl+shift +y :更为小写
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="CREATE TABLE user_info("
				+ "user_id integer primary key,"
				+ "user_name text,"
				+ "user_sex text)";//sql语句结束不能加分号
		//执行sql语句
		db.execSQL(sql);
//		如果有其他表的话，以上代码再来一遍
		
	}

	/**
	 * 负责更新表结构，version的值改变，该方法自动执行
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		先删除表,在oncreate方法中创建的表，都要删除
		String sql="drop table if exists user_info";
		db.execSQL(sql);
//		在创建表,在oncreate方法中更新sql语句
		onCreate(db);
	}

}
