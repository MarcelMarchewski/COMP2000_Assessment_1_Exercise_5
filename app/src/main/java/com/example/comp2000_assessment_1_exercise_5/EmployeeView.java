package com.example.comp2000_assessment_1_exercise_5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeView extends AppCompatActivity {

    RecyclerView bookingView;
    BookingAdapter bookingAdapter;

    List<Booking> bookings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        bookingView = findViewById(R.id.bookingsRecyclerView);

        bookingView.setLayoutManager(new LinearLayoutManager(this));

        bookings.add
        (
            new Booking
                (
                    "Seminar Room 2",
                    "06/11/2026",
                    "09:00-12:00",
                    "Meeting for latest product",
                    "Approved"
                )
        );

        bookings.add
        (
            new Booking
                (
                    "Meeting Room 1",
                    "06/11/2026",
                    "13:00-14:00",
                    "Meeting for new marketing strategy",
                    "Approved"
                )
        );

        bookings.add
        (
            new Booking
                (
                    "Meeting Room 3",
                    "08/11/2026",
                    "09:00-12:00",
                    "Meeting for work review",
                    "Denied"
                )
        );

        for (int i = 9; i < 15; i++)
        {
            bookings.add
                (
                    new Booking
                        (
                            "Seminar Room 2",
                            "0" + String.valueOf(i) + "/11/2026",
                            "09:00-12:00",
                            "Meeting for generic purpose",
                            "Pending"
                        )
                );
        }

        bookingAdapter = new BookingAdapter(bookings);

        bookingView.setAdapter(bookingAdapter);
    }
}