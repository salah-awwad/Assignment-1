package com.example.q1;

import java.util.List;

public class Meal {
    private String name;
    private List<String> ingredients;
    private int calories;

    public Meal(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Override toString to return meal name
    @Override
    public String toString() {
        return name;
    }
}
