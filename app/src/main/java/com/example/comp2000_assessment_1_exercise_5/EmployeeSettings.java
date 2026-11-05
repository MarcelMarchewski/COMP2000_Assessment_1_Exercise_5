package com.example.comp2000_assessment_1_exercise_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        Button accountButton = (Button) findViewById(R.id.accountButton);

        accountButton.setOnClickListener(x -> OnAccountButtonClick());

        Button notificationsButton = (Button) findViewById(R.id.notificationsButton);

        notificationsButton.setOnClickListener(x -> OnNotificationsButtonClick());

        Button accessibilityButton = (Button) findViewById(R.id.accessibilityButton);

        accessibilityButton.setOnClickListener(x -> OnAccessibilityButtonClick());
    }

    private void OnAccountButtonClick()
    {
        Intent intent = new Intent(this, EmployeeAccountSettings.class);

        startActivity(intent);
    }

    private void OnNotificationsButtonClick()
    {
        Intent intent = new Intent(this, EmployeeNotificationSettings.class);

        startActivity(intent);
    }

    private void OnAccessibilityButtonClick()
    {
        Intent intent = new Intent(this, EmployeeAccessibilitySettings.class);

        startActivity(intent);
    }
}