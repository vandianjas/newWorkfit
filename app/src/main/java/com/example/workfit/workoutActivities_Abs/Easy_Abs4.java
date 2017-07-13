package com.example.workfit.workoutActivities_Abs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.Timer;
import com.example.workfit.activities.WorkoutDetails_Abs;
import com.example.workfit.workfitapps.R;

public class Easy_Abs4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout_easy_4);

        Bundle bundle = getIntent().getExtras();
        final long baseTime = bundle.getLong("chrono");

        final Chronometer chronometer = (Chronometer)findViewById(R.id.chronometer5);
        chronometer.setBase(baseTime);
        chronometer.start();


        Button next = (Button)findViewById(R.id.nextButton4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(Easy_Abs4.this, Easy_Abs_Result.class);
                Timer countDownDialog = new Timer(Easy_Abs4.this, android.R.style.Theme_Light);
                countDownDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseHandler db = DatabaseHandler.getInstance(Easy_Abs4.this); //Deklarasi database handler 'online'
                        DetailedProgress_DynamicData dbOffline; //Deklarasi container database 'offline'
                        dbOffline = db.getDatabase(0); //ngambil database dari 'online' masukin dalem containter 'offline'
                        dbOffline.addV0(); //container 'offline' ditambahin isinya
                        db.updateDatabase(dbOffline); //container dikirim lagi ke database 'online'

                        intent.putExtra("chrono", baseTime);

                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    }
                }, 15000);
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Easy_Abs4.this);
        alertDialog.setTitle("Awww what happened");
        alertDialog.setMessage("Are you sure you want to quit the workout?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface d, int which) {
                Intent intent = new Intent(Easy_Abs4.this, WorkoutDetails_Abs.class);
                startActivity(intent);
                Toast.makeText(Easy_Abs4.this, "Successfully ran out from the workout", Toast.LENGTH_SHORT).show();
                d.dismiss();
            }
        });
        alertDialog.setNegativeButton("Nope", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }
}
