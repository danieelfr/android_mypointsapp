package danieeelfr.projects.android.mypoints.Models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by danielfr on 21/03/2017.
 */

public class PointModel extends RealmObject {
    @PrimaryKey
    private Long id;
    @Required
    private String description;
    @Required
    private String latitude;
    @Required
    private String longitude;

    public PointModel()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long _id) {
        this.id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String _description) {
        this.description = _description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(final String _latitude) {
        this.latitude = _latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(final String _longitude) {
        this.longitude = _longitude;
    }
}