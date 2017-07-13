package com.example.workfit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.workfit.workoutActivities_Abs.Easy_Abs1;
import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 6/28/2017.
 */

public class WorkoutDetails_Abs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout_choose);

        ImageView Back = (ImageView)findViewById(R.id.backButtonAbs);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutDetails_Abs.this, ChooseWorkout.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
            }
        });

        Button EasyPlan = (Button)findViewById(R.id.button13);
        EasyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutDetails_Abs.this, Easy_Abs1.class);
                startActivity(intent);
                overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
            }
        });

        Button MediumPlan = (Button)findViewById(R.id.button14);
        MediumPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(WorkoutDetails_Abs.this, Medium_Abs1.class);
                startActivity(intent);*/

                Toast.makeText(WorkoutDetails_Abs.this, "Medium Plan is currently unavailable, sorry!", Toast.LENGTH_SHORT).show();
            }
        });

        Button HardPlan = (Button)findViewById(R.id.button15);
        HardPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(WorkoutDetails_Abs.this, Hard_Abs1.class);
                startActivity(intent);*/

                Toast.makeText(WorkoutDetails_Abs.this, "Hard Plan is currently unavailable, sorry!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
