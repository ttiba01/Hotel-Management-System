package GUI;

import Entity.Earning;
import EntityList.EarningList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EarningManagementPage extends JFrame implements ActionListener {
    
    private EarningList earningList;
    private JTextField employeeCostField, foodEarningsField, roomEarningsField;
    private JTextArea earningsDisplayArea;
    private JButton addButton, clearButton;
    
    public EarningManagementPage() {
        earningList = new EarningList(10);

        setTitle("Earning Management System");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(190, 220, 255));
        setLayout(null);

        JLabel titleLabel = new JLabel("Earning Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(150, 10, 400, 30);
        add(titleLabel);

        JLabel employeeCostLabel = new JLabel("Employee Cost");
        employeeCostLabel.setBounds(50, 60, 150, 25);
        add(employeeCostLabel);

        employeeCostField = new JTextField();
        employeeCostField.setBounds(200, 60, 150, 25);
        add(employeeCostField);

        JLabel foodEarningsLabel = new JLabel("Food Earnings");
        foodEarningsLabel.setBounds(50, 100, 150, 25);
        add(foodEarningsLabel);

        foodEarningsField = new JTextField();
        foodEarningsField.setBounds(200, 100, 150, 25);
        add(foodEarningsField);

        JLabel roomEarningsLabel = new JLabel("Room Earnings");
        roomEarningsLabel.setBounds(50, 140, 150, 25);
        add(roomEarningsLabel);

        roomEarningsField = new JTextField();
        roomEarningsField.setBounds(200, 140, 150, 25);
        add(roomEarningsField);

        addButton = new JButton("ADD");
        addButton.setBounds(50, 190, 300, 40);
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.BLACK);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.addActionListener(this);
        add(addButton);
        
        clearButton = new JButton("CLEAR");
        clearButton.setBounds(50, 240, 300, 40);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.addActionListener(this);
        add(clearButton);

        earningsDisplayArea = new JTextArea();
        earningsDisplayArea.setEditable(false);
        earningsDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(earningsDisplayArea);
        scrollPane.setBounds(380, 60, 280, 300);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                double employeeCost = Double.parseDouble(employeeCostField.getText());
                double foodEarnings = Double.parseDouble(foodEarningsField.getText());
                double roomEarnings = Double.parseDouble(roomEarningsField.getText());

                earningList.insert(new Earning("Employee Cost", employeeCost));
                earningList.insert(new Earning("Food Earnings", foodEarnings));
                earningList.insert(new Earning("Room Earnings", roomEarnings));

                updateEarningsDisplay();
            } catch (NumberFormatException ex) {
            }
        } else if (e.getSource() == clearButton) {
            employeeCostField.setText("");
            foodEarningsField.setText("");
            roomEarningsField.setText("");
            earningsDisplayArea.setText("");
        }
    }
    
    private void updateEarningsDisplay() {
        earningsDisplayArea.setText("Current Earnings Data:\n");
        for (Earning earning : earningList.getAll()) {
            earningsDisplayArea.append(earning.getId() + ": $" + earning.getAmount() + "\n");
        }
    }

    public static void main(String[] args) {
        new EarningManagementPage();
    }
}
