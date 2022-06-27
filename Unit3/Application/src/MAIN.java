
public class MAIN {

	public static void main(String[] args) {
		
		ACL idandPasswords = new ACL();
		
		@SuppressWarnings({ "unused", "unchecked" })
		//warning flagged, but is being used
		Login loginPage = new Login(idandPasswords.getLoginInfo());

	}

}
