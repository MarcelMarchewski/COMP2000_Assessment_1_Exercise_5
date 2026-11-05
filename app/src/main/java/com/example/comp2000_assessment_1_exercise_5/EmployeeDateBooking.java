package com.example.comp2000_assessment_1_exercise_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeDateBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_date_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        DatePicker picker = (DatePicker) findViewById(R.id.bookingDatePicker);

        Button continueButton = (Button) findViewById(R.id.continueButton);

        continueButton.setOnClickListener(x -> OnContinueButtonClick(picker));
    }

    private void OnContinueButtonClick(DatePicker picker)
    {
        Intent intent = new Intent(this, EmployeeTimeSlot.class);

        intent.putExtra("selectedRoom", getIntent().getStringExtra("selectedRoom"));
        intent.putExtra("selectedDate", String.valueOf(picker.getDayOfMonth()) + "/" + String.valueOf(picker.getMonth()) + "/" + String.valueOf(picker.getYear()));

        startActivity(intent);
    }
}