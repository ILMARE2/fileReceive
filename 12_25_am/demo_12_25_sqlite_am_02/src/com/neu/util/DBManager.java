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
	//静态块，在类加载的时候执行，只执行一次
	static{
		//创建读取.properties文件的对象
		Properties pro=new Properties();
		//把src下名db.properties的文件，构建为输入流
//		文件名前必须添加 / 表示src的根目录
		InputStream in=DBManager
				.class.getResourceAsStream("/db.properties");
//		加载资源文件
		try {
			pro.load(in);
			//从资源文件中获取数据
			name=pro.getProperty("dbname");
			version=Integer.parseInt(pro.getProperty("version"));
			//获取创建表的语句
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
	 * 在创建表的时候，需要添加以扩展列(3个)，以备将来使用
	 * 数据库的设计的三大范式（只要满足第二范式即可）
	 * powerdisiner(自己查) 数据库设计工具
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
	 * 该方法没有意义
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String[] sqls=drop_sql.split(";");
		execsql(db, drop_sql);
		onCreate(db);
	}

}
