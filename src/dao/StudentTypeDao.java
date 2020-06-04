package dao;

import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.StudentClass;
import model.StudentType;
import util.StringUtil;

/**
 * ѧ����
 * ��Ҫ��ѧ��������ɾ���ġ����һЩ����
 * */
public class StudentTypeDao extends BaseDao {
/**
 * ѧ�����
 * */
	public boolean add(StudentType studentType) throws Exception{
		String sql="insert into stu_user values(null,?,?,?,?,?,?,?,?,?,?,?)";//ѧ�����sql���
		try {
			java.sql.PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, studentType.getStu_num());
			pstmt.setString(2, studentType.getStu_name());
			pstmt.setString(3, studentType.getStu_sex());
			pstmt.setString(4, studentType.getBirth_day());
			pstmt.setString(5, studentType.getStu_passowrd());
			pstmt.setInt(6, studentType.getApartment_id());
			pstmt.setString(7, studentType.getApartment_name());
			pstmt.setString(8, studentType.getMajor_id());
			pstmt.setString(9, studentType.getMajor_name());
			pstmt.setString(10, studentType.getStu_class());
			pstmt.setInt(11, studentType.getStatus());
			if(pstmt.executeUpdate()>0) return true;
		} catch (SQLException e){
			
			e.printStackTrace();
			
		}
		return false;
	}
	public List<StudentType> getStudentList(StudentType studentType){					//	��ѯѧ��
		java.util.List<StudentType> retList=new ArrayList<StudentType>();
		String sqlString ="select * from stu_user";
		if(!StringUtil.isEmpty(studentType.getStu_name())) {     //���������Ϊ�գ����ѯ��ģ����ѯ������
			sqlString += " where stu_name like '%"+studentType.getStu_name()+"%'";
			
		}try {
			PreparedStatement preparedStatement=conn.prepareStatement(sqlString);
			ResultSet executeQuery=preparedStatement.executeQuery();
			while(executeQuery.next()) {
				StudentType sc=new StudentType();      
				//�ȴӱ�ģ���л�ȡ��ѡ�е���һ�����ݣ������ø���ֵ
				sc.setStu_id(executeQuery.getInt("stu_id"));       			//��ȡ������id
				sc.setStu_name(executeQuery.getString("stu_name"));			//��ȡ����������
				sc.setStu_num(executeQuery.getString("stu_num"));           //��ȡ������ѧ��
				sc.setBirth_day(executeQuery.getString("birth_day"));			//��ȡ���������� 
				sc.setStu_passowrd(executeQuery.getString("stu_password"));		//��ȡ����������
				sc.setApartment_id(executeQuery.getInt("apartment_id"));			//��ȡ������Ժϵ���
				sc.setApartment_name(executeQuery.getString("apartment_name"));    //��ȡ������ѧԺ����
				sc.setMajor_id(executeQuery.getString("major_id"));			//��ȡ������רҵ���
				sc.setMajor_name(executeQuery.getString("major_name"));		//��ȡ������רҵ����
				sc.setStu_class(executeQuery.getString("stu_class"));			//��ȡ�����ð༶
				sc.setStatus(executeQuery.getInt("status"));			    //��ȡ������ѧ��״̬
				sc.setStu_sex(executeQuery.getString("stu_sex"));           //��ȡ�������Ա�

				retList.add(sc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) {					//ɾ��ѧ��
		String sql="delete from stu_user where stu_id=?";
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
	public boolean update(StudentType sc) {       								//�޸�ѧ��
		String sql="update stu_user set stu_num=?,stu_name=?,stu_sex=?,birth_day=?,stu_password=?,apartment_id=?,apartment_name=?,major_id=?,major_name=?,stu_class=?,status=? where stu_id=?";
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, sc.getStu_num());
			preparedStatement.setString(2, sc.getStu_name());
			preparedStatement.setString(3, sc.getStu_sex());
			preparedStatement.setString(4, sc.getBirth_day());
			preparedStatement.setString(5, sc.getStu_passowrd());
			preparedStatement.setInt(6, sc.getApartment_id());
			preparedStatement.setString(7, sc.getApartment_name());
			preparedStatement.setString(8, sc.getMajor_id());
			preparedStatement.setString(9, sc.getMajor_name());
			preparedStatement.setString(10, sc.getStu_class());
			preparedStatement.setInt(11, sc.getStatus());
			preparedStatement.setInt(12, sc.getStu_id());
			
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
