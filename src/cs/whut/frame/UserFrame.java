package cs.whut.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import qi.*;

public class UserFrame extends JFrame implements ActionListener{
	//�û���������
	static User aUser=null;
	static String title;
	private static final long serialVersionUID = 1L;
	
	//�û����ݵĴ���
	public UserFrame(User a) {
		aUser = a;
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("�û�����");
		menuBar.add(mnNewMenu);
		//�������administrator,��ע�����û�����˵�
		if(!aUser.getRole().equals("administrator"))
			mnNewMenu.setEnabled(false);
		JMenuItem menuItem = new JMenuItem("�����û�");
		mnNewMenu.add(menuItem);
		//�����û���Ӧ
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelfFrame addusers = new SelfFrame(1);
				addusers.setSize(430, 350);
				addusers.setLocationRelativeTo(null);
				addusers.setVisible(true);
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("ɾ���û�");
		mnNewMenu.add(menuItem_1);
		//ɾ���û���Ӧ
		menuItem_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SelfFrame addusers = new SelfFrame(2);
				addusers.setSize(430, 350);
				addusers.setLocationRelativeTo(null);
				addusers.setVisible(true);
			}
		});
		
		JMenuItem menuItem_2 = new JMenuItem("�޸��û�");
		mnNewMenu.add(menuItem_2);
		//�޸��û���Ӧ
		menuItem_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SelfFrame addusers = new SelfFrame(3);
				addusers.setSize(430, 350);
				addusers.setLocationRelativeTo(null);
				addusers.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("��������");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("�����ϴ�");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem);
		//�ж������browser����ע���������ϴ��˵�
		if(aUser.getRole().equals("browser"))
			mntmNewMenuItem.setEnabled(false);
		mntmNewMenuItem.addActionListener(new loadfile());
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("��������");
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new downloadfile());
		
		JMenu mnNewMenu_2 = new JMenu("������Ϣ����");
		menuBar.add(mnNewMenu_2);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("��Ϣ�޸�");
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new passwordChange());
	}
	
	//�����ļ�
	static class downloadfile implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			FileFrame fileFrame = new FileFrame(aUser,2);
			fileFrame.setTitle("�ļ��������");
			fileFrame.setSize(500,400);
			fileFrame.setLocationRelativeTo(null);
			fileFrame.setVisible(true);
		}
	}
	
	//�ϴ��ļ�
	static class loadfile implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			FileFrame fileFrame = new FileFrame(aUser,1);
			fileFrame.setSize(500, 400);
			fileFrame.setLocationRelativeTo(null);
			fileFrame.setTitle("�ļ��������");
			
			fileFrame.setVisible(true);
		}
		
	}
	//�޸ĸ�����Ϣ
	static class passwordChange implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			MainFrame apasswordFrame = new MainFrame(aUser);
			apasswordFrame.setSize(500,400);
			apasswordFrame.setLocationRelativeTo(null);
			apasswordFrame.setTitle("������Ϣ����");
			
			apasswordFrame.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {}
	
	public void actionPerformed(ActionEvent e) {}
}
