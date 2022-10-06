import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * check email pattern matches
	 */

	public static boolean emailPatternMatch(String email) {
		return Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
				.matcher(email)
				.matches();
	}
	
	/**
	 * Create the frame.
	 */
	
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Enter Email:");
		lblEmail.setBounds(84, 96, 79, 16);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(162, 90, 130, 26);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Enter Password:");
		lblPassword.setBounds(64, 124, 99, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 119, 130, 26);
		contentPane.add(passwordField);
		
		JButton btnLoginSubmit = new JButton("Submit");
		btnLoginSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String passwordStr = new String(passwordField.getPassword());
				
				/**
				 * hash map for login credentials
				 */
				
				HashMap<String, String> ACL = new HashMap<String, String>();

				ACL.put("password1","login1@gmail.com");
				ACL.put("password2","login2@hotmail.com");
				
				/**
				 * check email
				 */
				
				if(textEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please input email", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				else if(emailPatternMatch(textEmail.getText()) == false) {
					
					JOptionPane.showMessageDialog(null, "Please input your full valid email address", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				else if(!ACL.containsValue(textEmail.getText())) {
					
					JOptionPane.showMessageDialog(null, "There is no record of this email", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				/**
				 * check password
				 */
				
				else if(passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Please input password", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				else if(!ACL.containsKey(passwordStr)) {
					JOptionPane.showMessageDialog(null, "The password does not match this account", "Input Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "Welcome!");
					return;
				}
			}
		});
		btnLoginSubmit.setBounds(327, 237, 117, 29);
		contentPane.add(btnLoginSubmit);
	}
}
