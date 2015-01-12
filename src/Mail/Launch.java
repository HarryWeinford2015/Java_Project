package Mail;


public class Launch {
	
	public Launch() {
		
	}
	
	public static void main(final String[] args) throws Exception {
		
		
		//LoginWindow wdw = new LoginWindow();
		//wdw.setVisible(true);
		
		
		
		String host = "pop.gmx.net";
		String username = "javaproject@gmx.de";
		
		String password = "javamail";
		//String port;
		
		//port = "995";
		
		
		ReceiveMail.receive(host, username, password);
		
	
		
		
	
	}
	
}
	


