
package model;
/*
 * ö����
 * */
public enum XueType {	//��ͬԺϵ
	JINGGUAN("���������ѧԺ",0),FOOD("ʳƷѧԺ",1),SHENGKE("�����Ƽ�ѧԺ",2),WENFA("�ķ�ѧԺ",3),XINGONG("��Ϣ����ѧԺ",4),HUAGONG("��ѧ����ѧԺ",5),JIDIAN("����ѧԺ",6),ART("����ѧԺ",7),XINKE("�¿�ѧԺ",8),TEACH("������ѧѧԺ",9),ZIHUAN("��Դ�뻷��ѧԺ",10),SHUXUE("��ѧ��ѧѧԺ",11),FUZHUANG("��װѧԺ",12),DONGKE("����Ƽ�ѧԺ",13),YUANYI("԰��԰��ѧԺ",14),TIYU("����ѧԺ",15),WAIYU("�����ѧԺ",16);
	private String name;//������Ա����
	private int index;
	private XueType(String name,int index){
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
