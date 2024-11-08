package com.example.q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWorkout = findViewById(R.id.btnWorkoutPlanner);
        btnWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WorkoutPlannerActivity.class);
            startActivity(intent);
        });

        Button btnMeal = findViewById(R.id.btnMealPlanner);
        btnMeal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MealPlannerActivity.class);
            startActivity(intent);
        });
    }
}
