package test;

import java.lang.reflect.Field;

import com.neu.entity.Student;

public class Test {
//java������Ϊ���˷�����ƣ�java���Բ�������Ϊ��̬����
//java(����������ײ�Ӳ�����������) C# C C++
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student();
		//���ҵ����õ�class�ļ���
		Class cla=stu.getClass();
//		��˵������Ը���final���εı���
		//System.out.println(cla);
//		�ٴ�class�ļ�������Ҫ�����ԣ�
//		cla.getFields():��������public���ε����ԣ�����Ϥ�������Ը���
//		cla.getDeclaredFields()��ֻ�����������������ԣ��������ַ������η�
		try {
			Field f= cla.getDeclaredField("name");
			//���÷���Ȩ��Ϊtrue
			f.setAccessible(true);
//			�ڸ������е�����
			f.set(stu, "aaaaaa");
//			Object obj=f.get(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		stu.print();
	}

}
