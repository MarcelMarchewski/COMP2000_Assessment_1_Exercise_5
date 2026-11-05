package com.example.comp2000_assessment_1_exercise_5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SubmitChangePasswordDialogFragment extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Warning").setMessage("Are you sure you want to submit this new password?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                // Submit the new password

                getActivity().finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                // Don't submit the new password
            }
        });

        return builder.create();
    }
}
