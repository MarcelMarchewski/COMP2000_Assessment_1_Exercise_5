package com.example.comp2000_assessment_1_exercise_5;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.widget.Button;

import androidx.core.content.ContextCompat;

public class NavigationBar
{
    public static void Setup(Activity activity)
    {
        Button viewBookings = activity.findViewById(R.id.viewBookingsButton);

        Button createBooking = activity.findViewById(R.id.createBookingButton);

        Button settings = activity.findViewById(R.id.settingsButton);

        int selectColour = ContextCompat.getColor(activity, R.color.bookingBlue);

        if ((activity instanceof EmployeeView))
        {
            viewBookings.setBackgroundTintList(ColorStateList.valueOf(selectColour));
        }

        else if ((activity instanceof EmployeeCreateBooking))
        {
            createBooking.setBackgroundTintList(ColorStateList.valueOf(selectColour));
        }

        else if ((activity instanceof EmployeeSettings))
        {
            settings.setBackgroundTintList(ColorStateList.valueOf(selectColour));
        }

        viewBookings.setOnClickListener
        (
            x ->
            {
                if (!(activity instanceof EmployeeView))
                {
                    Intent intent = new Intent(activity, EmployeeView.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

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

                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

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

                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                    activity.startActivity(intent);
                }
            }
        );
    }
}
