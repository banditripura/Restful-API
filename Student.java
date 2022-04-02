package com.springbootjdbc.model;

public class Student {
	private int studentid;
   private String firstname;
        String address;
		public int getStudentid() {
			return studentid;
		}
		public void setStudentid(int studentid) {
			this.studentid = studentid;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Student(int studentid, String firstname, String address) {
			super();
			this.studentid = studentid;
			this.firstname = firstname;
			this.address = address;
		}
		public Student() {
			super();
		}
			
}       

