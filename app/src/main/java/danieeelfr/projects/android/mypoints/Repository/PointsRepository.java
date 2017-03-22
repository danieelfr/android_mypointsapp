package danieeelfr.projects.android.mypoints.Repository;

import android.content.Context;
import android.graphics.Point;

import danieeelfr.projects.android.mypoints.Models.PointModel;
import io.realm.Realm;
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
        _realm = Realm.getInstance(_context);
    }

    public void Add(PointModel _pointModel) {
        try {
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

            _realm.commitTransaction();
        }
        catch (Exception ex)
        {
            _realm.cancelTransaction();

            if (!_realm.isClosed())
                _realm.close();
        }
    }

    public void Remove(int _id) {
        try {
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
}
