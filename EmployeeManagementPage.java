package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Employee;
import EntityList.EmployeeList;
import Files.*;


public class EmployeeManagementPage extends JFrame implements ActionListener {
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextField employeeIdTextField,employeeNameTextField,employeePositionTextField,employeeSalaryTextField;
	JTextField searchTextField,deleteTextField;
	JTextArea display;
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton,LogoutButton,GoBackButton;
	
	EmployeeList employeeList = new EmployeeList(100);
	
	public EmployeeManagementPage(){
		
		super("Hotel Management GUI");
		this.setTitle("Employee Management");
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(980,720); 
		this.setLocation(150,0); 
		this.getContentPane().setBackground(new Color(123,202,222));
		this.setLayout(null);
		FileIOemployee.loadEmployeeFromFile(employeeList);

	
		// Title
		JLabel title = new JLabel("Hotel Management System");
		title.setBounds(250,10,500,50);
		title.setFont(titleFont);
		this.add(title);
		
		JLabel subTitle = new JLabel("All Employee's Information");
		subTitle.setBounds(290,40,320,60); 
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		this.add(subTitle);
		
		
		//ID Entry  ===========
		JLabel employeeIdLabel = new JLabel("Employee ID");
		employeeIdLabel.setBounds(40,125,200,30); 
		employeeIdLabel.setFont(font15);
		this.add(employeeIdLabel);
		
		employeeIdTextField = new JTextField();
		employeeIdTextField.setBounds(40,160,200,30); 
		employeeIdTextField.setFont(font15);
		this.add(employeeIdTextField);
		
		//============Name Entry  ===========
		JLabel employeeNameLabel = new JLabel("Employee Name");
		employeeNameLabel.setBounds(40,195,200,30); 
		employeeNameLabel.setFont(font15);
		this.add(employeeNameLabel);
		
		
		employeeNameTextField = new JTextField();
		employeeNameTextField.setBounds(40,225,200,30);
		employeeNameTextField.setFont(font15);
		this.add(employeeNameTextField);
		//Position
		JLabel employeePositionLabel = new JLabel("Employee Position Name");
		 employeePositionLabel.setBounds(40,260,200,30); 
		 employeePositionLabel.setFont(font15);
		 this.add(employeePositionLabel);
		
		
		employeePositionTextField = new JTextField();
		employeePositionTextField.setBounds(40,295,200,30); 
		employeePositionTextField.setFont(font15);
		this.add(employeePositionTextField);
		
		
		//quantity Entry 
		JLabel employeeSalaryLabel = new JLabel("Employee Salary");
		employeeSalaryLabel.setBounds(40,400,200,30); 
		employeeSalaryLabel.setFont(font15);
		this.add(employeeSalaryLabel);
		
		employeeSalaryTextField = new JTextField();
		employeeSalaryTextField.setBounds(40,435,200,30); 
		employeeSalaryTextField.setFont(font15);
		this.add(employeeSalaryTextField);
		
		//Add  Buttons
		addButton = new JButton("ADD");
		addButton.setBounds(40,520,120,30); 
		
	    addButton.setBackground(Color.GREEN);
		addButton.setFont(font15);
		this.add(addButton);
		addButton.addActionListener(this);
		
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(215,520,120,30); 
	    updateButton.setBackground(Color.BLUE);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(font15);
     	updateButton.addActionListener(this);
		this.add(updateButton);
		
       // Show All information 
		
		showAllButton = new JButton("SHOW ALL");
		showAllButton.setBounds(120,560,120,30);
		showAllButton.setBackground(Color.PINK);
		showAllButton.setForeground(Color.WHITE);               
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		this.add(showAllButton);
		
	
		
		      //Search
		JLabel searchLabel = new JLabel("Search By Employee ID");
		searchLabel.setBounds(690,55,200,30); 
		searchLabel.setFont(font15);
		this.add(searchLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(690,85,130,25); 
		searchTextField.setFont(font15);
		this.add(searchTextField);
		
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(830,85,105,25); 
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);
		this.add(searchButton);
		
		
		// delete
		JLabel deleteLabel = new JLabel("Delete By Product ID");
		deleteLabel.setBounds(450,515,200,30); 
		deleteLabel.setFont(font15);
		this.add(deleteLabel);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(450,550,135,30);
		deleteTextField.setFont(font15);
		this.add(deleteTextField);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(575,550,110,30); 
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.YELLOW);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		//go back  button
		
		GoBackButton = new JButton("Go Back");
        GoBackButton.setBounds(830,550,120,40); 
        GoBackButton.setBackground(Color.ORANGE); 
        GoBackButton.setForeground(Color.WHITE);  
        GoBackButton.setFont(font15);             
        GoBackButton.addActionListener(this);     
        this.add(GoBackButton);
		
		//log out button
		
		LogoutButton = new JButton("Log out");
		LogoutButton.setBounds(830,610,120,40); 
		LogoutButton.setBackground(Color.DARK_GRAY);
		LogoutButton.setForeground(Color.WHITE);
		LogoutButton.setFont(font15);
		LogoutButton.addActionListener(this); 
		this.add(LogoutButton);
		
		//Data Display Area 
		display = new JTextArea();
		//display.setBounds(500,150,300,300);
		display.setBackground(Color.WHITE);
		display.setFont(font20);
		JScrollPane jsp = new JScrollPane(display);
		jsp.setBounds(300,130,600,380);
		this.add(jsp);
		reloadData();
		
		this.setVisible(true); 
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(addButton == e.getSource()){
			System.out.println("ADD CLICKED");			
			Employee ee = employeeList.getById(employeeIdTextField.getText());
			if(ee==null){
				if(!employeeIdTextField.getText().isEmpty() &&
				!employeeNameTextField.getText().isEmpty() &&
				!employeePositionTextField.getText().isEmpty() &&
				!employeeSalaryTextField.getText().isEmpty()){
					Employee tempE = new Employee(employeeIdTextField.getText(),
									employeeNameTextField.getText(),
									employeePositionTextField.getText(),
									Integer.parseInt(employeeSalaryTextField.getText()));
					employeeList.insert(tempE);
					FileIOemployee.writeEmployeeInFile(tempE);
					reloadData();
				}
				else{
					JOptionPane.showMessageDialog(this,"Provide All Information");
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Employee Id Already Used");
			}
		
		}
		else if(updateButton == e.getSource()){
			System.out.println("UPDATE CLICKED");
			Employee ee = employeeList.getById(employeeIdTextField.getText());
			if(ee!=null){
				if(!employeeNameTextField.getText().isEmpty()){
					ee.setEmployeeName(employeeNameTextField.getText());
				}
				if(!employeePositionTextField.getText().isEmpty()){
					ee.setEmployeePosition(employeePositionTextField.getText());
				}
				if(!employeeSalaryTextField.getText().isEmpty()){
					ee.setEmployeeSalary(Integer.parseInt(employeeSalaryTextField.getText()));
				}
				reloadData();
				JOptionPane.showMessageDialog(this,"Employee Updated");
			}
			else{
				JOptionPane.showMessageDialog(this,"No Employee Found");
			}
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
		
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			Employee ee = employeeList.getById(employeeIdTextField.getText());
			if(ee!=null){
				employeeList.removeById(deleteTextField.getText());
			    FileIOemployee.removeEmployeeFromFile(deleteTextField.getText());
				reloadData();
			}
			else{
				JOptionPane.showMessageDialog(this,"No Employee Found");
			}
		}
		else if(showAllButton == e.getSource()){
			System.out.println("SHOW ALL CLICKED");
			reloadData();
		}
		else if(clearButton == e.getSource()){
			System.out.println("CLEAR CLICKED");
		}
		else if(LogoutButton == e.getSource()){
			System.out.println("LOGOUT CLICKED");
			HomePageEmployee homePageEmployee = new HomePageEmployee();
			this.dispose();
		}
		else if(GoBackButton == e.getSource())
		{
			System.out.println("Go Back CLICKED");
			LoginPageEmployee lpe = new LoginPageEmployee();
			this.dispose();
		}
	}
	public void reloadData(){
		display.setText(employeeList.getAllEmployeeAsString());
	}

}