package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddMealActivity extends AppCompatActivity {

    private EditText editMealName, editMealIngredients, editMealCalories;
    private Button buttonAddMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        editMealName = findViewById(R.id.editMealName);
        editMealIngredients = findViewById(R.id.editMealIngredients);
        editMealCalories = findViewById(R.id.editMealCalories);
        buttonAddMeal = findViewById(R.id.buttonAddMeal);

        
        buttonAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMeal();
            }
        });
    }

    
    private void addMeal() {
        
        String mealName = editMealName.getText().toString().trim();
        String ingredientsText = editMealIngredients.getText().toString().trim();
        String caloriesText = editMealCalories.getText().toString().trim();

       
        if (mealName.isEmpty() || ingredientsText.isEmpty() || caloriesText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

      
        List<String> ingredients = Arrays.asList(ingredientsText.split(","));
        int calories;
        try {
            calories = Integer.parseInt(caloriesText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Calories must be a number", Toast.LENGTH_SHORT).show();
            return;
        }

        
        Intent resultIntent = new Intent();
        resultIntent.putExtra("mealName", mealName);
        resultIntent.putStringArrayListExtra("mealIngredients", new ArrayList<>(ingredients));
        resultIntent.putExtra("mealCalories", calories);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
