package com.example.comp2000_assessment_1_exercise_5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.NotImplementedError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button employeeLoginButton = (Button) findViewById(R.id.employeeLoginButton);

        employeeLoginButton.setOnClickListener(x -> OnEmployeeLoginButtonClick());

        Button managerLoginButton = (Button) findViewById(R.id.managerLoginButton);

        managerLoginButton.setOnClickListener(x -> OnManagerLoginButtonClick());
    }

    private void OnEmployeeLoginButtonClick()
    {
        Log.d("EmployeeLoginButton", "Clicked");

        Intent intent = new Intent(this, ActivityEmployeeLogin.class);

        startActivity(intent);
    }

    private void OnManagerLoginButtonClick()
    {
        Log.e("ManagerLoginButton", "Manager logins are not yet implemented!");
    }
}