package com.example.comp2000_assessment_1_exercise_5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

public class EmployeeManageBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_manage_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button cancelButton = (Button) findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(x -> OnCancelButtonClick());

        TextView roomName = (TextView) findViewById(R.id.roomName);
        TextView bookingDateTime = (TextView) findViewById(R.id.bookingDateTime);
        TextView description = (TextView) findViewById(R.id.bookingDescription);
        TextView status = (TextView) findViewById(R.id.bookingStatus);

        Intent intent = getIntent();

        roomName.setText(intent.getStringExtra("roomName"));
        bookingDateTime.setText(intent.getStringExtra("date") + "\n" + intent.getStringExtra("time"));
        description.setText(intent.getStringExtra("description"));
        status.setText(intent.getStringExtra("status"));
    }

    private void OnBackButtonClick()
    {
        finish();
    }

    private void OnCancelButtonClick()
    {
        CancelButtonDialogFragment dialog = new CancelButtonDialogFragment();

        dialog.show(getSupportFragmentManager(), "CancelBookingDialog");
    }
}