ʹ���ֲ�
��һ������src�´���db.properties�ļ�
�ڶ�������db.properties�ļ������ݸ�ʽΪ
dbname=������ݿ��ļ���
version=������ݰ汾��Ϊint����
create_sql=Ҫ���������䣬���Ҫ���� ��Ҫ��ÿһ�к������ \
		   ���д����Ҫ���; ���һ�䲻��Ҫ
drop_sql=Ҫɾ��������

ʵ������
================================
dbname=neu.db
version=1
create_sql=create table user_info(\
			user_id integer pimary key,\
			user_name text,\
			user_pwd text,\
			ext_01 text,\
			ext_02 t\
			);\
			create table book_info(\
			book_id integer primary key,\
			book_name text\
			)
drop_sql=drop table user_info;drop table book_info	