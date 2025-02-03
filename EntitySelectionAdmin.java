package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntitySelectionAdmin extends JFrame implements ActionListener {
    Font font20 = new Font("Cambria", Font.PLAIN, 20);
    Font font18 = new Font("Cambria", Font.PLAIN, 18);
    Font font25 = new Font("Cambria", Font.BOLD, 25);

    JButton roomButton, foodButton, employeeButton, earningButton; 

    public EntitySelectionAdmin() {
        super("Management Selection");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocation(350, 200);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0, 100, 100));

        JLabel titleLabel = new JLabel("Select a Management");
        titleLabel.setBounds(120, 30, 200, 30);
        titleLabel.setFont(font25);
        titleLabel.setForeground(Color.WHITE);
        this.add(titleLabel);

        // Room Button
        roomButton = new JButton("Room");
        roomButton.setBounds(100, 80, 200, 40);
        roomButton.setFont(font20);
        roomButton.addActionListener(this);
        this.add(roomButton);

        // Food Button
        foodButton = new JButton("Food");
        foodButton.setBounds(100, 130, 200, 40);
        foodButton.setFont(font20);
        foodButton.addActionListener(this);
        this.add(foodButton);

        // Employee Button
        employeeButton = new JButton("Employee");
        employeeButton.setBounds(100, 180, 200, 40);
        employeeButton.setFont(font20);
        employeeButton.addActionListener(this);
        this.add(employeeButton);

        // Earning Button 
        earningButton = new JButton("Earning");
        earningButton.setBounds(100, 230, 200, 40);
        earningButton.setFont(font20);
        earningButton.addActionListener(this);
        this.add(earningButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == roomButton) {
                RoomManagementPage rmp = new RoomManagementPage();
                this.dispose();
            }
        } else if (e.getSource() == foodButton) {
            JOptionPane.showMessageDialog(this, "Food feature is not available yet!");
        } else if (e.getSource() == employeeButton) {
                EmployeeManagementPage emp = new EmployeeManagementPage();
                this.dispose();
            }
        } else if (e.getSource() == earningButton) { 
		        EarningManagementPage emp = new EarningManagementPage();
			    this.dispose();
                JOptionPane.showMessageDialog(this, "Earning feature is not available yet!");
        }
    }

    public static void main(String[] args) {
        new EntitySelectionAdmin();
    }
}
