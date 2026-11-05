package com.example.comp2000_assessment_1_exercise_5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SignOutButtonDialogFragment extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Warning").setMessage("Are you sure you want to sign out?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                // Sign out

                Intent intent = new Intent(getActivity(), MainActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                getActivity().startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                // Don't sign out
            }
        });

        return builder.create();
    }
}
