package com.neu.entity;

public class Student {

	private String name="neu";
	
	public Student(){
		
	}
	
	public void print(){
		if(name.startsWith("neu")){
			System.out.println("你来这江湖");
		}else{
			System.out.println("请你先入江湖");
		}
	}
}
