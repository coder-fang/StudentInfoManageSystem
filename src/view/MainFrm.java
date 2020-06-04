package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.UserType;
import dao.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.SystemColor;



public class MainFrm extends JFrame {

	private JPanel contentPane;
	private UserType userType;
	private Object userObject;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrm frame = new MainFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrm(UserType userType,Object userObject) {  //���췽������ʼ������
		this.userType=userType;
		this.userObject=userObject;
		setTitle("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 701);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xitongshezhi.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {  //�޸�����
				
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xiugaimima.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {  //ϵͳ������:�˳�����
				int result=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�����"); //����һ����������
				if(result==0){
					
					dispose();//���ٳ���
					
				}
				
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tuichu.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/xuesheng.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {     //��ҳ:���, ���ѧ��
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
				
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {        //����ѧ��(ѧ���б�)
				studentManageAct(ae);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/user-list.png")));
		menu_1.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {        //�༶���
				 classAddAct(ae);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				classManageAct(ae);                               //�༶����
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		menu_2.add(mntmNewMenuItem);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bangzhu.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/wode-guanyuwomen.png")));
		menu_3.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 885, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 574, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void studentManageAct(ActionEvent ae) {	 //ѧ�������¼�
		// TODO Auto-generated method stub				
		StudentManageFrm studentManageFrm=new StudentManageFrm();
		studentManageFrm.setVisible(true);	 //��ʾѧ������Ľ���
		
	}

	protected void classAddAct(ActionEvent ae) {         //�༶����¼�
		// TODO Auto-generated method stub
		
		ClassAddFrm classAddFrm=new ClassAddFrm();
		classAddFrm.setVisible(true);		//��ʾ��Ӱ༶�Ľ���
	}

	protected void classManageAct(ActionEvent ae) {       //�༶�����¼�
		// TODO Auto-generated method stub
		
		ClassManageFrm classManageFrm=new ClassManageFrm();
		classManageFrm.setVisible(true);	//��ʾ�༶����Ľ���
	}

	protected void studentAddAct(ActionEvent ae) {		 //�����ѧ�����¼�
		// TODO Auto-generated method stub
		
		StudentTypeAddFrm studentTypeAddFrm=new StudentTypeAddFrm();
		studentTypeAddFrm.setVisible(true);	//��ʾ���ѧ���Ľ���

	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info="�����ǹ������ǣ��������⣬����ϵ�绰:12548586,лл��";
		//JOptionPane.showMessageDialog(this, info);
		String[] buttons= {"�Ȳ�����ȥ����","�Ժ���˵"};
		int ret=JOptionPane.showOptionDialog(this, info,"��������",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/Logo.png")), buttons, null);//����
		if(ret==0){
		//����java����ϵͳ��������ƶ�
			try {
				URI uri=new URI("https://next.xuetangx.com/learn/Wuhanty04021002450/Wuhanty04021002450/1516389/video/1394133");
				Desktop.getDesktop().browse(uri);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			JOptionPane.showMessageDialog(this, "�뿪");
		}
	}
}
