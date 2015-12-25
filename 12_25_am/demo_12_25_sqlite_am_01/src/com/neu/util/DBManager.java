package com.neu.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

	private static String name="neu.db";
	private static int version=1;
	public DBManager(Context context) {
		super(context, name, null, version);
	}

	/**
	 * 在创建表的时候，需要添加以扩展列(3个)，以备将来使用
	 * 数据库的设计的三大范式（只要满足第二范式即可）
	 * powerdisiner(自己查) 数据库设计工具
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="create table user_info"
				+ "("
				+ "user_id integer primary key,"
				+ "user_name text,"
				+ "user_pwd text,"
				+ "ext_01 text,"
				+ "ext_02 text,"
				+ "ext_03 text"
				+ ")";
		db.execSQL(sql);
		sql="create table book_info"
				+ "("
				+ "book_no integer primary key,"
				+ "book_name text,"
				+ "book_price real"
				+ ")";
		db.execSQL(sql);
	}

	/**
	 * 该方法没有意义
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql="drop table  user_info";
		db.execSQL(sql);
		sql="drop table  book_info";
		db.execSQL(sql);
		onCreate(db);
	}

}
