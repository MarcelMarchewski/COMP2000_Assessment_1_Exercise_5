package com.example.comp2000_assessment_1_exercise_5;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityEmployeeLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button showPasswordButton = (Button) findViewById(R.id.showPasswordButton);

        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

        showPasswordButton.setOnClickListener(x -> OnShowPasswordClick(showPasswordButton, passwordInput));
    }

    private void OnBackButtonClick()
    {
        finish();
    }

    private void OnShowPasswordClick(Button showPasswordButton, EditText passwordInput)
    {
        Typeface original = passwordInput.getTypeface();
        int cursorPos = passwordInput.getSelectionStart();

        switch (passwordInput.getInputType())
        {
            case (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD):
            {
                showPasswordButton.setBackground(getDrawable(R.drawable.hide_password_icon_img));

                passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                break;
            }

            case (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD):
            {
                showPasswordButton.setBackground(getDrawable(R.drawable.show_password_icon_img));

                passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                break;
            }
        }

        passwordInput.setTypeface(original);
        passwordInput.setSelection(cursorPos);
    }
}