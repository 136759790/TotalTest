package com.clone;

public class CloneClass  {
	public static void main(String[] args) {
		
		Address addr=new Address();
		addr.setAdd("杭州市...");
		
		Student stu1=new Student();
		stu1.setNumber(12345);
		stu1.setAddress(addr);
		Student stu2=(Student) stu1.clone();
		
		System.out.println("学生1： "+stu1.getNumber()+"，地址是： "+stu1.getAddress().getAdd());
		System.out.println("学生2： "+stu2.getNumber()+"，地址是： "+stu2.getAddress().getAdd());

		stu2.setNumber(54321);
		System.out.println("学生1： "+stu1.getNumber());
		System.out.println("学生2： "+stu2.getNumber());
		System.out.println(stu1==stu2);
	}
	static class Address{
		private String add;

		public String getAdd() {
			return add;
		}

		public void setAdd(String add) {
			this.add = add;
		}
		
	}
	static class Student implements Cloneable {
		private int number;
		
		private Address address;
		
		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
		public Object clone(){
			Student stu=null;
			try {
				stu=(Student) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return stu;
		}
}

}
