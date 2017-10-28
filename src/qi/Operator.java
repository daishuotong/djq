package qi;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Operator extends User{
	Operator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String password;
	private String role;
	
	String uploadpath="e:\\OOP\\uploadfile\\";
	String downloadpath="e:\\OOP\\downloadfile\\";
	
	public boolean uploadFile(String filename,String ID,String description) throws IOException, SQLException{
		
		String creator=null; 
		creator=getName();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		byte[] buffer =new byte[1024];
		Doc doc=DataProcessing.searchDoc(ID);
		if(doc!=null)
		{
			System.out.println("�õ������ѱ�ʹ��");
			return false;			
		}
		File tempFile=new File(filename);
		if(!tempFile.exists()){
			System.out.println("���ļ��Ѵ���");
			return false;
		}
			
		String Filename=tempFile.getName();
		BufferedInputStream infile=new BufferedInputStream(new FileInputStream(tempFile));
		BufferedOutputStream targetfile=new BufferedOutputStream(new FileOutputStream(uploadpath+Filename,true));
		
		while(true){
			int byteRead=infile.read(buffer);//���ļ������ݸ��ֽ�����
			if(byteRead==-1)//���ļ�β�������ݿɶ�
				break;//�˳�ѭ��
			targetfile.write(buffer, 0, byteRead);//������������д��Ŀ���ļ�
		}
		infile.close();
		targetfile.close();
		if(DataProcessing.insertDoc(ID, creator, timestamp, description, Filename)==true)			
		return true;
		else
			return false;
	}
	public void showmenu() throws IOException, SQLException {
		System.out.println("1.�ϴ��ļ�");	
		System.out.println("2.�����ļ�");
		System.out.println("3.�ļ��б�");
		System.out.println("4.�޸�����");
		System.out.println("5.�˳�");
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
		case 1:{//�ϴ��ļ�
			System.out.println("�ϴ��ļ�");
			String filename = null;
			String ID = null;
			String description = null;
			System.out.println("������Դ�ļ�����");
			try{
			filename=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			System.out.println("�����뵵���ţ�");
			try{
			ID=br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
			System.out.println("�����뵵��������");
			try{
			description=br.readLine();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try{
			  if(uploadFile(filename, ID, description)==false)
			    System.out.println("�ϴ�ʧ��");
			  
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();}
			System.out.println("�ļ��ϴ��ɹ���");
			break;
		}
		case 2:{//�����ļ�
			System.out.println("�����뵵���ţ�");
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
		case 3:{//�ļ��б�
			try{
			showFileList();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 4:{
			//�޸�����
			try {
				password=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
			if(DataProcessing.updateUser(name, password, role)==false)
				System.out.println("�޸�����ɹ���");
			else System.out.println("�޸�����ʧ�ܣ�");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 5 :{//�˳�
			System.out.println("ϵͳ�˳���ллʹ�ã�");
		}
		break;
		default:{System.out.println("�����Ŵ���");}
		}
	}
}
	