package com.nt.beans;

public class Student {

	private int sno;
	private String sname;
	private String course;
	private double fee;

	public Student(int sno, String sname, String course, double fee) {
		System.out.println("Student : 4-param constructor");
		this.sno = sno;
		this.sname = sname;
		this.course = course;
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", course=" + course + ", fee=" + fee + "]";
	}

}// class
