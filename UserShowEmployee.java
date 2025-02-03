package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Files.FileIOemployee;
import EntityList.EmployeeList;
import GUI.HomePageEmployee;
import Entity.Employee;


public class UserShowEmployee extends JFrame implements ActionListener   {
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextArea display;
	JButton searchButton,showAllButton,LogoutButton;
	JTextField searchTextField;
	EmployeeList employeeList = new EmployeeList(100);
	
	public UserShowEmployee(){
		
		super("Hotel Management GUI");
		this.setTitle("Information");
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,600); 
		this.setLocation(150,0); 
		this.getContentPane().setBackground(new Color(153,124,211));
		this.setLayout(null);
		FileIOemployee.loadEmployeeFromFile(employeeList);
		
		

	
		// Title
		JLabel title = new JLabel("Hotel Management System");
		title.setBounds(150,10,500,50);
		title.setFont(titleFont);
		this.add(title);
		
       // Show All product information 
		
		showAllButton = new JButton("SHOW ALL");
		showAllButton.setBounds(300,500,120,30);
		showAllButton.setBackground(Color.RED);
		showAllButton.setForeground(Color.WHITE);               
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		this.add(showAllButton);
		
		
		//============ Search Entry  ===========
		JLabel searchLabel = new JLabel("Search By Employee ID");
		searchLabel.setBounds(575,45,200,30); 
		searchLabel.setFont(font15);
		this.add(searchLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(550,75,130,25); 
		searchTextField.setFont(font15);
		this.add(searchTextField);
		
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(680,75,100,25); 
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);
		this.add(searchButton);
		
		
		//log out button
		
		LogoutButton = new JButton("Log out");
		LogoutButton.setBounds(660,500,120,30); 
		LogoutButton.setBackground(Color.DARK_GRAY);
		LogoutButton.setForeground(Color.WHITE);
		LogoutButton.setFont(font15);
		LogoutButton.addActionListener(this); 
		this.add(LogoutButton);
		
		//Data Display Area 
		display = new JTextArea();
		display.setBounds(500,50,300,300);
		display.setBackground(Color.WHITE);
		display.setFont(font15);
		JScrollPane jsp = new JScrollPane(display);
		jsp.setBounds(40,70,500,400);
		this.add(jsp);
		reloadData();
		this.setVisible(true); 
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		 if(showAllButton == e.getSource()){
			 
			reloadData();
		}
	 
		else if(LogoutButton == e.getSource()){
			System.out.println("LOGOUT CLICKED");
			HomePageEmployee homePageEmployee = new HomePageEmployee();
			this.dispose();
			 
		}
		else if(searchButton == e.getSource()){
			System.out.println("SEARCH CLICKED");	
			Employee ee = employeeList.getById(searchTextField.getText());
			if(ee!=null){
				display.setText(ee.getEmployeeAsString());
			}
			else{
				JOptionPane.showMessageDialog(this,"No Employee Found");
			}
		}
	}
	public void reloadData(){
		display.setText(employeeList.getAllEmployeeAsString());
	}
	
}