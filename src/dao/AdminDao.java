package dao;

import model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao {
	/**
	 *管理员登录
	 */
	public Admin login(Admin admin){  //传参
		String sql="select * from s_admin where name=? and password=?";
		Admin adminRst=new Admin();
		
		try {
			PreparedStatement prst=conn.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();//（ResultSet结果集:存储查询结果的对象）数据中查询结果返回的一种对象
			if(executeQuery.next()){
				
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();//用完之后关掉数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adminRst;
		
	}

}
