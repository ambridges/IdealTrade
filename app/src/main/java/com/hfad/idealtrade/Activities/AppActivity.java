package com.hfad.idealtrade.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.hfad.idealtrade.Fragments.LandingFragment;
import com.hfad.idealtrade.R;

/**
 *
 * Created by Alex on 04/08/2016.
 */
public class AppActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            setMainFragment(new LandingFragment());
        }
    }

    private void setMainFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.landingFragmentContainer, fragment)
                .commit();
    }
}
