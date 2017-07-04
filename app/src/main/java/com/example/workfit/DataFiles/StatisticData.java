package com.example.workfit.DataFiles;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revina Adisty on 6/1/2017.
 */

public class StatisticData {

    private List<String> StatisticListItems;
    private List<Integer> StatisticListResult;
    private String[][] ExpandListHeaders;
    private String[][][] ExpandListChild = new String[100][100][100];
    GlobalProgress_DynamicData globalProgressDynamicData;

    public StatisticData(Context context){
        StatisticListItems = new ArrayList<String>();
        StatisticListResult = new ArrayList<Integer>();

        /** ini yang outer list tanpa anak **/
        StatisticListItems.add(0, "Average Duration");
        StatisticListItems.add(1, "Total Time");
        StatisticListItems.add(2, "Total Exercise Done");

        try {
            StatisticListResult.add(0, globalProgressDynamicData.get_avgDuration());
            StatisticListResult.add(1, globalProgressDynamicData.get_totalTimeSpent());
        } catch (NullPointerException e) {
            StatisticListResult.add(0, 0);
            StatisticListResult.add(1, 0);
        }
    }

    public String getStatListItem(int i) {
        return StatisticListItems.get(i);
    }

    public List<String> getFullStatList() {
        return StatisticListItems;
    }

    public Integer getStatResultItem(int i) {
        return StatisticListResult.get(i);
    }

}