package dao;//���ݿ���ʶ���������Ŀ�����ݿ�򽻵������õ���һ������
/* 
 * ��ȡutil�н����������,Ȼ�󣨰�������ݿ���󣩴���ÿһ����Ҫ�����ݿ⽻����model����
 * */

import com.sun.jdi.connect.spi.Connection;

import util.DbUtil;

public class BaseDao {
//	private static final String URL="jdbc:mysql://127.0.0.1:3306/stuinfo?serverTimezone=UTC&useSSL=false";
//	private static final String USER="root";
//	private static final String PASSWORD="267356";
//	public static void main(String[] args) {
//		try {
//			//1.������������(���䣬ͨ������)
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("�������سɹ�");
//			//2.������ݿ������
//			java.sql.Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
//			System.out.println("���ݿ����ӳɹ�");
//			//3.����ִ�л���
//			java.sql.Statement stmt=conn.createStatement();
//			//ִ��sql��䣬�õ������
//			ResultSet rs=stmt.executeQuery("select NAME,sex from stu_user");
//			//���rs���������ݣ�����Ϊtrue����ô���ѭ���ͻ���
//			while(rs.next()){
//				System.out.println(rs.getString("sex")+","+rs.getString("NAME"));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("��������ʧ��");
//			System.out.println("���ݿ�����ʧ��");
//			
//		}
//			
//	}
	public java.sql.Connection conn=new DbUtil().getCon(); 
	
}