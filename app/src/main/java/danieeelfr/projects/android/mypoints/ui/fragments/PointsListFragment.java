package danieeelfr.projects.android.mypoints.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import danieeelfr.projects.android.mypoints.Business.PointBusiness;
import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.R;
import danieeelfr.projects.android.mypoints.ui.MyPointsActivity;
import danieeelfr.projects.android.mypoints.ui.adapters.PointsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointsListFragment extends Fragment {

    PointBusiness pointBusiness;
    Context context;

    public PointsListFragment() {
        // context = getActivity().getApplicationContext();
        this.pointBusiness = new PointBusiness();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_points_list, container, false);

        List<PointModel> pointModelList = pointBusiness.GetPointsListFake();

        PointsAdapter atendimentoAdapter = new PointsAdapter(getActivity(), pointModelList);
        ListView lvAtendimentos = (ListView)view.findViewById(R.id.lvPoints);
        lvAtendimentos.setAdapter(atendimentoAdapter);

        return view;
    }

}
