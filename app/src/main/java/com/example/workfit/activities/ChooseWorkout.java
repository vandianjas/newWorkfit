package com.example.workfit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.workfit.workfitapps.R;

public class ChooseWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseworkout);

        ImageView Back = (ImageView)findViewById(R.id.imageView12);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseWorkout.this, Home.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
            }
        });

        ImageView Arm = (ImageView)findViewById(R.id.imageView2);
        Arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChooseWorkout.this, "Arm Workout is currently unavailable, sorry!", Toast.LENGTH_LONG).show();
                /*Intent intent = new Intent(ChooseWorkout.this, WorkoutDetails_Arm.class);
                startActivity(intent);*/
            }
        });

        ImageView Abs = (ImageView)findViewById(R.id.imageView11);
        Abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseWorkout.this, WorkoutDetails_Abs.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
            }
        });

        ImageView Butt = (ImageView)findViewById(R.id.imageView13);
        Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChooseWorkout.this, "Butt Workout is currently unavailable, sorry!", Toast.LENGTH_LONG).show();
                /*Intent intent = new Intent(ChooseWorkout.this, WorkoutDetails_Leg.class);
                startActivity(intent);*/
            }
        });
}
}
