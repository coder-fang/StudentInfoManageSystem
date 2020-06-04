package util;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.sun.jdi.connect.spi.Connection;



public class DbUtil {//与数据库建立连接，然后basedao对象获取建立起来的连接
	private static final String URL="jdbc:mysql://127.0.0.1:3306/stuinfo?serverTimezone=UTC&useSSL=false";
	private static final String USER="root";
	private static final String PASSWORD="267356";
	
	public java.sql.Connection getCon() {
		java.sql.Connection conn=null;
		try {
			//1.加载驱动程序(反射，通过类名)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
			//2.获得数据库的连接
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("数据库连接成功");
			//3.创建执行环境
			java.sql.Statement stmt=conn.createStatement();
			//执行sql语句，得到结果集
			ResultSet rs=stmt.executeQuery("select stu_name,stu_sex from stu_user");
			//如果rs里面有数据，它就为true，那么这个循环就会走
			while(rs.next()){
				System.out.println(rs.getString("stu_sex")+","+rs.getString("stu_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("驱动加载失败");
			System.out.println("数据库连接失败");
			
		}
		return conn;
		
	}
	/**
	 *关闭数据库连接
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
			
			System.out.println("数据库连接成功");
			
		}catch(Exception e){
			e.printStackTrace();
		
			System.out.println("数据库连接失败");
			
		}
	}
	
}
