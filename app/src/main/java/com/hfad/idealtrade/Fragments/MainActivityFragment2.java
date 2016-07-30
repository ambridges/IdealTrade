package com.hfad.idealtrade.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;

import com.hfad.idealtrade.R;
import com.hfad.idealtrade.Utilities.OnSwipeTouchListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment2 extends Fragment {

    private FragmentManager fragmentManager;

    public MainActivityFragment2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_main, container, false);

        view.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeLeft() {
                setMainFragment(new MainActivityFragment3());
            }
            public void onSwipeRight() {
                setMainFragment(new MainActivityFragment1());
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
