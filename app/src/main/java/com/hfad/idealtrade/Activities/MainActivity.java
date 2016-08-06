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
public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            setMainFragment(new LoginActivityFragment1());
        }
    }

    private void setMainFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.loginFragmentContainer, fragment)
                .commit();
    }
}
