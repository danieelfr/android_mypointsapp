package danieeelfr.projects.android.mypoints.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import danieeelfr.projects.android.mypoints.Business.PointBusiness;
import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.R;

public class PointDetailActivity extends AppCompatActivity {

    private PointBusiness pointBusiness;
    private PointModel pointModel;

    private EditText tvTitle;
    private EditText tvLatitude;
    private EditText tvLongitude;
    private EditText tvLocal;
    private EditText tvDescription;
    private CheckBox chbSurfPoint;
    private CheckBox chbPaddlePoint;
    private CheckBox chbKitePoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton btnGetCurrentPosition = (ImageButton)findViewById(R.id.btnGetCurrentPosition);
        InitControls();

        Button btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar().execute();
            }
        });
    }

    private AsyncTask<Void, Void, Void> Salvar() {

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                pointBusiness = new PointBusiness(PointDetailActivity.this);

                FetchPointModel();
                pointBusiness.Add(pointModel);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(PointDetailActivity.this, "Point saved!", Toast.LENGTH_SHORT).show();
                finish();
            }
        };

        return task;
    }

    private void InitControls()
    {
        tvTitle = (EditText)findViewById(R.id.tvTitle);
        tvLatitude = (EditText)findViewById(R.id.tvLatitude);
        tvLongitude = (EditText)findViewById(R.id.tvLongitude);
        tvLocal = (EditText)findViewById(R.id.tvLocal);
        tvDescription = (EditText)findViewById(R.id.tvDescription);
        chbSurfPoint = (CheckBox)findViewById(R.id.chbSurfPoint);
        chbPaddlePoint = (CheckBox)findViewById(R.id.chbPaddlePoint);
        chbKitePoint = (CheckBox)findViewById(R.id.chbKitePoint);
    }

    private void FetchPointModel()
    {
        pointModel = new PointModel();
        pointModel.setTitle(tvTitle.getText().toString());
        pointModel.setLatitude(tvLatitude.getText().toString());
        pointModel.setLongitude(tvLongitude.getText().toString());
        pointModel.setLocal(tvLocal.getText().toString());
        pointModel.setDescription(tvLocal.getText().toString());
        pointModel.setSurf(chbSurfPoint.isChecked());
        pointModel.setPaddle(chbPaddlePoint.isChecked());
        pointModel.setKite(chbKitePoint.isChecked());
    }
}
