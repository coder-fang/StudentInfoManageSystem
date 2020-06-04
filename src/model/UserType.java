package model;

public enum UserType {//枚举类
	ADMIN("系统管理员",0),TEACHER("教师",1),STUDENT("学生",2);
	private String name;//创建成员变量
	private int index;
	private UserType(String name,int index){
		this.name=name;
		this.index=index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	//重写（改写）父类中的toString()方法
	@Override 
	public String toString() {
		return this.name;
	}
	
}
