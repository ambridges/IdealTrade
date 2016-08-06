package com.hfad.idealtrade.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.hfad.idealtrade.R;
import com.hfad.idealtrade.fragments.LoginActivityFragment1;

/**
 *
 * Created by Alex on 28/07/2016.
 */
public class SettingsActivity extends AppCompatActivity {

    private Boolean activeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityPaused();
    }

    private void activityResumed(){
        this.activeActivity = true;
    }

    private void activityPaused(){
        this.activeActivity = false;
    }

    public boolean getActive(){
        return activeActivity;
    }

}
