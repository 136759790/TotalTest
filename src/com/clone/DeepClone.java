package com.clone;

import com.clone.DeepClone.Address.Student;

public class DeepClone {
	public static void main(String[] args) {
		Address addr=new Address();
		addr.setAdd("杭州市...");
		Student stu1=new Student();
		stu1.setNumber(123);
		stu1.setAddr(addr);
		
		Student stu2=(Student) stu1.clone();
		
		System.out.println("学生1： "+stu1.getNumber()+"，地址 "+stu1.getAddr().getAdd());
		System.out.println("学生1： "+stu2.getNumber()+"，地址 "+stu2.getAddr().getAdd());
	
		addr.setAdd("西湖区");
		
		System.out.println("学生1： "+stu1.getNumber()+"，地址 "+stu1.getAddr().getAdd());
		System.out.println("学生1： "+stu2.getNumber()+"，地址 "+stu2.getAddr().getAdd());
	
	}
	static class Address implements Cloneable{
		private String add;

		public String getAdd() {
			return add;
		}

		public void setAdd(String add) {
			this.add = add;
		}
		public Object clone(){
			Address addr=null;
			try {
				addr=(Address) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return addr;
		}
		static class Student implements Cloneable{
			private int number;
			private Address addr;
			public int getNumber() {
				return number;
			}
			public void setNumber(int number) {
				this.number = number;
			}
			public Address getAddr() {
				return addr;
			}
			public void setAddr(Address addr) {
				this.addr = addr;
			}
			
			public Object clone(){
				Student stu=null;
				try {
					stu=(Student) super.clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				stu.addr=(Address) addr.clone();
				return stu;
			}
		}
	}
}
