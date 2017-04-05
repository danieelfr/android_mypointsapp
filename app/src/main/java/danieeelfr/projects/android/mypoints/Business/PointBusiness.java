package danieeelfr.projects.android.mypoints.Business;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.R;
import danieeelfr.projects.android.mypoints.Repository.PointsRepository;

public class PointBusiness {

    private Context context;
    private PointsRepository pointsRepository;

    public PointBusiness(Context _context) {
        context = _context;
        pointsRepository = new PointsRepository(context);
    }

    public void Add(PointModel _pointModel) {
        pointsRepository.Add(_pointModel);
    }

    public void Remove(PointModel _pointModel) {
        pointsRepository.Remove(_pointModel.getId());
    }

    public List<PointModel> GetPointsList() {
        pointsRepository = new PointsRepository(context);
        return pointsRepository.GetPointsList();
    }

    public List<PointModel> GetPointsListFake() {
        return pointsRepository.GetPointsListFake();
    }

    public void PreparePointShare(PointModel pointModel){

        try
        {
            FileOutputStream outStream;
            String fileName ="ic_launcher_round.jpeg";
            Bitmap bitMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.point_share);
            File mFile1 = Environment.getExternalStorageDirectory();
            File mFile2 = new File(mFile1,fileName);
            outStream = new FileOutputStream(mFile2);
            bitMap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();

            String sdPath = mFile1.getAbsolutePath()+"/"+fileName;
            SharePoint(sdPath, pointModel);
        }
        catch (IOException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void SharePoint(String mPath, PointModel pointModel)
    {
        File f = new File(mPath);
        Uri uri = Uri.parse("file://"+f.getAbsolutePath());

        Intent share = new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.setType("image/*");
        share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        String text = "Point: " + pointModel.getTitle() + "." + System.getProperty("line.separator");
        text = text + "Local: " + pointModel.getLocal() + "." + System.getProperty("line.separator");
        text = text + "Description: " + pointModel.getDescription() + "." + System.getProperty("line.separator");
        text = text + "Latitude: " + pointModel.getLatitude() + " | " + "Longitude: " + pointModel.getLongitude() + "." + System.getProperty("line.separator");

        share.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(Intent.createChooser(share, "Share this point using:"));

        share.putExtra(Intent.EXTRA_SUBJECT, "Point shared: " + pointModel.getTitle());
        share.putExtra(Intent.EXTRA_TITLE, "My Points: " + pointModel.getTitle());
    }
}
