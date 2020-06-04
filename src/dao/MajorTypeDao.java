package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.MajorType;


/*
 * 对专业的增删改查
 * */
public class MajorTypeDao extends BaseDao{
	public String searchMajorId(MajorType majorType) throws SQLException {					//查询（获取）专业id
	    String major_id=null;
	
	    String sqlString ="select major_info.major_id from major_info INNER JOIN stu_user ON major_info.major_name=stu_user.major_name";      //两个表联合查询
	   
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sqlString);
		ResultSet resultSet=pstmt.executeQuery();    //从数据库查询之后放在结果集中
			      
		if(resultSet.next()){    //next():判断<数据库查询>有无结果
				
			major_id=resultSet.getString("major_info.major_id");
			System.out.println("major_id是："+major_id);            				//为什么major_id都为1？
		}
	   return major_id;
	}
}
