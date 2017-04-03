package danieeelfr.projects.android.mypoints.Repository;

import android.content.Context;
import android.graphics.Point;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import danieeelfr.projects.android.mypoints.Models.PointModel;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by danielfr on 21/03/2017.
 */

public class PointsRepository {

    private Context context;
    private Realm _realm;

    public PointsRepository(Context _context)
    {
        context = _context;
    }

    public PointsRepository()
    {

    }

    public void Add(PointModel _pointModel) {
        try {
            _realm = Realm.getInstance(context);
            _realm.beginTransaction();

            PointModel point = _realm.createObject(PointModel.class);
            Number nextID = (Long)(_realm.where(PointModel.class).max("id"));

            if (nextID == null || nextID.longValue() == 0)
                nextID = 1;
            else
                nextID = nextID.longValue() + 1;

            point.setId(nextID.longValue());
            point.setDescription(_pointModel.getDescription());
            point.setLatitude(_pointModel.getLatitude());
            point.setLongitude(_pointModel.getLongitude());
            point.setTitle(_pointModel.getTitle());
            point.setLocal(_pointModel.getLocal());
            point.setKite(_pointModel.getKite());
            point.setSurf(_pointModel.getSurf());
            point.setPaddle(_pointModel.getPaddle());

            _realm.commitTransaction();


        }
        catch (Exception ex)
        {
            _realm.cancelTransaction();

            if (!_realm.isClosed())
                _realm.close();
        }

    }



    public void Remove(long _id) {
        try {
            _realm = Realm.getInstance(context);
            _realm.beginTransaction();

            RealmResults<PointModel> points = _realm.where(PointModel.class).equalTo("id", _id).findAll();

            if (!points.isEmpty()) {
                for (int i = points.size() - 1; i >= 0; i--) {
                    points.get(i).removeFromRealm();
                }
            }
            _realm.commitTransaction();

        }
        catch (Exception ex) {
            _realm.cancelTransaction();

            if (!_realm.isClosed())
                _realm.close();
        }
    }

    public List<PointModel> GetPointsList()
    {
        try
        {
            _realm = Realm.getInstance(context);
            _realm.beginTransaction();

            RealmResults<PointModel> points = _realm.where(PointModel.class).findAll();

            List<PointModel> retorno =  new ArrayList<PointModel>();

            if (!points.isEmpty()) {
                for (int i = points.size() - 1; i >= 0; i--) {
                    retorno.add(points.get(i));
                }
            }
            _realm.commitTransaction();

            return  retorno;

        }
        catch (Exception ex) {
            _realm.cancelTransaction();

            if (!_realm.isClosed())
                _realm.close();
        }

        return null;
    }

    public List<PointModel> GetPointsListFake()
    {
        try
        {
            List<PointModel> lista = new ArrayList<PointModel>();

            PointModel item1 = new PointModel((long) 6, "descriçao teste", "20:20:20:20", "30:00:00:00", true, true, false, "Hawaii", "Pacific Ocean");
            PointModel item2 = new PointModel((long) 7, "descriçao teste 222", "20:20:20:20", "30:00:00:00", true, true, false, "Hawaii", "Pacific Ocean");
            PointModel item3 = new PointModel((long) 8, "descriçao teste 222", "20:20:20:20", "30:00:00:00", true, true, false, "Hawaii", "Pacific Ocean");
            PointModel item4 = new PointModel((long) 9, "descriçao teste 222", "20:20:20:20", "30:00:00:00", true, true, false, "Hawaii", "Pacific Ocean");
            PointModel item5 = new PointModel((long) 10, "descriçao teste 222", "20:20:20:20", "30:00:00:00", true, true, false, "Hawaii", "Pacific Ocean");
            PointModel item6 = new PointModel((long) 10, "descriçao teste 222", "20:20:20:20", "30:00:00:00", true, true, false, "Hawaii", "Pacific Ocean");

            lista.add(item1);
            lista.add(item2);
            lista.add(item3);
            lista.add(item4);
            lista.add(item5);
            lista.add(item6);

            return lista;
        }
        catch (Exception ex) {

        }
        return null;
    }

}
