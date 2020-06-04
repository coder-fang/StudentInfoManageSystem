package view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ClassDao;
import model.StudentClass;
import util.StringUtil;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassManageFrm extends JFrame {
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextField editClassInfoTextArea;

	/**
	 * Create the frame.
	 */
	public ClassManageFrm() {
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 745, 613);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(ClassManageFrm.class.getResource("/images/xueshengxinxibiangengchakan.png")));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 				//��ѯ�༶�¼�
				StudentClass sc=new StudentClass();
				sc.setClassName(searchClassNameTextField.getText().toString());
				setTable(sc);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(ClassManageFrm.class.getResource("/images/xueshengxinxibiangengchakan.png")));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_2.setIcon(new ImageIcon(ClassManageFrm.class.getResource("/images/xueshengxinxicaiji.png")));
		
		editClassInfoTextArea = new JTextField();
		editClassInfoTextArea.setColumns(10);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {             //ȷ���޸İ༶�¼�
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ClassManageFrm.class.getResource("/images/queren.png")));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {            //ɾ���༶�¼�
				deleteClassAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(ClassManageFrm.class.getResource("/images/zhongzhi.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(136)
									.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label_2))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(editClassInfoTextArea, 142, 142, 142))
									.addGap(122)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(submitDeleteButton)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {    //������¼�:���༶�޸� 
				selectedTabledRow(me);
			}
		});
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(215);
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StudentClass());     //ˢ���б���Ķ���

	}
	protected void deleteClassAct(ActionEvent ae) {     //ɾ���༶�¼�
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this,"��ȷ��ɾ����")!=JOptionPane.OK_OPTION) {  //�����ѡOKȷ��ɾ��,�������������
			return;  //�����������
		}
		int index=classListTable.getSelectedRow();
		if(index==-1) {       //���û��ѡ��,��������������
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ�������ݣ�");
			return;
		}
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();
		int id=Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());          //���ѡ��,��Ӵ˴���ʼִ��
		ClassDao classDao=new ClassDao();
		if(classDao.delete(id)){
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
		}
		setTable(new StudentClass());     //ɾ���ɹ��Ժ�,ˢ���б�JTable
	}
	protected void submitEditAct(ActionEvent ae) {    //ȷ���޸İ༶�¼�
		// TODO Auto-generated method stub
		ClassDao classDao=new ClassDao();
		int index=classListTable.getSelectedRow();
		if(index==-1) {       //���û��ѡ��,��������������
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ����ݣ�");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();	//�õ�tableģ��
		String className = dft.getValueAt(classListTable.getSelectedRow(),1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(),2).toString();
		String editClassName = editClassNameTextField.getText().toString();
		String editClassInfo = editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)) {
			JOptionPane.showMessageDialog(this, "����дҪ�޸ĵİ༶���ƣ�");
			return;
		}
		if(StringUtil.isEmpty(editClassInfo)) {
			JOptionPane.showMessageDialog(this, "����дҪ�޸ĵİ༶��Ϣ��");
			return;
		}
		if(className.equals(editClassName) && classInfo.equals(editClassInfo)) {
			JOptionPane.showConfirmDialog(this, "����û�����κ��޸ģ�");
			return;
		}
		int id=Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		StudentClass sc=new StudentClass();   //�����༶����
		sc.setClassId(id);
		sc.setClassName(editClassName);
		sc.setClassInfo(editClassInfo);
		if(classDao.update(sc)) {
			JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�");
		}
		setTable(new StudentClass());     //�޸ĳɹ��Ժ�,ˢ���б�JTable
		}
	protected void selectedTabledRow(MouseEvent me) { //������༶����¼� : �������ְ༶��Ϣ
		// TODO Auto-generated method stub
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(),1).toString()); //�����ڰ༶���ƿ���
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(),2).toString()); //�����ڰ༶��Ϣ����
	}
	private void setTable(StudentClass studentClass) {												//��ѯ�༶
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();	//�õ�tableģ��
		dft.setRowCount(0);   	//���б����
		ClassDao classDao=new ClassDao();
		List<StudentClass> classList=classDao.getClassList(studentClass);
 		for(StudentClass sc : classList) {      //�������ϣ����ÿһ���༶����������༶�������Ϣ
			Vector v=new Vector();
			v.add(sc.getClassId());
			v.add(sc.getClassName());
			v.add(sc.getClassInfo());
			dft.addRow(v);
		}
		
	}
}
