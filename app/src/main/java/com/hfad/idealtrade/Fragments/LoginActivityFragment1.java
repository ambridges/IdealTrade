package com.hfad.idealtrade.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;
import android.widget.Button;

import com.hfad.idealtrade.activities.AppActivity;
import com.hfad.idealtrade.R;
import com.hfad.idealtrade.utilities.OnSwipeTouchListener;

public class LoginActivityFragment1 extends Fragment {

    private FragmentManager fragmentManager;

    public LoginActivityFragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_login, container, false);

        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeLeft() {
                setMainFragment(new LoginActivityFragment2());
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
                .replace(R.id.loginFragmentContainer, fragment)
                .commit();
    }
}
