package danieeelfr.projects.android.mypoints.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import danieeelfr.projects.android.mypoints.R;
import danieeelfr.projects.android.mypoints.ui.fragments.PointsListFragment;
import danieeelfr.projects.android.mypoints.ui.fragments.PointsMapFragment;

public class MyPointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_points);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_point);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPointsActivity.this, PointDetailActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.Update();
    }

    public void Update()
    {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.points_list, new PointsListFragment())
                .add(R.id.points_map, new PointsMapFragment())
                .commit();
    }
}
