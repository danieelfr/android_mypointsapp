package danieeelfr.projects.android.mypoints.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by danielfr on 21/03/2017.
 */

public class PointModel extends RealmObject {
    @PrimaryKey
    private Long id;
    @Required
    private String title;

    private String description;
    private String local;
    private Boolean surf;
    private Boolean paddle;
    private Boolean kite;

    @Required
    private String latitude;
    @Required
    private String longitude;

    public PointModel()
    {

    }

    public PointModel(Long id, String description, String latitude, String longitude, Boolean surf, Boolean paddle, Boolean kite, String local, String title)
    {
        this.id = id;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.surf = surf;
        this.paddle = paddle;
        this.kite = kite;
        this.local = local;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(final String _title) {
        this.title = _title;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(final String _local) {
        this.title = _local;
    }

    public Boolean getSurf() {
        return surf;
    }

    public void setSurf(final Boolean _surf) {
        this.surf = _surf;
    }

    public Boolean getPaddle() {
        return paddle;
    }

    public void setPaddle(final Boolean _paddle) {
        this.paddle = _paddle;
    }

    public Boolean getKite() {
        return kite;
    }

    public void setKite(final Boolean _kite) {
        this.kite = _kite;
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