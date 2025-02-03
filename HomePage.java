package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import GUI.RoomManagementPage;
import GUI.LoginU;

public class HomePage extends JFrame implements ActionListener {
	Font font20 = new Font("cambria",Font.PLAIN,20);
	Font font18 = new Font("cambria",Font.PLAIN,18);
	Font font50 = new Font("cambria",Font.BOLD,50);
	Font font30 = new Font("cambria",Font.PLAIN,30);
	Font font40 = new Font("cambria",Font.PLAIN,40);
	Font font25 = new Font("cambria",Font.PLAIN,25);
	
	JLabel userLabel ;
	JButton loginBtn,adminBtn,userBtn;
	
	public HomePage (){
		super("Home");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,400);
		this.setLocation(350,200);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0,100,100));

		userLabel = new JLabel("Welcome to Our Site");
		userLabel.setBounds(170,40,370,30); 
		userLabel.setFont(font40);
		userLabel.setForeground(Color.PINK);
		this.add(userLabel);
	


		//Buy
		userBtn = new JButton("User");
		userBtn.setBounds(150,170,100,30);
		userBtn.setFont(font25);
		userBtn.setBackground(new Color(0,255,255));
		userBtn.setForeground(Color.WHITE);
		userBtn.addActionListener(this);
		this.add(userBtn);

		//Admin
		adminBtn = new JButton("Admin");
		adminBtn.setBounds(400,170,150,30);
		adminBtn.setFont(font25);
		adminBtn.setBackground(Color.ORANGE);
		adminBtn.setForeground(Color.BLACK);
		adminBtn.addActionListener(this);
		
		this.add(adminBtn);



		this.setVisible(true);
		
}
        public void actionPerformed(ActionEvent e) {
        
            if(e.getSource() == adminBtn)
			{
				
				new LoginPage();
				this.dispose();
			}
          
           
        
		else if(e.getSource() == userBtn)
		{new LoginU();
	     this.dispose();
	    }
		
	
}

}