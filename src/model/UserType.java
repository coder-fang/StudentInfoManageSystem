package model;

public enum UserType {//ö����
	ADMIN("ϵͳ����Ա",0),TEACHER("��ʦ",1),STUDENT("ѧ��",2);
	private String name;//������Ա����
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
	//��д����д�������е�toString()����
	@Override 
	public String toString() {
		return this.name;
	}
	
}
