package danieeelfr.projects.android.mypoints.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import danieeelfr.projects.android.mypoints.R;
import danieeelfr.projects.android.mypoints.ui.fragments.HomeFragment;
import danieeelfr.projects.android.mypoints.ui.fragments.PointsListFragment;
import danieeelfr.projects.android.mypoints.ui.fragments.PointsMapFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent intent;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    initPage();
                    return true;
                case R.id.navigation_mypoints:
                    intent = new Intent(MainActivity.this, MyPointsActivity.class);
                    startActivity(intent);

                    return true;
                case R.id.navigation_about:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.content, new HomeFragment())
                            .commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPage();
    }

    private void initPage()
    {
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
