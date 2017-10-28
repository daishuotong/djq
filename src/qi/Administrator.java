package qi;

import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Administrator extends User {

Administrator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

public boolean changeUserInfo(String name,String password,String role) throws SQLException{
	//д�û���Ϣ���洢
	return(DataProcessing.updateUser(name, password, role));
	
}
public static boolean delete(String name,String password,String role) throws SQLException{
	return(DataProcessing.updateUser(name, password, role));
}
public boolean addUser(String name,String password,String role) throws SQLException{
	return (DataProcessing.insertUser(name, password, role));
}
public void listUser()throws SQLException{
Enumeration<User> e =DataProcessing.users.elements();
User user;
while(e.hasMoreElements()){
	user=e.nextElement();
	System.out.println("Name:"+user.getName()+"\t Password:"+user.getPassword()+"\tRole:"+user.getRole());
}	
}
public void showmenu() throws SQLException, IOException{
	System.out.println("1.�޸��û�");
	System.out.println("2.ɾ���û�");
	System.out.println("3.�����û�");
	System.out.println("4.�г��û�");
	System.out.println("5.�����ļ�");
	System.out.println("6.�ļ��б�");
	System.out.println("7.�޸ģ����ˣ�����");
	System.out.println("8.�˳�");
	int num;
	String str=null;
    String name=null;
	String password=null;
	String role=null;
	int flag=0;
	Enumeration<User>user = null;
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
	case 1:{//�޸��û�
		System.out.println("�������û�����");
		try {
			name=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("���������:");
	try {
		password=br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("�������ɫ��");
	try {
		role=br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try{
	if(DataProcessing.updateUser(name, password, role)==false){
		System.out.println("�޸��û�ʧ�ܣ�");
	}else System.out.println("�޸��û��ɹ�!");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	break;
	}
		case 2:{//ɾ���û�
			System.out.println("�������û�����");
			try {
				name=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("��������");
			try {
				password=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("�������ɫ��");
			try {
				role=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
			if(DataProcessing.updateUser(name, password, role)==false)
				System.out.println("ɾ���û�ʧ�ܣ�");
			else System.out.println("ɾ���û��ɹ���");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
			case 3:{//�����û�
				System.out.println("�������û�����");
				try {
					name=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("��������");
				try {
					password=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("�������ɫ��");
				try {
					role=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
				if(DataProcessing.insertUser(name, password, role)==false)
					System.out.println("�����û�ʧ�ܣ�");
				else System.out.println("�����û��ɹ���");
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
				case 4:{//�г��û�
					try{
						listUser();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
					break;
				}
				case 5:{//�����ļ�
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
				case 6:{//�ļ��б�
					try{
					showFileList();
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					}
				case 7:{//�޸ģ����ˣ�����
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
				case 8:{
					//�˳�
					System.out.println("ϵͳ�˳���ллʹ�ã�");
				}
				break;
				default:{System.out.println("����˵���Ŵ���");}
	

	}
  
  }
}

