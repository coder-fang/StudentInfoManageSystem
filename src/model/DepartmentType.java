package model;

/*
 * 学院表
 * */
public class DepartmentType {
	private String dept_id; //学院编号
	private String dept_name; //学院名称
	private String dept_chairman; //系主任
	private String dept_tel; //联系方式
	private String dept_desc; //院系介绍
	
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_chairman() {
		return dept_chairman;
	}
	public void setDept_chairman(String dept_chairman) {
		this.dept_chairman = dept_chairman;
	}
	public String getDept_tel() {
		return dept_tel;
	}
	public void setDept_tel(String dept_tel) {
		this.dept_tel = dept_tel;
	}
	public String getDept_desc() {
		return dept_desc;
	}
	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}
   
}
 