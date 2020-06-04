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
 * ��Ժϵ����ɾ�Ĳ�
 * */
public class DeptTypeDao extends BaseDao {
	
	public String searchDeptId(DepartmentType departemntType) throws SQLException {					//��ѯ����ȡ��ѧԺid
	    String dept_id=null;
//		String sqlString ="select dept_id from dept_info where dept_name='���������ѧԺ'";
	    String sqlString ="select dept_id from dept_info INNER JOIN stu_user ON dept_info.dept_name=stu_user.apartment_name";      //���������ϲ�ѯ
	   
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sqlString);
		ResultSet resultSet=pstmt.executeQuery();    //�����ݿ��ѯ֮����ڽ������
			      
		if(resultSet.next()){    //next():�ж�<���ݿ��ѯ>���޽��
				
			 dept_id=resultSet.getString("dept_id");
		}
	   return dept_id;
	}
}
