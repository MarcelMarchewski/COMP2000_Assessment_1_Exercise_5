package com.example.comp2000_assessment_1_exercise_5;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeTimeSlot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_time_slot);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        TextView[] slots =
        {
                findViewById(R.id.one),
                findViewById(R.id.two),
                findViewById(R.id.three),
                findViewById(R.id.four),
                findViewById(R.id.five),
                findViewById(R.id.nine),
                findViewById(R.id.ten),
                findViewById(R.id.eleven),
                findViewById(R.id.twelve)
        };

        int[] slotTimes = {13, 14, 15, 16, 17, 9, 10, 11, 12};

        EditText startTime = (EditText) findViewById(R.id.startTimeInput);
        EditText endTime = (EditText) findViewById(R.id.endTimeInput);

        TextWatcher timeWatcher = new TextWatcher()
        {
            @Override
            public void afterTextChanged(Editable editable)
            {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                UpdateTimeSlots(slots, slotTimes, startTime, endTime);
            }
        };

        startTime.addTextChangedListener(timeWatcher);
        endTime.addTextChangedListener(timeWatcher);
    }

    private void UpdateTimeSlots(TextView[] slots, int[] slotTimes, EditText startTime, EditText endTime)
    {
        String start = startTime.getText().toString();
        String end = endTime.getText().toString();

        if (start.isEmpty() || end.isEmpty()) { return; }

        int startHour = Integer.parseInt(start);
        int endHour = Integer.parseInt(end);

        if (startHour < 9 || endHour > 18) { return; }

        for (int i = 0; i < slots.length; i++)
        {
            if (slotTimes[i] >= startHour && slotTimes[i] < endHour)
            {
                slots[i].setBackgroundColor(ContextCompat.getColor(this, R.color.bookingOrange));
            }

            else
            {
                slots[i].setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            }
        }
    }
}