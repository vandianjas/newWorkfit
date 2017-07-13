package com.example.workfit.workoutActivities_Abs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.activities.Home;
import com.example.workfit.viewAnimators.Techniques;
import com.example.workfit.viewAnimators.YoYo;
import com.example.workfit.workfitapps.R;

import org.w3c.dom.Text;

public class Easy_Abs_Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy__abs__result);

        DatabaseHandler db = DatabaseHandler.getInstance(getApplicationContext());
        db.addOneProgress(1);

        Bundle bundle = getIntent().getExtras();
        long totalTime = bundle.getLong("total");

        /*YoYo.with(Techniques.Landing)
                .duration(1000)
                .playOn(findViewById(R.id.congrats));*/

        long totalTimeInMinutes = totalTime/60/1000;
        TextView timeSpent = (TextView)findViewById(R.id.timespent);
        timeSpent.setText(Long.toString(totalTimeInMinutes) + " Minutes");

        Button backToHome = (Button)findViewById(R.id.backtohome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Easy_Abs_Result.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
