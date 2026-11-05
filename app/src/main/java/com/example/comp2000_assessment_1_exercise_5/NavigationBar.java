package com.example.comp2000_assessment_1_exercise_5;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

public class NavigationBar
{
    public static void Setup(Activity activity)
    {
        Button viewBookings = activity.findViewById(R.id.viewBookingsButton);

        Button createBooking = activity.findViewById(R.id.createBookingButton);

        Button settings = activity.findViewById(R.id.settingsButton);

        viewBookings.setOnClickListener
        (
            x ->
            {
                if (!(activity instanceof EmployeeView))
                {
                    Intent intent = new Intent(activity, EmployeeView.class);

                    activity.startActivity(intent);
                }
            }
        );

        createBooking.setOnClickListener
        (
            x ->
            {
                if (!(activity instanceof EmployeeCreateBooking))
                {
                    Intent intent = new Intent(activity, EmployeeCreateBooking.class);

                    activity.startActivity(intent);
                }
            }
        );

        settings.setOnClickListener
        (
            x ->
            {
                if (!(activity instanceof EmployeeSettings))
                {
                    Intent intent = new Intent(activity, EmployeeSettings.class);

                    activity.startActivity(intent);
                }
            }
        );
    }
}
