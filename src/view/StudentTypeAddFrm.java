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
	private JTextField StudentNameText; //ѧ������
	private JTextField StudentNumText;	//ѧ��
	private JRadioButton stuSexWomanButton;	//�Ա�:Ů
	private JRadioButton stuSexManButton;	//�Ա�:��	
	private JTextField StudentBirthdayTextField; //����
	private JTextField GradeTextField; //�༶
	private JComboBox xueTypeComboBox; //ѧԺ
	private JTextField StudentMajorTextField; //רҵ
	private JTextField stuPassowrd;   //ѧ������

	/**
	 * Create the frame.
	 */
	public StudentTypeAddFrm() {     //���췽��,��ʼ������
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
		
		stuSexManButton = new JRadioButton("��");  //�Ա�ť����
		stuSexManButton.setSelected(true);
		
	    stuSexWomanButton = new JRadioButton("Ů");  //�Ա�ť��Ů
		
		//���尴ť��(ѧ���Ա�)��ʵ���Ա�ѡ�ѡ
		ButtonGroup group=new ButtonGroup();
		group.add(stuSexManButton);
		group.add(stuSexWomanButton);
		
		
		xueTypeComboBox = new JComboBox();
		xueTypeComboBox.setModel(new DefaultComboBoxModel(XueType.values()));
		xueTypeComboBox.setToolTipText("");
		
		JButton QueAddButton = new JButton("\u786E\u8BA4");
		QueAddButton.setIcon(new ImageIcon(StudentTypeAddFrm.class.getResource("/images/queren.png")));
		QueAddButton.addActionListener(new ActionListener() {   //ȷ�����ѧ���¼�����
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
	 * ѧ������¼�
	 	* */
	protected void studentTypeAddActionPerfromed(ActionEvent ae) throws Exception {
		// TODO Auto-generated method stub
		
		StudentTypeDao studentDao=new StudentTypeDao();
		String studentNumber=StudentNumText.getText().toString();//��ȡѧ��
		String studentName=StudentNameText.getText().toString();//��ȡ����
		String studentBirthday=StudentBirthdayTextField.getText().toString();//��ȡ����
		String studentMajor=StudentMajorTextField.getText().toString();//��ȡרҵ
		String studentClass=GradeTextField.getText().toString();//��ȡ�༶
		XueType selectedXueItem = (XueType)xueTypeComboBox.getSelectedItem();//��ȡѧԺ , XueTypeǿ������ת��
		String stuSex=(stuSexManButton.isSelected()) ? (stuSexManButton.getText()) : (stuSexWomanButton.getText()); //��ȡ�Ա�
		String studentPassword=stuPassowrd.getText().toString();//��ȡѧ������
	
		//�ж������Ƿ�Ϊ��
		if(StringUtil.isEmpty(studentNumber)){
			JOptionPane.showMessageDialog(null, "ѧ�����Ʋ���Ϊ��");
		
		}
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
		
		}
		if(stuSex==null){
			JOptionPane.showMessageDialog(null, "�Ա���Ϊ��");
		
		}
		
		if(StringUtil.isEmpty(studentBirthday)){
			JOptionPane.showMessageDialog(null, "���ղ���Ϊ��");
		
		} 
		
		if(StringUtil.isEmpty(studentMajor)){
			JOptionPane.showMessageDialog(null, "רҵ����Ϊ��");
		
		}
		if(StringUtil.isEmpty(studentClass)){
			JOptionPane.showMessageDialog(null, "�༶����Ϊ��");
		
		}	
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(null, "ѧ�����벻��Ϊ��");
		
		}	
		
		StudentType student=new StudentType(); //����ѧ������ 
		student.setStu_name(studentName);
		student.setStu_sex(stuSex);
		student.setStu_num(studentNumber);
		student.setBirth_day(studentBirthday);
		student.setApartment_name(selectedXueItem.toString());
		student.setMajor_name(studentMajor);
		student.setStu_class(studentClass);
		student.setStu_passowrd(studentPassword);
		student.setStatus(1);  //Ĭ��Ϊ1��ѧ������
		
		DepartmentType departemntType=new DepartmentType();
		DeptTypeDao deptTypeDao=new DeptTypeDao();									//��ȡԺϵid
		String dept_id=deptTypeDao.searchDeptId(departemntType).toString();
		
		MajorType majorType=new MajorType();							            //��ȡרҵid
		MajorTypeDao majorTypeDao=new MajorTypeDao();
		String major_id=majorTypeDao.searchMajorId(majorType).toString();
		
		if("���������ѧԺ".equals(selectedXueItem.getName())) {	
			//���������ѧԺ����ӵ�����ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
			
			if("���".equals(student.getMajor_name())) {
				student.setMajor_id(major_id);
			}
			else if("�г�Ӫ��".equals(student.getMajor_name())) {
				student.setMajor_id(major_id);
			}
			else if("���ʾ�����ó��".equals(student.getMajor_name())) {
				student.setMajor_id(major_id);
			} 
			else{
				student.setMajor_id(major_id);
			}
		}
		if("ʳƷѧԺ".equals(selectedXueItem.getName())) {
			//ʳƷѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("����ѧԺ".equals(selectedXueItem.getName())) {
			//����ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("�ķ�ѧԺ".equals(selectedXueItem.getName())) {
			//�ķ�ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("�Ź�ѧԺ".equals(selectedXueItem.getName())) {
			//�Ź�ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("����ѧԺ".equals(selectedXueItem.getName())) {
			//����ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("����ѧԺ".equals(selectedXueItem.getName())) {
			//����ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("�¿�ѧԺ".equals(selectedXueItem.getName())) {
			//�¿�ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("�̿�ѧԺ".equals(selectedXueItem.getName())) {
			//�̿�ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		if("����ѧԺ".equals(selectedXueItem.getName())) {
			//����ѧԺ
			student.setApartment_id(Integer.parseInt(dept_id));		
		}
		
		//�ж��Ƿ����ѧ���ɹ�
		if(studentDao.add(student)) {
			JOptionPane.showMessageDialog(this,"��ӳɹ���");
		}else {
			JOptionPane.showMessageDialog(this,"���ʧ�ܣ�");
		}
		System.out.println(student.getStatus()+"״̬");
	}
/*
 *��ʼ��ѧԺ������
 */
	private void closeStudentTypeAddFrm(ActionEvent ae) {  //���"ȡ��",�ر�"���ѧ����Ϣ"����(����¼�����)
		this.dispose();  //�رմ���,�ͷ���Դ
	}
}
