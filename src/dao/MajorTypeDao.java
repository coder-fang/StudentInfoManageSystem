package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.MajorType;


/*
 * ��רҵ����ɾ�Ĳ�
 * */
public class MajorTypeDao extends BaseDao{
	public String searchMajorId(MajorType majorType) throws SQLException {					//��ѯ����ȡ��רҵid
	    String major_id=null;
	
	    String sqlString ="select major_info.major_id from major_info INNER JOIN stu_user ON major_info.major_name=stu_user.major_name";      //���������ϲ�ѯ
	   
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sqlString);
		ResultSet resultSet=pstmt.executeQuery();    //�����ݿ��ѯ֮����ڽ������
			      
		if(resultSet.next()){    //next():�ж�<���ݿ��ѯ>���޽��
				
			major_id=resultSet.getString("major_info.major_id");
			System.out.println("major_id�ǣ�"+major_id);            				//Ϊʲômajor_id��Ϊ1��
		}
	   return major_id;
	}
}
