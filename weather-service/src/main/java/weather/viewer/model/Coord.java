package weather.viewer.model;

/**
 * Created by james on 29/12/2016.
 */
public class Coord {
    private String lon;

    private String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coord [lon = " + lon + ", lat = " + lat + "]";
    }
}
