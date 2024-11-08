package com.example.q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {
    public static List<Workout> getMockWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout("Running", "High", 30));
        workouts.add(new Workout("Yoga", "Low", 45));
        workouts.add(new Workout("Cycling", "Medium", 60));
        workouts.add(new Workout("Swimming", "High", 40));
        workouts.add(new Workout("Pilates", "Low", 50));
        workouts.add(new Workout("Rowing", "Medium", 35));
        workouts.add(new Workout("Hiking", "High", 90));
        workouts.add(new Workout("Strength Training", "Medium", 45));
        workouts.add(new Workout("Dancing", "Low", 30));
        return workouts;
    }
    public static List<Meal> getMockMeals() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Breakfast Burrito", Arrays.asList("Eggs", "Tortilla", "Cheese", "Salsa"), 400));
        meals.add(new Meal("Chicken Salad", Arrays.asList("Chicken", "Lettuce", "Tomatoes", "Dressing"), 350));
        meals.add(new Meal("Grilled Salmon", Arrays.asList("Salmon", "Lemon", "Garlic"), 500));
        return meals;
    }

}
