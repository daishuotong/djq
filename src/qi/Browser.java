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
		System.out.println("1.�����ļ�");
	System.out.println("2.�ļ��б�");
	System.out.println("3.�޸�����");
	System.out.println("4.�˳�");
	int num;
	String str=null;
	String name=null;
	String password=null;
	String role=null;
	int flag=0;
	Enumeration<User>user;
	System.out.println("��ѡ��˵����:");
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
		//�����ļ�
		System.out.println("�������ļ����ƣ�");
		try {
			str=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			downloadFile(str);
		if(downloadFile(str)==false)
			System.out.println("�ļ�����ʧ�ܣ�");
			else System.out.println("�ļ����سɹ���");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		
	}
	case 2:{
		//�ļ��б�
		try{
		showFileList();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	}
	case 3:{
		//�޸�����
		System.out.println("�����������룻");
		try {
			password=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
		if(changeUserInfo()!=false)
			System.out.println("�޸�����ɹ���");
		else System.out.println("�޸�����ʧ�ܣ�");
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	}
	case 4 :{
		//�˳�
		System.out.println("ϵͳ�˳���ллʹ�ã�");
	}
	break;
	default :{
		System.out.println("�����Ŵ���");
	}
	}
	
		
		}
	
			
	}

