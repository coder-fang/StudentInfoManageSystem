
package model;
/*
 * 枚举类
 * */
public enum XueType {	//不同院系
	JINGGUAN("经济与管理学院",0),FOOD("食品学院",1),SHENGKE("生命科技学院",2),WENFA("文法学院",3),XINGONG("信息工程学院",4),HUAGONG("化学化工学院",5),JIDIAN("机电学院",6),ART("艺术学院",7),XINKE("新科学院",8),TEACH("教育科学学院",9),ZIHUAN("资源与环境学院",10),SHUXUE("数学科学学院",11),FUZHUANG("服装学院",12),DONGKE("动物科技学院",13),YUANYI("园艺园林学院",14),TIYU("体育学院",15),WAIYU("外国语学院",16);
	private String name;//创建成员变量
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
	//重写（改写）父类中的toString()方法
	@Override 
	public String toString() {
		return this.name;
	}
}
