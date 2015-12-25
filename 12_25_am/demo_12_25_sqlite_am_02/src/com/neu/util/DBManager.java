package com.neu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

	private static String name;
	private static int version;
	private static String create_sql;
	private static String drop_sql;
	//��̬�飬������ص�ʱ��ִ�У�ִֻ��һ��
	static{
		//������ȡ.properties�ļ��Ķ���
		Properties pro=new Properties();
		//��src����db.properties���ļ�������Ϊ������
//		�ļ���ǰ������� / ��ʾsrc�ĸ�Ŀ¼
		InputStream in=DBManager
				.class.getResourceAsStream("/db.properties");
//		������Դ�ļ�
		try {
			pro.load(in);
			//����Դ�ļ��л�ȡ����
			name=pro.getProperty("dbname");
			version=Integer.parseInt(pro.getProperty("version"));
			//��ȡ����������
			create_sql=pro.getProperty("create_sql");
			drop_sql=pro.getProperty("drop_sql");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
		execsql(db, create_sql);
	}

	private void execsql(SQLiteDatabase db, String temp) {
		String[] sqls=temp.split(";");
		if(sqls!=null){
			for(String sql:sqls){
				db.execSQL(sql);
			}
		}
	}

	/**
	 * �÷���û������
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String[] sqls=drop_sql.split(";");
		execsql(db, drop_sql);
		onCreate(db);
	}

}
