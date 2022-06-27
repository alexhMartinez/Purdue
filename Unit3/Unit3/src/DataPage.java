import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DataPage {
	
	JFrame frame = new JFrame();
	
	JButton connectButton = new JButton("Connect");
	JButton customerCountButton = new JButton("Pull Report");
	JButton companyNamesButton = new JButton("Pull Report");
	JButton countOrdersButton = new JButton("Pull Report");
	JButton listOrderNamesButton = new JButton("Pull Report");
	JButton countEmployeesButton = new JButton("Pull Report");
	JButton listEmployeeNamesButton = new JButton("Pull Report");
	JButton quitButton = new JButton("Exit");
	
	JLabel dataLabel = new JLabel();
	JLabel connectLabel = new JLabel("(Required) Connect To DataBase First");
	JLabel customerCountLabel = new JLabel("Count Customers");
	JLabel companyNamesLabel = new JLabel("List Company Names");
	JLabel countOrdersLabel = new JLabel("Count Orders");
	JLabel listOrderNamesLabel = new JLabel("List Order Names");
	JLabel countEmployeesLabel = new JLabel("Count Employees");
	JLabel listEmployeeNamesLabel = new JLabel("List Employee Names");
	
	// userID and password passes login credentials to server for query access
	DataPage(String userID, String password){
		
		dataLabel.setBounds(0,0,200,35);
		dataLabel.setFont(new Font(null,Font.ITALIC,25));
		dataLabel.setText("Hello "+ userID + "!");
		connectButton.setBackground(Color.red);
		
		connectButton.setBounds(25,50,100,25);
		customerCountButton.setBounds(25,100,100,25);
		companyNamesButton.setBounds(25,150,100,25);
		countOrdersButton.setBounds(25,200,100,25);
		listOrderNamesButton.setBounds(25,250,100,25);
		countEmployeesButton.setBounds(25,300,100,25);
		listEmployeeNamesButton.setBounds(25,350,100,25);
		
		connectLabel.setBounds(150,50,300,25);
		customerCountLabel.setBounds(150,100,300,25);
		companyNamesLabel.setBounds(150,150,300,25);
		countOrdersLabel.setBounds(150,200,300,25);
		listOrderNamesLabel.setBounds(150,250,300,25);
		countEmployeesLabel.setBounds(150,300,300,25);
		listEmployeeNamesLabel.setBounds(150,350,300,25);
		
		quitButton.setBounds(200,425,100,25);
		
		frame.add(dataLabel);
		frame.add(connectButton);
		frame.add(connectLabel);
		frame.add(customerCountButton);
		frame.add(customerCountLabel);
		frame.add(companyNamesButton);
		frame.add(companyNamesLabel);
		frame.add(countOrdersButton);
		frame.add(countOrdersLabel);
		frame.add(listOrderNamesButton);
		frame.add(listOrderNamesLabel);
		frame.add(countEmployeesButton);
		frame.add(countEmployeesLabel);
		frame.add(listEmployeeNamesButton);
		frame.add(listEmployeeNamesLabel);
		frame.add(quitButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		// dbURL to call server uses login credentials and specified ServerConfig
		String dbURL = 
				"jdbc:"+ServerConfig.host+"://"+ServerConfig.portAndserviceName
				+";database="+ServerConfig.database+";user="+userID+";password="+password
				+";encrypt="+ServerConfig.encrypt
				+";trustServerCertificate="+ServerConfig.trustServerCertificate
				+";loginTimeout="+ServerConfig.loginTimeout+";";
		DataBase database = new DataBase(dbURL);
		
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				//tests account access to server
				Connection connectionTest = null;
				try{
					connectionTest = DriverManager.getConnection(dbURL);
					JOptionPane.showMessageDialog(null, "Connected");			
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		customerCountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String returnedValue = database.getCustomerCount();
					JOptionPane.showMessageDialog(null, "The customer count is: " + returnedValue);									
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		companyNamesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String returnedValue = database.getCompanyNames();
					JOptionPane.showMessageDialog(null, "Customer names: " + returnedValue);											
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		countOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String returnedValue = database.getOrderCount();
					JOptionPane.showMessageDialog(null, "The order count is: " + returnedValue);										
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		listOrderNamesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{			
					String returnedValue = database.getShipNames();	
					JOptionPane.showMessageDialog(null, "Order ship names: " + returnedValue);											
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		countEmployeesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String returnedValue = database.getEmployeeCount();
					JOptionPane.showMessageDialog(null, "The employee count is: " + returnedValue);									
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		listEmployeeNamesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{		
					String returnedValue = database.getEmployeeNames();	
					JOptionPane.showMessageDialog(null, "Employee names: " + returnedValue);										
				} 
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}