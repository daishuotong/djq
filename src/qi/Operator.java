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
			System.out.println("该档案号已被使用");
			return false;			
		}
		File tempFile=new File(filename);
		if(!tempFile.exists()){
			System.out.println("该文件已存在");
			return false;
		}
			
		String Filename=tempFile.getName();
		BufferedInputStream infile=new BufferedInputStream(new FileInputStream(tempFile));
		BufferedOutputStream targetfile=new BufferedOutputStream(new FileOutputStream(uploadpath+Filename,true));
		
		while(true){
			int byteRead=infile.read(buffer);//从文件读数据给字节数组
			if(byteRead==-1)//在文件尾，无数据可读
				break;//退出循环
			targetfile.write(buffer, 0, byteRead);//将读到的数据写入目标文件
		}
		infile.close();
		targetfile.close();
		if(DataProcessing.insertDoc(ID, creator, timestamp, description, Filename)==true)			
		return true;
		else
			return false;
	}
	public void showmenu() throws IOException, SQLException {
		System.out.println("1.上传文件");	
		System.out.println("2.下载文件");
		System.out.println("3.文件列表");
		System.out.println("4.修改密码");
		System.out.println("5.退出");
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
		case 1:{//上传文件
			System.out.println("上传文件");
			String filename = null;
			String ID = null;
			String description = null;
			System.out.println("请输入源文件名：");
			try{
			filename=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			System.out.println("请输入档案号：");
			try{
			ID=br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
			System.out.println("请输入档案描述：");
			try{
			description=br.readLine();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try{
			  if(uploadFile(filename, ID, description)==false)
			    System.out.println("上传失败");
			  
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();}
			System.out.println("文件上传成功！");
			break;
		}
		case 2:{//下载文件
			System.out.println("请输入档案号：");
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
		case 3:{//文件列表
			try{
			showFileList();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 4:{
			//修改密码
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
		case 5 :{//退出
			System.out.println("系统退出，谢谢使用！");
		}
		break;
		default:{System.out.println("输入编号错误！");}
		}
	}
}
	