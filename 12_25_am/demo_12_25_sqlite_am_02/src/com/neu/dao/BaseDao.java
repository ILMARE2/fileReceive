package com.neu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.neu.util.DBManager;

/**
 * �����еķ���ֻ��Ҫ�������з��ʣ�ͨ��������protected����
 * �����еķ��� ���ܱ�������д��ͨ��ʹ��final����
 * @author Administrator
 *
 */
public class BaseDao {

	private DBManager manager;
	private SQLiteDatabase db;
	/**
	 * 
	 * @param context:��Ϊ ����DBManager������Ҫ�ò���
	 */
	public BaseDao(Context context){
//		context.getPackageName()//��ȡapp����İ���
		manager=new DBManager(context);
	}
//	���ݿ�Ĳ�����ΪCRUD����Ϊ������
//	�޸Ĳ�����insert��delete��update
//	��ѯ������select
	/**
	 * ����ִ���޸Ĳ����ķ���
	 * insert into user_info values(?,?)
	 */
	protected final void executeUpdate(String sql,Object...args){
		db=manager.getWritableDatabase();
		db.execSQL(sql, args);
		db.close();
	}
	
	/**
	 * �û�ִ�и��ֲ�ѯ
	 */
	protected final List<HashMap<String, String>> executeQuery(
				String sql,	String...args){
		List<HashMap<String, String>> data=
				new ArrayList<HashMap<String,String>>();
		db=manager.getReadableDatabase();
		//����ֵΪ�α꣬��ʵ����resultSet
		Cursor cur= db.rawQuery(sql, args);
		//��ȡ��ѯ����������
		String[] names=cur.getColumnNames();
		//��ȡ��ѯ������
//		int n= cur.getColumnCount();
//		��ȡ��ѯ�ļ�¼������
//		int n=cur.getCount();
		//�û�����ÿһ���е�����
//		�洢��ʽ��������Ϊkey������ Ϊvalue
		HashMap<String, String> item=null;
//		moveToNext() �ƶ�����һ��������з���true
		while(cur.moveToNext()){
			//��ȡ����
			item=new HashMap<String, String>();
			for(String name:names){
//				����������ȡ���У����ڵ��±�
//				�ڸ����±��ȡ��Ӧ������
				String value=cur.getString(cur.getColumnIndex(name));
//				��������
				item.put(name, value);
			}
			//�����������
			data.add(item);
		}
		cur.close();
		db.close();
		return data;
	}
}




