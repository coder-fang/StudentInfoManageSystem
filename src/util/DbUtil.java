package util;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.sun.jdi.connect.spi.Connection;



public class DbUtil {//�����ݿ⽨�����ӣ�Ȼ��basedao�����ȡ��������������
	private static final String URL="jdbc:mysql://127.0.0.1:3306/stuinfo?serverTimezone=UTC&useSSL=false";
	private static final String USER="root";
	private static final String PASSWORD="267356";
	
	public java.sql.Connection getCon() {
		java.sql.Connection conn=null;
		try {
			//1.������������(���䣬ͨ������)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�������سɹ�");
			//2.������ݿ������
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("���ݿ����ӳɹ�");
			//3.����ִ�л���
			java.sql.Statement stmt=conn.createStatement();
			//ִ��sql��䣬�õ������
			ResultSet rs=stmt.executeQuery("select stu_name,stu_sex from stu_user");
			//���rs���������ݣ�����Ϊtrue����ô���ѭ���ͻ���
			while(rs.next()){
				System.out.println(rs.getString("stu_sex")+","+rs.getString("stu_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��������ʧ��");
			System.out.println("���ݿ�����ʧ��");
			
		}
		return conn;
		
	}
	/**
	 *�ر����ݿ�����
	 * 
	 * */
	public void closeCon(java.sql.Connection conn)throws Exception{
		if(conn!=null) {
			conn.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		
		try {
			dbUtil.getCon();
			
			System.out.println("���ݿ����ӳɹ�");
			
		}catch(Exception e){
			e.printStackTrace();
		
			System.out.println("���ݿ�����ʧ��");
			
		}
	}
	
}
