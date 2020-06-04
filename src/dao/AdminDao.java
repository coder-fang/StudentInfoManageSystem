package dao;

import model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao {
	/**
	 *����Ա��¼
	 */
	public Admin login(Admin admin){  //����
		String sql="select * from s_admin where name=? and password=?";
		Admin adminRst=new Admin();
		
		try {
			PreparedStatement prst=conn.prepareStatement(sql);//��sql��䴫�����ݿ��������
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();//��ResultSet�����:�洢��ѯ����Ķ��������в�ѯ������ص�һ�ֶ���
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
			conn.close();//����֮��ص����ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adminRst;
		
	}

}
