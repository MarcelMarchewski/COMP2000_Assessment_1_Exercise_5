package com.example.comp2000_assessment_1_exercise_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class EmployeeCreateBooking extends AppCompatActivity {

    private String selectedRoom = "Seminar Room 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_create_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        Button continueButton = (Button) findViewById(R.id.continueButton);

        continueButton.setOnClickListener(x -> OnContinueButtonClick());

        TextView selectedRoomLabel = (TextView) findViewById(R.id.selectedRoomLabel);

        Button srOne = (Button) findViewById(R.id.seminarRoomOneButton);
        Button srTwo = (Button) findViewById(R.id.seminarRoomTwoButton);
        Button mrOne = (Button) findViewById(R.id.meetingRoomOneButton);
        Button mrTwo = (Button) findViewById(R.id.meetingRoomTwoButton);
        Button mrThree = (Button) findViewById(R.id.meetingRoomThreeButton);
        Button mrFour = (Button) findViewById(R.id.meetingRoomFourButton);
        Button mrFive = (Button) findViewById(R.id.meetingRoomFiveButton);

        srOne.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Seminar Room 1"));
        srTwo.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Seminar Room 2"));
        mrOne.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Meeting Room 1"));
        mrTwo.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Meeting Room 2"));
        mrThree.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Meeting Room 3"));
        mrFour.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Meeting Room 4"));
        mrFive.setOnClickListener(x -> OnRoomChosen(selectedRoomLabel, "Meeting Room 5"));

        if (savedInstanceState != null)
        {
            selectedRoom = savedInstanceState.getString("selectedRoom", "Seminar Room 1");

            OnRoomChosen(selectedRoomLabel, selectedRoom);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putString("selectedRoom", selectedRoom);
    }

    private void OnContinueButtonClick()
    {
        Intent intent = new Intent(this, EmployeeDateBooking.class);

        intent.putExtra("selectedRoom", selectedRoom);

        startActivity(intent);
    }

    private void OnRoomChosen(TextView label, String room)
    {
        label.setText("Selected Room: " + room);

        selectedRoom = room;
    }
}