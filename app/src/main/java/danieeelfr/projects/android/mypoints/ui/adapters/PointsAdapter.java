package danieeelfr.projects.android.mypoints.ui.adapters;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import danieeelfr.projects.android.mypoints.Business.PointBusiness;
import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.R;
import danieeelfr.projects.android.mypoints.ui.MyPointsActivity;
import danieeelfr.projects.android.mypoints.ui.fragments.PointsListFragment;
import danieeelfr.projects.android.mypoints.ui.fragments.PointsMapFragment;

/**
 * Created by danielfr on 06/03/2017.
 */

public class PointsAdapter extends BaseAdapter {

    private List<PointModel> points;
    private Activity activity;
    private PointBusiness pointBusiness;
    private PointModel pointModel;

    public PointsAdapter(Activity activity, List<PointModel> points)
    {
        this.activity = activity;
        this.points = points;
        this.pointBusiness = new PointBusiness(activity);
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

        final View view = this.activity.getLayoutInflater().inflate(R.layout.item_list_points, null);

        pointModel = points.get(position);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText(pointModel.getTitle());

        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        tvDescription.setText(pointModel.getDescription());

        TextView tvLocal = (TextView) view.findViewById(R.id.tvLocal);
        tvLocal.setText(pointModel.getLocal());

        TextView tvLatitude = (TextView) view.findViewById(R.id.tvLatitude);
        tvLatitude.setText(pointModel.getLatitude());

        TextView tvLongitude = (TextView) view.findViewById(R.id.tvLongitude);
        tvLongitude.setText(pointModel.getLongitude());

        CheckBox chbSurfPoint = (CheckBox) view.findViewById(R.id.chbSurfPoint);
        chbSurfPoint.setChecked(pointModel.getSurf());

        CheckBox chbKitePoint = (CheckBox) view.findViewById(R.id.chbKitePoint);
        chbKitePoint.setChecked(pointModel.getKite());

        CheckBox chbPaddlePoint = (CheckBox) view.findViewById(R.id.chbPaddlePoint);
        chbPaddlePoint.setChecked(pointModel.getPaddle());

        ImageButton imbWhatsApp = (ImageButton)view.findViewById(R.id.imbWhatsApp);
        imbWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePointToWhatsapp(v, pointModel);
            }
        });

        ImageButton imbDelete = (ImageButton)view.findViewById(R.id.imbDelete);
        imbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointBusiness.Remove(pointModel);

            }
        });

        ImageButton imbPhotos = (ImageButton)view.findViewById(R.id.imbPhotos);
        imbPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton imbViewMap = (ImageButton)view.findViewById(R.id.imbViewMap);
        imbViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton imbWebSearch = (ImageButton)view.findViewById(R.id.imbWebSearch);
        imbWebSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    public void SharePointToWhatsapp(View view, PointModel pointModel) {

        try {
            store();

        } catch (Exception e) {
            Toast.makeText(activity, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
        }
    }

    public void store(){
        Bitmap bitMap = BitmapFactory.decodeResource(activity.getResources(),R.mipmap.ic_launcher_round);
        File mFile1 = Environment.getExternalStorageDirectory();
        String fileName ="ic_launcher_round.png";

        File mFile2 = new File(mFile1,fileName);
        try {
            FileOutputStream outStream;
            outStream = new FileOutputStream(mFile2);
            bitMap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sdPath = mFile1.getAbsolutePath().toString()+"/"+fileName;

        File temp=new File(sdPath);
        openScreenshot(mFile1, sdPath);
    }

    private void openScreenshot(File imageFile, String mPath)
    {

        File f=new File(mPath);
        Uri uri = Uri.parse("file://"+f.getAbsolutePath());
        Intent share = new Intent(Intent.ACTION_SEND);
        //share.setPackage("com.whatsapp");
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.setType("image/*");
        share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        share.putExtra(Intent.EXTRA_TEXT, "teste");

        activity.startActivity(Intent.createChooser(share, "Share image File"));
    }
}