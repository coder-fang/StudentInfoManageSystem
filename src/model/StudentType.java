package model;

import java.sql.Date;
/*
 * 学生表
 * */

public class StudentType {
	private int stu_id;//编号
	private String stu_num;//学号
	private String stu_name;//学生姓名
	private String stu_sex;//学生性别
	private String birth_day;//学生生日
	private int apartment_id;//学院编号
	private String apartment_name;//学院名称
	private String major_id;//专业编号
	private String major_name;//专业名称
	private String stu_class; //班级
	private String stu_passowrd;//学生密码
	private int status;//学生状态（默认1，为学籍在校，0为学籍不在校）
	
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public 	String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stuSex) {
		this.stu_sex = stuSex;
	}
	public String getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(String studentBirthday) {
		this.birth_day = studentBirthday;
	}
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	public String getApartment_name() {
		return apartment_name;
	}
	public void setApartment_name(String selectedXueItem) {
		this.apartment_name = selectedXueItem;
	}
	public String getMajor_id() {
		return major_id;
	}
	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getStu_passowrd() {
		return stu_passowrd;
	}
	public void setStu_passowrd(String stu_passowrd) {
		this.stu_passowrd = stu_passowrd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStu_class() {
		return stu_class;
	}
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	
}
