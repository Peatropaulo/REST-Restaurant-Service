package Foodie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String type;
    private double lat;
    private double longi;

    public Address() {
        longi = 0.0;
        lat = 0.0;
    }

    public double getLat() {
        return lat;
    }
    public double getLongi(){
        return longi;
    }
    public void setLongi(){
        this.longi = longi;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Latitude='" + lat + '\'' +
                ", Longitude=" + longi +
                '}';
    }
}