package com.example.workfit.workoutActivities_Abs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.Timer;
import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 6/28/2017.
 */

public class Easy_Abs1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_workout_easy_1);

        final Chronometer chronometer = (Chronometer)findViewById(R.id.chronometer2);
        chronometer.start();

        Button next = (Button)findViewById(R.id.nextButton1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Easy_Abs1.this, Easy_Abs2.class);
                Timer timer = new Timer(Easy_Abs1.this);
                timer.show();

                DatabaseHandler db = DatabaseHandler.getInstance(Easy_Abs1.this); //Deklarasi database handler 'online'
                DetailedProgress_DynamicData dbOffline; //Deklarasi container database 'offline'
                dbOffline = db.getDatabase(0); //ngambil database dari 'online' masukin dalem containter 'offline'
                dbOffline.addV0(); //container 'offline' ditambahin isinya
                db.updateDatabase(dbOffline); //container dikirim lagi ke database 'online'

                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();

                intent.putExtra("chrono", elapsedMillis);
                startActivity(intent);
            }
        });
    }

    /*public void Timer() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_overlay_timer);
        final TextView timer = (TextView)findViewById(R.id.timer);
        dialog.setCancelable(false);
        dialog.show();

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                String displayTime = Long.toString(millisUntilFinished/1000);
                timer.setText(displayTime);
            }

            public void onFinish() {
                timer.setText("done!");
                dialog.dismiss();
            }
        }.start();
    }*/
}