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
		
           String system="����ϵͳ";
           String menu="��ѡ��˵���";
           String exit="ϵͳ�˳���ллʹ�ã�";
           String infos="***��ӭ����"+system+"****\n\t"+
                                          "1.��¼\n\t   2.�˳�\n\t"+
                                          "*****************";
          
           System.out.println(infos);
           BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

			 while (true){	
				 System.out.print(menu);
				 try {
					str=br.readLine();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				 num=Integer.parseInt(str);
				 switch(num){
				 case 1://
					 System.out.println("�������û�����");
					 try {
						name=br.readLine();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					 System.out.println("��������");
					 try {
						password=br.readLine();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
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
				    	 System.out.println("û�в�ѯ�����û��������û����������Ƿ�������ȷ!");
				     break;
				 case 2://
					 System.out.println("exit");
					 System.exit(0);
				     break;
				 default:
					 System.out.println("�˵��������");
				 }
			 } 
}
}
