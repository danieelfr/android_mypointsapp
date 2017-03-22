package danieeelfr.projects.android.mypoints.ui.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.R;

/**
 * Created by danielfr on 06/03/2017.
 */

public class PointsAdapter extends BaseAdapter {

    private List<PointModel> points;
    private Activity activity;

    public PointsAdapter(Activity activity, List<PointModel> points)
    {
        this.activity = activity;
        this.points = points;
    }

    @Override
    public int getCount() {
        return points.size();
    }

    @Override
    public Object getItem(int position) {
        return points.get(position);
    }

    @Override
    public long getItemId(int position) {
        return points.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = this.activity.getLayoutInflater().inflate(R.layout.item_list_points, null);

        PointModel pointModel = points.get(position);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText(pointModel.getDescription().toString());

        return view;
    }
}
