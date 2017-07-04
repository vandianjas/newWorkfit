package com.example.workfit.activities;

import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DataFiles.PersonalData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.DatabaseHandlers.DatabaseHandler_PersonalData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler_Photo;
import com.example.workfit.workfitapps.R;

public class SplashScreen extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                DatabaseHandler_PersonalData personaldb = DatabaseHandler_PersonalData.getInstance(getApplication());
                DatabaseHandler db = DatabaseHandler.getInstance(getApplication());
                DatabaseHandler_Photo photo = DatabaseHandler_Photo.getInstance(getApplication());

                try {
                    if(personaldb.getPersonalData()!= null && db.getDatabase(0) != null && photo.getPhoto("profile") != null) {
                        Intent i = new Intent(SplashScreen.this, Home.class);
                        startActivity(i);
                    } else {
                        db.addDatabase(new DetailedProgress_DynamicData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                        db.addDatabase(new DetailedProgress_DynamicData(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

                        personaldb.addCompletePersonalData(new PersonalData("nama", true, 0, 0));

                        Intent i = new Intent(SplashScreen.this, Register.class);
                        startActivity(i);
                    }
                } catch  (CursorIndexOutOfBoundsException e) {
                    Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } catch (NullPointerException e) {
                    Toast.makeText(SplashScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
