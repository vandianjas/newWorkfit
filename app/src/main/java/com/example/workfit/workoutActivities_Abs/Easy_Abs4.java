package com.example.workfit.workoutActivities_Abs;

import android.app.Dialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.Timer;
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
                Intent intent = new Intent(Easy_Abs4.this, Easy_Abs_Result.class);
                Timer timer = new Timer(Easy_Abs4.this);
                timer.show();

                DatabaseHandler db = DatabaseHandler.getInstance(Easy_Abs4.this); //Deklarasi database handler 'online'
                DetailedProgress_DynamicData dbOffline; //Deklarasi container database 'offline'
                dbOffline = db.getDatabase(0); //ngambil database dari 'online' masukin dalem containter 'offline'
                dbOffline.addV3(); //container 'offline' ditambahin isinya
                db.updateDatabase(dbOffline); //container dikirim lagi ke database 'online'

                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();

                long totalTimeSpent = baseTime + elapsedMillis;
                intent.putExtra("total", totalTimeSpent);

                intent.putExtra("chrono", elapsedMillis);
                intent.putExtra("total", totalTimeSpent);
                startActivity(intent);
            }
        });
    }

    public void Timer() {

        final TextView timer = (TextView)findViewById(R.id.timer);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_overlay_timer);
        dialog.setCancelable(false);
        dialog.show();

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(Long.toString(millisUntilFinished/1000));
            }

            public void onFinish() {
                timer.setText("done!");
                dialog.dismiss();
            }
        }.start();
    }
}
