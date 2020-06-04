package model;

/*
 * 专业表
 * */
public class MajorType {
	private int major_id; //专业编号
	private String department_id; //系编号
	private String major_name; //专业名称
	private String major_assistant; //辅导员
	private String major_tel; //联系方式
	private String mojor_desc; //专业介绍
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getMajor_assistant() {
		return major_assistant;
	}
	public void setMajor_assistant(String major_assistant) {
		this.major_assistant = major_assistant;
	}
	public String getMajor_tel() {
		return major_tel;
	}
	public void setMajor_tel(String major_tel) {
		this.major_tel = major_tel;
	}
	public String getMojor_desc() {
		return mojor_desc;
	}
	public void setMojor_desc(String mojor_desc) {
		this.mojor_desc = mojor_desc;
	}
	
}
