package com.example.workfit.RecyclerViewStuffs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workfit.workfitapps.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class HeaderAdapter extends ExpandableRecyclerViewAdapter<HeaderViewHolder, ChildViewHolder> {

    public int childIndex;
    Context context;
    Activity activity;

    public HeaderAdapter(List<? extends ExpandableGroup> groups, Context context, Activity activity) {
        super(groups);
        this.context = context;
        this.activity = activity;
    }

    @Override
    public HeaderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_list_group_header_items, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_list_group_child_items, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final WorkoutChildItems workoutChildItems = ((WorkoutHeaderItems) group).getItems().get(childIndex);
        holder.setArtistName(workoutChildItems.getName(), flatPosition, childIndex, context, activity);
    }

    @Override
    public void onBindGroupViewHolder(HeaderViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {

        holder.setGenreTitle(group);
    }
}