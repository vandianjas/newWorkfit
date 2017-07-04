package com.example.workfit;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.TextView;

import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 7/4/2017.
 */

public class Timer extends Dialog {

    private Activity a;

    public Timer(Activity activity) {
        super(activity);
        this.a = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_overlay_timer);
        final TextView timer = (TextView)findViewById(R.id.timer);

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                String displayTime = Long.toString(millisUntilFinished/1000);
                timer.setText(displayTime);
            }

            public void onFinish() {
                timer.setText("done!");
            }
        }.start();

        dismiss();
    }
}
