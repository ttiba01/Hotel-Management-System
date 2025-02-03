package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Room;
import EntityList.*;
import Files.FileIO;

public class RoomManagementPage extends JFrame implements ActionListener {
	Font titleFont = new Font("cambria",Font.BOLD,30);
	Font font15 = new Font("cambria",Font.BOLD,15);
	Font font20 = new Font("cambria",Font.BOLD,20);
	
	JTextField roomIdTextField,roomNameTextField,roomPriceTextField,roomQuantityTextField;
	JTextField searchTextField,deleteTextField;
	JTextArea display;
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton,LogoutButton,GoBackButton;
	
	RoomList roomList = new RoomList(100);
	
	public RoomManagementPage(){
		
		super("Room Management GUI");
		this.setTitle("Room Management");
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(980,720); 
		this.setLocation(150,0); 
		this.getContentPane().setBackground(new Color(123,202,222));
		this.setLayout(null);
		FileIO.loadRoomFromFile(roomList);

	
		// Title
		JLabel title = new JLabel("Hotel Management System");
		title.setBounds(250,10,500,50);
		title.setFont(titleFont);
		this.add(title);
	
		JLabel subTitle = new JLabel("All Room Information");
		subTitle.setBounds(290,40,320,60); 
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		this.add(subTitle);
		
		
		//ID Entry
		JLabel roomIdLabel = new JLabel("Room ID");
		roomIdLabel.setBounds(40,125,200,30); 
		roomIdLabel.setFont(font15);
		this.add(roomIdLabel);
		
		roomIdTextField = new JTextField();
		roomIdTextField.setBounds(40,160,200,30); 
		roomIdTextField.setFont(font15);
		this.add(roomIdTextField);
		
		//Name Entry
		JLabel roomNameLabel = new JLabel("Room Name");
		roomNameLabel.setBounds(40,195,200,30); 
		roomNameLabel.setFont(font15);
		this.add(roomNameLabel);
		
		
		roomNameTextField = new JTextField();
		roomNameTextField.setBounds(40,225,200,30);
		roomNameTextField.setFont(font15);
		this.add(roomNameTextField);
		
		
		//room price Entry
		JLabel roomPriceLabel  = new JLabel("Room Price");
		roomPriceLabel.setBounds(40,330,200,30); 
		roomPriceLabel.setFont(font15);
		this.add(roomPriceLabel);
		
		roomPriceTextField = new JTextField();
		roomPriceTextField.setBounds(40,365,200,30); 
		roomPriceTextField.setFont(font15);
		this.add(roomPriceTextField);
		
		//room quantity Entry 
		JLabel roomQuantityLabel = new JLabel("Room Quantity");
		roomQuantityLabel.setBounds(40,400,200,30); 
		roomQuantityLabel.setFont(font15);
		this.add(roomQuantityLabel);
		
		roomQuantityTextField = new JTextField();
		roomQuantityTextField.setBounds(40,435,200,30); 
		roomQuantityTextField.setFont(font15);
		this.add(roomQuantityTextField);
		
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
		
       // Show All room information 
		
		showAllButton = new JButton("SHOW ALL");
		showAllButton.setBounds(120,560,120,30);
		showAllButton.setBackground(Color.PINK);
		showAllButton.setForeground(Color.WHITE);               
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		this.add(showAllButton);
		
		GoBackButton = new JButton("Go Back");
        GoBackButton.setBounds(830,550,120,40); 
        GoBackButton.setBackground(Color.ORANGE); 
        GoBackButton.setForeground(Color.WHITE);  
        GoBackButton.setFont(font15);             
        GoBackButton.addActionListener(this);     
        this.add(GoBackButton);
		
	
		
		      //Search
		JLabel searchLabel = new JLabel("Search By Room ID");
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
		JLabel deleteLabel = new JLabel("Delete By Room ID");
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
			Room r = roomList.getById(roomIdTextField.getText());
			if(r==null){
				if(!roomIdTextField.getText().isEmpty() &&
				!roomNameTextField.getText().isEmpty() &&
				!roomPriceTextField.getText().isEmpty() && 
				!roomQuantityTextField.getText().isEmpty()){
					Room tempR = new Room(roomIdTextField.getText(),
									roomNameTextField.getText(),
									Integer.parseInt(roomPriceTextField.getText()),
									Integer.parseInt(roomQuantityTextField.getText()));
					roomList.insert(tempR);
					FileIO.writeRoomInFile(tempR);
					reloadData();
				}
				else{
					JOptionPane.showMessageDialog(this,"Provide All Information");
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Rooom Id Already Used");
			}
		
		}
		else if(updateButton == e.getSource()){
			System.out.println("UPDATE CLICKED");
			Room r = roomList.getById(roomIdTextField.getText());
			if(r!=null){
				if(!roomNameTextField.getText().isEmpty()){
					r.setRoomName(roomNameTextField.getText());
				}
				if(!roomPriceTextField.getText().isEmpty()){
					r.setRoomPrice(Integer.parseInt(roomPriceTextField.getText()));
				}
				if(!roomQuantityTextField.getText().isEmpty()){
					r.setRoomQuantity(Integer.parseInt(roomQuantityTextField.getText()));
				}
				reloadData();
				JOptionPane.showMessageDialog(this,"Room Updated");
			}
			else{
				JOptionPane.showMessageDialog(this,"No Room Found");
			}
		}
		else if(searchButton == e.getSource()){
			System.out.println("SEARCH CLICKED");	
			Room r = roomList.getById(searchTextField.getText());
			if(r!=null){
				display.setText(r.getRoomAsString());
			}
			else{
				JOptionPane.showMessageDialog(this,"No Room Found");
			}
		}
		
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			Room r = roomList.getById(roomIdTextField.getText());
			if(r!=null){
				roomList.removeById(deleteTextField.getText());
			    FileIO.removeRoomFromFile(deleteTextField.getText());
				reloadData();
			}
			else{
				JOptionPane.showMessageDialog(this,"No Room Found");
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
			HomePage homePage = new HomePage();
			this.dispose();
		}
		else if (GoBackButton == e.getSource()){
            System.out.println("GO BACK CLICKED");
            EntitySelectionAdmin esa= new EntitySelectionAdmin(); 
            this.dispose(); 
        }
	}
	public void reloadData(){
		display.setText(roomList.getAllRoomAsString());
	}

}