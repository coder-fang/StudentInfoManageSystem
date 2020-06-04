package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Publisher;

import model.StudentClass;
import util.StringUtil;

/*
 * �༶��Ϣ�����ݿ����
 * */

public class ClassDao extends BaseDao {
	public boolean addClass(StudentClass scl) throws Exception {                   //��Ӱ༶
		String sql="insert into s_class values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement=conn.prepareStatement(sql);

		    preparedStatement.setString(1, scl.getClassName());
			preparedStatement.setString(2, scl.getClassInfo());
			if(preparedStatement.executeUpdate()>0) return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public List<StudentClass> getClassList(StudentClass studentClass){					//	��ѯ�༶
		java.util.List<StudentClass> retList=new ArrayList<StudentClass>();
		String sqlString ="select * from s_class";
		if(!StringUtil.isEmpty(studentClass.getClassName())) {     //�����Ϊ�գ����ѯ���༶��ģ����ѯ������
			sqlString += " where class_name like '%"+studentClass.getClassName()+"%'";
			
		}try {
			PreparedStatement preparedStatement=conn.prepareStatement(sqlString);
			ResultSet executeQuery=preparedStatement.executeQuery();
			while(executeQuery.next()) {
				StudentClass sc=new StudentClass();      
				sc.setClassId(executeQuery.getInt("class_id"));       //�ȴӱ�ģ���л�ȡ��ѡ�е���һ�����ݣ������ø���ֵ
				sc.setClassName(executeQuery.getString("class_name"));
				sc.setClassInfo(executeQuery.getString("class_info"));
				retList.add(sc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) {					//ɾ���༶
		String sql="delete from s_class where class_id=?";
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;      					
	}
	public boolean update(StudentClass sc) {       								//�޸İ༶
		String sql="update s_class set class_name=?,class_info=? where class_id=?";
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, sc.getClassName());
			preparedStatement.setString(2, sc.getClassInfo());
			preparedStatement.setInt(3, sc.getClassId());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;      
	}
}
