package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ClassDao;
import dao.DeptTypeDao;
import dao.MajorTypeDao;
import dao.StudentTypeDao;
import model.DepartmentType;
import model.MajorType;
import model.StudentClass;
import model.StudentType;
import util.StringUtil;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class StudentManageFrm extends JFrame {
	private JTable studentListTable;     //声明成员变量
	private JTextField searchStudentNameTextField;
	private JTextField searchClassTextField;
	private JTextField editStudentNameTextField;
	private JTextField editClassTextField;
	private JTextField editStudentPasswordTextField;
	private JRadioButton editStudentSexManRadioButton;
	private JRadioButton editStudentSexFemalRadioButton;
	private JRadioButton editStudentSexUnknownRadioButton;
	private ButtonGroup sexButtonGroup;
	private JTextField editStuNumberTextField;
	private JTextField editStuBirthdayTextField;
	private JTextField editXueTextField;
	private JTextField editMajorTextField;
	
	/**
	 * Create the frame.
	 */
	public StudentManageFrm() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 1010, 838);
		
		JScrollPane scrollPane = new JScrollPane();
		
		studentListTable = new JTable();
		studentListTable.setBackground(Color.WHITE);
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5B66\u53F7", "\u5B66\u9662", "\u73ED\u7EA7", "\u751F\u65E5", "\u5BC6\u7801", "\u5B66\u7C4D\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentListTable);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/xuesheng.png")));
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/juxingkaobei.png")));
		
		searchClassTextField = new JTextField();
		searchClassTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {           				//查询学生
				StudentType sc=new StudentType();
				sc.setStu_name(searchStudentNameTextField.getText().toString());
				sc.setStu_class(searchClassTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/xuesheng.png")));
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		
		editStudentSexManRadioButton = new JRadioButton("\u7537");
		editStudentSexManRadioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editStudentSexFemalRadioButton = new JRadioButton("\u5973");
		editStudentSexFemalRadioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editStudentSexUnknownRadioButton = new JRadioButton("\u4FDD\u5BC6");
		editStudentSexUnknownRadioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		//添加按钮组，将性别三个按钮放在按钮组中，实现三选一
		sexButtonGroup=new ButtonGroup();
		sexButtonGroup.add(editStudentSexManRadioButton);
		sexButtonGroup.add(editStudentSexFemalRadioButton);
		sexButtonGroup.add(editStudentSexUnknownRadioButton);
		
		JLabel label_4 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editClassTextField = new JTextField();
		editClassTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editStudentPasswordTextField = new JTextField();
		editStudentPasswordTextField.setColumns(10);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {								//确认修改学生事件
				try {
					submitEditStudentAct(ae);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		submitEditButton.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/queren.png")));
		submitEditButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton deleteStudentButton = new JButton("\u5220\u9664\u5B66\u751F");
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {              //删除学生
				deleteStuAct(ae);
			}
		});
		deleteStudentButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel("\u5B66\u53F7\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editStuNumberTextField = new JTextField();
		editStuNumberTextField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5B66\u9662\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel label_8 = new JLabel("\u751F\u65E5\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editStuBirthdayTextField = new JTextField();
		editStuBirthdayTextField.setColumns(10);
		
		editXueTextField = new JTextField();
		editXueTextField.setColumns(10);
		
		JLabel label_9 = new JLabel(" \u4E13\u4E1A\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 14));
		
		editMajorTextField = new JTextField();
		editMajorTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchClassTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(158)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap(182, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_6)
											.addGap(19))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_9)
												.addComponent(label_7))
											.addGap(18)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(editMajorTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(editXueTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(editStuNumberTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(editClassTextField))))
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editStudentSexManRadioButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editStudentSexFemalRadioButton)
									.addGap(6)
									.addComponent(editStudentSexUnknownRadioButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_5)
										.addComponent(label_8))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(editStuBirthdayTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(editStudentPasswordTextField))))
							.addGap(78)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteStudentButton)
								.addComponent(submitEditButton)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 841, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchClassTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton)
						.addComponent(label_1))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editStudentSexUnknownRadioButton)
						.addComponent(editStudentSexFemalRadioButton)
						.addComponent(editStudentSexManRadioButton)
						.addComponent(label_3)
						.addComponent(submitEditButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(editClassTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(editStudentPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteStudentButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editStuNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(editStuBirthdayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editXueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editMajorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitEditStudentAct(ActionEvent ae) throws SQLException {    //确认修改学生事件
		// TODO Auto-generated method stub
		StudentTypeDao studentTypeDao=new StudentTypeDao();
		int index=studentListTable.getSelectedRow();
		if(index==-1) {       //如果没有选中,·······
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();	//拿到table模型
		String studentName = dft.getValueAt(studentListTable.getSelectedRow(),1).toString();  //姓名
		String studentSex= dft.getValueAt(studentListTable.getSelectedRow(),2).toString();    //性别
		String studentNum =dft.getValueAt(studentListTable.getSelectedRow(),3).toString();    //学号
		String studentXue =dft.getValueAt(studentListTable.getSelectedRow(),4).toString();    //学院
		String classInfo =dft.getValueAt(studentListTable.getSelectedRow(),5).toString();     //班级
		String studentBirthday =dft.getValueAt(studentListTable.getSelectedRow(),6).toString();  //生日
		String studentPassword=dft.getValueAt(studentListTable.getSelectedRow(),7).toString();   //密码
				
		String editStudentName = editStudentNameTextField.getText().toString();       //姓名
		String editStudentSex=(editStudentSexManRadioButton.isSelected()) ? (editStudentSexManRadioButton.getText()) : ((editStudentSexFemalRadioButton.isSelected()) ? (editStudentSexFemalRadioButton.getText()):(editStudentSexUnknownRadioButton.getText())); //获取性别
		String editStuNumber = editStuNumberTextField.getText().toString();           //学号
		String editXue = editXueTextField.getText().toString();                       //学院
		String editMajor = editMajorTextField.getText().toString();   				  //专业
		String editClass = editClassTextField.getText().toString();                   //班级
		String editStuBirthday = editStuBirthdayTextField.getText().toString();       //生日
		String editStudentPassword = editStudentPasswordTextField.getText().toString();   //密码
		
		if(StringUtil.isEmpty(editStudentName)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的学生姓名！");
			return;
		}
		if(StringUtil.isEmpty(editStudentSex)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的学生性别！");
			return;
		}		
		if(StringUtil.isEmpty(editStuNumber)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的学生学号！");
			return;
		}
		if(StringUtil.isEmpty(editXue)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的学院！");
			return;
		}
		if(StringUtil.isEmpty(editMajor)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的专业！");
			return;
		}
		if(StringUtil.isEmpty(editClass)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的班级！");
			return;
		}
		if(StringUtil.isEmpty(editStuBirthday)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的学生生日！");
			return;
		}
		if(StringUtil.isEmpty(editStudentPassword)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的学生密码！");
			return;
		}
		
		int id=Integer.parseInt(dft.getValueAt(studentListTable.getSelectedRow(), 0).toString());
		StudentType sc=new StudentType();   //创建学生对象
		sc.setStu_id(id);
		sc.setStu_name(editStudentName);
		sc.setStu_sex(editStudentSex);
		sc.setStu_num(editStuNumber);
		sc.setApartment_name(editXue);
		sc.setMajor_name(editMajor);
		sc.setStu_class(editClass);
		sc.setBirth_day(editStuBirthday);
		sc.setStu_passowrd(editStudentPassword);
		sc.setStatus(1);  //默认为1，学籍存在
		
		DepartmentType departemntType=new DepartmentType();
		DeptTypeDao deptTypeDao=new DeptTypeDao();									//获取院系id
		String dept_id=deptTypeDao.searchDeptId(departemntType).toString();
		
		MajorType majorType=new MajorType();							            //获取专业id
		MajorTypeDao majorTypeDao=new MajorTypeDao();
		String major_id=majorTypeDao.searchMajorId(majorType).toString();
		
		if("经济与管理学院".equals(editXue)) {	
			//经济与管理学院，添加到经管学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
			
			if("会计".equals(sc.getMajor_name())) {
				sc.setMajor_id(major_id);
			}
			else if("市场营销".equals(sc.getMajor_name())) {
				sc.setMajor_id(major_id);
			}
			else if("国际经济与贸易".equals(sc.getMajor_name())) {
				sc.setMajor_id(major_id);
			} 
			else{
				sc.setMajor_id(major_id);
			}
		}
		if("食品学院".equals(editXue)) {
			//食品学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
			if("旅游".equals(sc.getMajor_name())) {
				sc.setMajor_id(major_id);
			}
			else if("质量".equals(sc.getMajor_name())) {
				sc.setMajor_id(major_id);
			}
			else if("食工".equals(sc.getMajor_name())) {
				sc.setMajor_id(major_id);
			} 
			else{
				sc.setMajor_id(major_id);
			}
		}
		if("生科学院".equals(editXue)) {
			//生科学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("文法学院".equals(editXue)) {
			//文法学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("信工学院".equals(editXue)) {
			//信工学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("机电学院".equals(editXue)) {
			//机电学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("艺术学院".equals(editXue)) {
			//艺术学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("新科学院".equals(editXue)) {
			//新科学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("教科学院".equals(editXue)) {
			//教科学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("化工学院".equals(editXue)) {
			//化工学院
			sc.setApartment_id(Integer.parseInt(dept_id));		
		}
		
		if(studentTypeDao.update(sc)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		setTable(new StudentType());     //修改成功以后,刷新列表JTable
		}
	protected void selectedTabledRow(MouseEvent me) {   //‘点击学生表格’事件 : 输入框出现学生信息
		// TODO Auto-generated method stub
		DefaultTableModel dft=(DefaultTableModel) studentListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),1).toString()); //出现在学生姓名框中		
		if("男".equals(dft.getValueAt(studentListTable.getSelectedRow(),2).toString())) {   	 //“男”被选中
			editStudentSexManRadioButton.setSelected(true);
		}  		
		if("女".equals(dft.getValueAt(studentListTable.getSelectedRow(),2).toString())) {   	  //“女”被选中
			editStudentSexFemalRadioButton.setSelected(true);
		}  
		if("保密".equals(dft.getValueAt(studentListTable.getSelectedRow(),2).toString())) {   //“保密”被选中
			editStudentSexUnknownRadioButton.setSelected(true);
		}  
		editStuNumberTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),3).toString()); //出现在学号框中
		editXueTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),4).toString()); //出现在学院框中
		editClassTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),5).toString()); //出现在班级框中
		editStuBirthdayTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),6).toString()); //出现在生日框中		
		editStudentPasswordTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),7).toString()); //出现在密码框中
		
	}
	protected void deleteStuAct(ActionEvent ae) {   //删除学生
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this,"您确定删除吗？")!=JOptionPane.OK_OPTION) {  //如果不选OK确定删除,则跳出这个方法
			return;  //跳出这个方法
		}
		int index=studentListTable.getSelectedRow();
		if(index==-1) {       //如果没有选中,·······
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		DefaultTableModel dft=(DefaultTableModel) studentListTable.getModel();
		int id=Integer.parseInt(dft.getValueAt(studentListTable.getSelectedRow(),0).toString());          //如果选中,则从此处开始执行
		StudentTypeDao studentTypeDao=new StudentTypeDao();
		if(studentTypeDao.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new StudentType());     //删除成功以后,刷新列表JTable
	}
	private void setTable(StudentType studentType) {
		DefaultTableModel dft=(DefaultTableModel) studentListTable.getModel();	//拿到table模型
		dft.setRowCount(0);   	//将列表清空
		StudentTypeDao studentTypeDao=new StudentTypeDao();
		List<StudentType> studentList=studentTypeDao.getStudentList(studentType);
 		for(StudentType st : studentList) {      //遍历集合，获得每一个学生对象，再输出学生对象的信息
			Vector v=new Vector();
			v.add(st.getStu_id());
			v.add(st.getStu_name());
			v.add(st.getStu_sex());	
			v.add(st.getStu_num());
			v.add(st.getApartment_name());
			v.add(st.getStu_class());
			v.add(st.getBirth_day());
			v.add(st.getStu_passowrd());
			v.add(st.getStatus());
	
			dft.addRow(v);
		}
		
	}
}
