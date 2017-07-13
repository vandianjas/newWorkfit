package com.example.workfit;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.workfit.workfitapps.R;

/**
 * Created by Revina Adisty on 7/4/2017.
 */

public class Timer extends Dialog {

    private Activity a;

    public Timer(Context context, int ThemeResId) {
        super(context, ThemeResId);
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

            @Override
            public void onFinish() {
                timer.setText("done!");
            }
        }.start();

        dismiss();
    }

    @Override
    public void onBackPressed() {

    }
}
