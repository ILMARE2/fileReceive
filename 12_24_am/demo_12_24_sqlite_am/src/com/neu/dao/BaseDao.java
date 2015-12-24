package com.neu.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.neu.util.DBManager;

/**
 * �������ݿ�ĸ���
 * ��װ��insert��delete��update��select����ز���
 * ֻ����ִ�У�������sql���ı�д
 * sql�������б�д
 *
 */
public class BaseDao {
	//��ȡ���ݿ������Ķ���
	private DBManager manager;
//	����sql������
	private SQLiteDatabase db;
	
	public BaseDao(Context context){
		//���������������Ҫ���������Ĳ���
		manager=new DBManager(context);
	}
	/**
	 * 
	 * @param sql:Ҫִ��sql���
	 * @param args:sql����еĲ�����
	 * ���sql�����û�в����������ṩ
	 */
	protected final void insert(String sql,String...args){
		//��ȡ���Զ�д�ķ�ʽ�����ݿ�����
		db=manager.getWritableDatabase();
		//ִ��sql���
		db.execSQL(sql, args);
		//��ϵ����
		db.close();
	}
	
	protected final void update(String sql,String...args){
		db=manager.getWritableDatabase();
		//ִ��sql���
		db.execSQL(sql, args);
		//��ϵ����
		db.close();
	}
	
	protected final void delete(String sql,String...args){
		db=manager.getWritableDatabase();
		//ִ��sql���
		db.execSQL(sql, args);
		//��ϵ����
		db.close();
	}
	
	
}




