import java.util.HashMap;

public class ACL {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	ACL() {
		//fill appropriate passwords as designated in server
		logininfo.put("User_Sales","INPUT_PASSWORD");
		logininfo.put("User_HR","INPUT_PASSWORD");
		logininfo.put("User_CEO","INPUT_PASSWORD");
		//Admin account sa
		logininfo.put("sa","INPUT_PASSWORD");
		//used to test DB access when no access is available
		logininfo.put("No_DB_Access","test");
	}
	
	@SuppressWarnings("rawtypes")
	protected HashMap getLoginInfo() {
		return logininfo;
	}

}
