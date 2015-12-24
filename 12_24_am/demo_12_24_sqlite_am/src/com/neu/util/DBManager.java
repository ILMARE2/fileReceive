package com.neu.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 
 * ���ڹ������ݿ�
 * <p>�������ݿ��ļ��Ĵ���</p>
 * <p>�������ݿ��б�Ĵ����ͱ�ṹ���޸�</p>
 *
 */
public class DBManager extends SQLiteOpenHelper {

	//���ݿ��ļ�������û�к�׺������
	private static final String name="neu.db";
//	��ʾ���ݵİ汾�ţ������1 ��Ϊ 2 ��ʾ���ݿ�������
//	ϵͳ���Զ�ɾ����������
	private static final int version=1;
	/**
	 * 
	 * @param context	:��ǰ���������ݿ��ļ������λ��
	 * @param name		:��ʾ�������ݿ��ļ�������
	 * @param factory	:��ѯ�õ��Ľ����α���,null��ʾĬ�Ϸ�ʽ����
	 * @param version	:��ʾ���ݿ�İ汾��
	 */
	public DBManager(Context context) {
		super(context, name, null, version);
	}

	/**
	 * �������ݱ�Ĵ���
	 * �Ѵ������ݱ��sql��䶼д�ڸ÷�����
	 * ϰ���ϣ�sql�ؼ��� ��д
	 * ctrl+shift +x :��Ϊ��д
	 * ctrl+shift +y :��ΪСд
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="CREATE TABLE user_info("
				+ "user_id integer primary key,"
				+ "user_name text,"
				+ "user_sex text)";//sql���������ܼӷֺ�
		//ִ��sql���
		db.execSQL(sql);
//		�����������Ļ������ϴ�������һ��
		
	}

	/**
	 * ������±�ṹ��version��ֵ�ı䣬�÷����Զ�ִ��
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		��ɾ����,��oncreate�����д����ı���Ҫɾ��
		String sql="drop table if exists user_info";
		db.execSQL(sql);
//		�ڴ�����,��oncreate�����и���sql���
		onCreate(db);
	}

}
