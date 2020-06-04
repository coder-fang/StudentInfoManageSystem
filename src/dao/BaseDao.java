package dao;//数据库访问对象，整个项目与数据库打交道，都用到这一个对象
/* 
 * 获取util中建立起的连接,然后（把这个数据库对象）传给每一个想要和数据库交互的model对象
 * */

import com.sun.jdi.connect.spi.Connection;

import util.DbUtil;

public class BaseDao {
//	private static final String URL="jdbc:mysql://127.0.0.1:3306/stuinfo?serverTimezone=UTC&useSSL=false";
//	private static final String USER="root";
//	private static final String PASSWORD="267356";
//	public static void main(String[] args) {
//		try {
//			//1.加载驱动程序(反射，通过类名)
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("驱动加载成功");
//			//2.获得数据库的连接
//			java.sql.Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
//			System.out.println("数据库连接成功");
//			//3.创建执行环境
//			java.sql.Statement stmt=conn.createStatement();
//			//执行sql语句，得到结果集
//			ResultSet rs=stmt.executeQuery("select NAME,sex from stu_user");
//			//如果rs里面有数据，它就为true，那么这个循环就会走
//			while(rs.next()){
//				System.out.println(rs.getString("sex")+","+rs.getString("NAME"));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("驱动加载失败");
//			System.out.println("数据库连接失败");
//			
//		}
//			
//	}
	public java.sql.Connection conn=new DbUtil().getCon(); 
	
}