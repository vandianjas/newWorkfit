package com.example.workfit.RecyclerViewStuffs;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.workfitapps.R;


/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

    private TextView childTextView;
    private TextView childTextView2;
    private int temp;
    Context context;

    public ChildViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView)itemView.findViewById(R.id.child1);
        childTextView2 = (TextView)itemView.findViewById(R.id.child2);
    }

    public void setArtistName(String name, int groupIndex, int childIndex, Context context, Activity activity) {

        //groupIndex == INDEX URUTAN ITEM DARI ATAS BANGET SAMPE BAWAH
        this.context = context;
        String valueFromDatabase = "No Database Yet";
        DatabaseHandler db = DatabaseHandler.getInstance(activity.getApplication());
        childTextView.setText(name);

        if (groupIndex <= 10) {
            groupIndex = 1;
        } else if (groupIndex > 10 && groupIndex < 21) {
            groupIndex = 2;
        } else if (groupIndex >= 21) groupIndex = 3;

            switch (childIndex) {
                case 0:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV0()) + " Reps";
                    break;
                case 1:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV1()) + " Reps";
                    break;
                case 2:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV2()) + " Reps";
                    break;
                case 3:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV3()) + " Reps";
                    break;
                case 4:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV4()) + " Reps";
                    break;
                case 5:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV5()) + " Reps";
                    break;
                case 6:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV6()) + " Reps";
                    break;
                case 7:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV7()) + " Reps";
                    break;
                case 8:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV8()) + " Reps";
                    break;
                case 9:
                    valueFromDatabase = String.valueOf(db.getDatabase(groupIndex).getV9()) + " Reps";
                    break;
                default:
                    childTextView2.setText("Database Error");
                    break;
            }

        childTextView2.setText(valueFromDatabase);
    }
}