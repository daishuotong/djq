package cs.whut.frame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import qi.*;
import cs.whut.frame.MainFrame.changePassword;

public class MainFrame extends JFrame implements ActionListener{
	//�޸ĸ�����Ϣ
	private static final long serialVersionUID = 1L;
	static private JTextField textField;
	static private JTextField textField_4;
	static User aUser=null;
	static String username,oldpassword,newpassword1,newpassword2,role;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	private static JPasswordField passwordField_2;
	public MainFrame(User a) {
		aUser = a;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�û���");
		lblNewLabel.setBounds(112, 21, 64, 15);
		getContentPane().add(lblNewLabel);
		
		username=aUser.getName();
		textField = new JTextField();
		textField.setBounds(200, 18,100, 21);
		textField.setColumns(10);
		textField.setText(username);
		textField.setEditable(false);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("ԭ����");
		lblNewLabel_1.setBounds(112, 56, 64, 15);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 53, 100, 21);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("�¿���");
		lblNewLabel_2.setBounds(112, 91, 64, 15);
		getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(200, 88, 100, 21);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("�ٴ�ȷ��");
		lblNewLabel_3.setBounds(112, 126, 64, 15);
		getContentPane().add(lblNewLabel_3);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(200, 123, 100, 21);
		getContentPane().add(passwordField_2);
		
		JLabel lblNewLabel_4 = new JLabel("��ɫ");
		lblNewLabel_4.setBounds(112, 165, 64, 15);
		getContentPane().add(lblNewLabel_4);
		
		role=aUser.getRole();
		textField_4 = new JTextField();
		textField_4.setBounds(200, 162, 100, 21);
		textField_4.setText(role);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("�޸�");
		btnNewButton.setBounds(95, 206, 85, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new changePassword());
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.setBounds(230, 206, 85, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
	static class changePassword implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			username = textField.getText();
			oldpassword = passwordField.getText();
			newpassword1 = passwordField_1.getText();
			newpassword2 = passwordField_2.getText();
			role = textField_4.getText();
			User a;
			try {
				a = DataProcessing.searchUser(username, oldpassword);
				if(a!=null)
				{
					if(newpassword1.equals(newpassword2))
					{
						if(DataProcessing.updateUser(username, newpassword1, role))
							JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
					}
					else
						JOptionPane.showMessageDialog(null, "�������벻һ��");
				}
				else
					JOptionPane.showMessageDialog(null, "�����ڸ��û�");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {}
	
	
	public static void main(String[] args) {
//		passwordFrame passwordframe = new passwordFrame();
//		passwordframe.setTitle("������Ϣ����");
//		passwordframe.setSize(500,400);
//		passwordframe.setVisible(true);
//		passwordframe.setLocationRelativeTo(null);
//		Container container = passwordframe.getContentPane();
//		container.setLayout(null);
	}
}
