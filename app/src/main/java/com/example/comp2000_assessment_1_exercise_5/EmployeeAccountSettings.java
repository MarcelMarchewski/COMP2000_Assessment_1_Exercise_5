package com.example.comp2000_assessment_1_exercise_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeAccountSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_account_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button changePasswordButton = (Button) findViewById(R.id.changePasswordButton);

        changePasswordButton.setOnClickListener(x -> OnChangePasswordClick());

        Button signOutButton = (Button) findViewById(R.id.signOutButton);

        signOutButton.setOnClickListener(x -> OnSignOutClick());
    }

    private void OnBackButtonClick()
    {
        finish();
    }

    private void OnChangePasswordClick()
    {
        Intent intent = new Intent(this, EmployeeChangePassword.class);

        startActivity(intent);
    }

    private void OnSignOutClick()
    {
        SignOutButtonDialogFragment dialog = new SignOutButtonDialogFragment();

        dialog.show(getSupportFragmentManager(), "SignOutButtonDialog");
    }
}