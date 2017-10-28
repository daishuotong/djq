package qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.*;





public class main {
	public static void main(String[] args) throws SQLException, IOException {
		
		   int num;
		   String name = null,str = null,password = null;
		   User user = null;
		   int flag = 0;
		
           String system="档案系统";
           String menu="请选择菜单：";
           String exit="系统退出，谢谢使用！";
           String infos="***欢迎进入"+system+"****\n\t"+
                                          "1.登录\n\t   2.退出\n\t"+
                                          "*****************";
          
           System.out.println(infos);
           BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

			 while (true){	
				 System.out.print(menu);
				 try {
					str=br.readLine();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				 num=Integer.parseInt(str);
				 switch(num){
				 case 1://
					 System.out.println("请输入用户名：");
					 try {
						name=br.readLine();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					 System.out.println("请输入口令：");
					 try {
						password=br.readLine();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					 try{
					 user=DataProcessing.searchUser(name, password);
					 }catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
				     if(user!=null)
						try {
							user.showmenu();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					else
				    	 System.out.println("没有查询到此用户！请检查用户名或密码是否输入正确!");
				     break;
				 case 2://
					 System.out.println("exit");
					 System.exit(0);
				     break;
				 default:
					 System.out.println("菜单编码错误");
				 }
			 } 
}
}
