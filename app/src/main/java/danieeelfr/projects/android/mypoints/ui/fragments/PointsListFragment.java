package danieeelfr.projects.android.mypoints.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import danieeelfr.projects.android.mypoints.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointsListFragment extends Fragment {


    public PointsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_points_list, container, false);
    }

}
