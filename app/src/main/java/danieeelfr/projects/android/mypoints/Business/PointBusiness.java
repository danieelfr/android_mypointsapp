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
        pointsRepository = new PointsRepository(context);
    }

    public void Add(PointModel _pointModel)
    {
        pointsRepository.Add(_pointModel);
    }

    public void Remove(PointModel _pointModel)
    {
        pointsRepository.Remove(_pointModel.getId());
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
