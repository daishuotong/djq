package cs.whut.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.CardLayout;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import qi.*;

public class FileFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	static String uploadpath="e:\\OOP\\uploadfile\\";
	static String downloadpath="e:\\OOP\\downloadfile\\";
	
	@SuppressWarnings("unused")
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static Object[][]  data  = new Object[20][5];
	public static int k=0;
	static File file1;
	
	public FileFrame(User a,int index1) {
		setTitle("文件");
		getContentPane().setLayout(new CardLayout(1,0));
		
		//在表格中加入内容
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "1");
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("文件下载", null, panel_1, null);
		panel_1.setLayout(null);
		//数据存储表头
		String columnNames[] = {"档案号","创建者","时间","文件名","描述"};
		
		Enumeration<Doc> e;
 		int i=0;
 		try {
			e = DataProcessing.getAllDocs();
			Doc doc;
			while(e.hasMoreElements())
			{
				k++;
				doc = e.nextElement();
				for(int j=0;j<5;j++)
				{
					switch(j)
					{
					case 0:data[i][j]=doc.getID();
					break;
					case 1:data[i][j]=doc.getCreator();
					break;
					case 2:data[i][j]=doc.getTimestamp();
					break;
					case 3:data[i][j]=doc.getFilename();
					break;
					case 4:data[i][j]=doc.getDescription();
					break;
					}
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
 		
 		//将信息存入表中
 		final JTable table = new JTable(data,columnNames);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(null);
		table.setCellSelectionEnabled(true);
		
		TableColumn column = null;
		table.setBounds(0, 0, 5, 3);
		int columns = table.getColumnCount();
		for(int k=0;k<columns;k++)
		{
			column = table.getColumnModel().getColumn(i);
			//将每一列的默认宽度设置为100
			column.setPreferredWidth(100);
		}
 		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(82, 10, 278, 150);
		panel_1.add(scrollPane);
		
		//设置table中的数据单元为不可编辑
		//DefaultTableModel t1;
		//int i1,j1;
		//for(i1=0;i1<table.getRowCount();i1++){
		//	for(j1=0;j1<table.getColumnCount();j1++){
		//		t1=new DefaultTableModel(table.getRowCount(),table.getColumnCount()){
		//			boolean isCellEditable(i1,j1){
		//				return false;
		//			}
		//		};
		//		table.setModel(t1);
		//	}
		//}
		 
		
		JButton button = new JButton("下载");
		button.setBounds(87, 187, 93, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(267, 187, 93, 23);
		panel_1.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("文件上传", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("档案号");
		label_1.setBounds(111, 24, 36, 15);
		panel_2.add(label_1);
		textField = new JTextField();
		textField.setBounds(203, 21, 103, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel Label_2 = new JLabel("档案描述");
		Label_2.setBounds(111, 69, 48, 15);
		panel_2.add(Label_2);
		textField_1 = new JTextField();
		textField_1.setBounds(203, 58, 103, 91);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("档案文件名");
		label_3.setBounds(111, 162, 60, 15);
		panel_2.add(label_3);
		textField_2 = new JTextField();
		textField_2.setBounds(203, 159, 103, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("打开");
		btnNewButton.setBounds(331, 158, 68, 23);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new openfile());
		
		JButton button_2 = new JButton("上传");
		button_2.setBounds(126, 199, 78, 23);
		panel_2.add(button_2);
		button_2.addActionListener(new loadfile());
		if(a.getRole().equals("browser"))
			tabbedPane.setEnabledAt(1, false);
		
		JButton button_3 = new JButton("取消");
		button_3.setBounds(249, 199, 78, 23);
		panel_2.add(button_3);
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//证实是否进行下载操作的提示
				int copy = JOptionPane.showConfirmDialog(null, "确定要下载选择的文件吗？","确定",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(copy  == JOptionPane.YES_OPTION){
					
					Doc bUser = null;
					byte[] buffer = new byte[1024];
					int row = table.getSelectedRow();
					String x = (String) table.getValueAt(row, 0);
					
					try{
						try{
							bUser=DataProcessing.searchDoc(x);
						}catch(SQLException e1){
							e1.printStackTrace();
						}
						File file = new File(bUser.getFilename());
						FileInputStream fis = new FileInputStream(uploadpath+file.getName());
						BufferedInputStream infile = new BufferedInputStream(fis);
						JFileChooser fileChooser = new JFileChooser();
						int result = fileChooser.showSaveDialog(null);
						if(result ==JFileChooser.APPROVE_OPTION){
							fileChooser.setVisible(true);
							File path = fileChooser.getCurrentDirectory();
							FileOutputStream fos = new FileOutputStream(path+"\\"+file.getName());
							BufferedOutputStream dos = new BufferedOutputStream(fos);
							while(true)        
							{
								int byteRead = infile.read(buffer);
								if(byteRead==-1)
									break;
								dos.write(buffer, 0, byteRead);
							}
							infile.close();
							dos.close();
						}
					}catch (IOException e1) {
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "文件下载成功！");
				}
			
			}
		});
		if(index1==1)
			tabbedPane.setSelectedComponent(panel_2);
		else
			tabbedPane.setSelectedComponent(panel_1);
	}
	
	
	//下载文件
	public boolean downloadfile(String x) throws IOException
	{
		byte[] buffer = new byte[1024];
		Doc doc;
		try {
			doc = DataProcessing.searchDoc(x);
			if(doc==null)                           //判断是否存在要下载的档案
			{
				JOptionPane.showMessageDialog(null, "不存在该档案", "提示", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			//用于读取文件名
			File file = new File(doc.getFilename());  
			//输入缓冲流
			//FileInputStream fis = new FileInputStream(uploadpath+file.getName());
			FileInputStream fis = new FileInputStream(uploadpath+file.getName());
			BufferedInputStream infile = new BufferedInputStream(fis);
			//输出缓冲流
			FileOutputStream fos = new FileOutputStream(downloadpath+file.getName());
			BufferedOutputStream dos = new BufferedOutputStream(fos);
			
			//写入文件
			while(true)        
			{
				int byteRead = infile.read(buffer);
				if(byteRead==-1)
					break;
				dos.write(buffer, 0, byteRead);
			}
			infile.close();
			dos.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return true;
	}	
	
	//打开本地文件并选择要存储的位置
	static class openfile implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JFileChooser jFileChooser = new JFileChooser();
			int result = jFileChooser.showSaveDialog(null);
			
			if(result ==JFileChooser.APPROVE_OPTION){
				jFileChooser.setVisible(true);
				file1 = jFileChooser.getSelectedFile();
				String path = file1.getPath();
				textField_2.setText(path);
			}
		}
	}
	
	
	static class loadfile implements ActionListener
	{
		byte[] buffer = new byte[1024];
		public void actionPerformed(ActionEvent e) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				try {
					DataProcessing.insertDoc(textField.getText(), "jack", timestamp, textField_1.getText(), textField_2.getText());
					//输入缓冲流
					FileInputStream fis;
					try {
						fis = new FileInputStream(textField_2.getText());
						BufferedInputStream infile = new BufferedInputStream(fis);
						//输出缓冲流
						FileOutputStream fos = new FileOutputStream(uploadpath+file1.getName());
						BufferedOutputStream dos = new BufferedOutputStream(fos);
						
						//写入文件
						while(true)        
						{
							int byteRead;
							try {
								byteRead = infile.read(buffer);
								if(byteRead==-1)
									break;
								dos.write(buffer, 0, byteRead);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
						}
						try {
							infile.close();
							dos.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "文件上传成功！");
				File file2 = file1;
				for(int j=0;j<5;j++)
				{
					switch(j)
					{
					case 0:data[k][j]=textField.getText();
					break;
					case 1:data[k][j]="jack";
					break;
					case 2:data[k][j]=timestamp;
					break;
					case 3:data[k][j]=file2.getName();
					break;
					case 4:data[k][j]=textField_1.getText();
					break;
					}
				}
				k++;             
					
		}
	}
	
	public static void main(String[] args) {}
	
	public void actionPerformed(ActionEvent e){}
}
	
	
	

		
		
		
		
		
