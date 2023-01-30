package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        loadProfile();
    }

    public void onGoBackClicked(View view) {
        finish();

    }

    @Override
    protected void onDestroy() {
        saveProfile();
        super.onDestroy();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "default_if_not_found");

        TextView nameField = findViewById(R.id.nameField);
        if (!name.equals("default_if_not_found")) {
            nameField.setText(name);
        }
    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameField = findViewById(R.id.nameField);
        editor.putString("name", nameField.getText().toString());

        editor.apply();
    }
}