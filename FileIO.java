package File;

import Entity.Food;
import EntityList.FoodList;
import java.io.*;

public class FileIO {
    public static void loadFoodsFromFile(FoodList foodList) {
        File file = new File("File/data/foods.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    String category = parts[2];
                    Food food = new Food(id, name, price, quantity, category);
                    foodList.insert(food);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFood(Food food) {
        File file = new File("File/data/foods.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(food.getId() + "," + food.getName() + "," + food.getCategory() + "," + food.getPrice() + "," + food.getQuantity());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAllFoods(FoodList foodList) {
        File file = new File("File/data/foods.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Food[] allFoods = foodList.getAll();
            for (Food food : allFoods) {
                if (food != null) {
                    writer.write(food.getId() + "," + food.getName() + "," + food.getCategory() + "," + food.getPrice() + "," + food.getQuantity());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
