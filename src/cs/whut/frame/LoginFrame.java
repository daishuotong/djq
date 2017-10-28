package cs.whut.frame;

import qi.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public  static JTextField textField;
	public static JPasswordField passwordField;
	private static String username;
	private static String password;
	
	
	public LoginFrame(){
		//登录界面
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setVgap(10);
		flowLayout_3.setHgap(60);
		panel_2.add(panel_3);
		//用户输入面板
		JLabel label_1 = new JLabel("用户名");
		panel_3.add(label_1);
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setHgap(70);
		panel_2.add(panel_4);
		//密码输入面板
		JLabel label_2 = new JLabel("密码");
		panel_4.add(label_2);
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel_4.add(passwordField);
		
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(60);
		panel_2.add(panel_5);
		//确定按钮
		JButton button = new JButton("确定");	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		panel_5.add(button);
		button.addActionListener(new ActionListener(){
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				User a;
				try {
					username=textField.getText();
					password=passwordField.getText();
					a=DataProcessing.searchUser(username, password);
					if(a.getRole().equals("browser")){
						UserFrame browserframe = new UserFrame(a);
						browserframe.setTitle("档案浏览员界面");
						browserframe.setSize(800,600);
						browserframe.setLocationRelativeTo(null);
						browserframe.setVisible(true);
					}
					else if(a.getRole().equals("operator")){
						UserFrame operator = new UserFrame(a);
						operator.setSize(800,600);
						operator.setTitle("档案操作员界面");
						operator.setLocationRelativeTo(null);
						operator.setVisible(true);
					}
					else if(a.getRole().equals("administrator"))
					{
						UserFrame administrator = new UserFrame(a);
						administrator.setSize(800,600);
						administrator.setTitle("系统管理人员界面");
						administrator.setLocationRelativeTo(null);
						administrator.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "用户名错误或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
				}catch (SQLException e1){
					e1.printStackTrace();
				}
				setVisible(false);
			}
			
		});
		
		//取消按钮
		JButton btnNewButton = new JButton("取消");
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
	}
	
	public static void main(String[] args) {
	}
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		username = textField.getText();
		password = passwordField.getText();
	}
	

}
