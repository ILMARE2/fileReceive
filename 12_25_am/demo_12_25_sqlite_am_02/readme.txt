使用手册
第一步：在src下创建db.properties文件
第二步：在db.properties文件中数据格式为
dbname=你的数据库文件名
version=你的数据版本，为int类型
create_sql=要创建表的语句，如果要换行 需要在每一行后面添加 \
		   语句写完需要添加; 最后一句不需要
drop_sql=要删除表的语句

实例如下
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