package com.example.josephthedev.jobmanagementsheet.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.josephthedev.jobmanagementsheet.Activity.Client.ClientNavigationActivity;
import com.example.josephthedev.jobmanagementsheet.Activity.Client.CurrentLocationActivity;
import com.example.josephthedev.jobmanagementsheet.R;
import com.example.josephthedev.jobmanagementsheet.Services.LoginService;
import com.google.android.gms.maps.SupportMapFragment;

public class LoginActivity extends AppCompatActivity {
    private Button userLogin;
    private Intent intent;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLogin = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validateUserLogin();

            }
        });
    }

    public void validateUserLogin(){
        username.setError(null);
        password.setError(null);

        if (username.length() == 0 && username.isFocused()) {
            username.setError("Username cannot be empty");
        }

        if (password.length() == 0 && username.isFocused()) {
            password.setError("Password cannot be empty");
        } else {
            LoginService task = new LoginService(LoginActivity.this);
            task.execute(username.getText().toString(), password.getText().toString());
        }
    }

}
