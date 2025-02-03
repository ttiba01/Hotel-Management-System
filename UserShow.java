package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import GUI.LoginU;
import Files.FileIO;
import EntityList.RoomList;
import GUI.HomePage;
import Entity.Room;

public class UserShow extends JFrame implements ActionListener   {
    Font titleFont = new Font("cambria", Font.BOLD, 30);
    Font font15 = new Font("cambria", Font.BOLD, 15);
    Font font20 = new Font("cambria", Font.BOLD, 20);
    
    JTextArea display;
    JButton searchButton, showAllButton, LogoutButton, GoBackButton; 
    JTextField searchTextField;
    RoomList roomList = new RoomList(100);
    
    public UserShow(){
        
        super("Room Management GUI");
        this.setTitle("Information");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600); 
        this.setLocation(150, 50); 
        this.getContentPane().setBackground(new Color(153,124,211));
        this.setLayout(null);
        FileIO.loadRoomFromFile(roomList);
        
        // Title
        JLabel title = new JLabel("Hotel Management System");
        title.setBounds(150, 10, 500, 50);
        title.setFont(titleFont);
        this.add(title);
        
        // Show All product information 
        showAllButton = new JButton("SHOW ALL");
        showAllButton.setBounds(300, 500, 120, 30);
        showAllButton.setBackground(Color.RED);
        showAllButton.setForeground(Color.WHITE);               
        showAllButton.setFont(font15);
        showAllButton.addActionListener(this);
        this.add(showAllButton);
        
        // Search Entry
        JLabel searchLabel = new JLabel("Search By Room ID");
        searchLabel.setBounds(575, 45, 200, 30); 
        searchLabel.setFont(font15);
        this.add(searchLabel);
        
        searchTextField = new JTextField();
        searchTextField.setBounds(550, 75, 130, 25); 
        searchTextField.setFont(font15);
        this.add(searchTextField);
        
        searchButton = new JButton("SEARCH");
        searchButton.setBounds(680, 75, 100, 25); 
        searchButton.setBackground(Color.YELLOW);
        searchButton.setFont(font15);
        searchButton.addActionListener(this);
        this.add(searchButton);
        
        // Log out button
        LogoutButton = new JButton("Log out");
        LogoutButton.setBounds(660, 500, 120, 30); 
        LogoutButton.setBackground(Color.DARK_GRAY);
        LogoutButton.setForeground(Color.WHITE);
        LogoutButton.setFont(font15);
        LogoutButton.addActionListener(this); 
        this.add(LogoutButton);
        
        // Data Display Area 
        display = new JTextArea();
        display.setBounds(500, 50, 300, 300);
        display.setBackground(Color.WHITE);
        display.setFont(font15);
        JScrollPane jsp = new JScrollPane(display);
        jsp.setBounds(40, 70, 500, 400);
        this.add(jsp);
        
        GoBackButton = new JButton("Go Back");
        GoBackButton.setBounds(660, 450, 120, 30); 
        GoBackButton.setBackground(Color.ORANGE); 
        GoBackButton.setForeground(Color.WHITE);  
        GoBackButton.setFont(font15);             
        GoBackButton.addActionListener(this);     
        this.add(GoBackButton);
        
        reloadData();
        this.setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent e){
        if (showAllButton == e.getSource()){
            reloadData();
        }
        else if (LogoutButton == e.getSource()){
            System.out.println("LOGOUT CLICKED");
            HomePage homePage = new HomePage();
            this.dispose();
        }
        else if (searchButton == e.getSource()){
            System.out.println("SEARCH CLICKED");    
            Room r = roomList.getById(searchTextField.getText());
            if (r != null){
                display.setText(r.getRoomAsString());
            }
            else{
                JOptionPane.showMessageDialog(this, "No Room Found");
            }
        }
        else if (GoBackButton == e.getSource()){
            System.out.println("GO BACK CLICKED");
            EntitySelection es = new EntitySelection(); 
            this.dispose(); 
        }
    }
    
    public void reloadData(){
        display.setText(roomList.getAllRoomAsString());
    }
}
