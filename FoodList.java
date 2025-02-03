package EntityList;

import Entity.Food;

public class FoodList {
    private Food[] foods;
    private int size;

    public FoodList(int capacity) {
        foods = new Food[capacity];
        size = 0;
    }

    public void insert(Food food) {
        if (size < foods.length) {
            foods[size++] = food;
        } else {
            System.out.println("Food list is full.");
        }
    }

    public Food[] getAll() {
        Food[] allFoods = new Food[size];
        System.arraycopy(foods, 0, allFoods, 0, size);
        return allFoods;
    }

    public Food getById(String id) {
        for (int i = 0; i < size; i++) {
            if (foods[i].getId().equals(id)) {
                return foods[i];
            }
        }
        return null;
    }

    public void remove(Food food) {
        for (int i = 0; i < size; i++) {
            if (foods[i].equals(food)) {
                for (int j = i; j < size - 1; j++) {
                    foods[j] = foods[j + 1];
                }
                foods[--size] = null;
                break;
            }
        }
    }

    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Food food : foods) {
            if (food != null) {
                sb.append(food.getFoodAsString()).append("\n\n");
            }
        }
        return sb.toString();
    }
}
