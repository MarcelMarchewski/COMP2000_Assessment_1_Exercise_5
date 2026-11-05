package com.example.comp2000_assessment_1_exercise_5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeAccessibilitySettings extends AppCompatActivity {

    private boolean colourblindMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_accessibility_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        CheckBox colourBlindBox = (CheckBox) findViewById(R.id.colourblindMode);

        if (savedInstanceState != null)
        {
            colourblindMode = savedInstanceState.getBoolean("colourblindMode", false);
        }

        colourBlindBox.setChecked(colourblindMode);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putBoolean("colourblindMode", colourblindMode);
    }

    private void OnBackButtonClick()
    {
        finish();
    }
}