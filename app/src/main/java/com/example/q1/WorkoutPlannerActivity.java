package com.example.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutPlannerActivity extends AppCompatActivity {

    private Spinner spinnerIntensity;
    private Button btnFilter, btnSearch;
    private ListView listViewWorkouts;
    private EditText editTextSearch;
    private TextView textViewResult;

    private List<Workout> allWorkouts;
    private ArrayAdapter<String> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_planner);

        spinnerIntensity = findViewById(R.id.spinnerIntensity);
        btnFilter = findViewById(R.id.btnFilter);
        listViewWorkouts = findViewById(R.id.listViewWorkouts);
        editTextSearch = findViewById(R.id.editTextSearch);
        btnSearch = findViewById(R.id.btnSearch);
        textViewResult = findViewById(R.id.textViewResult);

        // Initialize the workout data
        allWorkouts = DataProvider.getMockWorkouts();

        // Set up intensity options in the Spinner with custom layouts
        List<String> intensities = Arrays.asList("Low", "Medium", "High");
        ArrayAdapter<String> intensityAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, intensities);
        intensityAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerIntensity.setAdapter(intensityAdapter);

        // Set up ListView adapter
        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listViewWorkouts.setAdapter(listViewAdapter);

        // Filter button functionality
        btnFilter.setOnClickListener(v -> filterWorkoutsByIntensity());

        // Search button functionality
        btnSearch.setOnClickListener(v -> searchWorkoutByName());
    }

    // Filter workouts by selected intensity
    private void filterWorkoutsByIntensity() {
        String selectedIntensity = spinnerIntensity.getSelectedItem().toString();
        List<String> filteredWorkouts = new ArrayList<>();

        for (Workout workout : allWorkouts) {
            if (workout.getIntensity().equalsIgnoreCase(selectedIntensity)) {
                filteredWorkouts.add(workout.getType() + " - " + workout.getDuration() + " mins");
            }
        }

        // Update ListView with filtered workouts
        listViewAdapter.clear();
        listViewAdapter.addAll(filteredWorkouts);
        listViewAdapter.notifyDataSetChanged();

        // Show message if no workouts match
        if (filteredWorkouts.isEmpty()) {
            Toast.makeText(this, "No workouts found for " + selectedIntensity + " intensity", Toast.LENGTH_SHORT).show();
        }
    }

    // Search for a workout by name and display result in the result box
    private void searchWorkoutByName() {
        String searchQuery = editTextSearch.getText().toString().trim();

        if (searchQuery.isEmpty()) {
            Toast.makeText(this, "Please enter a workout name", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean workoutFound = false;

        for (Workout workout : allWorkouts) {
            if (workout.getType().equalsIgnoreCase(searchQuery)) {
                // Workout found, display details in the result box
                String result = "Workout: " + workout.getType() +
                        "\nIntensity: " + workout.getIntensity() +
                        "\nDuration: " + workout.getDuration() + " mins";
                textViewResult.setText(result);
                textViewResult.setVisibility(View.VISIBLE);
                workoutFound = true;
                break;
            }
        }

        // Show "coming soon" message if workout not found
        if (!workoutFound) {
            String comingSoonMessage = searchQuery + " is coming soon in this app!";
            textViewResult.setText(comingSoonMessage);
            textViewResult.setVisibility(View.VISIBLE);
        }
    }
}
