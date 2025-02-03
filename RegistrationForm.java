package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import GUI.LoginU;
import Files.FileIO;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationForm extends JFrame implements ActionListener{
	Font font20 = new Font("cambria",Font.BOLD,20);
	JLabel userNameLabel, passLabel,emailLabel ;
	JTextField userNameTextField,emailTextField;
	JPasswordField userPassField;
	JButton submitBtn,backBtn;
	public RegistrationForm()
	{
		super("User Registration Form");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);//w,h
		this.setLocation(350,200);//w,h
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(244,0,0));
		
		userNameLabel = new JLabel("UserName");
		userNameLabel.setBounds(150,70,100,20); 
		userNameLabel.setFont(font20);
		userNameLabel.setForeground(Color.BLACK);
		this.add(userNameLabel);
		
		userNameTextField = new JTextField();
        userNameTextField.setFont(new Font("cambria", Font.PLAIN, 14));
        userNameTextField.setBounds(150, 100, 190, 30); 
        this.add(userNameTextField);
	   
	     emailLabel = new JLabel("Email");
        emailLabel.setFont(font20);
        emailLabel.setBounds(150,130,190, 30);  
		emailLabel.setForeground(Color.BLACK);
        this.add(emailLabel);
		
		emailTextField= new JTextField();
		emailTextField.setFont(new Font("cambria", Font.PLAIN, 14));
		emailTextField.setBounds(150,165,190,30);
		this.add(emailTextField);
		
		passLabel = new JLabel("Password");
        passLabel.setFont(font20);
        passLabel.setBounds(150, 200,190,30);  
		passLabel.setForeground(Color.BLACK);
        this.add(passLabel);
		
		userPassField=new JPasswordField();
		userPassField.setFont(new Font("cambria", Font.PLAIN, 14));
		userPassField.setBounds(150,235,190,30);
		this.add(userPassField);
		
		submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        submitBtn.setBounds(140,275,100,30);  
        submitBtn.addActionListener(this);
        this.add(submitBtn);
		
		backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        backBtn.setBounds(250,275, 100,30); 
        backBtn.addActionListener(this);
        this.add(backBtn);
		 
		
		this.setVisible(true);
		
	}

   public void actionPerformed(ActionEvent e){
	if(submitBtn == e.getSource()){
			System.out.println("SUBMIT CLICKED");
			String userName= userNameTextField.getText();
			String email= emailTextField.getText();
			String pass= new String(userPassField.getText());
			
			if(!userNameTextField.getText().isEmpty()&&
			   !emailTextField.getText().isEmpty()&&
			   !userPassField.getText().isEmpty())
			   {
				 try {
					 FileWriter writer = new FileWriter("./Files/user.txt",true);
					 String line = userName+ ";" +email +";" +pass+ "\n";
					 writer.write(line);
			         writer.flush();
			        writer.close();
				 }
				 
				 catch(Exception ex){
			    System.out.println("File Not Found");
			   }
	
	}

}
			else if(backBtn == e.getSource()){
	       LoginU loginU = new LoginU();
		   this.dispose();
}
   }
}