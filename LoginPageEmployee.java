package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginPageEmployee extends JFrame implements ActionListener{
	Font font20 = new Font("cambria",Font.PLAIN,20);
	Font font18 = new Font("cambria",Font.PLAIN,18);
	Font font25 = new Font("cambria",Font.BOLD,25);
	Font font30 = new Font("cambria",Font.PLAIN,30);
	Font font15 = new Font("cambria",Font.PLAIN,15);
	
	JLabel userLabel, passLabel, userImage;
	JTextField userTextField;
	JPasswordField userPassField;
	JButton loginBtn,registerBtn;
	
	public LoginPageEmployee(){
		super("Admin Login Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setLocation(350,200);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0,100,100));
		
		userLabel = new JLabel("Welcome");
		userLabel.setBounds(140,55,350,30);
		userLabel.setFont(font30);
		userLabel.setForeground(Color.PINK);
		this.add(userLabel);
		
		
		
		
		//User Name
		userLabel = new JLabel("UserName: ");
		userLabel.setBounds(9,120,350,30); 
		userLabel.setFont(font18);
		userLabel.setForeground(Color.BLACK);
		this.add(userLabel);
		
		
		userTextField = new JTextField();
		userTextField.setBounds(100,120,200,30);
		userTextField.setFont(font20);
		this.add(userTextField);

		
		//User Password
		userLabel = new JLabel("PassWord: ");
		userLabel.setBounds(9,160,350,30);
		userLabel.setFont(font18);
		userLabel.setForeground(Color.BLACK);
		this.add(userLabel);
		
		
		 userPassField = new JPasswordField();
		 userPassField.setBounds(100,160,200,30);
		 userPassField.setFont(font20);
		 userPassField.setEchoChar('#');
		 this.add(userPassField);
		
		//Login button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(150,200,100,30);
		loginBtn.setFont(font25);
		loginBtn.setBackground(new Color(0,255,255));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.addActionListener(this);
		this.add(loginBtn);
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == loginBtn){
			String name = "admin";
			String pass = "1234";
			
			
			String userName = userTextField.getText();
			String password = String.valueOf( userPassField.getPassword());
			
			if(userName.equals(name) && password.equals(pass)){	
				JOptionPane.showMessageDialog(this,"Welcome "+ userTextField.getText() +" :)");
				 EmployeeManagementPage employeeManagementPage= new EmployeeManagementPage();
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"Wrong User Name or Password?","Error",JOptionPane.ERROR_MESSAGE);
			}
			this.dispose();
		}
		
	}
}
