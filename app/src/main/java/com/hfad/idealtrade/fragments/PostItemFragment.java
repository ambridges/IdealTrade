package com.hfad.idealtrade.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.idealtrade.R;

/**
 *
 * Created by Alex on 04/08/2016.
 */
public class PostItemFragment extends Fragment {

    public PostItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postitem, container, false);

        return view;
    }
}
