package qi;

import cs.whut.frame.LoginFrame;

public class MainGUI {
	public static void main(String [] args){
		LoginFrame login=new LoginFrame();
		login.setTitle("ÏµÍ³µÇÂ¼");
		login.setSize(350,225);
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}

}
