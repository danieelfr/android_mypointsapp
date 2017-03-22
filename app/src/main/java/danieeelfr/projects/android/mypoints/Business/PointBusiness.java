package danieeelfr.projects.android.mypoints.Business;

import android.content.Context;

import java.util.List;

import danieeelfr.projects.android.mypoints.Models.PointModel;
import danieeelfr.projects.android.mypoints.Repository.PointsRepository;

public class PointBusiness {

    private Context context;
    private PointsRepository pointsRepository;

    public PointBusiness()
    {
        pointsRepository = new PointsRepository();
    }

    public PointBusiness(Context _context)
    {
        context = _context;

    }

    public void Add(String _description, String _latitude, String _longitude)
    {
        PointModel pointModel = new PointModel();
        pointModel.setDescription(_description);
        pointModel.setLatitude(_latitude);
        pointModel.setLongitude(_longitude);

        pointsRepository.Add(pointModel);
    }

    public List<PointModel> GetPointsList()
    {
        pointsRepository = new PointsRepository(context);
        return pointsRepository.GetPointsList();
    }

    public List<PointModel> GetPointsListFake()
    {
        return pointsRepository.GetPointsListFake();
    }
}
