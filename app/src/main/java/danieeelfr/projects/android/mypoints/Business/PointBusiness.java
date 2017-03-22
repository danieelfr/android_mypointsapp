package danieeelfr.projects.android.mypoints.Business;

import android.content.Context;
import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.Repository.PointsRepository;

public class PointBusiness {

    private Context context;
    private PointsRepository pointsRepository;

    public PointBusiness(Context _context)
    {
        context = _context;
        pointsRepository = new PointsRepository(context);
    }

    public void Add(String _description, String _latitude, String _longitude)
    {
        PointModel pointModel = new PointModel();
        pointModel.setDescription(_description);
        pointModel.setLatitude(_latitude);
        pointModel.setLongitude(_longitude);

        pointsRepository.Add(pointModel);
    }


}
