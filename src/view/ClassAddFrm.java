package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClassDao;
import dao.StudentTypeDao;
import model.StudentClass;
import model.StudentType;
import model.XueType;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ClassAddFrm extends JFrame {

	private JPanel contentPane;
	private JTextField className;
	private JLabel label_1;
	private JTextField classInfo;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Create the frame.
	 */
	public ClassAddFrm() {
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(ClassAddFrm.class.getResource("/images/juxingkaobei.png")));
		
		className = new JTextField();
		className.setColumns(10);
		
		label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(ClassAddFrm.class.getResource("/images/xueshengxinxicaiji.png")));
		
		classInfo = new JTextField();
		classInfo.setColumns(10);
		
		btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(ClassAddFrm.class.getResource("/images/queren.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {     //确认添加班级
				classAddActionPerfromed(ae);
			}
		});
		
		button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {   //重置：所添加的班级信息
				restValue(ae);
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setIcon(new ImageIcon(ClassAddFrm.class.getResource("/images/zhongzhi.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(46))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(classInfo)
								.addComponent(className, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
							.addContainerGap(81, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(className, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(classInfo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void classAddActionPerfromed(ActionEvent ae) {     //添加班级事件
		
		ClassDao classDao=new ClassDao();
		String class_name=className.getText().toString();//获取班级名称
		String class_info=classInfo.getText().toString();//获取班级介绍
		//判断输入是否为空
		if(StringUtil.isEmpty(class_name)){
			JOptionPane.showMessageDialog(null, "班级名称不能为空");
		}
		if(StringUtil.isEmpty(class_info)){
			JOptionPane.showMessageDialog(null , "班级介绍不能为空");
		}
		
		StudentClass studentClass=new StudentClass(); //创建班级对象 
		studentClass.setClassName(class_name);
		studentClass.setClassInfo(class_info);
		
		//判断是否添加班级成功
		try {
			if(classDao.addClass(studentClass)) {
				JOptionPane.showMessageDialog(this,"添加成功！");
			}else {
				JOptionPane.showMessageDialog(this,"添加失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void restValue(ActionEvent ae) {		//清空以前输入的内容 (重置)
			className.setText("");
			classInfo.setText("");
	}
}
