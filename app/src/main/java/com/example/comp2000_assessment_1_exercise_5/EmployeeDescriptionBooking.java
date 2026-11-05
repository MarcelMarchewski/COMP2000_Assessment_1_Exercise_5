package com.example.comp2000_assessment_1_exercise_5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeDescriptionBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_description_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        TextView roomName = (TextView) findViewById(R.id.selectedRoomLabel);
        TextView dateTime = (TextView) findViewById(R.id.bookingDateTime);

        roomName.setText(getIntent().getStringExtra("selectedRoom"));
        dateTime.setText(getIntent().getStringExtra("selectedDate") + "\n" + getIntent().getStringExtra("selectedTime"));

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        EditText descriptionInput = (EditText) findViewById(R.id.descriptionInput);

        Button submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(x -> OnSubmitButtonClick());
    }

    private void OnBackButtonClick()
    {
        finish();
    }

    private void OnSubmitButtonClick()
    {
        SubmitButtonDialogFragment dialog = new SubmitButtonDialogFragment();

        dialog.show(getSupportFragmentManager(), "SubmitButtonDialog");
    }
}