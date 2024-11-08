package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MealPlannerActivity extends AppCompatActivity {

    private ListView listViewMeals;
    private FloatingActionButton fabAddMeal;
    private ArrayAdapter<Meal> adapter;
    private List<Meal> meals;

    private static final int REQUEST_CODE_ADD_MEAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_planner);

        listViewMeals = findViewById(R.id.listViewMeals);
        fabAddMeal = findViewById(R.id.fabAddMeal);

        // Initialize mock meal data
        meals = DataProvider.getMockMeals();

        // Set up ArrayAdapter with custom layout
        adapter = new ArrayAdapter<>(this, R.layout.meal_list_item, R.id.textMealName, meals);
        listViewMeals.setAdapter(adapter);

        // Set up item click listener to open MealDetailActivity with meal data
        listViewMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Meal selectedMeal = meals.get(position);

                // Start MealDetailActivity with the selected meal's data
                Intent intent = new Intent(MealPlannerActivity.this, MealDetailActivity.class);
                intent.putExtra("mealName", selectedMeal.getName());
                intent.putStringArrayListExtra("mealIngredients", new ArrayList<>(selectedMeal.getIngredients()));
                intent.putExtra("mealCalories", selectedMeal.getCalories());
                startActivity(intent);
            }
        });

        // FAB click listener to add a new meal
        fabAddMeal.setOnClickListener(v -> {
            Intent intent = new Intent(MealPlannerActivity.this, AddMealActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_MEAL);
        });
    }

    // Handle the result from AddMealActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_MEAL && resultCode == RESULT_OK && data != null) {
            // Retrieve the new meal data from the Intent
            String mealName = data.getStringExtra("mealName");
            List<String> ingredients = data.getStringArrayListExtra("mealIngredients");
            int calories = data.getIntExtra("mealCalories", 0);

            // Create a new Meal object and add it to the list
            Meal newMeal = new Meal(mealName, ingredients, calories);
            meals.add(newMeal);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Meal added successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
