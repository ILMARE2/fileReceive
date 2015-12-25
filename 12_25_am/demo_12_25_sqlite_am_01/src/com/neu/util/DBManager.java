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
	 * �ڴ������ʱ����Ҫ�������չ��(3��)���Ա�����ʹ��
	 * ���ݿ����Ƶ�����ʽ��ֻҪ����ڶ���ʽ���ɣ�
	 * powerdisiner(�Լ���) ���ݿ���ƹ���
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
	 * �÷���û������
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
