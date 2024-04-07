package com.example.dhikashop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {
    EditText edUsername;
    Button buttonEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        edUsername = findViewById(R.id.edUsername);
        buttonEdit = findViewById(R.id.buttonEdit);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = edUsername.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newName", newName);
                setResult(RESULT_OK, returnIntent);
                finish(); // Finish this Activity, back to FirstActivity
            }
        });

    }
}