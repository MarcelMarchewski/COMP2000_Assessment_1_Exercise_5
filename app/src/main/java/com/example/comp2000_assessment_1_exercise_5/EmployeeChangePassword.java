package com.example.comp2000_assessment_1_exercise_5;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeChangePassword extends AppCompatActivity {

    private boolean isPasswordAVisible = false;
    private boolean isPasswordBVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_change_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NavigationBar.Setup(this);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(x -> OnSubmitButtonClicked());

        Button showPasswordAButton = (Button) findViewById(R.id.showPasswordButtonA);

        EditText passwordAInput = (EditText) findViewById(R.id.passwordInputA);

        showPasswordAButton.setOnClickListener(x -> OnShowPasswordAClick(showPasswordAButton, passwordAInput));

        Button showPasswordBButton = (Button) findViewById(R.id.showPasswordButtonB);

        EditText passwordBInput = (EditText) findViewById(R.id.passwordInputB);

        showPasswordBButton.setOnClickListener(x -> OnShowPasswordBClick(showPasswordBButton, passwordBInput));

        if (savedInstanceState != null)
        {
            isPasswordAVisible = savedInstanceState.getBoolean("passwordAVisible", false);

            if (isPasswordAVisible) { SetPasswordVisibility(showPasswordAButton, passwordAInput, true); }

            isPasswordBVisible = savedInstanceState.getBoolean("passwordBVisible", false);

            if (isPasswordBVisible) { SetPasswordVisibility(showPasswordBButton, passwordBInput, true); }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putBoolean("passwordAVisible", isPasswordAVisible);
        outState.putBoolean("passwordBVisible", isPasswordBVisible);
    }

    private void OnBackButtonClick()
    {
        finish();
    }

    private void OnSubmitButtonClicked()
    {
        SubmitChangePasswordDialogFragment dialog = new SubmitChangePasswordDialogFragment();

        dialog.show(getSupportFragmentManager(), "SubmitChangePasswordDialog");
    }

    private void OnShowPasswordAClick(Button showPasswordButton, EditText passwordInput)
    {
        isPasswordAVisible = !isPasswordAVisible;

        SetPasswordVisibility(showPasswordButton, passwordInput, isPasswordAVisible);
    }

    private void OnShowPasswordBClick(Button showPasswordButton, EditText passwordInput)
    {
        isPasswordBVisible = !isPasswordBVisible;

        SetPasswordVisibility(showPasswordButton, passwordInput, isPasswordBVisible);
    }

    private void SetPasswordVisibility(Button showPasswordButton, EditText passwordInput, boolean state)
    {
        Typeface original = passwordInput.getTypeface();
        int cursorPos = passwordInput.getSelectionStart();

        if (state)
        {
            showPasswordButton.setBackground(getDrawable(R.drawable.hide_password_icon_img));

            passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }

        else
        {
            showPasswordButton.setBackground(getDrawable(R.drawable.show_password_icon_img));

            passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        passwordInput.setTypeface(original);
        passwordInput.setSelection(cursorPos);
    }
}