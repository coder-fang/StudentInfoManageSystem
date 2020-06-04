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
 * 学生类
 * 主要对学生的增、删、改、查的一些操作
 * */
public class StudentTypeDao extends BaseDao {
/**
 * 学生添加
 * */
	public boolean add(StudentType studentType) throws Exception{
		String sql="insert into stu_user values(null,?,?,?,?,?,?,?,?,?,?,?)";//学生添加sql语句
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
	public List<StudentType> getStudentList(StudentType studentType){					//	查询学生
		java.util.List<StudentType> retList=new ArrayList<StudentType>();
		String sqlString ="select * from stu_user";
		if(!StringUtil.isEmpty(studentType.getStu_name())) {     //姓名如果不为空，则查询（模糊查询）。。
			sqlString += " where stu_name like '%"+studentType.getStu_name()+"%'";
			
		}try {
			PreparedStatement preparedStatement=conn.prepareStatement(sqlString);
			ResultSet executeQuery=preparedStatement.executeQuery();
			while(executeQuery.next()) {
				StudentType sc=new StudentType();      
				//先从表模型中获取所选中的那一行数据，再设置各个值
				sc.setStu_id(executeQuery.getInt("stu_id"));       			//获取并设置id
				sc.setStu_name(executeQuery.getString("stu_name"));			//获取并设置姓名
				sc.setStu_num(executeQuery.getString("stu_num"));           //获取并设置学号
				sc.setBirth_day(executeQuery.getString("birth_day"));			//获取并设置生日 
				sc.setStu_passowrd(executeQuery.getString("stu_password"));		//获取并设置密码
				sc.setApartment_id(executeQuery.getInt("apartment_id"));			//获取并设置院系编号
				sc.setApartment_name(executeQuery.getString("apartment_name"));    //获取并设置学院名称
				sc.setMajor_id(executeQuery.getString("major_id"));			//获取并设置专业编号
				sc.setMajor_name(executeQuery.getString("major_name"));		//获取并设置专业名称
				sc.setStu_class(executeQuery.getString("stu_class"));			//获取并设置班级
				sc.setStatus(executeQuery.getInt("status"));			    //获取并设置学籍状态
				sc.setStu_sex(executeQuery.getString("stu_sex"));           //获取并设置性别

				retList.add(sc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) {					//删除学生
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
	public boolean update(StudentType sc) {       								//修改学生
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
