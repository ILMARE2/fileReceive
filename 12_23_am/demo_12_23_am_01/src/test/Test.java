package test;

import java.lang.reflect.Field;

import com.neu.entity.Student;

public class Test {
//java中正因为有了反射机制，java语言才真正成为动态语言
//java(不允许操作底层硬件，提出反射) C# C C++
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student();
		//先找到你用的class文件，
		Class cla=stu.getClass();
//		据说反射可以更改final修饰的变量
		//System.out.println(cla);
//		再从class文件中找需要的属性，
//		cla.getFields():查找所有public修饰的属性，该熟悉可以来自父类
//		cla.getDeclaredFields()：只查找自身声明的属性，不管哪种访问修饰符
		try {
			Field f= cla.getDeclaredField("name");
			//设置访问权限为true
			f.setAccessible(true);
//			在更改其中的数据
			f.set(stu, "aaaaaa");
//			Object obj=f.get(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		stu.print();
	}

}
