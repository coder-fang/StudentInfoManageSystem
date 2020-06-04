package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DepartmentType;
import util.StringUtil;

/*
 * 对院系的增删改查
 * */
public class DeptTypeDao extends BaseDao {
	
	public String searchDeptId(DepartmentType departemntType) throws SQLException {					//查询（获取）学院id
	    String dept_id=null;
//		String sqlString ="select dept_id from dept_info where dept_name='经济与管理学院'";
	    String sqlString ="select dept_id from dept_info INNER JOIN stu_user ON dept_info.dept_name=stu_user.apartment_name";      //两个表联合查询
	   
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sqlString);
		ResultSet resultSet=pstmt.executeQuery();    //从数据库查询之后放在结果集中
			      
		if(resultSet.next()){    //next():判断<数据库查询>有无结果
				
			 dept_id=resultSet.getString("dept_id");
		}
	   return dept_id;
	}
}
