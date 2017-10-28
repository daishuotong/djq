package qi;

import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Browser extends User{
	Browser(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String password;
	private String role;
	public  void showmenu() throws IOException, SQLException{
		System.out.println("1.下载文件");
	System.out.println("2.文件列表");
	System.out.println("3.修改密码");
	System.out.println("4.退出");
	int num;
	String str=null;
	String name=null;
	String password=null;
	String role=null;
	int flag=0;
	Enumeration<User>user;
	System.out.println("请选择菜单编号:");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	try {
		str=br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
		num=Integer.parseInt(str);
		
	switch(num){
	case 1:{
		//下载文件
		System.out.println("请输入文件名称：");
		try {
			str=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			downloadFile(str);
		if(downloadFile(str)==false)
			System.out.println("文件下载失败！");
			else System.out.println("文件下载成功！");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		
	}
	case 2:{
		//文件列表
		try{
		showFileList();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	}
	case 3:{
		//修改密码
		System.out.println("请输入新密码；");
		try {
			password=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
		if(changeUserInfo()!=false)
			System.out.println("修改密码成功！");
		else System.out.println("修改密码失败！");
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	}
	case 4 :{
		//退出
		System.out.println("系统退出，谢谢使用！");
	}
	break;
	default :{
		System.out.println("输入编号错误");
	}
	}
	
		
		}
	
			
	}

