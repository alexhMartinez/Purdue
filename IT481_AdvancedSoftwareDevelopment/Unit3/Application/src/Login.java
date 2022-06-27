import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JTextField serverField = new JTextField(ServerConfig.portAndserviceName);
	JTextField dataBaseField = new JTextField(ServerConfig.database);
	
	
	JLabel messageLabel = new JLabel("Welcome! Please Log In!");
	JLabel userIDLabel = new JLabel("User ID:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel serverLabel = new JLabel("Server");
	JLabel dataBaseLabel = new JLabel("DataBase");
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	Login(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		serverLabel.setBounds(50,200,75,25);
		dataBaseLabel.setBounds(50,250,75,25);
		
		messageLabel.setBounds(50,400,400,25);
		messageLabel.setFont(new Font(null,Font.ITALIC,20));
		
		userIDField.setBounds(175,100,200,25);
		userPasswordField.setBounds(175,150,200,25);
		serverField.setBounds(175,200,200,25);
		dataBaseField.setBounds(175,250,200,25);
		
		loginButton.setBounds(175,300,75,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(300,300,75,25);
		resetButton.addActionListener(this);
		
		frame.add(messageLabel);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(serverLabel);
		frame.add(dataBaseLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(serverField);
		frame.add(dataBaseField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		//temporary block on field edit as there are no other sources available
		serverField.setEditable(false);
		dataBaseField.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//reset fields in login window
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					//return success message if login is correct
					messageLabel.setText("Login Successful");
					frame.dispose();
					@SuppressWarnings("unused")
					DataPage dataPage = new DataPage(userID,password);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Wrong Username");
			}
		}
	}

}
