package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MealDetailActivity extends AppCompatActivity {

    private TextView textMealName;
    private TextView textMealIngredients;
    private TextView textMealCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        textMealName = findViewById(R.id.textMealName);
        textMealIngredients = findViewById(R.id.textMealIngredients);
        textMealCalories = findViewById(R.id.textMealCalories);

      
        Intent intent = getIntent();
        String mealName = intent.getStringExtra("mealName");
        List<String> ingredients = intent.getStringArrayListExtra("mealIngredients");
        int calories = intent.getIntExtra("mealCalories", 0);


        textMealName.setText(mealName);
        textMealIngredients.setText("• " + String.join("\n• ", ingredients));
        textMealCalories.setText(calories + " Calories");
    }
}
