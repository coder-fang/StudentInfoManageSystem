package view;

import java.awt.EventQueue;
import view.LoginFrm;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.sun.jdi.connect.spi.Connection;

import dao.DeptTypeDao;
import dao.MajorTypeDao;
import dao.StudentTypeDao;
import model.DepartmentType;
import model.MajorType;
import model.StudentType;
import model.UserType;
import model.XueType;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button; 
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import util.StringUtil;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class StudentTypeAddFrm extends JFrame {
	private JTextField StudentNameText; //学生姓名
	private JTextField StudentNumText;	//学号
	private JRadioButton stuSexWomanButton;	//性别:女
	private JRadioButton stuSexManButton;	//性别:男	
	private JTextField StudentBirthdayTextField; //生日
	private JTextField GradeTextField; //班级
	private JComboBox xueTypeComboBox; //学院
	private JTextField StudentMajorTextField; //专业
	private JTextField stuPassowrd;   //学生密码

	/**
	 * Create the frame.
	 */
	public StudentTypeAddFrm() {     //构造方法,初始化界面
		setTitle("\u6DFB\u52A0\u5B66\u751F\u754C\u9762");
		setBounds(100, 100, 494, 545);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		
		StudentNameText = new JTextField();
		StudentNameText.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		
		StudentNumText = new JTextField();
		StudentNumText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel label_4 = new JLabel("\u751F\u65E5:");
		
		StudentBirthdayTextField = new JTextField();
		StudentBirthdayTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4E13\u4E1A\uFF1A");
		
		JLabel label_6 = new JLabel("\u9662\u7CFB\uFF1A");
		
		StudentMajorTextField = new JTextField();
		StudentMajorTextField.setColumns(10);
		
		stuSexManButton = new JRadioButton("男");  //性别按钮：男
		stuSexManButton.setSelected(true);
		
	    stuSexWomanButton = new JRadioButton("女");  //性别按钮：女
		
		//定义按钮组(学生性别)，实现性别选项单选
		ButtonGroup group=new ButtonGroup();
		group.add(stuSexManButton);
		group.add(stuSexWomanButton);
		
		
		xueTypeComboBox = new JComboBox();
		xueTypeComboBox.setModel(new DefaultComboBoxModel(XueType.values()));
		xueTypeComboBox.setToolTipText("");
		
		JButton QueAddButton = new JButton("\u786E\u8BA4");
		QueAddButton.setIcon(new ImageIcon(StudentTypeAddFrm.class.getResource("/images/queren.png")));
		QueAddButton.addActionListener(new ActionListener() {   //确认添加学生事件监听
			public void actionPerformed(ActionEvent ae) {
				try {
					studentTypeAddActionPerfromed(ae);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton closeStudentTypeAdd = new JButton("\u53D6\u6D88");
		closeStudentTypeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeStudentTypeAddFrm(e);
				
			}
		});
		closeStudentTypeAdd.setIcon(new ImageIcon(StudentTypeAddFrm.class.getResource("/images/zhongzhi.png")));
		
		JLabel label_7 = new JLabel("\u73ED\u7EA7\uFF1A");
		
		GradeTextField = new JTextField();
		GradeTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(StudentTypeAddFrm.class.getResource("/images/mima.png")));
		
		stuPassowrd = new JTextField();
		stuPassowrd.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_5)
												.addComponent(label_6)
												.addComponent(label_7))
											.addComponent(label_4)
											.addComponent(label_3))
										.addComponent(label_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(StudentBirthdayTextField)
										.addComponent(StudentNumText)
										.addComponent(GradeTextField)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(8)
											.addComponent(stuSexManButton)
											.addGap(30)
											.addComponent(stuSexWomanButton))
										.addComponent(StudentNameText, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(StudentMajorTextField)
										.addComponent(xueTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuPassowrd, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(QueAddButton)))
					.addGap(6)
					.addComponent(closeStudentTypeAdd)
					.addGap(106))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(StudentNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(StudentNumText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuSexWomanButton)
						.addComponent(label_3)
						.addComponent(stuSexManButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(StudentBirthdayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(StudentMajorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(xueTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(GradeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuPassowrd, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(QueAddButton, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(closeStudentTypeAdd, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		getContentPane().setLayout(groupLayout);
	}
	/*
	 * 学生添加事件
	 	* */
	protected void studentTypeAddActionPerfromed(ActionEvent ae) throws Exception {
		// TODO Auto-generated method stub
		
		StudentTypeDao studentDao=new StudentTypeDao();
		String studentNumber=StudentNumText.getText().toString();//获取学号
		String studentName=StudentNameText.getText().toString();//获取姓名
		String studentBirthday=StudentBirthdayTextField.getText().toString();//获取生日
		String studentMajor=StudentMajorTextField.getText().toString();//获取专业
		String studentClass=GradeTextField.getText().toString();//获取班级
		XueType selectedXueItem = (XueType)xueTypeComboBox.getSelectedItem();//获取学院 , XueType强制类型转换
		String stuSex=(stuSexManButton.isSelected()) ? (stuSexManButton.getText()) : (stuSexWomanButton.getText()); //获取性别
		String studentPassword=stuPassowrd.getText().toString();//获取学生密码
	
		//判断输入是否为空
		if(StringUtil.isEmpty(studentNumber)){
			JOptionPane.showMessageDialog(null, "学号名称不能为空");
		
		}
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(null, "姓名不能为空");
		
		}
		if(stuSex==null){
			JOptionPane.showMessageDialog(null, "性别不能为空");
		
		}
		
		if(StringUtil.isEmpty(studentBirthday)){
			JOptionPane.showMessageDialog(null, "生日不能为空");
		
		} 
		
		if(StringUtil.isEmpty(studentMajor)){
			JOptionPane.showMessageDialog(null, "专业不能为空");
		
		}
		if(StringUtil.isEmpty(studentClass)){
			JOptionPane.showMessageDialog(null, "班级不能为空");
		
		}	
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(null, "学生密码不能为空");
		
		}	
		
		StudentType student=new StudentType(); //创建学生对象 
		student.setStu_name(studentName);
		student.setStu_sex(stuSex);
		student.setStu_num(studentNumber);
		student.setBirth_day(studentBirthday);
		student.setApartment_name(selectedXueItem.toString());
		student.setMajor_name(studentMajor);
		student.setStu_class(studentClass);
		student.setStu_passowrd(studentPassword);
		student.setStatus(1);  //默认为1，学籍存在
		
		DepartmentType departemntType=new DepartmentType();
		DeptTypeDao deptTypeDao=new DeptTypeDao();									//获取院系id
		String dept_id=deptTypeDao.searchDeptId(departemntType).toString();
		
		MajorType majorType=new MajorType();							            //获取专业id
		MajorTypeDao majorTypeDao=new MajorTypeDao();
		String major_id=majorTypeDao.searchMajorId(majorType).toString();
		
		if("经济与管理学院".equals(selectedXueItem.getName())) {	
			//经济与管理学院，添加到经管学院
			student.setApartment_id(Integer.parseInt(dept_id));		
			
			if("会计".equals(student.getMajor_name())) {
				student.setMajor_id(major_id);
			}
			else if("市场营销".equals(student.getMajor_name())) {
				student.setMajor_id(major_id);
			}
			else if("国际经济与贸易".equals(student.getMajor_name())) {
				student.setMajor_id(major_id);
			} 
			else{
				student.setMajor_id(major_id);
			}
		}
		if("食品学院".equals(selectedXueItem.getName())) {
			//食品学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("生科学院".equals(selectedXueItem.getName())) {
			//生科学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("文法学院".equals(selectedXueItem.getName())) {
			//文法学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("信工学院".equals(selectedXueItem.getName())) {
			//信工学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("机电学院".equals(selectedXueItem.getName())) {
			//机电学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("艺术学院".equals(selectedXueItem.getName())) {
			//艺术学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("新科学院".equals(selectedXueItem.getName())) {
			//新科学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("教科学院".equals(selectedXueItem.getName())) {
			//教科学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("化工学院".equals(selectedXueItem.getName())) {
			//化工学院
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		
		//判断是否添加学生成功
		if(studentDao.add(student)) {
			JOptionPane.showMessageDialog(this,"添加成功！");
		}else {
			JOptionPane.showMessageDialog(this,"添加失败！");
		}
		System.out.println(student.getStatus()+"状态");
	}
/*
 *初始化学院下拉框
 */
	private void closeStudentTypeAddFrm(ActionEvent ae) {  //点击"取消",关闭"添加学生信息"窗口(添加事件监听)
		this.dispose();  //关闭窗口,释放资源
	}
}
