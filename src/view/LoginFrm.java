package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import model.Admin;
import model.UserType;
import util.StringUtil;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {

	private JPanel contentPane;      //成员变量
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/Logo.png")));
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 19));
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setFont(new Font("微软雅黑", Font.BOLD, 14));
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/xingmingyonghumingnicheng.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6   \u7801:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/mima.png")));
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u7C7B\u578B:");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/shijian-.png")));
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setBackground(Color.LIGHT_GRAY);
		userTypeComboBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {//登录事件
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/rightArrow.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/zhongzhi.png")));
		resetButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(label)
									.addComponent(lblNewLabel_1))
								.addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
									.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(userTypeComboBox, 0, 189, Short.MAX_VALUE))))
					.addGap(158))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(185)
					.addComponent(loginButton)
					.addGap(63)
					.addComponent(resetButton)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {//点击登录就会跳转到这个方法
		// TODO Auto-generated method stub
		String userName=userNameTextField.getText().toString();//获取userName的值
		String password=passwordTextField.getText().toString();//获取password的值
		UserType selectedUserTypeItem = (UserType)userTypeComboBox.getSelectedItem();//获取userType, UserType强制类型转换
	
		//判断用户是否输入（判断字符串是否为空）
		//........=> 封装为String类
		if(StringUtil.isEmpty(userName)&&StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this,"用户名和密码不能为空！");//点击登陆，如果输入为空，就展示对话框
			return;
		}if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this,"密码不能为空！");//点击登陆，如果输入为空，就展示对话框
			return;
		}if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this,"用户名不能为空！");//点击登陆，如果输入为空，就展示对话框
			return;
		}Admin admin=null;
		if("系统管理员".equals(selectedUserTypeItem.getName())){
			//系统管理员登录
			AdminDao adminDao=new AdminDao();
			Admin adminTmp=new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin =adminDao.login(adminTmp);
			if(admin==null){
				JOptionPane.showMessageDialog(this,"用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedUserTypeItem.getName()+"】"+admin.getName()+"登录本系统！");
			this.dispose();  //关闭窗体,释放资源
			new MainFrm(selectedUserTypeItem, admin).setVisible(true); 	//显示主页面
			
			
		}else if("教师".equals(selectedUserTypeItem.getName())){
			//教师登录
		}else {
			//学生登录
		}
	}
	protected void restValue(ActionEvent ae) { //清空以前输入的内容
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
		
	}
}
