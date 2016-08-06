package com.hfad.idealtrade.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;

import com.hfad.idealtrade.R;
import com.hfad.idealtrade.utilities.OnSwipeTouchListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment2 extends Fragment {

    private FragmentManager fragmentManager;

    public LoginActivityFragment2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_login, container, false);

        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeLeft() {
                setMainFragment(new LoginActivityFragment3());
            }
            public void onSwipeRight() {
                setMainFragment(new LoginActivityFragment1());
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
