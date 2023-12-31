package org.armandosalazar.aseapplication.ui.sign;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.armandosalazar.aseapplication.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    private ActivitySignInBinding binding;
    SignInViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());

        SpannableString content = new SpannableString(binding.tvSignUp.getText());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);

        binding.tvSignUp.setText(content);
        binding.tvSignUp.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: Sign up clicked");
            startActivity(new Intent(this, SignUpActivity.class));
        });

        viewModel = new SignInViewModel(this);

        binding.btnSignIn.setOnClickListener(v -> {
            // viewModel.login("armando@email.com", "123");
            if (binding.tilEmail.getEditText().getText().toString().trim().isEmpty()) {
                binding.tilEmail.setError("Email is required");
            }
            if (binding.tilPassword.getEditText().getText().toString().trim().isEmpty()) {
                binding.tilPassword.setError("Password is required");
            }
            if (!binding.tilEmail.getEditText().getText().toString().trim().isEmpty() &&
                    !binding.tilPassword.getEditText().getText().toString().trim().isEmpty()) {
                viewModel.login(
                        binding.tilEmail.getEditText().getText().toString().trim(),
                        binding.tilPassword.getEditText().getText().toString().trim());
            }
        });

        setContentView(binding.getRoot());
    }
}