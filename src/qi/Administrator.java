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
	//写用户信息到存储
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
	System.out.println("1.修改用户");
	System.out.println("2.删除用户");
	System.out.println("3.新增用户");
	System.out.println("4.列出用户");
	System.out.println("5.下载文件");
	System.out.println("6.文件列表");
	System.out.println("7.修改（本人）密码");
	System.out.println("8.退出");
	int num;
	String str=null;
    String name=null;
	String password=null;
	String role=null;
	int flag=0;
	Enumeration<User>user = null;
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
	case 1:{//修改用户
		System.out.println("请输入用户名：");
		try {
			name=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("请输入口令:");
	try {
		password=br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("请输入角色：");
	try {
		role=br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try{
	if(DataProcessing.updateUser(name, password, role)==false){
		System.out.println("修改用户失败！");
	}else System.out.println("修改用户成功!");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	break;
	}
		case 2:{//删除用户
			System.out.println("请输入用户名：");
			try {
				name=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("请输入口令：");
			try {
				password=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("请输入角色：");
			try {
				role=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
			if(DataProcessing.updateUser(name, password, role)==false)
				System.out.println("删除用户失败！");
			else System.out.println("删除用户成功！");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
			case 3:{//新增用户
				System.out.println("请输入用户名：");
				try {
					name=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("请输入口令：");
				try {
					password=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("请输入角色：");
				try {
					role=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
				if(DataProcessing.insertUser(name, password, role)==false)
					System.out.println("新增用户失败！");
				else System.out.println("新增用户成功！");
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
				case 4:{//列出用户
					try{
						listUser();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
					break;
				}
				case 5:{//下载文件
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
				case 6:{//文件列表
					try{
					showFileList();
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					}
				case 7:{//修改（本人）密码
					try {
						password=br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try{
					if(DataProcessing.updateUser(name, password, role)==false)
						System.out.println("修改密码成功！");
					else System.out.println("修改密码失败！");
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 8:{
					//退出
					System.out.println("系统退出，谢谢使用！");
				}
				break;
				default:{System.out.println("输入菜单编号错误！");}
	

	}
  
  }
}

