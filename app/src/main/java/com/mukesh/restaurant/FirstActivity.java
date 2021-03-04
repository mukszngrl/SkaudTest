package com.mukesh.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initialiseControls();
    }

    private void initialiseControls() {
        //initialising views
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(view -> startActivity(new Intent(FirstActivity.this, MainActivity.class)));
    }
}
