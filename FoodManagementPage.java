package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Food;
import EntityList.FoodList;
import File.FileIO;

public class FoodManagementPage extends JFrame implements ActionListener {
    Font titleFont = new Font("Cambria", Font.BOLD, 30);
    Font font15 = new Font("Cambria", Font.BOLD, 15);

    JTextField idTextField, nameTextField, typeTextField, priceTextField, quantityTextField;
    JTextField searchTextField, deleteTextField;

    JButton addButton, updateButton, searchButton, deleteButton, clearButton, showAllButton;

    JTextArea textArea;

    FoodList foodList = new FoodList(1000);

    public FoodManagementPage() {
        super("Food Management Page");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(940, 650);
        super.setLocation(150, 0);
        super.getContentPane().setBackground(new Color(218, 232, 252));
        super.setLayout(null);

        FileIO.loadFoodsFromFile(foodList);

        JLabel title = new JLabel("Food Management System");
        title.setBounds(230, 10, 500, 50);
        title.setFont(titleFont);
        this.add(title);

        JLabel subTitle = new JLabel("FOOD ITEMS");
        subTitle.setBounds(350, 60, 320, 50);
        subTitle.setFont(new Font("Cambria", Font.BOLD, 25));
        this.add(subTitle);

        int top = 100;
        int gap = 40;

        JLabel idLabel = new JLabel("Food ID");
        idLabel.setBounds(20, top, 200, 30);
        idLabel.setFont(font15);
        this.add(idLabel);

        idTextField = new JTextField();
        idTextField.setBounds(20, top += gap, 200, 30);
        idTextField.setFont(font15);
        this.add(idTextField);

        JLabel nameLabel = new JLabel("Food Name");
        nameLabel.setBounds(20, top += gap, 200, 30);
        nameLabel.setFont(font15);
        this.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(20, top += gap, 200, 30);
        nameTextField.setFont(font15);
        this.add(nameTextField);

        JLabel typeLabel = new JLabel("Food Category");
        typeLabel.setBounds(20, top += gap, 200, 30);
        typeLabel.setFont(font15);
        this.add(typeLabel);

        typeTextField = new JTextField();
        typeTextField.setBounds(20, top += gap, 200, 30);
        typeTextField.setFont(font15);
        this.add(typeTextField);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(20, top += gap, 200, 30);
        priceLabel.setFont(font15);
        this.add(priceLabel);

        priceTextField = new JTextField();
        priceTextField.setBounds(20, top += gap, 200, 30);
        priceTextField.setFont(font15);
        this.add(priceTextField);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(20, top += gap, 200, 30);
        quantityLabel.setFont(font15);
        this.add(quantityLabel);

        quantityTextField = new JTextField();
        quantityTextField.setBounds(20, top += gap, 200, 30);
        quantityTextField.setFont(font15);
        this.add(quantityTextField);

        addButton = new JButton("ADD");
        addButton.setBounds(20, top += gap + 20, 200, 30);
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(font15);
        addButton.addActionListener(this);
        this.add(addButton);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(20, top += gap + 20, 200, 30);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(font15);
        updateButton.addActionListener(this);
        this.add(updateButton);

        top = 100;
        gap = 40;

        JLabel searchLabel = new JLabel("Search By Food ID");
        searchLabel.setBounds(700, top, 200, 30);
        searchLabel.setFont(font15);
        this.add(searchLabel);

        searchTextField = new JTextField();
        searchTextField.setBounds(700, top += gap, 200, 30);
        searchTextField.setFont(font15);
        this.add(searchTextField);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(700, top += gap, 200, 30);
        searchButton.setBackground(Color.YELLOW);
        searchButton.setFont(font15);
        searchButton.addActionListener(this);
        this.add(searchButton);

        JLabel deleteLabel = new JLabel("Delete By Food ID");
        deleteLabel.setBounds(700, top += gap, 200, 30);
        deleteLabel.setFont(font15);
        this.add(deleteLabel);

        deleteTextField = new JTextField();
        deleteTextField.setBounds(700, top += gap, 200, 30);
        deleteTextField.setFont(font15);
        this.add(deleteTextField);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(700, top += gap, 200, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(font15);
        deleteButton.addActionListener(this);
        this.add(deleteButton);

        showAllButton = new JButton("SHOW ALL");
        showAllButton.setBounds(700, 500, 200, 30);
        showAllButton.setBackground(Color.PINK);
        showAllButton.setForeground(Color.WHITE);
        showAllButton.setFont(font15);
        showAllButton.addActionListener(this);
        this.add(showAllButton);

        clearButton = new JButton("CLEAR SCREEN");
        clearButton.setBounds(700, 550, 200, 30);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(font15);
        clearButton.addActionListener(this);
        this.add(clearButton);

        textArea = new JTextArea();
        textArea.setFont(font15);
        textArea.setEditable(false);
        textArea.setText(foodList.getAllAsString());

        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBounds(230, 120, 460, 470);
        this.add(jsp);

        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String idText = idTextField.getText().trim();
            String name = nameTextField.getText().trim();
            String category = typeTextField.getText().trim();
            String priceText = priceTextField.getText().trim();
            String quantityText = quantityTextField.getText().trim();

            if (!idText.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Food ID must be a valid integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!name.matches("[A-Za-z ]+")) {
                JOptionPane.showMessageDialog(this, "Food name must only contain letters and spaces!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (category.length() < 3 || !category.matches("[A-Za-z]+")) {
                JOptionPane.showMessageDialog(this, "Food category must be at least 3 alphabetic characters!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceText);
                if (price <= 0) {
                    JOptionPane.showMessageDialog(this, "Price must be a positive decimal number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Price must be a valid decimal number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
                if (quantity < 0) {
                    JOptionPane.showMessageDialog(this, "Quantity cannot be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Quantity must be a valid non-negative integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (foodList.getById(idText) != null) {
                JOptionPane.showMessageDialog(this, "Food ID already exists! Use a unique ID.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Food newFood = new Food(idText, name, price, quantity, category);
            foodList.insert(newFood);
            FileIO.saveFood(newFood);
            textArea.setText(foodList.getAllAsString());
            JOptionPane.showMessageDialog(this, "Food Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == updateButton) {
            String id = idTextField.getText().trim();
            Food food = foodList.getById(id);

            if (food == null) {
                JOptionPane.showMessageDialog(this, "Food ID not found!", "Update Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = nameTextField.getText().trim();
            String category = typeTextField.getText().trim();
            String priceText = priceTextField.getText().trim();
            String quantityText = quantityTextField.getText().trim();

            double price;
            int quantity;
            try {
                price = Double.parseDouble(priceText);
                quantity = Integer.parseInt(quantityText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price or quantity!", "Update Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            food.setName(name);
            food.setCategory(category);
            food.setPrice(price);
            food.setQuantity(quantity);

            FileIO.saveAllFoods(foodList);
            textArea.setText(foodList.getAllAsString());
            JOptionPane.showMessageDialog(this, "Food Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == searchButton) {
            String id = searchTextField.getText().trim();
            Food food = foodList.getById(id);

            if (food != null) {
                textArea.setText(food.getFoodAsString());
            } else {
                JOptionPane.showMessageDialog(this, "Food not found!", "Search Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource() == deleteButton) {
            String id = deleteTextField.getText().trim();
            Food food = foodList.getById(id);

            if (food != null) {
                foodList.remove(food);
                FileIO.saveAllFoods(foodList);
                textArea.setText(foodList.getAllAsString());
                JOptionPane.showMessageDialog(this, "Food Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Food ID not found!", "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource() == showAllButton) {
            textArea.setText(foodList.getAllAsString());
        }

        else if (e.getSource() == clearButton) {
            idTextField.setText("");
            nameTextField.setText("");
            typeTextField.setText("");
            priceTextField.setText("");
            quantityTextField.setText("");
            searchTextField.setText("");
            deleteTextField.setText("");
            textArea.setText("");
        }
    }
}
