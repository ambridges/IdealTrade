package com.hfad.idealtrade.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;
import android.widget.Button;

import com.hfad.idealtrade.Activities.AppActivity;
import com.hfad.idealtrade.R;
import com.hfad.idealtrade.Utilities.OnSwipeTouchListener;

public class MainActivityFragment1 extends Fragment {

    private FragmentManager fragmentManager;

    public MainActivityFragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_main, container, false);

        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeLeft() {
                setMainFragment(new MainActivityFragment2());
            }
        });

        Button goToApp = (Button)view.findViewById(R.id.GoToApp);
        goToApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), AppActivity.class);
                startActivity(myIntent);
            }
        });

        return view;
    }

    private void setMainFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, fragment)
                .commit();
    }
}
