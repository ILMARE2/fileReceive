package com.neu.entity;

public class Student {

	private String name="neu";
	
	public Student(){
		
	}
	
	public void print(){
		if(name.startsWith("neu")){
			System.out.println("�����⽭��");
		}else{
			System.out.println("�������뽭��");
		}
	}
}
