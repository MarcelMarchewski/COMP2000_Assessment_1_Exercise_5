package com.example.comp2000_assessment_1_exercise_5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeNotificationSettings extends AppCompatActivity {

    private boolean bookingReminders = false;
    private boolean emailReminders = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_notification_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        CheckBox bookingRemindersBox = (CheckBox) findViewById(R.id.bookingReminders);

        CheckBox emailRemindersBox = (CheckBox) findViewById(R.id.emailReminders);

        if (savedInstanceState != null)
        {
            bookingReminders = savedInstanceState.getBoolean("bookingReminders", false);

            emailReminders = savedInstanceState.getBoolean("emailReminders", false);
        }

        bookingRemindersBox.setChecked(bookingReminders);

        emailRemindersBox.setChecked(emailReminders);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putBoolean("bookingReminders", bookingReminders);
        outState.putBoolean("emailReminders", emailReminders);
    }

    private void OnBackButtonClick()
    {
        finish();
    }
}